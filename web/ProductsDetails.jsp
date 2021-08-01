

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
    </head>
    <body>

        <%
            com.shop.models.Products product = (com.shop.models.Products) request.getAttribute("product");
        %>

        <div class="card border-dark">
            <br>
            <div class="row no-gutters">
                <div class="col-md-4">
                    <img src="images/products/<%= product.getGuid()%>" class="card-img" alt="...">  
                </div>
                <div class="col-md-8">
                    <div class="card-header text-center">
                        <%= product.getName()%>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">$ <%= product.getPrice()%></li>
                        <li class="list-group-item"><b>Costo de envío</b>  $<%= product.getShippingCost()%></li>
                        <li class="list-group-item"><b>Cantidad</b> 1</li>
                        <li class="list-group-item"><b>Garantía</b></li>
                        <li class="list-group-item"><%= product.getWarranty()%></li>
                        <li class="list-group-item"><b>Estado</b> <%= product.getStates().getName()%></li>  
                        <li class="list-group-item"><b>Descripción</b></li>
                        <li class="list-group-item"><%= product.getDescription()%></li>

                        <li class="list-group-item">
                            <a href="SalesController?btnShippingCost=true"
                               id="btnShippingCost" 
                               name="btnShippingCost"
                               class="btn btn-primary">Comprar</a>
                        </li>
                    </ul> 
                </div>
            </div>
        </div>
    </body>
</html>
