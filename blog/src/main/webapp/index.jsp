<%-- 
    Document   : index.jsp
    Created on : Nov 2, 2020, 1:29:29 PM
    Author     : jenniffercrystine
--%>
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

    <title>Home</title>
  </head>
  <body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand nav-home" href="index.jsp">Blog</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav navbar-nav-home ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="index.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a href="" class="nav-link" data-toggle="modal" data-target="#loginModal">Entrar</a>
            </li>
            <li class="nav-item">
              <a href="" class="nav-link" data-toggle="modal" data-target="#signupModal">Cadastrar-se</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

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
            <form id="form-login" action="Login" method="post">
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

    <!-- Sign up Modal -->
    <div class="modal fade" id="signupModal" tabindex="-1" aria-labelledby="signupModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="signupModalLabel">Cadastrar-se</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form id="form-signup" action="UsuarioCadastro" method="post">
                <div class="form-group">
                  <label for="user-name" class="col-form-label">Nome:</label>                
                  <input type="text" class="form-control" id="user-name" name="name">
                  <span class='msg-erro msg-name' style="color: red; display: none;"></span>
                </div>
                <div class="form-group">
                  <label for="user-cpf" class="col-form-label">CPF:</label>
                  <input type="number" class="form-control" id="user-cpf-signup" name="cpf">
                  <span class='msg-erro msg-cpf-signup' style="color: red; display: none;"></span>
                </div>
                <div class="form-group">
                  <label for="user-email" class="col-form-label">E-mail:</label>
                  <input type="email" class="form-control" id="user-email" name="email">
                  <span class='msg-erro msg-email' style="color: red; display: none;"></span>
                </div>
                <div class="form-group">
                  <label for="user-password" class="col-form-label">Senha:</label>
                  <input type="password" class="form-control" id="user-password-signup" name="password"></input>
                  <span class='msg-erro msg-password-signup' style="color: red; display: none;"></span>
                </div>
                <p>Selecione o papel desejado:</p>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="roles" id="defaultCheck1" value="option1">
                  <label class="form-check-label" for="defaultCheck1">
                    Administrador
                  </label>
                </div>
                <div class="form-check">                
                  <input class="form-check-input" type="radio" name="roles" id="defaultCheck2" value="option2">
                  <label class="form-check-label" for="defaultCheck2">
                    Autor
                  </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="roles" id="defaultCheck3" value="option3">
                  <label class="form-check-label" for="defaultCheck3">
                    Comentarista
                  </label>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                  <button type="submit" class="btn btn-primary">Cadastrar-se</button>
                </div>
            </form>
          </div>
          
        </div>
      </div>
    </div>

    <!-- JavaScript (Opcional) -->
    <!-- jQuery, Popper.js, Bootstrap JS --> 
    <script src="assets/js/jquery-3.5.1.min.js"></script>
    <script src="assets/js/bootstrap/bootstrap.min.js"></script>
    <!-- <script src="assets/js/form_validation.js"></script> -->

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
            <% for(Artigo artigo : artigoCTRL.mostrarArtigos()){ %>  
                <div class="post-preview">
                  <a href="page-post.jsp">
                    <h2 class="post-title">
                        <% out.println(artigo.getTitulo());%>
                    </h2>
                  </a>
                  <p class="post-category"><% out.println(artigo.getCategoria().getDescricao());%></p>
                  <p class="post-meta"><% out.println(artigo.getUsuario().getNome());%></p>
                </div>
                <hr>
            <% }%>          
          <!-- Pager -->
          <div class="clearfix">
            <a class="btn btn-primary float-right" href="page-post.jsp">Posts antigos&rarr;</a>
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