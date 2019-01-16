package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Daoclientes {

    public static void Guardar(String nombre, String apellido, String telf, String email) throws SQLException {

        DaoConectar cc = new DaoConectar();
        String sql = "INSERT INTO Clientes (nom_client,ape_client,telf_client,email_client) values (?,?,?,?) ";
        try {
            PreparedStatement ps = cc.conexion().prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, telf);
            ps.setString(4, email);
            ps.executeUpdate();
            System.out.println("subido");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar " + e);
        }}

    public static void Editar(String cod_cient, String nombre, String apellido, String telf, String email) throws SQLException {

        DaoConectar cc = new DaoConectar();
        
        String sql = " INSERT INTO Clientes (cod_cliente,nom_client,ape_client,telf_client,email_client)";
        try {
            PreparedStatement ps = cc.conexion().prepareCall(sql);
            ps.setString(1, cod_cient);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, telf);
            ps.setString(5, email);
            ps.executeUpdate();
            System.out.println("subido");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar " + e);
        } }

    public static void eliminar(String cod_venta) throws SQLException {

        DaoConectar cc = new DaoConectar();
        
        String sql = " update Clientes set est_cli = 'I' where cod_cliente = ? ";
        try {
            PreparedStatement ps = cc.conexion().prepareCall(sql);
            ps.setString(1, cod_venta);
            ps.executeUpdate();

            System.out.println("Resgitro Eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar " + e);
        }}}
