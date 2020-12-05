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
    <%@ include file="headers/admin-home-header.jsp"%>
    
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
                    <div class="col-7">
                        <h2 class="post-title">
                            <% out.println(artigo.getTitulo()); %>
                        </h2>
                    </div>
                    <div class="col-2">
                        <form action="ArtigoController" method="post"> 
                            <a method="GET" href="AprovarArtigoController?id=<%= artigo.getIdArtigo()%>" class="btn btn-info">Aprovar</a>
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