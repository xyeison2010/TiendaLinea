

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        
        <!-- jQuery -->
        <script src="js/popper.min.js" type="text/javascript"></script>
        
        <title>JSP Page</title>
    </head>
    <body>
      <%
            if (request.getAttribute("code") != null) {

        if(Integer.parseInt(request.getAttribute("code").toString() )==200 ){        
        %>
        <script>
        alert('200 - the process was succesful ' ) ;
        </script>
        <%   } else {   %>
        <script>
        alert('500 - an error ocurred during the process ' ) ;
        </script>
        <%
                }

            }
        %>

        <div class="container-fluid"> 

            <form    method="post"    action="AccountController"> 
                <div class="form-row text-center" >
                    <div class="col-md-4 offset-md-4" > 
                        <br >
                        <img src="images/brand.png" alt="" >

                    </div>
                </div>

                <div class="form-row">
                    <div class="col-md-2 offset-md-4">
                        <br>
                        <label>Email:</label> 
                    </div> 
                    <div class="col-md-2 offset-md-4">
                        <br>
                        <input required="" class="form-control"  id="txtEmail" name="txtEmail" type="text" placeholder="Enter user"/>
                    </div>

                </div>
                <div class="form-row ">
                    <div class="col-md-2 offset-md-4">
                        <br>
                        <label>Password:</label> 
                    </div>
                    <div class="col-md-2 offset-md-4">
                        <br>
                        <input required="" class="form-control"  id="txtPassword" name="txtPassword" type="password" placeholder="Enter password"/>
                    </div>
                </div>
                <div class="form-row text-center">
                    <div class="col-md-4 offset-md-4">
                        <br>
                        <input class="btn btn-primary btn-block" id="btnLogin"  name="btnLogin" type="submit"   value="Login"    />
                        <br>
                        <input type="checkbox" id="chkRemember" name="chkRemember"/> Remember me?
                        <br>
                        <a  href="$">Lost Password?</a>
                        <br>
                        <a  href="Register.jsp" >Register</a>
                    </div>
                </div>

            </form>

        </div>
    </body>
</html>
