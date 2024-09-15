/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfx;

import java.awt.Component;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author mahek
 */
public class PurchaseController implements Initializable {

    @FXML
    private Button btnfile;
    @FXML
    private Button btncancel;
    String f;
    /**
     * Initializes the controller class.
     */
    byte[] photo = null;
    String filename = null;

    static File selectedfile;
    @FXML
    private DatePicker dt;
    @FXML
    private Label l;
    String fis;
    @FXML
    private AnchorPane anchor;
    static Date date;
    @FXML
    private VBox box;
        AnchorPane apn = new AnchorPane();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        String vurl="file:\\C:\\Users\\mahek\\Downloads\\mp4";
//        Media media=new Media(vurl);
//        MediaPlayer mediaplayer=new MediaPlayer(media);
//        md.setFitWidth(800);
//        md.setFitHeight(600);
//        md.setMediaPlayer(mediaplayer);
//        mediaplayer.play();

    }

    @FXML
    private void btncancel(ActionEvent event) {
    }

    @FXML
    private void filechoose(ActionEvent event) {
        System.out.println("click");
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        selectedfile = chooser.showOpenDialog(new Stage());
        date = Date.valueOf(dt.getValue());
        String f = selectedfile.getPath();
        try {
            if (selectedfile != null) {

////                AnchorPane pane = FXMLLoader.load(getClass().getResource("purchase.fxml"));
//                anchor.getScene().getWindow().hide();
//                Stage primaryStage = new Stage();
//                Parent r = FXMLLoader.load(getClass().getResource("image.fxml"));
//                Scene scene = new Scene(r);
//                // scene.getStylesheets().add(getClass().getResource("medi_design.css").toExternalForm());
//                primaryStage.setScene(scene);
//                primaryStage.show();
                anchor.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                Parent root = loader.load();
                DashboardController d = loader.getController();
                FXMLLoader loading = new FXMLLoader(getClass().getResource("image.fxml"));
                apn = loading.load();
                d.pn2.setContent(apn);
                apn.prefHeightProperty().bind(d.pn2.heightProperty());
                Stage primaryStage = new Stage();
                Scene scene = new Scene(root);
                scene.getStylesheets().add(getClass().getResource("dashboard_design.css").toExternalForm());
                primaryStage.setScene(scene);
                primaryStage.setMaximized(true);
                primaryStage.show();

            } else {
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "no file selected");

            }
        } catch (Exception e) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, e, "try again", JOptionPane.ERROR_MESSAGE);

        }

    }

}
