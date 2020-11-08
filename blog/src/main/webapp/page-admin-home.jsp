<%-- 
    Document   : page-admin-home
    Created on : Nov 2, 2020, 1:50:10 PM
    Author     : jenniffercrystine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Logged admin page -->

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <title>Home</title>
  </head>
  <body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand nav-home" href="page-admin-home.jsp">Blog</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav navbar-nav-home ml-auto">
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
              <a class="nav-link" method="GET" href="Login">Sair</a>
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
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="post-preview">
            <a href="page-post.jsp">

              <div class="row post-title-button justify-content-between">
                  <div class="col-10">
                      <h2 class="post-title">
                          Exemplo de título de post 1
                      </h2>
                  </div>
                  <div class="col-2">
                      <button type="button" class="btn btn-danger">Desaprovar</button>
                  </div>
              </div>
              <h3 class="post-subtitle">
                Lorem ipsum dolor sit amet.
              </h3>
            </a>
            <p class="post-category">Política</p>
            <p class="post-meta">Postado por Nome do Autor em 25 de Outubro, 2020</p>
          </div>
          <hr>
          <div class="post-preview">
            <div class="row post-title-button justify-content-between">
              <div class="col-10">
                  <h2 class="post-title">
                      Exemplo de título de post 2
                  </h2>
              </div>
              <div class="col-2">
                  <button type="button" class="btn btn-danger">Desaprovar</button>
              </div>
          </div>
              <h3 class="post-subtitle">
                Lorem ipsum dolor sit amet, consectetur adipiscing.
              </h3>
            </a>
            <p class="post-category">Esporte</p>
            <p class="post-meta">Postado por Nome do Autor em 23 de Outubro, 2020</p>
          </div>
          <hr>
          <div class="post-preview">
            <div class="row post-title-button justify-content-between">
              <div class="col-10">
                  <h2 class="post-title">
                      Exemplo de título de post 3
                  </h2>
              </div>
              <div class="col-2">
                  <button type="button" class="btn btn-danger">Desaprovar</button>
              </div>
          </div>
              <h3 class="post-subtitle">
                Ut commodo, purus id sodales convallis, urna.
              </h3>
            </a>
            <p class="post-category">Cultura</p>
            <p class="post-meta">Postado por Nome do Autor em 23 de Outubro, 2020</p>
          </div>
          <hr>
          <div class="post-preview">
            <div class="row post-title-button justify-content-between">
              <div class="col-10">
                  <h2 class="post-title">
                      Exemplo de título de post 4
                  </h2>
              </div>
              <div class="col-2">
                  <button type="button" class="btn btn-danger">Desaprovar</button>
              </div>
          </div>
              <h3 class="post-subtitle">
                In pellentesque ligula sed ultricies consequat. Curabitur pulvinar tortor eu.              </h3>
            </a>
            <p class="post-category">Arte</p>
            <p class="post-meta">Postado por Nome do Autor em 20 de Outubro, 2020</p>
          </div>
          <hr>
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