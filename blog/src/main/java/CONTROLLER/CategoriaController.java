/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import java.io.IOException;
import MODEL.classes.Categoria;
import MODEL.dao.CategoriaDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import java.lang.NullPointerException;


/**
 *
 * @author jenniffercrystine
 */
@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {
    CategoriaDAO categoriaDAO;
    
    
    public List<Categoria> getCategorias() throws NullPointerException {
       List<Categoria> categorias = new ArrayList();
        try{ 
        categorias = categoriaDAO.getCategorias();    
        } catch (NullPointerException ex) {
            throw new NullPointerException("Lista vazia");
        }        
        return categorias;
        
    }
  
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int a;
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//         int a;
//    }   
}
