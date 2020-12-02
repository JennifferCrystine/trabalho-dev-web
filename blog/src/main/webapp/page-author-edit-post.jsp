<%-- 
    Document   : page-author-edit-post
    Created on : 2 de dez de 2020, 12:27:46
    Author     : jenniffercrystine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.classes.Artigo"%>
<%@page import="CONTROLLER.CategoriaController"%>
<%@page import="MODEL.classes.Categoria"%>
<%@page import="MODEL.classes.Comentario"%>
<%@page import="CONTROLLER.ArtigoController"%>
<%@page import="CONTROLLER.EditarArtigoController"%>
<%@page import="MODEL.classes.Usuario"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<!-- Create post author's page -->
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <title>Editar postagem pendente</title>
  </head>
  <body>
       <%   int id = Integer.parseInt(request.getParameter("id"));
            ArtigoController artigoCTRL = new ArtigoController();
            EditarArtigoController editarCTRL = new EditarArtigoController();
            Artigo artigo = artigoCTRL.buscaArtigos(id);                
        %>

    <!-- Navbar -->
    <% Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
    if (usuario.getPapel() == 0) {%>
        <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
            <div class="container">
              <a class="navbar-brand nav-post" href="page-admin-home.jsp">Blog</a>
              <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                Menu
                <i class="fas fa-bars"></i>
              </button>
              <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                  <li class="nav-item">
                      <a class="nav-link" href="page-admin-home.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="page-admin-pending-users.jsp">Usuários Pendentes</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="page-admin-authorized-users.jsp">Usuários Autorizados</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="Administrador">Postagens Pendentes</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" method="POST" href="Logout">Sair</a>
                    </li>

                </ul>
              </div>
            </div>
        </nav>
        <%} else if(usuario.getPapel() == 1) {%>
            <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
                <div class="container">
                  <a class="navbar-brand nav-post" href="page-author-home.jsp">Blog</a>
                  <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                  </button>
                  <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                      <li class="nav-item">
                        <a class="nav-link" href="page-author-home.jsp">Home</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="page-author-create-post.jsp">Criar Postagem</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="page-author-pending-posts.jsp">Minhas postagens pendentes</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" method="POST" href="Logout">Sair</a>
                      </li>
                    </ul>
                  </div>
                </div>
          </nav>
        <% }%>
    
    <!-- JavaScript (Opcional) -->
    <!-- jQuery, Popper.js, Bootstrap JS --> 
    <script src="assets/js/jquery-3.5.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap/bootstrap.min.js"></script>
    <div class="container mt-5">
      <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
              <div class="create-post">   
                <h2>Editar postagem pendente</h2>
               
                <form class="mt-3" method="POST" action="EditarArtigoController?id=<%= artigo.getIdArtigo() %>">
                  <div class="form-group">
                    <label for="creating-post-title">Título da Postagem</label>
                    <input type="text" class="form-control" name="title" id="creating-post-title" value="<%= artigo.getTitulo() %>">
                  </div>                    
                  <div class="form-group">
                    <label for="creating-ṕost-content">Edite o conteúdo da postagem</label>
                    <textarea class="form-control" name="content" id="creating-ṕost-content" rows="10"><%= artigo.getConteudo() %></textarea>
                  </div>
                 <div class="form-group">
                    <label for="exampleFormControlSelect1">Categoria</label>                  
                    <% CategoriaController categoriaCTRL = new CategoriaController();%>
                    <% try {
                        for (Categoria categoria : categoriaCTRL.getCategorias()) { 
                            if (categoria != null) { %>
                                <select class="form-control" id="exampleFormControlSelect1" name="category">
                                  <option><% out.println(categoria.getDescricao()); %></option>
                                </select>
                            <% } else {
                                    break;
                               }
                            }%>                        
                    <%} catch (NullPointerException ex) { %> 
                                <select class="form-control" id="exampleFormControlSelect1" name="category">
                                  <option>Política</option>
                                  <option>Atualidades</option>
                                  <option>Artes</option>
                                  <option>Outros</option>
                                </select>
                        <%}%>            
                  </div>
                  <div class="text-center">
                    <button type="submit" class="btn btn-primary">Pedir autorização para postar</button>
                  </div>
                </form>
              </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <hr class="mt-5">
    <footer>
        <div class="container">
          <div class="row">
            <div class="mx-auto">
              <p class="copyright">Copyright &copy; Blog 2020</p>
            </div>
          </div>
        </div>
    </footer>
  </body>
</html>