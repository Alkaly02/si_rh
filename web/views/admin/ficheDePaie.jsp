<%-- 
    Document   : ficheDePaie
    Created on : 5 déc. 2024, 23:58:17
    Author     : HP
--%>

<%@ page import="java.util.*, metier.entities.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIRH - Fiche de Paie</title>
        <%@include file="../header.jsp" %>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <div class="container">
            <div class="my-4">
                <div class="d-flex align-items-center gap-2">
                    <h1>Fiche de Paie</h1>
                    <form action="telechargerFichePaie" method="GET">
                        <input type="hidden" name="id" value="${fichePaie.employe.id}" />
                        <button type="submit" class="btn btn-warning">Télécharger la fiche de paie</button>
                    </form>
                </div>
                <c:if test="${fichePaie != null}">
                    <p>Employé : ${fichePaie.employe.prenom} ${fichePaie.employe.nom}</p>
                    <p>Poste : ${fichePaie.employe.poste}</p>
                    <p>Date de Paiement : ${fichePaie.getDatePaiement()}</p>
                    <p>Année : ${fichePaie.annee}, Mois : ${fichePaie.mois}</p>
                </c:if>
            </div>
            
            <!-- Informations Employé -->
        <div class="section-title">Informations Employé</div>
        <table class="table table-bordered">
            <tbody>
                <tr>
                    <th>Nom</th>
                    <td>${fichePaie.employe.nom} ${fichePaie.employe.prenom}</td>
                </tr>
                <tr>
                    <th>Poste</th>
                    <td>${fichePaie.employe.poste}</td>
                </tr>
                <tr>
                    <th>Catégorie</th>
                    <td>${fichePaie.employe.categorie.libelle}</td>
                </tr>
                <tr>
                    <th>Salaire Brut</th>
                    <td>${fichePaie.employe.getSalaireBrut()} F CFA</td>
                </tr>
            </tbody>
        </table>
        <!-- Détails du Paiement -->
        <div class="section-title">Détails du Paiement</div>
        <table class="table table-bordered">
            <tbody>
                <tr>
                    <th>Prime</th>
                    <td>${fichePaie.prime} EUR</td>
                </tr>
                <tr>
                    <th>Salaire Net</th>
                    <td>${fichePaie.getSalaireNet()} F CFA</td>
                </tr>
                <tr>
                    <th>Mois</th>
                    <td>${fichePaie.mois}</td>
                </tr>
                <tr>
                    <th>Date de Paiement</th>
                    <td>${fichePaie.getDatePaiement()}</td>
                </tr>
            </tbody>
        </table>
                <!-- Déductions -->
        <div class="section-title">Déductions</div>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Libellé</th>
                    <th>Pourcentage</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="deduction" items="${fichePaie.employe.deductions}">
                    <tr>
                        <td>${deduction.libelle}</td>
                        <td>${deduction.pourcentage} %</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </body>
</html>
