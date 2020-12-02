/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import java.io.IOException;
import MODEL.classes.Artigo;
import MODEL.dao.ArtigoDAO;
import MODEL.classes.Usuario;
import MODEL.classes.Categoria;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author jenniffercrystine
 */
@WebServlet(name = "ArtigoController", urlPatterns = {"/ArtigoController"})
public class ArtigoController extends HttpServlet {
   
    ArtigoDAO artigoDAO = new ArtigoDAO();
    
    
    public List<Artigo> mostrarArtigos(String aprovado) {
        List <Artigo> artigos;
        artigos = artigoDAO.getArtigos(aprovado);
        return artigos;        
    } 
    
    public Artigo buscaArtigos(int id) {
        Artigo artigo = artigoDAO.buscaArtigo(id);
        return artigo;
    } 
    
    public List<Artigo> autorArtigos(int id, String aprovado) {
        List <Artigo> artigos;
        artigos = artigoDAO.getUsuarioArtigos(id, aprovado);
        return artigos;        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Artigo artigo = artigoDAO.buscaArtigo(id);
        request.getSession().setAttribute("artigo", artigo);
        request.getRequestDispatcher("page-post.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Artigo artigo= new Artigo();
        Categoria categoria = new Categoria();
        Usuario usuario;
        
        usuario = (Usuario)request.getSession().getAttribute("usuario");
        
        artigo.setTitulo(request.getParameter("title"));
        artigo.setConteudo(request.getParameter("content"));
        artigo.setAprovado('N');
        artigo.setLiberar('S');
        String cat = request.getParameter("category");
        switch (cat) {
            case "Política": //se for politica
                categoria.setIdCategoria(1);
                break;
               
            case "Atualidades": //se for artes
                categoria.setIdCategoria(2);
                break;
                
            case "Artes": //se for atualidades
                categoria.setIdCategoria(3);
                break;    
            
            case "Outros": //se for outros
                categoria.setIdCategoria(4);
                break;   
        }
        
        artigo.setCategoria(categoria);
        artigo.setUsuario(usuario);
        artigoDAO.criar(artigo);
        RequestDispatcher view= request.getRequestDispatcher("page-author-pending-posts.jsp");
        view.forward(request, response);
    }



}
