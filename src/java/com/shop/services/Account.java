package com.shop.services;

import java.sql.*;
import com.shop.data.ConnectionDB;

public class Account {

    public void Register(String email, String password) throws SQLException, ClassNotFoundException {

        try {
            Connection cnx = ConnectionDB.GetConnection();
            PreparedStatement ps = cnx.prepareStatement("{ call RegisterUser(?,?) }");

            ps.setString(1, email);
            ps.setString(2, password);

//ESTO ES PARA Q RETORNE ALGO , AUN ME FALTA COMPLETAR EN EL REGISTER , POR Q CUANDO UNA CUENTA SE REPITA
//ESTA NO DEBE DE REGISTRARSE ESO ME FALTA NO MAS 
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        }

    }
//consultaa si el registro esta creado con un username mismo 
     public boolean ValidarRegistro(String email, String password) throws SQLException, ClassNotFoundException {

        try {
            Connection cnx = ConnectionDB.GetConnection();
            PreparedStatement ps = cnx.prepareStatement("{ call ValidarRegistro(?,?) }");

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            boolean exists = false ; //estaba en exits lo cambie a exists  mmmmm...
            while (rs.next()) {
                exists = true ;
            }
            return exists;
        } catch (Exception ex) {
          throw ex;
        }

    }
    
    //LOGIN USER
    //SI LA CONSULTA RETORNO ALGO , LA PERSONA EXISTE 
    //SINO RETORNA LA VARIABLE EN SU ESTADO ORIGINAL  FALSO
    public boolean Login(String email, String password) throws SQLException, ClassNotFoundException {

        try {
            Connection cnx = ConnectionDB.GetConnection();
            PreparedStatement ps = cnx.prepareStatement("{ call LoginUser(?,?) }");

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            boolean exists = false; //estaba en exits lo cambie a exists  mmmmm...
            while (rs.next()) {
                exists = true;
            }
            return exists;
        } catch (Exception ex) {
            throw ex;
        }

    }

}
