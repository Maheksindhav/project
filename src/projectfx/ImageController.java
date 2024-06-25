/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfx;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import sun.plugin.javascript.navig.Anchor;

/**
 * FXML Controller class
 *
 * @author mahek
 */
public class ImageController implements Initializable {

    @FXML
    private Button btnyes;
    @FXML
    private Button btnno;
    @FXML
    public ImageView img;
    @FXML
    private AnchorPane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        displayimage();

    }

    public void displayimage() {

        try {

            FileInputStream fis = new FileInputStream(PurchaseController.selectedfile);
            Image i = new Image(fis);
            img.setImage(i);
            Stage s=new Stage();
            Parent r=FXMLLoader.load(getClass().getResource("purchase.fxml"));
            Scene scane=new Scene(r);
             s.setScene(scane);
              s.show();
            

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public void another()
    {
        try {
              AnchorPane p=FXMLLoader.load(getClass().getResource("image.fxml"));
              pane.getScene().getWindow().hide();
              
            
        } catch (Exception e) {
        }
      
        
    }
    @FXML
    private void yes(ActionEvent event) {

        try {
         Date d=PurchaseController.date;
        String f=PurchaseController.selectedfile.getPath();
          
        
                         
              iobj obj=new iobj();

                if (obj.insertimg(d, f)>0) {
                     Component rootPane = null;
                 JOptionPane.showMessageDialog(rootPane, "insert record", "insert", JOptionPane.INFORMATION_MESSAGE);
                 another();
               }
                else
                 {
                   Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "try again", "try", JOptionPane.ERROR_MESSAGE);
                 }
        } catch (Exception e) {
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, e, "try", JOptionPane.ERROR_MESSAGE);
                
        }
    }

    @FXML
    private void btnno(ActionEvent event) {
        another();

    }

}
