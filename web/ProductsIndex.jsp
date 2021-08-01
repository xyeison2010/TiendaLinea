

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
        <div class="container-fluid">
            <form method="POST" action="ProductsController">
                <div class="form-row">
                    <div class="col-md-3">
                        <br>
                        <label><b>Buscar:</b></label>
                    </div>
                    <div class="col-md-3">
                        <br>
                        <input class="form-control" 
                               placeholder="Buscar productos, marcas y más…"
                               id="txtProductName"
                               name="txtProductName"
                               type="text"/>
                    </div>                    
                </div>
                <div class="form-row">
                    <div class="col-md-3">
                        <br>
                        <label><b>Categoría:</b></label>
                    </div>
                    <div class="col-md-3">
                        <br>
                        <select id="ddlCategories" 
                                name="ddlCategories"
                                class="form-control">

                            <option value="-1">--Seleccione--</option>

                            <%
                                if (request.getAttribute("listCategories") != null) {
                                    for (com.shop.models.Categories item : (List<com.shop.models.Categories>) request.getAttribute("listCategories")) {
                            %>
                            <option value="<%= item.getId()%>"> <%= item.getName()%> </option>
                            <%
                                    }
                                }
                            %>

                        </select>
                    </div>
                    <div class="col-md-3">
                        <br>
                        <input class="btn btn-primary"
                               value="Buscar"
                               type="submit"
                               id="btnSearchProduct"
                               name="btnSearchProduct"/>
                    </div>
                </div>

                <div class="form-row">
                    <div class="col-md-12">

                        <%
                            if (request.getAttribute("listProducts") != null) {

                                int column = 1;
                                for (com.shop.models.Products item : (List<com.shop.models.Products>) request.getAttribute("listProducts")) {
                                    if (column == 1) {
                        %>
                        <div class="form-row">                                
                            <% }%>

                            <div class="col-md-4">
                                <br>
                                <div class="card border-dark" style="width: 18rem;">
                                    <div class="card-header text-center">
                                        <%= item.getName()%>
                                    </div>
                                    <img style="max-height: 300px" src="images/products/<%= item.getGuid()%>"  class="card-img" alt="...">                                    
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">$ <%= item.getPrice()%></li>
                                        <li class="list-group-item">
                                            <a href="ProductsController?btnDetailsProduct=true&productId=<%= item.getId()%>"
                                               id="btnDetailsProduct" 
                                               name="btnDetailsProduct"
                                               class="btn btn-primary">Comprar</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                            <% if (column == 3) {
                                    column = 0; %>
                        </div>    
                        <% }%>

                        <%
                                    column++;
                                }
                            }
                        %>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
