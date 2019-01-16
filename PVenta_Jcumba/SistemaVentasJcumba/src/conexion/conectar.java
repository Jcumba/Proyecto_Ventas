/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.*;

/**
 *
 * @author 027
 */
public class conectar {

    public static Connection conexion() {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=Ventas";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            Connection conect = DriverManager.getConnection(url, "sa", "123");
            System.out.println("conexion establecida");
            //JOptionPane.showMessageDialog(null,"Conectado");	
            return conect;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error de conexion " + e);
            //JOptionPane.showMessageDialog(null,"Error de conexion"+e);
        }
        return null;
    }

}
