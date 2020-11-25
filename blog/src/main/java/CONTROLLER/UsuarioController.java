/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import MODEL.dao.UsuarioDAO;
import javax.servlet.RequestDispatcher;
import java.util.List;
import MODEL.classes.Usuario;

/**
 *
 * @author jenniffercrystine
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController"})
public class UsuarioController extends HttpServlet {

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public List<Usuario> getUsuariosAprovados(){
        List<Usuario> usuarios = usuarioDAO.getUsuariosAprovados();
        return usuarios;        
    }
    
    public String getUsuarioPapel(int papel){
        switch (papel){
            case 0:
                return "Admin";
                
            case 1:
                return "Autor";
              
            case 2:
                return "Comentarista";
            
            default:
                return "Inexistente";
            
        }
            
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view= request.getRequestDispatcher("page-admin-authorized-users.jsp");//redireciona para home de usuario não logado
        view.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuarioDeletar = usuarioDAO.buscaUsuario(id);
        Usuario usuarioAtual = (Usuario)request.getSession().getAttribute("usuario");
        
        if (usuarioAtual.getIdUsuario() == id) {
            RequestDispatcher view= request.getRequestDispatcher("page-admin-home.jsp");//redireciona para home de usuario não logado
            view.forward(request, response);
        }
        else{
            usuarioDAO.remover(usuarioDeletar);
            RequestDispatcher view= request.getRequestDispatcher("page-admin-authorized-users.jsp");//redireciona para home de usuario não logado
            view.forward(request, response);
        }
        
        
    }
}
