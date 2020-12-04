<%-- 
    Document   : page-author-create-post
    Created on : Nov 2, 2020, 1:56:29 PM
    Author     : jenniffercrystine
--%>
<%@page import="CONTROLLER.CategoriaController"%>
<%@page import="MODEL.classes.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Create post author's page -->
<!DOCTYPE html>

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
    <%@include file="headers/author-other-header.jsp" %>
    
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
                <form class="mt-5" action="ArtigoController" method="post">
                  <div class="form-group">
                    <label for="creating-post-title">Título da Postagem</label>
                    <input type="text" class="form-control" id="creating-post-title" name="title" placeholder="Adicione um título a sua postagem aqui">
                  </div>
                  <div class="form-group">
                    <label for="creating-ṕost-content">Adicione o conteúdo da postagem</label>
                    <textarea class="form-control" id="creating-post-content" rows="10" name="content" placeholder="Adicione o conteúdo a sua postagem aqui"></textarea>
                  </div>
                  <div class="form-group">
                    <label for="exampleFormControlSelect1">Categoria</label>                  
                    <% CategoriaController categoriaCTRL = new CategoriaController();%>
                    <% try {
                        for (Categoria categoria : categoriaCTRL.getCategorias()) { 
                            if (categoria != null) { %>
                                <select class="form-control" id="exampleFormControlSelect1" name="category">
                                  <option><% out.println(categoria.getDescricao()); %></option>
                                </select>
                            <% } else {
                                    break;
                               }
                            }%>                        
                    <%} catch (NullPointerException ex) { %> 
                                <select class="form-control" id="exampleFormControlSelect1" name="category">
                                  <option>Política</option>
                                  <option>Atualidades</option>
                                  <option>Artes</option>
                                  <option>Outros</option>
                                </select>
                        <%}%>            
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
