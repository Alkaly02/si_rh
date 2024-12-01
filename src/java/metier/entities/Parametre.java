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
public class Parametre implements Serializable {
    private int id;
    private String debut_journee;
    private String fin_journee;

    public Parametre() {}

    public Parametre(String debut_journee, String fin_journee) {
        this.debut_journee = debut_journee;
        this.fin_journee = fin_journee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDebut_journee() {
        return debut_journee;
    }

    public void setDebut_journee(String debut_journee) {
        this.debut_journee = debut_journee;
    }

    public String getFin_journee() {
        return fin_journee;
    }

    public void setFin_journee(String fin_journee) {
        this.fin_journee = fin_journee;
    }
    
        
}
