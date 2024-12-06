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
public class Paiement implements Serializable {
    private int id;
    private Double prime;
    private Double salaire_net;
    private Mois mois;
    private int annee;
    private String date_paiement;
    private Employe employe;
    
    public static enum Mois{
    Janvier("Janvier"),
    Fevrier("Fevrier"),
    Mars("Mars"),
    Avril("Avril"),
    Mai("Mai"),
    Juin("Juin"),
    Juillet("Juillet"),
    Aout("Août"),
    Septembre("Septembre"),
    Octobre("Octobre"),
    Novembre("Novembre"),
    Decembre("Decembre");
    
    public final String label;
    
    private Mois(String label){
        this.label = label;
    }
}

    public Paiement() {}

    public Paiement(Double prime, Double salaire_net, Mois mois, int annee, String date_paiement, Employe employe) {
        this.prime = prime;
        this.salaire_net = salaire_net;
        this.mois = mois;
        this.annee = annee;
        this.date_paiement = date_paiement;
        this.employe = employe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPrime() {
        return prime;
    }

    public void setPrime(Double prime) {
        this.prime = prime;
    }

    public Double getSalaireNet() {
        return salaire_net;
    }

    public void setSalaireNet(Double salaire_net) {
        this.salaire_net = salaire_net;
    }

    public Mois getMois() {
        return mois;
    }

    public void setMois(Mois mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getDatePaiement() {
        return date_paiement;
    }

    public void setDatePaiement(String date_paiement) {
        this.date_paiement = date_paiement;
    }

    public Employe getEmploye() {
        return this.employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
