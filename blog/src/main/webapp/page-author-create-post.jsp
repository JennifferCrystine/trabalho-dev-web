<%-- 
    Document   : page-author-create-post
    Created on : Nov 2, 2020, 1:56:29 PM
    Author     : jenniffercrystine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Create post author's page -->
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <title>Adicionar nova postagem</title>
  </head>
  <body>

    <!-- Navbar -->
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
              <a class="nav-link" href="">Sair</a>
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

    <div class="container mt-5">
      <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
              <div class="create-post">   
                <h2>Adicionar nova postagem</h2>
                <form class="mt-5">
                  <div class="form-group">
                    <label for="creating-post-title">Título da Postagem</label>
                    <input type="text" class="form-control" id="creating-post-title" placeholder="Adicione um título a sua postagem aqui">
                  </div>
                  <div class="form-group">
                    <label for="creating-ṕost-content">Adicione o conteúdo da postagem</label>
                    <textarea class="form-control" id="creating-ṕost-content" rows="10" placeholder="Adicione o conteúdo a sua postagem aqui"></textarea>
                  </div>
                  <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      Categoria
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                      <a class="dropdown-item" href="#">Ciência</a>
                      <a class="dropdown-item" href="#">Cultura</a>
                      <a class="dropdown-item" href="#">Economia</a>
                      <a class="dropdown-item" href="#">Educação</a>
                      <a class="dropdown-item" href="#">Entretenimento</a>
                      <a class="dropdown-item" href="#">Esporte</a>
                      <a class="dropdown-item" href="#">Política</a>
                      <a class="dropdown-item" href="#">Religião</a>
                      <a class="dropdown-item" href="#">Saúde</a>
                      <a class="dropdown-item" href="#">Tecnologia</a>
                      <a class="dropdown-item" href="#">Outra</a>
                    </div>
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