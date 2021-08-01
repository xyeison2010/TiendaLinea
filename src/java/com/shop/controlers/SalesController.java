/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SalesController", urlPatterns = {"/SalesController"})
public class SalesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
       if (request.getParameter("btnShippingCost") != null) {
           SaleShippingCost(request, response);
  } 
     else  if(request.getParameter("btnMethodPayment") !=null){
           SaleMethodPayment(request, response);
       }
     else if (request.getParameter("btnSale") !=null){
           SaleComplete(request, response);
     }
  }
    
       private void SaleComplete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    
         try {
             
             int methodPaymentId =Integer.parseInt(request.getParameter("ddlMethodPayment"));//metodo de pago
            
             com.shop.models.Products product = new com.shop.models.Products();//para registrar producto
             com.shop.models.Customer customer = new com.shop.models.Customer(); //obtenemos pero no enviamos 


             HttpSession session = request.getSession(true);
             product = (com.shop.models.Products) session.getAttribute("product");//atrapamos lo q estaba en session
             request.setAttribute( "product", product);//aqui guarde el producto ,  // enviamos al formulario  
 
             customer = (com.shop.models.Customer) session.getAttribute("customer"); //para registrar producto
            
             com.shop.services.Sales sales = new com.shop.services.Sales();//vms llamar y retorna
             int saleId = sales.SaleComplete(methodPaymentId,
                     product.getQuantity() * product.getPrice() + product.getShippingCost(), //valor total totalvalue
                     customer.getId(),
                     product.getId(),
                     product.getQuantity(),
                     product.getQuantity() * product.getPrice()); // el subtotal 
             
             request.setAttribute("saleId", saleId);
             
             request.setAttribute("message", "the process was succesful");
             request.setAttribute("code", 200);
             request.getRequestDispatcher("SaleComplete.jsp").forward(request, response);
             
         } catch (Exception ex) {
             request.setAttribute("message", ex.getMessage());
             request.setAttribute("code", 500);
             request.getRequestDispatcher("SaleComplete.jsp").forward(request, response);
         }
    
    }
    
    
     private void SaleMethodPayment(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    
         try {// desde q inicio sesion ya tnego la info del cliente en memoria
             double shippingCost =Double.parseDouble( request.getParameter("shippingCost"));//costo del envio
             com.shop.models.Products product = new com.shop.models.Products();
        

             HttpSession session = request.getSession(true);
             product = (com.shop.models.Products) session.getAttribute("product");//atrapamos lo q estaba en session
             //modificamos el valor del costo del envio de la variable de session
             product.setShippingCost(shippingCost);
             //actualizar la variabl de session
             session.setAttribute("product", product);
          // enviamos al formulario  
             request.setAttribute( "product", product);//aqui guarde el producto
 
             com.shop.services.MethodPayment methodPayment = new com.shop.services.MethodPayment();//implemetamos 
            List<com.shop.models.MethodPayment> listMethodsPayment = methodPayment.SearchMethodsPayment();
            request.setAttribute("listMethodsPayment", listMethodsPayment);//implemetamos esto para metodo de pago 
            
             request.setAttribute("message", "the process was succesful");
             request.setAttribute("code", 200);
             request.getRequestDispatcher("SaleMethodPayment.jsp").forward(request, response);
             
         } catch (Exception ex) {
             request.setAttribute("message", ex.getMessage());
             request.setAttribute("code", 500);
             request.getRequestDispatcher("SaleMethodPayment.jsp").forward(request, response);
         }
    
    }
    
     private void SaleShippingCost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    
         try {// desde q inicio sesion ya tnego la info del cliente en memoria
             
             com.shop.models.Products product = new com.shop.models.Products();
             com.shop.models.Customer customer = new com.shop.models.Customer();

             HttpSession session = request.getSession(true);
             product = (com.shop.models.Products) session.getAttribute("product");
             customer = (com.shop.models.Customer) session.getAttribute("customer");

             request.setAttribute("product", product);//aqui guarde el producto
             request.setAttribute("customer", customer); //desde aki enviamos al jspShippingcost  del setattribue 

             request.setAttribute("message", "the process was succesful");
             request.setAttribute("code", 200);
             request.getRequestDispatcher("SaleShippingCost.jsp").forward(request, response);
             
         } catch (Exception ex) {
             request.setAttribute("message", ex.getMessage());
             request.setAttribute("code", 500);
             request.getRequestDispatcher("SaleShippingCost.jsp").forward(request, response);
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
