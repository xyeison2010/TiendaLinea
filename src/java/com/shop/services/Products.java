/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.services;
import java.sql.*;
import com.shop.data.ConnectionDB;
import java.util.ArrayList;
import java.util.List;

/**
 SEARCH PRODUCTS 
 */
public class Products {

    public List<com.shop.models.Products> SearchProducts(int categoryId, String
            productName) throws SQLException, ClassNotFoundException {

        try {
            Connection cnx = ConnectionDB.GetConnection();
            PreparedStatement ps = cnx.prepareStatement("{ call SearchProducts(?,?) }");// los ??significa nombre/descripcion y una categoria de la bd
            ps.setInt(1, categoryId);
            ps.setString(2, productName);
            
            ResultSet rs = ps.executeQuery();

            List<com.shop.models.Products> listProducts = new ArrayList<>();
            while (rs.next()) {
                //tipos de products
                com.shop.models.Products products = new com.shop.models.Products();
                products.setId(rs.getInt("Id"));
                
                products.setCategoryId(rs.getInt("CategoryId"));//objeto foranea 
  //  en la BD y no pertene a producto se hace referencia a producto
                com.shop.models.Categories categories = new com.shop.models.Categories(); 
                categories.setId(rs.getInt("CategoryId"));
                categories.setName(rs.getString("CategoryName"));
                
                products.setCategories(categories);  //siempre se hace esto con una foranea 
              
                products.setName(rs.getString("Name"));
                products.setPrice(rs.getDouble("Price"));
                products.setShippingCost(rs.getDouble("ShippingCost"));
                products.setWarranty(rs.getString("Warranty"));
                products.setDescription("Description");
                products.setQuantity(rs.getInt("Quantity"));

                products.setStateId(rs.getInt("StateId"));//objetoforanea;
                com.shop.models.States states = new com.shop.models.States();//igual foranea
                states.setId(rs.getInt("StateId"));
                states.setName(rs.getString("StateName"));
                products.setStates(states);//guarda objeto como foranea
                //
                products.setCustomerId(rs.getInt("CustomerId"));
                products.setGuid(rs.getString("Guid"));
                
                
                listProducts.add(products);//adicionar lo q acabamos ccrear
               

            }
            return listProducts;
        } catch (Exception ex) {
            throw ex;
        }

    }
    //SEARCH PRODUCT BY ID 
    
     public List<com.shop.models.Products> SearchProductsById(int productId)
            throws SQLException, ClassNotFoundException {

        try {
            Connection cnx = ConnectionDB.GetConnection();
            PreparedStatement ps = cnx.prepareStatement("{ call SearchProductsById(?) }");
            ps.setInt(1, productId);

            ResultSet rs = ps.executeQuery();

            List<com.shop.models.Products> listProducts = new ArrayList<>();
            while (rs.next()) {
            
                com.shop.models.Products products = new com.shop.models.Products();
                products.setId(rs.getInt("Id"));

                products.setCategoryId(rs.getInt("CategoryId"));
               
                com.shop.models.Categories categories = new com.shop.models.Categories();
                categories.setId(rs.getInt("CategoryId"));
                categories.setName(rs.getString("CategoryName"));
                products.setCategories(categories); 
                
                products.setName(rs.getString("Name"));
                products.setPrice(rs.getDouble("Price"));
                products.setShippingCost(rs.getDouble("ShippingCost"));
                products.setWarranty(rs.getString("Warranty"));
                products.setDescription("Description");
                products.setQuantity(rs.getInt("Quantity"));

                products.setStateId(rs.getInt("StateId"));
                com.shop.models.States states = new com.shop.models.States();
                states.setId(rs.getInt("StateId"));
                states.setName(rs.getString("StateName"));
                products.setStates(states);

                products.setCustomerId(rs.getInt("CustomerId"));
                products.setGuid(rs.getString("Guid"));

                listProducts.add(products);

            }
            return listProducts;
        } catch (Exception ex) {
            throw ex;
        }

    }
}
