/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.panel;

import DAO.Daoclientes;
import Reporte.ReportGenerator;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class Clientes extends javax.swing.JPanel {

    DefaultTableModel model;
    DAO.DaoConectar cc = new DAO.DaoConectar();
    String del;
    String ad;

    public Clientes() {
        initComponents();
        busqueda();
        t_cliente.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (t_cliente.getSelectedRow() != -1) {
                int fila = t_cliente.getSelectedRow();
                ad = t_cliente.getValueAt(fila, 00).toString();
                codigo.setText((t_cliente.getValueAt(fila, 0).toString())); 

            }
        });
        registros.setVisible(false);
    }

    public void busqueda() {
        String[] titulos = {"CODIGO", "Cliente", "teléfono", "Emaiil"};
        String[] registros = new String[50];
        String sql = "select cod_cliente , concat(concat(ape_client,' '),nom_client) as Nombres,telf_client,email_client from Clientes" ;

        model = new DefaultTableModel(null, titulos);
        try {
            Statement st = (Statement) cc.conexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("cod_cliente");
                registros[1] = rs.getString("Nombres");
                registros[2] = rs.getString("telf_client");
                registros[3] = rs.getString("email_client");
                

                model.addRow(registros);
            }
            t_cliente.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

     public class Function {

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        public ResultSet find(String s) {
            try {

                ps = cc.conexion().prepareStatement("select * from Clientes where cod_cliente = ?  ");
                ps.setString(1, s);

                rs = ps.executeQuery();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            return rs;
        }

    }
    
     public void jalar() {
        Function f = new Function();
        ResultSet rs = null;
        rs = f.find(del);
        try {
            if (rs.next()) {
                nombre.setText(rs.getString("nom_client"));
                apellido.setText(rs.getString("ape_client"));
                telefono.setText(rs.getString("telf_client"));
                email.setText(rs.getString("email_client"));
                
            } else {
                JOptionPane.showMessageDialog(null, "Error no se encuentra Usuario");
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cliente = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        registros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_cliente = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        codigo = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        cliente.setBackground(new java.awt.Color(255, 255, 255));
        cliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        cliente.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        jLabel1.setText("NOMBRES");
        cliente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        jLabel2.setText("APELLIDOS");
        cliente.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel3.setText("TELÉFONO");
        cliente.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel4.setText("EMAIL");
        cliente.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));
        cliente.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 200, 30));
        cliente.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 200, 30));
        cliente.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 200, 30));
        cliente.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 200, 30));

        jButton2.setText("Resgistros");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        cliente.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));

        jButton6.setText("Actualizar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        cliente.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, -1, -1));

        add(cliente, "card3");

        registros.setBackground(new java.awt.Color(255, 255, 255));
        registros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(t_cliente);

        registros.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 430, 110));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/search.png"))); // NOI18N
        registros.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });
        registros.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 140, 30));

        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        registros.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        registros.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, -1, -1));

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        registros.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        codigo.setText("jLabel6");
        registros.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 110, 20));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/PDF 2_26px.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        registros.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, -1, -1));

        add(registros, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            DAO.Daoclientes.Guardar(nombre.getText(), apellido.getText(), telefono.getText(), email.getText());
            busqueda();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Subir Registro " + ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        registros.setVisible(true);
        cliente.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (t_cliente.getSelectedRows().length > 0) {
            int fila = t_cliente.getSelectedRow();
            String valor = t_cliente.getValueAt(fila, 0).toString();
            int jaja = JOptionPane.showConfirmDialog(null, "Desea Eliminar este registro", "Registro eliminado", JOptionPane.YES_NO_OPTION);
            if (jaja == JOptionPane.YES_OPTION) {
                if (fila >= 0) {
                    try {
                        Daoclientes.eliminar(codigo.getText());
                        busqueda();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error " + ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccion la fila a eliminar");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        registros.setVisible(false);
        cliente.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if (t_cliente.getSelectedRows().length > 0) {
            int fila = t_cliente.getSelectedRow();
            String valor = t_cliente.getValueAt(fila, 0).toString();
        try {
            jalar();
            Daoclientes.Editar(codigo.getText(),nombre.getText(),apellido.getText(),telefono.getText(),email.getText());
            registros.setVisible(false);
            cliente.setVisible(true);
            
        } catch (SQLException e) {
        }}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            Daoclientes.Editar(codigo.getText(), nombre.getText(), apellido.getText(), telefono.getText(), email.getText());
            busqueda();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Actulizar Registro");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
busqueda();        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        ReportGenerator re =new  ReportGenerator();//CREAMOS UN OBJETO DE LA CLASE REPORTES
        String ruta = "src/Jasper/Clientes.jasper";//RUTA DONDE TIENEN SU REPORTE --
        //ABRIR CUADRO DE DIALOGO PARA GUARDAR EL ARCHIVO
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("todos los archivos *.PDF", "pdf", "PDF"));//filtro para ver solo archivos .pdf
        int seleccion = fileChooser.showSaveDialog(null);
        try {
            if (seleccion == JFileChooser.APPROVE_OPTION) {//comprueba si ha presionado el boton de aceptar
                File JFC = fileChooser.getSelectedFile();
                String PATH = JFC.getAbsolutePath();//obtenemos la direccion del archivo + el nombre a guardar
                try (PrintWriter printwriter = new PrintWriter(JFC)) {
                    printwriter.print(ruta);
                }
                re.resportesPDF(ruta, PATH);
                //mandamos como parametros la ruta del archivo a compilar y el nombre y ruta donde se guardaran
                //comprobamos si a la hora de guardar obtuvo la extension y si no se la asignamos
                if (!(PATH.endsWith(".pdf"))) {
                    File temp = new File(PATH + ".pdf");
                    JFC.renameTo(temp);//renombramos el archivo
                }
                JOptionPane.showMessageDialog(null, "Esto puede tardar unos segundos,espere porfavor", "Estamos Generando el Reporte", JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(null, "Documento Exportado Exitosamente!", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (FileNotFoundException | HeadlessException e) {//por alguna excepcion salta un mensaje de error
            JOptionPane.showMessageDialog(null, "Error al Exportar el archivo!", "Oops! Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JPanel cliente;
    private javax.swing.JLabel codigo;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre;
    private javax.swing.JPanel registros;
    private javax.swing.JTable t_cliente;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
