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
import java.util.ArrayList;
import java.util.List;
//SEARCH METHOD PAYMENT

public class MethodPayment {
        public List<com.shop.models.MethodPayment> SearchMethodsPayment()
                throws SQLException, ClassNotFoundException {

        try {
            Connection cnx = ConnectionDB.GetConnection();
            PreparedStatement ps = cnx.prepareStatement("{ call SearchMethodsPayment() }");//no recibe parametros
            ResultSet rs = ps.executeQuery();

            List<com.shop.models.MethodPayment> listMethodsPayment = new ArrayList<>();
            while (rs.next()) {
                com.shop.models.MethodPayment methodPayment = new com.shop.models.MethodPayment();
                methodPayment.setId(rs.getInt("Id"));
                methodPayment.setName(rs.getString("Name"));
                methodPayment.setActive(rs.getBoolean("Active"));

                listMethodsPayment.add(methodPayment);
            }
            return listMethodsPayment;
        } catch (Exception ex) {
            throw ex;
        }

   }
    
    
    
}
