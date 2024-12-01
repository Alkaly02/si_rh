/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier.entities;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Presence implements Serializable {
    private int id;
    private String date;
    private String heure_arrivee;
    private String heure_depart;
    private int employe_id;

    public Presence() {}

    public Presence(String date, String heure_arrivee, String heure_depart, int employe_id) {
        this.date = date;
        this.heure_arrivee = heure_arrivee;
        this.heure_depart = heure_depart;
        this.employe_id = employe_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure_arrivee() {
        return heure_arrivee;
    }

    public void setHeure_arrivee(String heure_arrivee) {
        this.heure_arrivee = heure_arrivee;
    }

    public String getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(String heure_depart) {
        this.heure_depart = heure_depart;
    }

    public int getEmploye_id() {
        return employe_id;
    }

    public void setEmploye_id(int employe_id) {
        this.employe_id = employe_id;
    }
    
    
    
    
}
