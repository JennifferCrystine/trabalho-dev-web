<%-- 
    Document   : page-commentator-post
    Created on : Nov 2, 2020, 2:01:51 PM
    Author     : jenniffercrystine
--%>
<%@page import="MODEL.classes.Artigo"%>
<%@page import="MODEL.classes.Usuario"%>
<%@page import="MODEL.classes.Comentario"%>
<%@page import="CONTROLLER.ComentarioController"%>
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
    <%@include  file="headers/commentator-other-header.jsp" %>
    
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
                        <h1><%out.println(artigo.getTitulo()); %></h1>
                        <p class="post-category"><i><%out.println(artigo.getCategoria().getDescricao()); %></i></p>
                        <span class="meta">Postado por <b><%out.println(artigo.getUsuario().getNome()); %></b></span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Post content -->
    <div class="container post-content">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
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
    <!-- New comment-->
    <div class="container new-comment mt-3">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <form id="form-commentary" action="ComentarioController" method="post">
                    <div class="form-group">
                      <label for="creating-post-content">Deixe um comentário</label>
                      <textarea class="form-control" id="creating-post-content" name="commentary-content" rows="5" placeholder="Comente aqui"></textarea>
                    </div>
                    <div >
                        <button type="submit" class="btn btn-primary">Comentar</button>
                    </div>
                </form>
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
