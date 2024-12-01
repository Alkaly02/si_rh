/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  HP
 * Created: 1 déc. 2024
 */
DROP DATABASE si_rh;

CREATE DATABASE si_rh;

CREATE TABLE categorie_employes(
    id INT PRIMARY KEY AUTO_INCREMENT,
    libelle VARCHAR(255) NOT NULL
);

CREATE TABLE deductions(
    id INT PRIMARY KEY AUTO_INCREMENT,
    libelle VARCHAR(255) NOT NULL,
    pourcentage DECIMAL NOT NULL
); 

CREATE TABLE categorie_employes_deductions(
    id INT PRIMARY KEY AUTO_INCREMENT,
    categorie_employe_id INT NOT NULL,
    deduction_id INT NOT NULL,
    FOREIGN KEY (categorie_employe_id) REFERENCES categorie_employes(id),
    FOREIGN KEY (deduction_id) REFERENCES deductions(id)
); 

CREATE TABLE employes(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    prenom VARCHAR(255),
    nom VARCHAR(255),
    poste VARCHAR(255),
    salaire_brut DECIMAL,
    type ENUM("ADMIN RH", "EMPLOYE") DEFAULT "EMPLOYE",
    categorie_id INT NOT NULL,
    FOREIGN KEY (categorie_id) REFERENCES employes(id)
); 

CREATE TABLE paiements(
    id INT PRIMARY KEY AUTO_INCREMENT,
    prime DECIMAL,
    salaire_net DECIMAL,
    mois ENUM(
        "Janvier",
        "Février",
        "Mars",
        "Avril",
        "Mais",
        "Juin",
        "Juillet",
        "Août",
        "Septembre",
        "Octobre",
        "Novembre",
        "Décembre"
    ) NOT NULL,
    annee INT NOT NULL,
    date_paiement DATE NOT NULL,
    employe_id INT NOT NULL,
    FOREIGN KEY (employe_id) REFERENCES employes(id)
); 

CREATE TABLE pointages(
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    statut ENUM ("PRESENT", "ABSENT"),
    heure_arrivee TIME,
    heure_depart TIME,
    employe_id INT NOT NULL,
    FOREIGN KEY (employe_id) REFERENCES employes(id)
); 

CREATE TABLE parametres(
    id INT PRIMARY KEY AUTO_INCREMENT,
    debut_journee TIME,
    fin_journee TIME
)