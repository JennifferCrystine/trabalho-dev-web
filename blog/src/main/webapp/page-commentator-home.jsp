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
    <%@include  file="headers/commentator-home-header.jsp" %>
    
    <!-- JavaScript (Opcional) -->
    <!-- jQuery, Popper.js, Bootstrap JS --> 
    <script src="assets/js/jquery-3.5.1.min.js"></script>
    <script src="node_modules/@popperjs/core/lib/popper.js"></script>
    <script src="assets/js/bootstrap/bootstrap.min.js"></script>

    <!-- Header -->
   
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
