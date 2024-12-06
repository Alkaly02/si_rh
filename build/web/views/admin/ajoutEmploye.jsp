<%-- 
    Document   : ajoutEmploye
    Created on : 2 déc. 2024, 06:45:46
    Author     : HP
--%>

<%@page import="java.util.List"%>
<%@page import="metier.entities.CategorieEmploye"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIRH - Ajout employe</title>
        <%@include file="../header.jsp" %>
    </head>
    <body>
        <%@include file="../navbar.jsp" %>
        <div class="container">
            <h2 class="text-center mt-4">Ajoutez un employé</h2>
            <c:if test="${not empty errors}">
                <div class="alert alert-danger">
                    <ul>
                        <c:forEach var="error" items="${errors.values()}">
                            <li>${error}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
            <form method="POST" action="ajoutEmploye">
                <div class="d-flex gap-2 mb-3">
                    <div class="flex-fill">
                        <label for="prenom" class="form-label">Prénom</label>
                        <input type="text" class="form-control" id="prenom" name="prenom"> 
                    </div>
                    <div class="flex-fill">
                        <label for="nom" class="form-label">Nom</label>
                        <input type="text" class="form-control" id="nom" name="nom">    
                    </div>
                </div>
                <div class="mb-3">
                  <label for="poste" class="form-label">Poste</label>
                  <input type="text" class="form-control" id="post" name="poste">    
                </div>
                <div class="mb-3">
                  <label for="salaire_brut" class="form-label">Salaire brut</label>
                  <input type="number" class="form-control" id="salaire_brut" name="salaire_brut">    
                </div>
                <div class="mb-3">
                  <label for="type" class="form-label">Type</label>
                  <select class="form-select" aria-label="Selecionner le type d'employé" name="type">
                    <option value="">Sélectionner le type d'employé</option>
                    <option value="ADMIN RH">Admin RH</option>
                    <option value="EMPLOYE">Employé</option>
                  </select>  
                </div>
                <div class="mb-3">
                  <label for="type" class="form-label">Catégorie d'employé</label>
                  <select class="form-select" aria-label="Selecionner la catégorie d'employé" name="categorieEmployeId">
                      <c:choose>
                        <c:when test="${not empty categoriesEmployes}">
                            <c:forEach var="categorieEmploye" items="${categoriesEmployes}">
                                <option value="${categorieEmploye.id}">${categorieEmploye.libelle}</option>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <option value="">Pas encore de catégories d'employés</option>
                        </c:otherwise>
                    </c:choose>
                  </select>  
                </div>
                <button type="submit" class="btn w-100" style="background-color: #5c5ffa; color: white">Enregistrer</button>
            </form>
        </div>
    </body>
</html>
