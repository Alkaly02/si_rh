/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.interfaces.IDeductionDao;
import db.DbConnection;
import metier.entities.Deduction;

import java.sql.*;


/**
 *
 * @author HP
 */
public class DeductionDao implements IDeductionDao{
    
    /*
    Assurance maladie: 5%
    Assurance retraite: 10%
    Assurance chômage: 4%
    Accidents du travail: 2%
    Impôts sur le revenu: 10%
    */

//    Sauvegarder une deduction
    @Override
    public Deduction save(Deduction d){
//      Recuperation de la connexion a la base de donnees
        try(Connection connection = DbConnection.getConnection();){
//          Preparation de la requete
            String query = "INSERT INTO deductions (libelle, pourcentage) VALUES(?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, d.getLibelle());
            ps.setDouble(2, d.getPourcentage());
//          Executer la requete
            ps.executeUpdate();
//          Recuperation de l'id de la deduction ajoutee
            PreparedStatement ps2 = connection.prepareStatement("SELECT MAX(id) as id_deduction FROM deductions");
            ResultSet resultSet = ps2.executeQuery();
            while(resultSet.next()){
//              Ajouter l'id recuperer a la deduction actuelle
                d.setId(resultSet.getInt("id_deduction"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return d;
    }
    
}
