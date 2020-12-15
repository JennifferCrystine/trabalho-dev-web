<%-- 
    Document   : page-post
    Created on : Nov 2, 2020, 1:43:49 PM
    Author     : jenniffercrystine
--%>

<%@page import="MODEL.classes.Artigo"%>
<%@page import="MODEL.classes.Comentario"%>
<%@page import="CONTROLLER.ComentarioController"%>
<%@page import="MODEL.classes.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <title>Post</title>
  </head>
  <body>

    <!-- Navbar -->
    <% Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
    if ( usuario == null ) {%>
        <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
            <div class="container">
              <a class="navbar-brand nav-post" href="index.jsp">Blog</a>
              <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                Menu
                <i class="fas fa-bars"></i>
              </button>
              <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                  <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home</a>
                  </li>
                    <li class="nav-item">
                        <a href="" class="nav-link" data-toggle="modal" data-target="#loginModal">Entrar</a>
                    </li>
                </ul>
              </div>
            </div>
        </nav>
        <% } else if (usuario.getPapel() == 0) {%>
         <%@include file="headers/admin-other-header.jsp" %>
        <%} else if(usuario.getPapel() == 1) {%>
            <%@include file="headers/author-other-header.jsp" %>
        <%} else if(usuario.getPapel() == 2) {%>
            <%@include file="headers/commentator-other-header.jsp" %>
        <%}%>
     <!-- Login Modal -->
    <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="loginModalLabel">Login</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form id="form-login" action="Login" method="GET">
              <div class="form-group">
                <label for="user-cpf" class="col-form-label">CPF:</label>
                <input type="number" class="form-control" id="user-cpf" name="login-cpf" placeholder="Informe seu CPF">
                <span class='msg-erro msg-cpf-login' style="color: red; display: none;"></span>
              </div>
              <div class="form-group">
                <label for="user-password" class="col-form-label">Senha:</label>
                <input type="password" class="form-control" id="user-password" name="login-password" placeholder="Informe sua senha"></input>
                <span class='msg-erro msg-password-login' style="color: red; display: none;"></span>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="submit" class="btn btn-primary">Entrar</button>
              </div>
            </form>
          </div>          
        </div>
      </div>
    </div>
    <!-- JavaScript (Opcional) -->
    <!-- jQuery, Popper.js, Bootstrap JS --> 
    <script src="assets/js/jquery-3.5.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap/bootstrap.min.js"></script>

      <!-- Header -->
    <header class="masthead-post">
        <div class="container">
            <div class="row">
                <div class="mx-auto">
                    <div class="post-heading">
                        <%Artigo artigo = (Artigo)request.getSession().getAttribute("artigo"); %>                      
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Post content -->
    <div class="container post-content">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <h1><%out.println(artigo.getTitulo()); %></h1>
                <p class="post-category"><i><%out.println(artigo.getCategoria().getDescricao()); %></i></p>
                    <span class="meta">Postado por <b><%out.println(artigo.getUsuario().getNome()); %></b></span>
                    <p><span><%out.println(artigo.getConteudo()); %></span></p>
            </div>
        </div>
    </div>

    <!-- Post comments -->
    <div class="container post-comments mt-5">
      <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
              <h3 class="mb-4">Comentários</h3>
              <% ComentarioController comentarioCTRL = new ComentarioController(); 
                for (Comentario comentario : comentarioCTRL.getArtigoComentarios(artigo)) {%>
                    <div class="div">
                        <h5 class="post-commentator-name"><%out.println(comentario.getUsuario().getNome()); %></h5>
                        <p class="post-comment-content"> <%out.println(comentario.getComentario()); %></p>
                    </div>
                <%}%>           
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