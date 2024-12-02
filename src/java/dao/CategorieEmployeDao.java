/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.ICategorieEmployeDao;
import db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.entities.CategorieEmploye;

/**
 *
 * @author HP
 */
public class CategorieEmployeDao implements ICategorieEmployeDao{
    
//   Sauvegarde d'une categorie
    @Override
    public CategorieEmploye save(CategorieEmploye c) {
//      Recuperation de la connexion a la base de donnees
        try(Connection connection = DbConnection.getConnection();){
//          Preparation de la requete
            String query = "INSERT INTO categorie_employes (libelle) VALUES(?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, c.getLibelle());
//          Executer la requete
            ps.executeUpdate();
//          Recuperation de l'id de la categorie ajoutee
            PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(id) as id_categorie FROM categorie_employes");
            ResultSet resultSet = ps2.executeQuery();
            while(resultSet.next()){
//              Ajouter l'id recuperer a la categorie actuelle
                c.setId(resultSet.getInt("id_categorie"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<CategorieEmploye> get() {
        List<CategorieEmploye> categories = new ArrayList<>();
        //      Recuperation de la connexion a la base de donnees
        try(Connection connection = DbConnection.getConnection();){
//          Preparation de la requete
            String query = "SELECT * FROM categorie_employes";
            PreparedStatement ps = connection.prepareStatement(query);
//          Executer la requete
            ResultSet cetagoriesResultSet = ps.executeQuery();
            while(cetagoriesResultSet.next()){
                CategorieEmploye categorie = new CategorieEmploye(cetagoriesResultSet.getString("libelle"));
                categorie.setId(cetagoriesResultSet.getInt("id"));
                categories.add(categorie);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return categories;
    }
    
}
