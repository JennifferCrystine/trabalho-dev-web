<%-- 
    Document   : page-author-pending-posts
    Created on : Nov 2, 2020, 1:59:42 PM
    Author     : jenniffercrystine
--%>


<%@page import="CONTROLLER.ArtigoController"%>
<%@page import="MODEL.classes.Artigo"%>
<%@page import="MODEL.classes.Usuario"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Author's pending posts page -->
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
   <%@include file="headers/author-other-header.jsp" %>
    
    
    <!-- JavaScript (Opcional) -->
    <!-- jQuery, Popper.js, Bootstrap JS --> 
    <script src="assets/js/jquery-3.5.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap/bootstrap.min.js"></script>
 
    <!-- Main Content -->
    <div class="container mt-5">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <% Usuario usuario = (Usuario)request.getSession().getAttribute("usuario"); 
                    int id = 0;
                    if (usuario != null) {
                       id = usuario.getIdUsuario();
                    }
                   ArtigoController artigoCTRL = new ArtigoController();
                 %>
                <% for(Artigo artigo : artigoCTRL.autorArtigos(id, "N")) { %>
                    <div class="post-preview">
                        <a href="ArtigoController?id=<%=artigo.getIdArtigo()%>">
                          <h3><% out.println(artigo.getTitulo());%></h3>
                      </a>
                      <p class="post-category"><% out.println(artigo.getCategoria().getDescricao());%></p>
                      <p class="post-meta">Postado por <% out.println(artigo.getUsuario().getNome());%></p>
                    </div>
                    <form action="ArtigoController" method="post"> 
                        <a method="GET" href="page-author-edit-post.jsp?id=<%= artigo.getIdArtigo()%>" class="btn btn-info">Editar</a> 
                        <a method="GET"  href="ApagarArtigoController?id=<%= artigo.getIdArtigo()%>" class="btn btn-danger">Excluir</a>
                    </form>
                    <hr>
                <%}%>            
            <!-- Pager -->
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
