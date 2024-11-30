<%-- 
    Document   : connexion
    Created on : 30 nov. 2024, 16:55:42
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIRH - Connexion</title>
        <%@include file="./header.jsp" %>
    </head>
    <body>
        <div style="max-width: 500px; margin: auto" class="mt-5 shadow-sm p-4 rounded">
            <h2>Veuillez vous connecter</h2>
            <form>
                <div class="mb-3">
                  <label for="exampleInputEmail1" class="form-label">Email</label>
                  <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Mot de passe</label>
                  <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <button type="submit" class="btn w-100" style="background-color: #5c5ffa; color: white">Submit</button>
            </form>
        </div>
    </body>
</html>
