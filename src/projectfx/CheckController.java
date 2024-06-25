/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfx;

import java.awt.Frame;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 * FXML Controller class
 *
 * @author mahek
 */
public class CheckController extends Frame implements Initializable {

    @FXML
    private Button print;

    /**
     * Initializes the controller class.
     */
    private static JasperReport jr;
    private static JasperPrint jp;
    
    Connection c;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        public Connection connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jtb", "root", "");
            return c;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    @FXML
    private void btnprint(ActionEvent event) throws JRException {
            c = connection();
        Map<String, Object> m = new HashMap<>();
         m.put("invoiceno", "1");
        m.put("customername","ram");
        m.put("mobileno", "890898");
//        if(p_case.isSelected())
              m.put("payment","online");
//        else
//            m.put("payment", p_online.getText());
        

        jr = JasperCompileManager.compileReport("D:\\java\\.net\\projectfx\\src\\projectfx\\report1.jrxml");
        jp = JasperFillManager.fillReport(jr, m, c);
        JRViewer jrv = new JRViewer(jp);
        jrv.setOpaque(true);
        jrv.setVisible(true);
        this.add(jrv);
        this.setSize(300, 300);
        this.setVisible(true);
     

      
              
    }
    
}
