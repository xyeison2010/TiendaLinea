

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- jQuery -->
        <script src="js/jquery-3.4.1.min.js" type="text/javascript" ></script>
        <!-- popper -->
        <script src="js/popper.min.js" type="text/javascript" ></script>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <script src="js/bootstrap.min.js" type="text/javascript"></script>        
        <!-- Site -->
        <link rel="stylesheet" href="css/site.css">
        <script src="js/site.js"></script>

        <!-- FontAwesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>

        <div class="d-flex" id="wrapper">
            <!-- ============================================================== -->
            <!-- Sidebar -->
            <!-- ============================================================== -->
            <div class="bg-light border-right" id="sidebar-wrapper">
                <div class="sidebar-heading">
                    <img src="images/brand.png" alt="">                                  
                </div>
                <div class="list-group list-group-flush">
                    
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Sidebar -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- Page Content -->
            <!-- barra navegacion horizaontal q encontramos login y registrar -->
            <div id="page-content-wrapper">
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <i class="fas fa-align-justify" id="menu-toggle"></i>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="offset-md-10 collapse navbar-collapse" id="navbarSupportedContent">
                        <a class="nav-link" href="Login.jsp">Login</a>        
                        <a class="nav-link" href="Register.jsp">Registrar</a>               
                    </div>
                </nav>
                <div class="container-fluid bg-dark" style="height: 100%; padding: 50px">
                    <img src="images/main_banner_text.png" width="40%" alt=""> 
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- End Page Content -->
            <!-- ============================================================== -->
        </div>

        <!-- ============================================================== -->
        <!-- Menu Toggle Script -->
        <!-- ============================================================== -->
        <script>
            $("#menu-toggle").click(function (e) {
                e.preventDefault();
                $("#wrapper").toggleClass("toggled");
            });//prevendefault significa si ejecuta por dentro pero no va donde deberia ir pq asi keremos
        </script>

    </body>
</html>

