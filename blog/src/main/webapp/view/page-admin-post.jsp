<%-- 
    Document   : page-admin-post
    Created on : Nov 2, 2020, 1:55:36 PM
    Author     : jenniffercrystine
--%>

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
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand nav-post" href="index.jsp">Blog</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="index.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="login.jsp">Entrar</a>
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
    <header class="masthead-post">
        <div class="container">
            <div class="row">
                <div class="mx-auto">
                    <div class="post-heading">
                        <h1>Exemplo de título de post 1</h1>
                        <h2 class="subheading">Lorem ipsum dolor sit amet.</h2>
                        <p class="post-category">Política</p>
                        <span class="meta">Postado por Nome do Autor em 25 de Outubro, 2020</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Post content -->
    <div class="container post-content">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <p><span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas nec auctor ipsum. Morbi semper pellentesque eros, nec tempor ligula egestas finibus. In et lectus volutpat, accumsan arcu sit amet, tristique ligula. In ultrices elit risus, quis varius dolor accumsan id. Quisque id tincidunt quam, tempus pulvinar sem. Donec placerat gravida mattis. Suspendisse suscipit tellus velit, sed rutrum nunc facilisis nec. Ut vulputate est ac varius vehicula. Duis turpis orci, placerat sed odio ut, posuere congue ligula. Vestibulum non blandit nibh. Maecenas tempor condimentum diam nec vehicula. Praesent malesuada faucibus metus, vel porta lectus ullamcorper vitae.</span>

                <span>Sed pretium elementum massa, quis laoreet eros mattis ut. Praesent placerat, dolor et suscipit consectetur, lacus turpis volutpat arcu, nec molestie augue nibh id erat. In iaculis libero non bibendum tincidunt. Mauris suscipit, ligula at volutpat vehicula, augue leo facilisis est, sed congue libero turpis eu turpis. Maecenas tempor nibh non tellus interdum laoreet. Integer volutpat est in dignissim ornare. Etiam condimentum erat sit amet eros condimentum fringilla. Proin in fermentum sapien. Aenean a pellentesque nunc, id finibus enim. Nunc volutpat nisi eros, nec viverra diam porta non. Sed quis elit id orci placerat gravida. In hac habitasse platea dictumst. Maecenas at mi auctor, bibendum ex eu, malesuada nisi. Nunc lacinia ut massa in vulputate. Morbi viverra et leo vitae commodo. Donec feugiat eleifend leo luctus finibus.</span>
            
                <span>Donec et cursus massa, id pretium nunc. Nam fringilla nisl in felis dignissim suscipit. Morbi bibendum accumsan magna nec aliquam. Curabitur vehicula volutpat tincidunt. Nam vel rhoncus felis. Nullam urna lacus, accumsan sed ultrices et, venenatis in velit. Curabitur velit justo, pharetra id consectetur vel, luctus quis diam. Donec ante felis, sagittis quis pellentesque a, tempor a nunc.</span></p>
            </div>
        </div>
    </div>

    <!-- Post comments -->
    <div class="container post-comments mt-5">
      <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
              <h3 class="mb-4">Comentários</h3>
              <div class="div">
                <div class="row post-commentator-button">
                    <div class="col-10">
                        <h5 class="post-commentator-name">Patrícia Alves</h5>                        </h2>
                    </div>
                    <div class="col-2">
                        <button type="button" class="btn btn-success">Aprovar</button>
                    </div>
                </div>
                  <p class="post-comment-content">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ac sem pharetra, venenatis dui at, lacinia nisl. Nunc in metus libero. Quisque scelerisque dolor imperdiet, lobortis lacus non, porta ante. Integer vitae enim a mi viverra finibus a vel neque. Cras aliquet enim nunc, at molestie orci ultrices nec. Duis condimentum ipsum et facilisis efficitur. Donec leo ex, pretium et ante vitae, faucibus euismod turpis. Nunc vel volutpat magna.</p>
              </div>
              <div class="div mt-4">
                <div class="row post-commentator-button">
                    <div class="col-10">
                        <h5 class="post-commentator-name">Roberto Almeida</h5>
                    </div>
                    <div class="col-2">
                        <button type="button" class="btn btn-success">Aprovar</button>
                    </div>
                </div>
                  <p class="post-comment-content">In id diam finibus justo sagittis sollicitudin. Quisque maximus, tellus et vehicula auctor, tellus erat mollis nisi, volutpat suscipit erat urna sit amet ligula. Nunc mattis tortor non malesuada eleifend. In hac habitasse platea dictumst. Suspendisse sollicitudin sem eget porttitor placerat.</p>
              </div>
              <div class="div mt-4">
                <div class="row post-commentator-button">
                    <div class="col-10">
                        <h5 class="post-commentator-name">Ana maria</h5>
                    </div>
                    <div class="col-2">
                        <button type="button" class="btn btn-success">Aprovar</button>
                    </div>
                </div>
                  <p class="post-comment-content">Pellentesque vitae ultrices dui.</p>
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