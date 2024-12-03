/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.IEmployeDao;
import db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Employe;

/**
 *
 * @author HP
 */
public class EmployeDao implements IEmployeDao{

    @Override
    public Employe save(Employe employe) {
        //      Recuperation de la connexion a la base de donnees
        try(Connection connection = DbConnection.getConnection();){
//          Preparation de la requete
            String query = "INSERT INTO employes (prenom, nom, poste, salaire_brut, type, categorie_id) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, employe.getPrenom());
            ps.setString(2, employe.getNom());
            ps.setString(3, employe.getPoste());
            ps.setDouble(4, employe.getSalaireBrut());
            ps.setString(5, employe.getType());
            ps.setInt(6, employe.getCategorieId());
//          Executer la requete
            ps.executeUpdate();
//          Recuperation de l'id de la categorie ajoutee
            PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(id) as id_employe FROM employes");
            ResultSet resultSet = ps2.executeQuery();
            while(resultSet.next()){
//              Ajouter l'id recuperer a la categorie actuelle
                employe.setId(resultSet.getInt("id_employe"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return employe;
    }

    @Override
    public List<Employe> getAll() {
//      Recuperation de la connexion a la base de donnees
        List<Employe> employes = new ArrayList<>();
        try(Connection connection = DbConnection.getConnection();){
//          Preparation de la requete pour recuperer tous les employes
            PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM employes");
            ResultSet resultSet = ps2.executeQuery();
            while(resultSet.next()){
                Employe employe = new Employe();
//              Ajouter le resultat dans employe
                employe.setId(resultSet.getInt("id"));
                employe.setPrenom(resultSet.getString("prenom"));
                employe.setNom(resultSet.getString("nom"));
                employe.setPoste(resultSet.getString("poste"));
                employe.setSalaireBrut(resultSet.getDouble("salaire_brut"));
                employe.setCategorieId(resultSet.getInt("categorie_id"));
                
                employes.add(employe);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return employes;
    }

    @Override
    public void edit(Employe employe) {
//      Recuperation de la connexion a la base de donnees
        try(Connection connection = DbConnection.getConnection();){
//          Preparation de la requete
            PreparedStatement ps = connection.prepareStatement("UPDATE employes SET prenom = ?, nom = ?, poste = ?, salaire_brut = ?, categorie_id = ? WHERE id = ?");
            ps.setString(1, employe.getPrenom());
            ps.setString(2, employe.getNom());
            ps.setString(3, employe.getPoste());
            ps.setDouble(4, employe.getSalaireBrut());
            ps.setInt(5, employe.getCategorieId());
            ps.setInt(6, employe.getId());
//            executer la mise a jour
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Employe getOne(int id) {
        Employe employe = new Employe();
//      Recuperation de la connexion a la base de donnees
        try(Connection connection = DbConnection.getConnection();){
//          Preparation de la requete
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM employes WHERE id = ?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
//              Recuperer le resultat dans employe
                employe.setId(resultSet.getInt("id"));
                employe.setPrenom(resultSet.getString("prenom"));
                employe.setNom(resultSet.getString("nom"));
                employe.setPoste(resultSet.getString("poste"));
                employe.setSalaireBrut(resultSet.getDouble("salaire_brut"));
                employe.setCategorieId(resultSet.getInt("categorie_id"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return employe;
    }

    @Override
    public void payerSalaire(Employe employe, String mois, Double prime) {

     // TODO: Verifier s'il n'y a pas deja pour le mois selectionne

    // Connexion à la base de données
    try (Connection connection = DbConnection.getConnection()) {
        // Requête SQL pour insérer le paiement
        String sql = "INSERT INTO paiements (prime, salaire_net, mois, annee, date_paiement, employe_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        // Calcul automatique de la date de paiement et de l'année
        LocalDate datePaiement = LocalDate.now(); // Date actuelle du système
        int annee = datePaiement.getYear();       // Année extraite de la date actuelle
        Double salaireNet = employe.getSalaireBrut() + prime;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            // Remplissage des paramètres de la requête
            statement.setDouble(1, prime);
            statement.setDouble(2, salaireNet);
            statement.setString(3, mois);
            statement.setInt(4, annee);
            statement.setDate(5, java.sql.Date.valueOf(datePaiement));
            statement.setInt(6, employe.getId());

            // Exécution de la requête
            int rowsInserted = statement.executeUpdate();

            // Vérification du résultat
            if (rowsInserted == 0) {
                throw new SQLException("Le paiement n'a pas pu être enregistré dans la base de données.");
            }
        }

        } catch (SQLException e) {
            // Gestion des erreurs SQL
            e.printStackTrace();
            throw new RuntimeException("Une erreur est survenue lors de l'enregistrement du paiement.", e);
        }
    }
    
}
