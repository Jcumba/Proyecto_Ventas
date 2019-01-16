package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DaoProductos {

    public static void Guardar(String nombre, String apellido, String email) throws SQLException {

        DaoConectar cc = new DaoConectar();
        String sql = "INSERT INTO Productos (nom_product,costo_product,peso_product)values (?,?,?)";
        try {
            PreparedStatement ps = cc.conexion().prepareCall(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, email);
            ps.executeUpdate();

            System.out.println("subido");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar " + e);
        }
    }

    public static void update(String d1, String d2, String d3, String cod_venta) throws SQLException {

        DaoConectar cc = new DaoConectar();

        String sql = " update  Productos set nom_product = ?,costo_product = ?,peso_product = ?  where cod_productos = ? ";
        try {

            PreparedStatement ps = cc.conexion().prepareCall(sql);
            ps.setString(1, d1);
            ps.setString(2, d2);
            ps.setString(3, d3);
            ps.setString(4, cod_venta);
            ps.executeUpdate();
            System.out.println("subido");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar " + e);
        }
    }

    public static void eliminar(String cod_venta) throws SQLException {

        DaoConectar cc = new DaoConectar();

        String sql = " update  Productos set est_prod = 'I' where cod_productos = ? ";
        try {

            PreparedStatement ps = cc.conexion().prepareCall(sql);
            ps.setString(1, cod_venta);
            ps.executeUpdate();
            System.out.println("subido");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar " + e);
        }
    }

}
