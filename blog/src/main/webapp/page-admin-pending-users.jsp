<%-- 
    Document   : page-admin-pending-users
    Created on : Nov 2, 2020, 1:57:00 PM
    Author     : jenniffercrystine
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="CONTROLLER.UsuarioCadastro"%>
<%@page import="MODEL.classes.Usuario"%>
<!-- Pending users page -->

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="assets/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <title>Usuários Pendentes</title>
  </head>
  <body>
      
    <!-- Navbar -->
    <%@ include file="headers/admin-other-header.jsp"%>
    
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
                                <th><span>Usuário Pendente</span></th>
                                <th class="text-center"><span>Papel</span></th>
                                <th><span>Email</span></th>
                                <th>&nbsp;</th>
                            </tr>
                        </thead>
                         <% UsuarioCadastro usuarioCTRL = new UsuarioCadastro();%>
                        <tbody>
                            <% for(Usuario usuario : usuarioCTRL.mostrarUsuarioNaoAprovado()){ %>
                                <tr>
                                    <td>                                   
                                        <p class="user-link"><% out.println(usuario.getNome());%></p>
                                    </td>
                                    <td class="text-center">
                                        <span class="label label-default"><% out.println(usuario.getPapel(usuario.getPapel())); %></span>
                                    </td>
                                    <td>
                                        <p><% out.println(usuario.getEmail());%></p>
                                    </td>                                
                                    <td  class="text-center" style="width: 20%;">
                                        <form action="UsuarioCadastro" method="post"> 
                                            <a method="GET" href="AprovarUsuarioController?id=<%= usuario.getIdUsuario()%>">Aprovar</a>
                                          
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
