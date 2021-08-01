
package com.shop.data;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
// el public STATIC SIve para poder invocarlo desde cualkier parte del codigo sin ahcer instancia 


public class ConnectionDB {

    private static Connection cnx = null;

    public static Connection GetConnection() throws SQLException,
            ClassNotFoundException {
        if (cnx == null) {

            try {
                String server, dataBase, user, password = "";

                server = "localhost";
                dataBase = "ShopPrueba";
                user = "leo";
                password = "leo";
                //1. Driver de Conexion
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                //2. Hacemos la conexion

                cnx = DriverManager.getConnection("jdbc:sqlserver://" + server + " :1433 ; databaseName =" + dataBase, user, password);

            } catch (Exception ex) {
                throw ex;
            }
        }
        return cnx;
    }

    ; 

    public static void CloseConnection() throws SQLException {
        if (cnx != null) {
            cnx.close();
        }
    }
}
