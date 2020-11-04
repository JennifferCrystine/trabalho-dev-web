/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import java.io.IOException;
import MODEL.classes.Artigo;
import MODEL.dao.ArtigoDAO;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author jenniffercrystine
 */
@WebServlet(name = "ArtigoController", urlPatterns = {"/ArtigoController"})
public class ArtigoController extends HttpServlet {
   
    ArtigoDAO artigoDAO = new ArtigoDAO();
    
    
    public List<Artigo> mostrarArtigos() {
        List <Artigo> artigos = new ArrayList();
        artigos = artigoDAO.getArtigos();
        return artigos;        
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }



}
