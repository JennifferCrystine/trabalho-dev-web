/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import MODEL.dao.ArtigoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jenniffercrystine
 */
@WebServlet(name = "DesaprovarArtigo", urlPatterns = {"/DesaprovarArtigo"})
public class DesaprovarArtigo extends HttpServlet {
    
    ArtigoDAO artigoDAO = new ArtigoDAO();
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id;
        id = Integer.parseInt(request.getParameter("id"));        
        artigoDAO.reprovaArtigo(id);
        RequestDispatcher view = request.getRequestDispatcher("page-admin-home.jsp");
        view.forward(request, response);
    }


//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }



}
