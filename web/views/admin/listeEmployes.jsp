<%-- 
    Document   : listeEmployes
    Created on : 2 déc. 2024, 08:31:48
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIRH - Liste</title>
        <%@include file="../header.jsp" %>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <div class="container mt-5">
            <h1>Liste des Employés</h1>

            <!-- Message de succès -->
            <%@include file="../successPage.jsp" %>
            <!-- Tableau des employés -->
            <a href="ajoutEmploye" class="btn btn-success">Nouveau employé</a>
            <table class="table table-bordered table-striped mt-3">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Prénom</th>
                        <th>Nom</th>
                        <th>Salaire brut</th>
                        <th>Poste</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="employe" items="${employes}">
                        <tr>
                            <td>${employe.id}</td>
                            <td>${employe.prenom}</td>
                            <td>${employe.nom}</td>
                            <td>${employe.getSalaireBrut()}F CFA</td>
                            <td>${employe.poste}</td>
                            <td class="d-flex gap-2">
                                <a href="paiementSalaire?id=${employe.id}" class="btn btn-success btn-sm">Payer</a>
                                <a href="modifierEmploye?id=${employe.id}" class="btn btn-warning btn-sm">Modifier</a>
                                <a href="ficheDePaie?id=${employe.id}" class="btn btn-info btn-sm">Fiche de paie</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
