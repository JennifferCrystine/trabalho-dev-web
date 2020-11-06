/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;
import MODEL.dao.UsuarioDAO;
import MODEL.classes.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.util.List;


/**
 *
 * @author jenniffercrystine
 */
@WebServlet(name = "UsuarioCadastro", urlPatterns = {"/UsuarioCadastro"})
public class UsuarioCadastro extends HttpServlet {
    private UsuarioDAO usuarioDAO;

    public UsuarioCadastro(){
        super();
        usuarioDAO = new UsuarioDAO();
    }
    
    
    public List<Usuario> mostrarUsuarioNaoAprovado() {
        List <Usuario> usuarios;
        usuarios = usuarioDAO.getUsuariosNaoAprovados();
        return usuarios;        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");//cria uma variavel que define a acao do doGet
        Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
        request.getSession().setAttribute("usuario", usuario);//salva Usuário na seção
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario= new Usuario();
        
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setNome(request.getParameter("name"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("password"));
        usuario.setAprovado('N');
        String papel = request.getParameter("roles");
        switch (papel) {
            case "option1":
                usuario.setPapel(0); 
                break;
               
            case "option2":
                usuario.setPapel(1);
                break;
                
            case "option3":
                usuario.setPapel(2);
                break;       
        }
        
        usuarioDAO.criar(usuario);
        if (usuarioDAO.isAdmin(usuario)) {            
                RequestDispatcher view = request.getRequestDispatcher("Administrador"); //envia pra home
                view.forward(request, response);
        }
        else if (usuarioDAO.isAutor(usuario)) {            
                RequestDispatcher view = request.getRequestDispatcher("Autor"); //envia pra home
                view.forward(request, response);
        }
        else if (usuarioDAO.isComentarista(usuario)) {            
                RequestDispatcher view = request.getRequestDispatcher("Comentarista"); //envia pra home
                view.forward(request, response);
        }
        else {
            RequestDispatcher view= request.getRequestDispatcher("/index.jsp");//redireciona para home
            view.forward(request, response);
        
        }
        //eu acabo isso aqui e ele redireciona para /UsuarioCadastrado aminha duvida eh sera
        //será que eu coloco esse bloco lá pra cima?
        
    }


}
