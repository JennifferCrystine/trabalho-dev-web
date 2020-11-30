<%-- 
    Document   : page-admin-authorized-users
    Created on : Nov 2, 2020, 1:41:15 PM
    Author     : jenniffercrystine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="CONTROLLER.UsuarioController"%>
<%@page import="MODEL.classes.Usuario"%>

<!-- Autorized users page -->

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <title>Usuários Autorizados</title>
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


    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
    <div class="container mt-5">
    <div class="row">
        <div class="col-lg-12">
            <div class="main-box clearfix">
                <div class="table-responsive">
                    <table class="table user-list">
                        <thead>
                            <tr>
                                <th><span>Usuário Autorizado</span></th>
                                <th class="text-center"><span>Papel</span></th>
                                <th><span>Email</span></th>
                                <th>&nbsp;</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% UsuarioController usuarioCTRL = new UsuarioController();%>
                            <% for (Usuario usuario : usuarioCTRL.getUsuariosAprovados()) {%>
                            <tr>
                                <td>
                                    <a href="#" class="user-link"><%out.println(usuario.getNome()); %></a>
                                </td>
                                <td class="text-center">
                                    <span class="label label-default"><%out.println(usuarioCTRL.getUsuarioPapel(usuario.getPapel())); %></span>
                                </td>
                                <td>
                                    <a href="#"><%out.println(usuario.getEmail()); %></a>
                                </td>
                                <td class="text-center" style="width: 20%;">
                                    <a href="#" class="table-link">
                                        <span class="fa-stack">
                                            <i class="fa fa-square fa-stack-2x"></i>
                                            <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
                                        </span>
                                    </a>
                                    <form action="UsuarioCadastro" method="post">
                                        <a method="GET" href="UsuarioController?id=<%=usuario.getIdUsuario()%>"  class="table-link danger">
                                            <span class="fa-stack">
                                                <i class="fa fa-square fa-stack-2x"></i>
                                                <i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
                                            </span>
                                        </a>
                                    </form>
                                </td>
                            </tr>  
                            <%}%>
                        </tbody>
                    </table>
                </div>
                <ul class="pagination pull-right">
                    <li><a href="#"><i class="fa fa-chevron-left"></i></a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#"><i class="fa fa-chevron-right"></i></a></li>
                </ul>
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
