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
        <div class="container mt-5">
            <h1>Liste des Employés</h1>

            <!-- Message de succès -->
            <%--<c:if test="${not empty successMessage}">--%>
                <div class="alert alert-success" role="alert">
                    <%= request.getParameter("successMessage") %>
                </div>
            <%--</c:if>--%>

            <!-- Tableau des employés -->
            <table class="table table-bordered table-striped mt-3">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Prénom</th>
                        <th>Nom</th>
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
                            <td>${employe.poste}</td>
                            <td class="d-flex gap-2">
                                <a href="paiementSalaire?id=${employe.id}" class="btn btn-success btn-sm">Payer</a>
                                <a href="modifierEmploye?id=${employe.id}" class="btn btn-warning btn-sm">Modifier</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
