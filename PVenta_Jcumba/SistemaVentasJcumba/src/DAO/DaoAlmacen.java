/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class DaoAlmacen {

    public static void update(String d1, String d2) throws SQLException {

        DaoConectar cc = new DaoConectar();

        String sql = " exec ini  ?,? ";
        try {

            PreparedStatement ps = cc.conexion().prepareCall(sql);
            ps.setString(1, d1);
            ps.setString(2, d2);
            ps.executeUpdate();
            System.out.println("subido");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar " + e);
        }
    }

    public static void uno(String d1) throws SQLException {

        DaoConectar cc = new DaoConectar();

        String sql = " exec uno ? ";
        try {

            PreparedStatement ps = cc.conexion().prepareCall(sql);
            ps.setString(1, d1);

            ps.executeUpdate();
            System.out.println("1");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar " + e);
        }
    }

    public static void dos(String d1) throws SQLException {

        DaoConectar cc = new DaoConectar();

        String sql = " exec dos ? ";
        try {

            PreparedStatement ps = cc.conexion().prepareCall(sql);
            ps.setString(1, d1);

            ps.executeUpdate();
            System.out.println("2");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar " + e);
        }
    }

    public static void tres(String d1) throws SQLException {

        DaoConectar cc = new DaoConectar();

        String sql = " exec tres ? ";
        try {

            PreparedStatement ps = cc.conexion().prepareCall(sql);
            ps.setString(1, d1);

            ps.executeUpdate();
            System.out.println("3");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar " + e);
        }
    }

    public static void Guardar(String d1,String d2) throws SQLException {

        DaoConectar cc = new DaoConectar();

        String sql = " insert into Almacen (cantida_ini,cod_productos) values (?,?) ";
        try {

            PreparedStatement ps = cc.conexion().prepareCall(sql);
            ps.setString(1, d1);
            ps.setString(2, d2);
            ps.executeUpdate();
            System.out.println("subido");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Registrar " + e);
        }
    }

}
