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

/**
 *
 * SEARCH CUSTOMERS
 */
public class Customers {
      public List<com.shop.models.Customer> SearchCustomers(String userName)
         throws SQLException, ClassNotFoundException {

        try {
            Connection cnx = ConnectionDB.GetConnection();
            PreparedStatement ps = cnx.prepareStatement("{ call SearchCustomers(?) }");
            ps.setString(1,userName);
      
            
            ResultSet rs = ps.executeQuery();

            List<com.shop.models.Customer> listCustomers = new ArrayList<>();
            while (rs.next()) {

                com.shop.models.Customer customer = new com.shop.models.Customer();
                customer.setId(rs.getInt("Id"));
                
               customer.setDocumentTypeId(rs.getInt("DocumentTypeId"));
                com.shop.models.DocumentTypes documentTypes = new com.shop.models.DocumentTypes(); 
                documentTypes.setId(rs.getInt("DocumentTypeId"));
                documentTypes.setName(rs.getString("DocumentTypeName"));
                customer.setDocumentTypes(documentTypes);
                
                customer.setDocumentNumber(rs.getString("DocumentNumber"));
                customer.setFirstName(rs.getString("FirstName"));
                customer.setSecondName(rs.getString("SecondName"));
                customer.setSurname(rs.getString("Surname"));
                customer.setSecondSurname(rs.getString("SecondSurname"));
                
                customer.setTelephone(rs.getString("Telephone"));
                customer.setAddress(rs.getString("Address"));
                
                customer.setCityId(rs.getInt("CityId"));
                com.shop.models.Cities cities = new com.shop.models.Cities(); 
                cities.setId(rs.getInt("CityId"));
                cities.setName(rs.getString("CityName"));
                customer.setCities(cities);
                
                customer.setUserId(rs.getInt("UserId"));//esta apesar de ser foranea no traeramos las propiedades simplement el userid
                
                listCustomers.add(customer);
               

            }
            return listCustomers;
        } catch (Exception ex) {
            throw ex;
        }
}}
