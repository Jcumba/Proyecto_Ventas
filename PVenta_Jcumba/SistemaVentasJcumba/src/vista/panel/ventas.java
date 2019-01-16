package vista.panel;

import DAO.DaoAlmacen;
import DAO.DaoVentas;
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
import Reporte.ReportGenerator;





public final class ventas extends javax.swing.JPanel {

    DAO.DaoConectar cc = new DAO.DaoConectar();
    int User = 0;
    String nom;
    final String admin;
    DefaultTableModel model;
    String del;
    String ad;

    public ventas() {
        initComponents();
        busqueda();
        Ventas.setVisible(true);
        Registros.setVisible(false);

        admin = Vistas.Menu.nombreusuario.getText();
        fechadehoy.setDate(fechaActual());
        fechadehoy.setEnabled(false);
        t_ventas.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (t_ventas.getSelectedRow() != -1) {
                int fila = t_ventas.getSelectedRow();
                ad = t_ventas.getValueAt(fila, 00).toString();
                del = ((t_ventas.getValueAt(fila, 0).toString()));

            }
        });
        try {
            Statement sent = cc.conexion().createStatement();
            ResultSet rs = sent.executeQuery("select *from clientes");
            while (rs.next()) {
                this.cliente.addItem(rs.getString("ape_client"));
            }

        } catch (SQLException e) {
        }
        try {
            Statement sent = cc.conexion().createStatement();
            ResultSet rs = sent.executeQuery("select *from Productos");
            while (rs.next()) {
                this.producto.addItem(rs.getString("nom_product"));
            }

        } catch (SQLException e) {
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Ventas = new javax.swing.JPanel();
        producto = new javax.swing.JComboBox<>();
        cliente = new javax.swing.JComboBox<>();
        fechadehoy = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cantida = new javax.swing.JTextField();
        cod_client = new javax.swing.JLabel();
        cod_product = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        neto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codigo = new javax.swing.JLabel();
        cod_us = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Registros = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_ventas = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        Ventas.setBackground(new java.awt.Color(255, 255, 255));
        Ventas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });
        Ventas.add(producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 130, 30));

        cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteActionPerformed(evt);
            }
        });
        Ventas.add(cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 130, -1));
        Ventas.add(fechadehoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        jLabel2.setText("Cliente:");
        Ventas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 20));

        jLabel3.setText("Producto:");
        Ventas.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        Ventas.add(cantida, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 60, -1));

        cod_client.setText("jLabel1");
        Ventas.add(cod_client, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, 20));
        Ventas.add(cod_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 110, 20));

        jLabel1.setText("Monto Total");
        Ventas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, -1, -1));

        neto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Ventas.add(neto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 130, 30));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Ventas.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jLabel6.setText("Costo pór Unida");
        Ventas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 20));

        jLabel4.setText("Cantidad :");
        Ventas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 60, 20));
        Ventas.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 60, 20));
        Ventas.add(cod_us, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 40, 20));

        jButton2.setText("Registros");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Ventas.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, -1, -1));

        add(Ventas, "card2");

        Registros.setBackground(new java.awt.Color(255, 255, 255));
        Registros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_ventas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(t_ventas);

        Registros.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 460, 190));

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
        Registros.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 140, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/search.png"))); // NOI18N
        Registros.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 40, 40));

        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Registros.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Registros.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGEN/PDF 2_26px.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);

        Registros.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 50, 40));

        add(Registros, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteActionPerformed
        try {
            Statement sent = cc.conexion().createStatement();
            ResultSet rs = sent.executeQuery("select *from clientes where ape_client='" + this.cliente.getSelectedItem() + "'");
            rs.next();
            cod_client.setText(rs.getString("cod_cliente"));
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_clienteActionPerformed

    private void productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoActionPerformed
        try {
            Statement sent = cc.conexion().createStatement();
            ResultSet rs = sent.executeQuery("select *from Productos where nom_product='" + this.producto.getSelectedItem() + "'");
            rs.next();
            codigo.setText(rs.getString("cod_productos"));
            cod_product.setText(rs.getString("costo_product"));

        } catch (SQLException e) {
        }

    }//GEN-LAST:event_productoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (cantida.getText().length() == 0) {
            cantida.setText("1");
        }
        try {
            usuariovalidar();
            calcular();
            DaoVentas.guardar(cod_client.getText(), codigo.getText(), cod_us.getText(), new java.sql.Date(fechadehoy.getDate().getTime()), neto.getText());
            DaoAlmacen.update(codigo.getText(), cantida.getText());
            DaoAlmacen.uno(codigo.getText());
            DaoAlmacen.dos(codigo.getText());
            DaoAlmacen.tres(codigo.getText());
            busqueda();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Registro añadido");
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Registros.setVisible(true);
        Ventas.setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Ventas.setVisible(true);
        Registros.setVisible(false);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (t_ventas.getSelectedRows().length > 0) {
            int fila = t_ventas.getSelectedRow();
            String valor = t_ventas.getValueAt(fila, 0).toString();
            int jaja = JOptionPane.showConfirmDialog(null, "Desea Eliminar este registro", "Registro eliminado", JOptionPane.YES_NO_OPTION);
            if (jaja == JOptionPane.YES_OPTION) {
                if (fila >= 0) {
                    try {
                        DaoVentas.eliminar(del);
                        busqueda();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error " + ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccion la fila a eliminar");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        busqueda();        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        
        
       ReportGenerator re =new  ReportGenerator();//CREAMOS UN OBJETO DE LA CLASE REPORTES
        String ruta = "src/Jasper/ReporteVenta.jasper";//RUTA DONDE TIENEN SU REPORTE --
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

    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    public class Function {

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        public ResultSet find(String s) {
            try {

                ps = cc.conexion().prepareStatement("select * from usuarios where nombres = ?  ");
                ps.setString(1, s);

                rs = ps.executeQuery();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            return rs;
        }

    }

    public void busqueda() {
        String[] titulos = {"CODIGO", "VENDEDOR", "CLIENTE", "PRODUCTO"};
        String[] registros = new String[50];
        String sql = "select cod_ventas , nombres ,concat(clientes.nom_client,' ', clientes.ape_client) as cliente,nom_product from Ventas \n"
                + "inner join clientes on\n"
                + "clientes.cod_cliente = Ventas.cod_cliente\n"
                + "inner join Productos on\n"
                + "Productos.cod_productos = Ventas.cod_productos\n"
                + "inner join Usuarios on\n"
                + "Usuarios.cod_us = Ventas.cod_us where cod_ventas like'%" + txtBuscar.getText() + "%'";

        model = new DefaultTableModel(null, titulos);
        try {
            Statement st = (Statement) cc.conexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("cod_ventas");
                registros[1] = rs.getString("nombres");
                registros[2] = rs.getString("cliente");
                registros[3] = rs.getString("nom_product");

                model.addRow(registros);
            }
            t_ventas.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public void usuariovalidar() {
        Function f = new Function();
        ResultSet rs = null;
        rs = f.find(admin);
        try {
            if (rs.next()) {
                cod_us.setText(rs.getString("cod_us"));
            } else {
                JOptionPane.showMessageDialog(null, "Error no se encuentra Usuario");
            }
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void calcular() {
        double s1 = Double.valueOf(cantida.getText());
        double s2 = Double.valueOf(cod_product.getText());
        double rs = s1 * s2;
        String d1 = "" + rs;
        neto.setText(d1);
    }

    ;
public static java.util.Date fechaActual() {
        java.util.Date fecha = new java.util.Date();
        return (fecha);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Registros;
    private javax.swing.JPanel Ventas;
    private javax.swing.JTextField cantida;
    private javax.swing.JComboBox<String> cliente;
    private javax.swing.JLabel cod_client;
    private javax.swing.JLabel cod_product;
    private javax.swing.JLabel cod_us;
    private javax.swing.JLabel codigo;
    private com.toedter.calendar.JDateChooser fechadehoy;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel neto;
    private javax.swing.JComboBox<String> producto;
    private javax.swing.JTable t_ventas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

}
