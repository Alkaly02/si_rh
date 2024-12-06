<%-- 
    Document   : listePaiements
    Created on : 5 déc. 2024, 23:08:43
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIRH - Liste Paiements</title>
        <%@include file="../header.jsp" %>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <div class="container">
            <h1>Liste des Paiements des Employés</h1>
            <table class="table table-bordered table-striped mt-3">
                <thead>
                    <tr>
                        <th>Employé</th>
                        <th>Poste</th>
                        <th>Prime</th>
                        <th>Salaire Net</th>
                        <th>Mois</th>
                        <th>Année</th>
                        <th>Date de Paiement</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="paiement" items="${paiements}">
                        <tr>
                            <td>${paiement.employe.prenom} ${paiement.employe.nom}</td>
                            <td>${paiement.employe.poste}</td>
                            <td>${paiement.prime}</td>
                            <td>${paiement.salaireNet}</td>
                            <td>${paiement.mois}</td>
                            <td>${paiement.annee}</td>
                            <td>${paiement.datePaiement}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
