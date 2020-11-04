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
import MODEL.classes.Usuario;
import MODEL.dao.UsuarioDAO;
import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author jenniffercrystine
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();

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
        request.getSession().setAttribute("usuario", null); 
//        request.getRequestDispatcher("../../webapp/VIEW/index.jsp").forward(request, response);
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
        
        String cpf = request.getParameter("cpf");  //recupera o login informado
        String senha = request.getParameter("password");   //recupera a senha informada
        
        Usuario usuario = new Usuario();
        
        usuario = usuarioDAO.validarUsuario(cpf, senha);
        int id = usuario.getIdUsuario();
        if (usuarioDAO.checaSeAprovado(id) == 1) {
            if (usuarioDAO.isAdmin(usuario)) {
                request.getSession().setAttribute("usuario", usuario);
                Cookie cookieLogin=new Cookie("login", cpf);   //implementação de cookie dos dados de login
                Cookie cookieSenha= new Cookie("senha",senha);
                cookieLogin.setMaxAge(60*60);
                cookieSenha.setMaxAge(60*60);
                response.addCookie(cookieLogin);
                response.addCookie(cookieSenha);
                RequestDispatcher view = request.getRequestDispatcher("Administrador"); //envia pra home
                view.forward(request, response);
            }
            else if (usuarioDAO.isAutor(usuario)) {
                request.getSession().setAttribute("usuario", usuario);
                Cookie cookieLogin=new Cookie("login", cpf);   //implementação de cookie dos dados de login
                Cookie cookieSenha= new Cookie("senha",senha);
                cookieLogin.setMaxAge(60*60);
                cookieSenha.setMaxAge(60*60);
                response.addCookie(cookieLogin);
                response.addCookie(cookieSenha);
                RequestDispatcher view = request.getRequestDispatcher("Autor"); //envia pra home
                view.forward(request, response);
            }
            else if (usuarioDAO.isComentarista(usuario)) {
                request.getSession().setAttribute("usuario", usuario);
                Cookie cookieLogin=new Cookie("login", cpf);   //implementação de cookie dos dados de login
                Cookie cookieSenha= new Cookie("senha",senha);
                cookieLogin.setMaxAge(60*60);
                cookieSenha.setMaxAge(60*60);
                response.addCookie(cookieLogin);
                response.addCookie(cookieSenha);
                RequestDispatcher view = request.getRequestDispatcher("/page-author-home.jsp"); //envia pra home
                view.forward(request, response);
            }
        }
        
        
    }
}
