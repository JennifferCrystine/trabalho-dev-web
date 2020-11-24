<%-- 
    Document   : page-admin-pending-posts
    Created on : Nov 2, 2020, 1:51:34 PM
    Author     : jenniffercrystine
--%>
<%@page import="CONTROLLER.ArtigoController" %>
<%@page import="MODEL.classes.Artigo" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <title>Postagens Pendentes</title>
  </head>
  <body>

    <!-- Navbar -->
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
                <a class="nav-link" href="page-admin-pending-posts.jsp">Postagens Pendentes</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" method="GET" href="Logout">Sair</a>
              </li>
              
            </ul>
          </div>
        </div>
    </nav>
    
    <!-- JavaScript (Opcional) -->
    <!-- jQuery, Popper.js, Bootstrap JS --> 
    <script src="assets/js/jquery-3.5.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap/bootstrap.min.js"></script>
 
    <!-- Main Content -->
    <div class="container pendig-posts mt-5">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">     
          <% ArtigoController artigoCTRL = new ArtigoController();%>
                <% for(Artigo artigo : artigoCTRL.mostrarArtigos("N")){ %>
          <div class="post-preview">              
                <a href="page-post.jsp">                
                <div class="row post-title-button justify-content-between">
                    <div class="col-10">
                        <h2 class="post-title">
                            <% out.println(artigo.getTitulo()); %>
                        </h2>
                    </div>
                    <div class="col-2">
                        <form action="ArtigoController" method="post"> 
                            <a method="GET" href="AprovarArtigoController?id=<%= artigo.getIdArtigo()%>">Aprovar</a>
                        </form> 
                    </div>
                </div>
            </a>
            <p class="post-category"><% out.println(artigo.getCategoria().getDescricao()); %></p>
            <p class="post-meta">Postado por <%out.println(artigo.getUsuario().getNome()); %></p>
          </div>
          <hr> 
          <%}%>
          <!-- Pager -->
          <div class="clearfix">
            <a class="btn btn-primary float-right" href="#">Posts antigos&rarr;</a>
          </div>
        </div>
      </div>
    </div>
    <hr>

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