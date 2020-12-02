/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;
import MODEL.dao.ArtigoDAO;
import MODEL.classes.Artigo;
import MODEL.classes.Categoria;
import MODEL.classes.Usuario;
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
@WebServlet(name = "EditarArtigoController", urlPatterns = {"/EditarArtigoController"})
public class EditarArtigoController extends HttpServlet {
    
    ArtigoDAO artigoDAO = new ArtigoDAO();
    
    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titulo, conteudo;
        int idArtigo = Integer.parseInt(request.getParameter("id"));
        int idCategoria = 0;
        Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
        titulo = request.getParameter("title");
        conteudo = request.getParameter("content");
        String cat = request.getParameter("category");
        switch (cat) {
            case "Política": //se for politica
                idArtigo = 1;
                break;
               
            case "Atualidades": //se for artes
                idArtigo =  2;
                break;
                
            case "Artes": //se for atualidades
                idArtigo = 3;
                break;    
            
            case "Outros": //se for outros
                idArtigo = 4;
                break;   
        }
        artigoDAO.editar(idArtigo, titulo, conteudo, idCategoria);
        if (usuario.getPapel() == 0){
            RequestDispatcher view= request.getRequestDispatcher("page-admin-home.jsp");
            view.forward(request, response);
        }
        else if (usuario.getPapel() == 1) {
            RequestDispatcher view= request.getRequestDispatcher("page-author-pending-posts.jsp");
            view.forward(request, response);    
        }
    }

}
