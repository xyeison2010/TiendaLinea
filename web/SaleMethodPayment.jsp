

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
                        ¿Cómo quieres pagar?
                    </div>
                    <form method="POST" action="SalesController">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <select id="ddlMethodPayment" 
                                        name="ddlMethodPayment"
                                        class="form-control">

                                    <option value="-1">--Seleccione--</option>

                                    <%
                                        if (request.getAttribute("listMethodsPayment") != null) {
                                            for (com.shop.models.MethodPayment item :  (List<com.shop.models.MethodPayment>) request.getAttribute("listMethodsPayment")) {
                                    %>
                                    <option value="<%= item.getId()%>"> <%= item.getName()%> </option>
                                    <%
                                            }
                                        }
                                    %>

                                </select>
                            </li>     
                            <li class="list-group-item">
                                <input type="submit" 
                                       value="Continuar" 
                                       id="btnSale"
                                       name="btnSale"
                                       class="btn btn-primary btn-block"/>
                            </li>    
                        </ul>
                    </form>                   
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
                        <li class="list-group-item"><b>Envío</b> $<%= product.getShippingCost()%></li> 
                        <li class="list-group-item"><b>Pagas</b> $<%= (product.getPrice() + product.getShippingCost())%></li> 
                    </ul>
                </div>
            </div>            
        </div>
    </body>
</html>

