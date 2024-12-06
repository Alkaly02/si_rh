/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier.entities;

import java.io.Serializable;
import java.util.List;

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
    private String type;
    private int categorie_id;
    private CategorieEmploye categorie;
    private List<Deduction> deductions;

    public Employe() {}

    public Employe(String prenom, String nom, String poste, Double salaire_brut, String type, int categorie_id) {
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

    public Double getSalaireBrut() {
        return salaire_brut;
    }

    public void setSalaireBrut(Double salaire_brut) {
        this.salaire_brut = salaire_brut;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCategorieId() {
        return categorie_id;
    }

    public void setCategorieId(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    public CategorieEmploye getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieEmploye categorie) {
        this.categorie = categorie;
    }

    public List<Deduction> getDeductions() {
        return deductions;
    }

    public void setDeductions(List<Deduction> deductions) {
        this.deductions = deductions;
    }
    
    
    
}
