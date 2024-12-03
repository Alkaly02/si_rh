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
import java.net.URLEncoder;
import metier.entities.Employe;

/**
 *
 * @author HP
 */
@WebServlet(name = "PaiementEmployeServlet", urlPatterns = {"/paiementSalaire"})
public class PaiementSalaireServlet extends HttpServlet {


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
         
        EmployeDao employeDao = new EmployeDao();
//        Recuperer l'employe
        Employe employe = employeDao.getOne(Integer.parseInt(employeId));
//        Ajouter l'employer dans la requete
        request.setAttribute("employe", employe);
        request.setAttribute("employeId", employeId);
//        Transfert de la requete
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/paiementSalaire.jsp");
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
//        Recuperation des params
        String mois = request.getParameter("mois");
        String prime = request.getParameter("prime");
        String employeId = request.getParameter("employe_id");
        
//        Initialisation de la couche DAO
        EmployeDao employeDao = new EmployeDao();
//        Recuperer l'employe
        Employe employe = employeDao.getOne(Integer.parseInt(employeId));
//        Parer
        employeDao.payerSalaire(employe, mois, Double.valueOf(prime));
        
//        tranfert de la requete vers la liste des employes
        String message = URLEncoder.encode("Paiement effectué", "UTF-8");
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
