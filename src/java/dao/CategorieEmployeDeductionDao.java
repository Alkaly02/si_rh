/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.ICategorieEmployeDeductionDao;
import db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class CategorieEmployeDeductionDao implements ICategorieEmployeDeductionDao{

    //    Faire la logique la sauvegarde dans la table many to many entre employes et deductions
    @Override
    public void save(int categorie_employe_id, int deduction_id) {
//      Recuperation de la connexion a la base de donnees
        try(Connection connection = DbConnection.getConnection();){
//          Preparation de la requete
            String query = "INSERT INTO categorie_employes_deductions (categorie_employe_id, deduction_id) VALUES(?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, categorie_employe_id);
            ps.setInt(2, deduction_id);
//          Executer la requete
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
