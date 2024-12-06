/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.IPaiementDao;
import db.DbConnection;
import java.util.ArrayList;
import java.util.List;
import metier.entities.Paiement;
import java.sql.*;
import metier.entities.CategorieEmploye;
import metier.entities.Deduction;
import metier.entities.Employe;

/**
 *
 * @author HP
 */
public class PaiementDao implements IPaiementDao{

    @Override
    public List<Paiement> getAll() {
        List<Paiement> paiements = new ArrayList<>();
        String sql = "SELECT p.id, p.prime, p.salaire_net, p.mois, p.annee, p.date_paiement, " +
                     "e.id AS employe_id, e.prenom, e.nom, e.poste " +
                     "FROM paiements p " +
                     "JOIN employes e ON p.employe_id = e.id";

        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Paiement paiement = new Paiement();
                paiement.setId(rs.getInt("id"));
                paiement.setPrime(rs.getDouble("prime"));
                paiement.setSalaireNet(rs.getDouble("salaire_net"));
                paiement.setMois(Paiement.Mois.valueOf(rs.getString("mois")));
                paiement.setAnnee(rs.getInt("annee"));
                paiement.setDatePaiement(rs.getString("date_paiement"));

                Employe employe = new Employe();
                employe.setId(rs.getInt("employe_id"));
                employe.setPrenom(rs.getString("prenom"));
                employe.setNom(rs.getString("nom"));
                employe.setPoste(rs.getString("poste"));

                paiement.setEmploye(employe);
                paiements.add(paiement);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Gérer les exceptions correctement
        }

        return paiements;
    }
    
    @Override
    public Paiement getFichePaieByEmployeId(int employeId) {
        Paiement paiement = null;
        String sql = "SELECT p.id, p.prime, p.salaire_net, p.mois, p.annee, p.date_paiement, " +
                     "p.employe_id, e.prenom, e.nom, e.poste, e.salaire_brut, e.type, e.categorie_id, " +
                     "c.libelle AS categorie_libelle " +
                     "FROM paiements p " +
                     "JOIN employes e ON p.employe_id = e.id " +
                     "JOIN categorie_employes c ON e.categorie_id = c.id " +
                     "WHERE p.employe_id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employeId);  // Paramétrer l'employe_id

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Récupérer l'employé et sa catégorie
                    Employe employe = new Employe();
                    employe.setId(rs.getInt("employe_id"));
                    employe.setPrenom(rs.getString("prenom"));
                    employe.setNom(rs.getString("nom"));
                    employe.setPoste(rs.getString("poste"));
                    employe.setSalaireBrut(rs.getDouble("salaire_brut"));
                    employe.setType(rs.getString("type"));

                    // Récupérer la catégorie de l'employé
                    CategorieEmploye categorie = new CategorieEmploye();
                    categorie.setId(rs.getInt("categorie_id"));
                    categorie.setLibelle(rs.getString("categorie_libelle"));
                    employe.setCategorie(categorie);

                    // Récupérer le paiement
                    paiement = new Paiement();
                    paiement.setId(rs.getInt("id"));
                    paiement.setPrime(rs.getDouble("prime"));
                    paiement.setSalaireNet(rs.getDouble("salaire_net"));

                    // Mapper l'énumération Mois
                    String moisString = rs.getString("mois");
                    paiement.setMois(Paiement.Mois.valueOf(moisString));

                    paiement.setAnnee(rs.getInt("annee"));
                    paiement.setDatePaiement(rs.getString("date_paiement"));
                    paiement.setEmploye(employe);  // Associer l'employé au paiement

                    // Récupérer les déductions liées à la catégorie de l'employé
                    List<Deduction> deductions = new ArrayList<>();
                    String deductionSql = "SELECT d.id, d.libelle, d.pourcentage " +
                                           "FROM deductions d " +
                                           "JOIN categorie_employes_deductions ced ON d.id = ced.deduction_id " +
                                           "WHERE ced.categorie_employe_id = ?";
                    try (PreparedStatement deductionStmt = conn.prepareStatement(deductionSql)) {
                        deductionStmt.setInt(1, employe.getCategorie().getId());
                        try (ResultSet deductionRs = deductionStmt.executeQuery()) {
                            while (deductionRs.next()) {
                                Deduction deduction = new Deduction();
                                deduction.setId(deductionRs.getInt("id"));
                                deduction.setLibelle(deductionRs.getString("libelle"));
                                deduction.setPourcentage(deductionRs.getDouble("pourcentage"));
                                deductions.add(deduction);
                            }
                        }
                    }
                    employe.setDeductions(deductions);  // Associer les déductions à l'employé
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paiement;
    }
    
}
