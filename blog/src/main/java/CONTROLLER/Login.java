/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;
import java.io.IOException;
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
    
    //Fazer função de validação de cpf no banco pra garantir que cpf eh único

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        request.getSession().invalidate();
        request.getSession().setAttribute("usuario", null);        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
        String cpf = request.getParameter("cpf");  //recupera o login informado
        String senha = request.getParameter("password");   //recupera a senha informada
        
        //depois que o campo cpf se tornar único, pegar o usuário pelo cpf e fazer a validação
        Usuario usuario = usuarioDAO.buscaUsuario(cpf);
        int id = usuario.getIdUsuario();
        
        
        boolean existe = usuarioDAO.validarUsuario(cpf, senha);
        boolean aprovado = usuarioDAO.checaSeAprovado(id);
        
        if (existe == true && aprovado == true) {
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
                RequestDispatcher view = request.getRequestDispatcher("Comentarista"); //envia pra home
                view.forward(request, response);
            }
        }
        else {
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        }
        //fazer uma página para dizer que o usuario não possui acesso àquela area sem fazer login
        
        
    }
}
