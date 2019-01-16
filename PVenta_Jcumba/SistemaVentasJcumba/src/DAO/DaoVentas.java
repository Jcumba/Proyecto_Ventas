package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DaoVentas {

    public static void guardar(String cod_client, String cod_producto, String cod_us, java.sql.Date fch, String total) throws SQLException {

        DaoConectar cc = new DaoConectar();
        String sql = "INSERT INTO Ventas (cod_cliente,cod_productos,cod_us,fch_venta,total_venta) values (?,?,?,?,?) ";
        try {
            PreparedStatement ps = cc.conexion().prepareStatement(sql);
            ps.setString(1,cod_client );
            ps.setString(2, cod_producto);
            ps.setString(3,cod_us);
            ps.setString(4, String.valueOf(fch));
            ps.setString(5,total);
            ps.executeUpdate();

            System.out.println("subido");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar " + e);
        }
    }
    public static void eliminar(String cod_venta) throws SQLException {

        DaoConectar cc = new DaoConectar();
        String sql ="DELETE FROM Ventas where cod_ventas = ?";
        try {
            PreparedStatement ps = cc.conexion().prepareStatement(sql);
            ps.setString(1, cod_venta);            
            ps.executeUpdate();                       
            System.out.println("subido");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar " + e);
        } }}
