package Reporte;

import conexion.conectar;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ReportGenerator {

   
    
    public final void resportesPDF(String ruta, String archi) {
        try {
            String rutaInforme = ruta;
         
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme,null, conectar.conexion());
            JasperExportManager.exportReportToPdfFile(informe, archi);

            JasperViewer ventanavisor = new JasperViewer(informe, false);
            ventanavisor.setTitle("INFORME");
            ventanavisor.setVisible(false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL EXPORTAR DOCUMENTO"+e);
        }
    }
    
}
