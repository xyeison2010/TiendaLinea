

<%@page import="java.util.List"%>
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

        <div class="form-row">
            <div class="col-md-6">
                <br>
                <div class="card border-dark">     
                    <div class="card-header text-center">
                        Compras > Detalle de compra
                    </div>
                    
                    <ul class="list-group list-group-flush">                         
                        <li class="list-group-item"><b>Compra</b> # <%= request.getAttribute("saleId") %></li> 
                        <li class="list-group-item"><b>Resumen de compra</b></li>   
                        <li class="list-group-item"><b>Producto</b> $<%= product.getPrice() %></li>   
                        <li class="list-group-item"><b>Cargo de envío</b> $<%= product.getShippingCost()%></li>   
                        <li class="list-group-item"><b>Tu pago</b> $<%= (product.getPrice() + product.getShippingCost())%></li>   
                    </ul>                                 
                </div>
            </div>            
            <!-- COLUMNA IMG PRODUCTO  -->
            <div class="col-md-6">
                <br>
                <div class="card border-dark">
                    <div class="card-header text-center">
                        Compraste<br>
                        <%= product.getName()%>
                    </div>
                    <img src="images/products/<%= product.getGuid()%>" style="max-height: 300px" class="card-img" alt="...">                     
                    <ul class="list-group list-group-flush">                         
                        <li class="list-group-item">$<%= product.getPrice()%> x <%= product.getQuantity()%></li> 
                        <li class="list-group-item">
                            <a href="ProductsController?optProductsIndex=true" 
                               class="btn btn-primary">Finalizar</a>
                        </li>   
                    </ul>
                </div>
            </div>            
        </div>
    </body>
</html>
