/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import java.io.IOException;
import MODEL.classes.Comentario;
import MODEL.dao.ComentarioDAO;
import MODEL.classes.Artigo;
import MODEL.classes.Usuario;
import MODEL.dao.ArtigoDAO;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "ComentarioController", urlPatterns = {"/ComentarioController"})
public class ComentarioController extends HttpServlet {
    ComentarioDAO comentarioDAO = new ComentarioDAO();
    ArtigoDAO artigoDAO = new ArtigoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Artigo artigo = artigoDAO.buscaArtigo(id);
        request.getSession().setAttribute("artigo", artigo);
        request.getRequestDispatcher("page-commentator-post.jsp").forward(request, response);
    
    }
    
    public List<Comentario> getArtigoComentarios(Artigo artigo){
        List<Comentario> comentarios;
        comentarios = comentarioDAO.getArtigoComentarios(artigo);
        return comentarios;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Comentario comentario = new Comentario();
        comentario.setArtigo((Artigo)request.getSession().getAttribute("artigo"));
        comentario.setUsuario((Usuario)request.getSession().getAttribute("usuario"));
        comentario.setComentario(request.getParameter("commentary-content"));
        comentarioDAO.criar(comentario);
        RequestDispatcher view= request.getRequestDispatcher("page-commentator-post.jsp");
        view.forward(request, response);
        
    }

}
