<%-- 
    Document   : paiementSalaire
    Created on : 3 déc. 2024, 20:58:06
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIRH - Paiement Salaire</title>
        <%@include file="../header.jsp" %>
    </head>
    <body>
        <div class="container">
            <h2 class="text-center mt-4">Paiment salaire de un employé ${employe.getPrenom()} ${employe.getNom()}</h2>
            <c:if test="${not empty errors}">
                <div class="alert alert-danger">
                    <ul>
                        <c:forEach var="error" items="${errors.values()}">
                            <li>${error}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
            <form method="POST" action="paiementSalaire">
                    <div class="d-flex gap-2">
                    <div class="mb-3 flex-fill">
                        <label for="prime" class="form-label">Prime</label>
                        <input type="number" class="form-control" id="post" name="prime">    
                    </div>
                    <div class="mb-3 flex-fill">
                        <label for="type" class="form-label">Mois</label>
                        <select class="form-select" aria-label="Selecionner le mois de paie" name="mois">
                          <option value="">Sélectionner le mois de paie</option>
                          <option value="Janvier">Janvier</option>
                          <option value="Février">Février</option>
                          <option value="Mars">Mars</option>
                          <option value="Avril">Avril</option>
                          <option value="Mai">Mai</option>
                          <option value="Juin">Juin</option>
                          <option value="Juillet">Juillet</option>
                          <option value="Août">Août</option>
                          <option value="Septembre">Septembre</option>
                          <option value="Octobre">Octobre</option>
                          <option value="Novembre">Novembre</option>
                          <option value="Décembre">Décembre</option>
                        </select>  
                    </div>
                </div>
                <input type="hidden" value="${employeId}" name="employe_id" />
                <button type="submit" class="btn w-100" style="background-color: #5c5ffa; color: white">Payer</button>
            </form>
        </div>
    </body>
</html>
