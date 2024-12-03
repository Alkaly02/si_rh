/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import dao.interfaces.IPointageDao;
import db.DbConnection;
import metier.entities.Employe;

/**
 *
 * @author HP
 */
public class PointageDao implements IPointageDao {

    @Override
    public void marquerPresent(Employe employe) {
        try (Connection connection = DbConnection.getConnection()) {
            // Récupérer les horaires de début et de fin de journée
            String paramQuery = "SELECT debut_journee, fin_journee FROM parametres LIMIT 1";
            PreparedStatement paramStmt = connection.prepareStatement(paramQuery);
            ResultSet paramRs = paramStmt.executeQuery();

            Time debutJournee = paramRs.getTime("debut_journee");
            Time finJournee = paramRs.getTime("fin_journee");
            Time currentTime = new Time(System.currentTimeMillis());

            // Vérifier si le pointage est effectué dans les heures autorisées
            if (currentTime.before(debutJournee) || currentTime.after(finJournee)) {
//                response.getWriter().write("Pointage hors des horaires autorisés.");
                return;
            }

            // Vérifier s'il existe déjà un pointage pour aujourd'hui
            String checkQuery = "SELECT * FROM pointages WHERE employe_id = ? AND date = CURDATE()";
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setInt(1, employe.getId());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // L'employé a déjà un pointage aujourd'hui
                if (rs.getTime("heure_depart") == null) {
                    // Mettre à jour l'heure de départ
                    String updateQuery = "UPDATE pointages SET heure_depart = CURTIME() WHERE id = ?";
                    PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                    updateStmt.setInt(1, rs.getInt("id"));
                    updateStmt.executeUpdate();
                } 
            } else {
                // Enregistrer la présence
                String insertQuery = "INSERT INTO pointages (date, statut, heure_arrivee, employe_id) VALUES (CURDATE(), 'PRESENT', CURTIME(), ?)";
                PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
                insertStmt.setInt(1, employe.getId());
                insertStmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void marquerAbsent(Employe employe) {
    }
    
}
