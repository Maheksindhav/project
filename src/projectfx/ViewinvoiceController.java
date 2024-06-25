/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfx;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
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
import javax.imageio.stream.FileImageInputStream;

/**
 * FXML Controller class
 *
 * @author mahek
 */
public class ViewinvoiceController implements Initializable {

    @FXML
    private ImageView viewimages;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Button btnback;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        try {
         FileInputStream file=new FileInputStream(DisplayinvoiceController.path);
        Image i=new Image(file);
        viewimages.setImage(i);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void btnback(ActionEvent event) {
        
        try {
            AnchorPane a=FXMLLoader.load(getClass().getResource("viewinvoice.fxml"));
            anchor.getScene().getWindow().hide();
            Stage s=new Stage();
            Parent p=FXMLLoader.load(getClass().getResource("displayinvoice.fxml"));
            Scene sc=new Scene(p);
            sc.getStylesheets().add(getClass().getResource("purchasecss.css").toExternalForm());
            s.setScene(sc);
            s.show();
        } catch (Exception e) {
        }
        
    }

}
