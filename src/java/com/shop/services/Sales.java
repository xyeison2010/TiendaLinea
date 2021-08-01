/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shop.services;

import com.shop.data.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//VENTAS , SALES 
public class Sales {
   
//devolvera id venta para mostrarlo en la pagina
    public int SaleComplete(int methodPaymentId,
            double totalValue,
            int customerId,
            int productId,
            int quantity,
            double subtotalValue) throws SQLException, ClassNotFoundException {

        try {

            Connection cnx = ConnectionDB.GetConnection();
            PreparedStatement ps = cnx.prepareStatement("{ call Sale(?,?,?,?,?,?) }");

            ps.setInt(1, methodPaymentId);
            ps.setDouble(2, totalValue);
            ps.setInt(3, customerId);
            ps.setInt(4, productId);
            ps.setInt(5, quantity);
            ps.setDouble(6, subtotalValue);

           ResultSet rs = ps.executeQuery();
           int saleId = 0;
           
           while (rs.next()){
           saleId = rs.getInt("SaleId");  
           }
            return saleId;
        } catch (Exception ex) {
            throw ex;
        }

    }

}
