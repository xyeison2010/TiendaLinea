

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link href="css/bootstrap.min.css" rel="stylesheet" />
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
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
        alert('500 - userEmail ya registrado intente con otro  ' ) ;
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
                        <br>
                        <h6 >Create a new account</h6>

                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-2 offset-md-4">
                        <br>
                        <label>Email:</label> 
                    </div> 
                    <div class="col-md-2 offset-md-4">
                        <br>
                        <input required="" class="form-control"  id="txtEmail" name="txtEmail" type="text" placeholder="Enter email"/>
                    </div>
                </div>



                <div class="form-row">
                    <div class="col-md-2 offset-md-4">
                        <br>
                        <label>Password:</label> 

                    </div>
                    <div class="col-md-2 offset-md-4"> 
                        <br>
                        <input required="" class="form-control" id="txtPassword" name="txtPassword" type="password" placeholder="Enter password"/>
                    </div>

                </div>

                <div class="form-row">
                    <div class="col-md-2 offset-md-4" >
                        <br>
                        <label>Confirm password:</label> 


                    </div>
                    <div class="col-md-2 offset-md-4"> 
                        <br>
                        <input required="" class="form-control" id="txtConfirmPassword" name="txtConfirmPassword" type="password" placeholder="Enter Confirm password"/>
                    </div>
                </div>

                <div class="form-row text-center">
                    <div class="col-md-4 offset-md-4">
                        <br>
                        <input  class="btn btn-primary " id="btnRegister"  name="btnRegister" type="submit"   value="Register"    />
                        <br>
                        <a class="btn btn-info btn-sm" href="Login.jsp" >Back</a>
                    </div>
                </div>
             
            </form>
</div>
        
       
    </body>
</html>
