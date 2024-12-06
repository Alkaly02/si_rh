/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import dao.CategorieEmployeDao;
import dao.EmployeDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import metier.entities.Employe;

/**
 *
 * @author HP
 */
@WebServlet(name = "ModifierEmploye", urlPatterns = {"/modifierEmploye"})
public class ModifierEmployeServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String employeId = request.getParameter("id");
        
//        Recuperation des categories des employes
        CategorieEmployeDao categorieEmployeDao = new CategorieEmployeDao();
        request.setAttribute("categoriesEmployes", categorieEmployeDao.get());

        EmployeDao employeDao = new EmployeDao();
//        Recuperer l'employe
        Employe employe = employeDao.getOne(Integer.parseInt(employeId));
//        Ajouter l'employer dans la requete
        request.setAttribute("employe", employe);
        request.setAttribute("employeId", employeId);
//        Transfert de la requete
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/modifierEmploye.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Récupération des paramètres du formulaire
        String employeId = request.getParameter("employe_id");
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
//
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

        if (categorieEmployeId == null || categorieEmployeId.trim().isEmpty()) {
            errors.put("categorieEmployeId", "La catégorie d'employé est obligatoire.");
        }

        Employe employe = new Employe(prenom, nom, poste, salaireBrut, typeEmploye, Integer.parseInt(categorieEmployeId));
        employe.setId(Integer.parseInt(employeId));
        
        // Si des erreurs sont présentes, renvoyer au formulaire avec les erreurs
        if (!errors.isEmpty()) {
            CategorieEmployeDao categorieEmployeDao = new CategorieEmployeDao();
            request.setAttribute("categoriesEmployes", categorieEmployeDao.get());
            request.setAttribute("employe", employe);
            request.setAttribute("employeId", employeId);
            request.setAttribute("errors", errors);
            request.setAttribute("formData", request.getParameterMap()); // Pour pré-remplir les champs
            request.getRequestDispatcher("views/admin/modifierEmploye.jsp").forward(request, response);
            return;
        }
        
       
        EmployeDao employeDao = new EmployeDao();
//        Modifier employe
        employeDao.edit(employe);
        
        String message = URLEncoder.encode(prenom +" mis a jour avec succès", "UTF-8");
        response.sendRedirect(request.getContextPath() + "/listeEmployes?successMessage=" + message);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
