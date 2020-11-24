<%-- 
    Document   : page-commentator-home
    Created on : Nov 2, 2020, 2:01:04 PM
    Author     : jenniffercrystine
--%>
<%@page import="MODEL.classes.Usuario"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="CONTROLLER.ArtigoController"%>
<%@page import="MODEL.classes.Artigo"%>
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
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand nav-home" href="page-commentator-home.jsp">Blog</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav navbar-nav-home ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="page-commentator-home.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="Logout" method="GET">Sair</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    
    <!-- JavaScript (Opcional) -->
    <!-- jQuery, Popper.js, Bootstrap JS --> 
    <script src="assets/js/jquery-3.5.1.min.js"></script>
    <script src="node_modules/@popperjs/core/lib/popper.js"></script>
    <script src="assets/js/bootstrap/bootstrap.min.js"></script>

    <!-- Header -->
    <header class="masthead" style="background-image: url('assets/img/header-background.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="site-heading">
              <h1>Blog</h1>
              <span class="subheading font-italic">Desenvolvido por Jenniffer Cystine e Luisa Dirce</span>
            </div>
          </div>
        </div>
      </div>
    </header>
   
    <!-- Main Content -->
    <% ArtigoController artigoCTRL = new ArtigoController();%>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
            <% for(Artigo artigo : artigoCTRL.mostrarArtigos("S")){ %>  
                <div class="post-preview">
                  <a href="ComentarioController?id=<%=artigo.getIdArtigo()%>">
                    <h2 class="post-title">
                        <% out.println(artigo.getTitulo());%>
                    </h2>
                  </a>
                  <p class="post-category"><% out.println(artigo.getCategoria().getDescricao());%></p>
                  <p class="post-meta">Postado por <% out.println(artigo.getUsuario().getNome());%></p>
                </div>
                <hr>
            <% }%>     
          <!-- Pager -->
          <div class="clearfix">
            <a class="btn btn-primary float-right" href="#">Posts antigos&rarr;</a>
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
