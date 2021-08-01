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
 *
 * BUSCAR CATGORIAS NO RECIBE NINGUN PARAMETRO DE LA BASE DE DATOS
 */
public class Categories {

    public List<com.shop.models.Categories> SearchCategories() throws SQLException, ClassNotFoundException {

        try {
            Connection cnx = ConnectionDB.GetConnection();
            PreparedStatement ps = cnx.prepareStatement("{ call SearchCategories() }");
            ResultSet rs = ps.executeQuery();

            List<com.shop.models.Categories> listCategories = new ArrayList<>();
            while (rs.next()) {
                com.shop.models.Categories categories = new com.shop.models.Categories();
                categories.setId(rs.getInt("Id"));
                categories.setName(rs.getString("Name"));
                categories.setActive(rs.getBoolean("Active"));

                listCategories.add(categories);
            }
            return listCategories;
        } catch (Exception ex) {
            throw ex;
        }

   }
}
