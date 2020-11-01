/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;
import MODEL.dao.UsuarioDAO;
import MODEL.classes.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

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
        usuario.setNome(request.getParameter("nome"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setCpf(request.getParameter("login"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setAprovado(false);
        
        String papel = (request.getParameter("papel"));
        switch (papel) {
            case "Admin":
                usuario.setPapel(0); 
                break;
               
            case "Autor":
                usuario.setPapel(1);
                break;
                
            case "Comentarista":
                usuario.setPapel(2);
                break;       
        }
  
        if(request.getParameter("editar") == null)//se a variavel for null, cria Usuário
        {
            this.usuarioDAO.criar(usuario);
            RequestDispatcher view= request.getRequestDispatcher("/.jsp");//redireciona para pagina de login
            view.forward(request, response);
        }
        else if (request.getParameter("editar").equals("editar"))//se nao for igual a "editar", edita o Aluno
        {
            this.usuarioDAO.editar(usuario, usuario.getIdUsuario());
            RequestDispatcher view= request.getRequestDispatcher("/index.jsp");//redireciona para index
            view.forward(request, response);
        }
    }


}
