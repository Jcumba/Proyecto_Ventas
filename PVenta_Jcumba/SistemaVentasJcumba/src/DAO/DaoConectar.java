package DAO;

import java.sql.*;

public class DaoConectar {

    Connection conect = null;

    public Connection conexion() {
        try {

            String url = "jdbc:sqlserver://localhost:1433;databaseName=Ventas";
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            conect = DriverManager.getConnection(url, "sa", "123");
            System.out.println("conexion establecida");

        } catch (ClassNotFoundException | SQLException e) {
            
            System.out.println("error de conexion " + e);
        }
        return conect;
    }

}
