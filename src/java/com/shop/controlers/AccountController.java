/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.controlers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
import com.shop.services.Account;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

@WebServlet(name = "AccountController", urlPatterns = {"/AccountController"})
public class AccountController extends HttpServlet {

    /**
     DO GET Y DO POST  y (PROCESREQUEST) (llama metodo de register) para poder invocarlo usar jsp .
request : es una peticion q llega desde una vista
reponse :el lo q envia controlador a la vista 
sirve pa login registro acciones 
--  si el parametro q estamos enviando no es el boton register sino login entonces debe llamar el metodo login user
     */
    
   //CLASE processrequest
    /**
    
     * @param response
     * @throws javax.servlet.ServletException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("btnRegister") != null) {

            RegisterUser(request, response);
        } else if (request.getParameter("btnLogin") != null) {
            LoginUser(request, response);
        }

    }

    protected void LoginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");

            String message = "";
            if (email.length() == 0) {
                message = "email is required ,";
            }
            if (password.length() == 0) {
                message = "password is required ,";
            }
            if (message.length() != 0) {
                throw new Exception(message.substring(0, message.length() - 1));
            }

            Account account = new Account();
            boolean exists = account.Login(email, password);

            if (exists) {
                
                HttpSession session = request.getSession(true);
              
                com.shop.services.Customers customers = new com.shop.services.Customers();//lo guardamos en sesion
                List<com.shop.models.Customer> listCustomers = customers.SearchCustomers(email);
                session.setAttribute("customer", listCustomers.get(0));
                
            
                request.setAttribute("userName", email.split("@")[0]);//sirve pa mostrar el nombre del usuario en pagina 
                
                request.getRequestDispatcher("Home.jsp").forward(request, response);//es direccionar

            }
            throw new Exception("Invalid credentials");

        } catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("code", 500);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }
 //aca esta el registro usuario y validar si esque hay alguien que se quiera registrar con el mismo nombre de un usuario ya registrado 
  // esto solo aplica en el email , no en el password me parece perfecto 

    private void RegisterUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");
            String ConfirmPassword = request.getParameter("txtConfirmPassword");

            if (!password.equals(ConfirmPassword)) {
                throw new Exception("Password not matched");

            }
            Account account = new Account();
            boolean exists = account.ValidarRegistro(email, password);// pa validar usuario 

            if (exists) {

                throw new Exception("Invalid user");

            } else {

                account.Register(email, password);

                request.setAttribute("Message", "The process was successful");
                request.setAttribute("code", 200);
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
// aca tengo un problemilla creo pero igual se regista en la bd anque salda code 500

        } catch (Exception ex) {
            request.setAttribute("Message", " userEmail ya registrado  ");
            request.setAttribute("code", 500);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
