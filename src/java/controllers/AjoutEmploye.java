/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import dao.CategorieEmployeDao;
import dao.EmployeDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import metier.entities.CategorieEmploye;
import metier.entities.Employe;

/**
 *
 * @author HP
 */
@WebServlet(name = "AjoutEmploye", urlPatterns = {"/ajoutEmploye"})
public class AjoutEmploye extends HttpServlet {
    private EmployeDao employeDao;
    @Override
    public void init() throws ServletException {
        employeDao = new EmployeDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategorieEmployeDao categorieEmployeDao = new CategorieEmployeDao();
        request.setAttribute("categoriesEmployes", categorieEmployeDao.get());
//      Forward de la requete
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/ajoutEmploye.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Récupération des paramètres du formulaire
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String poste = request.getParameter("poste");
        String salaireBrutStr = request.getParameter("salaire_brut");
        String typeEmploye = request.getParameter("type");
        String categorieEmployeId = request.getParameter("categorieEmployeId");

        // Map pour stocker les messages d'erreur
        Map<String, String> errors = new HashMap<>();

        // Validation des champs obligatoires
        if (prenom == null || prenom.trim().isEmpty()) {
            errors.put("prenom", "Le prénom est obligatoire.");
        }

        if (nom == null || nom.trim().isEmpty()) {
            errors.put("nom", "Le nom est obligatoire.");
        }

        if (poste == null || poste.trim().isEmpty()) {
            errors.put("poste", "Le poste est obligatoire.");
        }

        double salaireBrut = 0.0;
        if (salaireBrutStr == null || salaireBrutStr.trim().isEmpty()) {
            errors.put("salaire_brut", "Le salaire brut est obligatoire.");
        } else {
            try {
                salaireBrut = Double.parseDouble(salaireBrutStr);
            } catch (NumberFormatException e) {
                errors.put("salaire_brut", "Veuillez entrer un nombre valide pour le salaire.");
            }
        }

        if (typeEmploye == null || typeEmploye.trim().isEmpty()) {
            errors.put("type", "Le type d'employé est obligatoire.");
        }
        
        if (!"ADMIN RH".equals(typeEmploye) || !"EMPLOYE".equals(typeEmploye)) {
            errors.put("type", "Le type d'employé doit etre ARMIN RH ou EMPLOYE.");
        }

        if (categorieEmployeId == null || categorieEmployeId.trim().isEmpty()) {
            errors.put("categorieEmployeId", "La catégorie d'employé est obligatoire.");
        }

        // Si des erreurs sont présentes, renvoyer au formulaire avec les erreurs
        if (!errors.isEmpty()) {
            CategorieEmployeDao categorieEmployeDao = new CategorieEmployeDao();
            request.setAttribute("categoriesEmployes", categorieEmployeDao.get());
            request.setAttribute("errors", errors);
            request.setAttribute("formData", request.getParameterMap()); // Pour pré-remplir les champs
            request.getRequestDispatcher("views/admin/ajoutEmploye.jsp").forward(request, response);
            return;
        }
        
        Employe employe = new Employe(prenom, nom, poste, salaireBrut, typeEmploye, Integer.parseInt(categorieEmployeId));
        
//        Sauvegarder un employe
        employeDao.save(employe);

    }


}
