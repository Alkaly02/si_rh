# Système de Gestion des Employés RH

## Description

Ce projet est un système complet de gestion des ressources humaines conçu pour centraliser les informations RH, suivre les présences et gérer les salaires. Il offre une interface intuitive pour les administrateurs RH et les employés, permettant une gestion efficace des données et des processus RH.

## Fonctionnalités principales

### 1. Gestion des employés

- Formulaire d'enregistrement des employés incluant :
  - Nom
  - Poste
  - Salaire
  - Autres informations pertinentes
- Interface de mise à jour des informations des employés

### 2. Suivi des présences

- Système d'enregistrement des arrivées et départs quotidiens
- Génération de rapports mensuels détaillant :
  - Absences
  - Retards

### 3. Gestion des salaires

- Calcul automatisé des salaires prenant en compte :
  - Jours travaillés
  - Primes
  - Déductions
- Fonctionnalité d'export des bulletins de salaire au format PDF

### 4. Système de connexion sécurisé

- Espace "Admin RH" :
  - Gestion complète des employés
  - Configuration du système
- Espace "Employé" :
  - Consultation des informations personnelles
  - Accès aux bulletins de salaire

## Technologies utilisées

- Backend : Java Enterprise Edition (JEE)
- Vue : JavaServer Pages (JSP) avec JSTL (JavaServer Pages Standard Tag Library)
- Logique de présentation : Expression Language (EL)
- Base de données : MySQL
- Accès aux données : JDBC (Java Database Connectivity)
- Outil de build : Apache Ant

## Prérequis

- JDK 8 ou supérieur
- Serveur d'applications compatible JEE (par exemple, Apache Tomcat)
- MySQL Server
- Apache Ant 1.10 ou supérieur
