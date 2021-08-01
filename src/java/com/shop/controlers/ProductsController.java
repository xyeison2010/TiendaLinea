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



@WebServlet(name = "ProductsController", urlPatterns = {"/ProductsController"})
public class ProductsController extends HttpServlet {

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
        //tamos llamando de un controlado a otro por eso es parametro , a diferencia
        //invocando de un controloador a la vistasi es attribute 
        if (request.getParameter("optProductsIndex") != null) {
            ProductsIndex(request, response);
        } 
        else if (request.getParameter("btnSearchProduct")!= null ){
            ProductsSearch(request, response); // esto el boton del jsp products lo redirecciona a ProductsSearch y procesa
        }
    else if (request.getParameter("btnDetailsProduct") != null) {
           ProductDetails (request, response);
        } }
    
    private void ProductDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    
        try {
             int productID = Integer.parseInt(request.getParameter("productId"));
     

            com.shop.services.Products products = new com.shop.services.Products();
            List<com.shop.models.Products> listProducts = products.SearchProductsById(productID);
            
            HttpSession session = request.getSession(true); // la variable session nos sirve para la informacion,con esto mantenemos la info, hasta q se cierre sesion
            session.setAttribute("product", listProducts.get(0)); //vams almacenas el producto sesion
    //ponemos get 0 porq solo tenemos id el valor 0 
            request.setAttribute("product", listProducts.get(0));
         

            request.setAttribute("message", "the process was succesful");
            request.setAttribute("code", 200);
            request.getRequestDispatcher("ProductsDetails.jsp").forward(request, response);
            
            
        } catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("code", 500);
            request.getRequestDispatcher("ProductsDetails.jsp").forward(request, response);
        }
    
    }
    
    
    private void ProductsSearch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    //parte consulta aqui se hace 
        try {
            
            int categoryId = Integer.parseInt(request.getParameter("ddlCategories"));//este ddl es del jspproducts
            String productsName = request.getParameter("txtProductName");//del jsp // la cateforia que la persona ingreso

            com.shop.services.Products products = new com.shop.services.Products();
            List<com.shop.models.Products> listProducts = products.SearchProducts(categoryId, productsName);//y si es vacio o no
            request.setAttribute("listProducts", listProducts);
            //
            //volvemos a cargar pq estamos refrescando porq tenemos q enviarle lo q ya estaba para que se comporte de la misma manera 
            com.shop.services.Categories categories = new com.shop.services.Categories();
            List<com.shop.models.Categories> listCategories = categories.SearchCategories();
            request.setAttribute("listCategories", listCategories);
            //
            request.setAttribute("message", "the process was succesful");
            request.setAttribute("code", 200);
            request.getRequestDispatcher("ProductsIndex.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("code", 500);
            request.getRequestDispatcher("ProductsIndex.jsp").forward(request, response);
        }
    }

    private void ProductsIndex(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//este products index debe cargar la vista con la informacion de las categorias nadamas
        try {
            
            com.shop.services.Categories categories = new com.shop.services.Categories();
            List<com.shop.models.Categories> listCategories = categories.SearchCategories();
            request.setAttribute("listCategories", listCategories);

            request.setAttribute("message", "the process was succesful");
            request.setAttribute("code", 200);
            request.getRequestDispatcher("ProductsIndex.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("code", 500);
            request.getRequestDispatcher("ProductsIndex.jsp").forward(request, response);
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
