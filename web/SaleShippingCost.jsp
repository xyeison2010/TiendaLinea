

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <script src="js/bootstrap.min.js" type="text/javascript"></script>        
        <script src="js/popper.min.js" type="text/javascript" ></script>

        <!-- jQuery -->
        <script src="js/jquery-3.4.1.min.js" type="text/javascript" ></script>
        
        <!-- FontAwesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

    </head>
    <body>

        <%
            com.shop.models.Products product = (com.shop.models.Products) request.getAttribute("product");
            com.shop.models.Customer customer = (com.shop.models.Customer) request.getAttribute("customer");
        %>

        <div class="form-row">
            <div class="col-md-6">
                <br>
                <div class="card border-dark">  
                    <div class="card-header text-center">
                        ¿Cómo quieres recibir o retirar tu compra?
                    </div>
                    <div class="card-body">                               
                        <p class="card-text">
                            <%= customer.getAddress()%>
                        </p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <a href="SalesController?btnMethodPayment=true&shippingCost=0">
                                <i class="fa fa-map-marker-alt"></i>
                                <span class="nav-link-text">Retiro en domicilio del vendedor</span>
                            </a>
                        </li>     
                        <li class="list-group-item">
                            <a href="SalesController?btnMethodPayment=true&shippingCost=<%= product.getShippingCost()%>">
                                <i class="fa fa-map-marker-alt"></i>
                                <span class="nav-link-text">Normal a domicilio  $<%= product.getShippingCost()%></span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>            
            <!-- COLUMNA IMG PRODUCTO  -->
            <div class="col-md-6">
                <br>
                <div class="card border-dark">
                    <div class="card-header text-center">
                        <%= product.getName()%>
                    </div>
                    <img src="images/products/<%= product.getGuid()%>" style="max-height: 300px" class="card-img" alt="...">                     
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><b>Cantidad</b> 1</li>     
                        <li class="list-group-item"><b>Producto</b> $<%= product.getPrice()%></li>     
                    </ul>
                </div>
            </div>            
        </div>
    </body>
</html>
<!--si ha retirado a domicio el vendor el costo debe ser 0 , si es la opcion lo kiere adomiciolio le enviamos el costo del envio del producto  -->