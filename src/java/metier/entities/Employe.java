/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier.entities;

import java.io.Serializable;

enum TypeEmploye {
    ADMIN_RH("ADMIN RH"),
    EMPLOYE("EMPLOYE");
    
    public final String label;

    private TypeEmploye(String label) {
        this.label = label;
    }
}

/**
 *
 * @author HP
 */
public class Employe implements Serializable {
    private int id;
    private String prenom;
    private String nom;
    private String poste;
    private Double salaire_brut;
    private TypeEmploye type;
    private int categorie_id;

    public Employe() {}

    public Employe(String prenom, String nom, String poste, Double salaire_brut, TypeEmploye type, int categorie_id) {
        this.prenom = prenom;
        this.nom = nom;
        this.poste = poste;
        this.salaire_brut = salaire_brut;
        this.type = type;
        this.categorie_id = categorie_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Double getSalaire_brut() {
        return salaire_brut;
    }

    public void setSalaire_brut(Double salaire_brut) {
        this.salaire_brut = salaire_brut;
    }

    public TypeEmploye getType() {
        return type;
    }

    public void setType(TypeEmploye type) {
        this.type = type;
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }
    
    
    
}
