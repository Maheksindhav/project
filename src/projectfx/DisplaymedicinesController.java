/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfx;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static projectfx.InvoicefxController.no;

/**
 * FXML Controller class
 *
 * @author mahek
 */
public class DisplaymedicinesController implements Initializable {

    @FXML
    private AnchorPane medicine_panel;
 
    /**
     * Initializes the controller class.
     */
    Connection c;
    @FXML
    private TableView<setvariables> tableview1;
    @FXML
    private TableColumn<setvariables, String> custnm;
    @FXML
    private TableColumn<setvariables, String> mno;
    @FXML
    private TableColumn<setvariables, Integer> drs;
    @FXML
    private TableColumn<setvariables, Float> gsti;
    @FXML
    private TableColumn<setvariables, Float> tam;
    @FXML
    private TableColumn<setvariables, Integer> ino;
    @FXML
    private TableColumn<setvariables, String> payment;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getdatelist();
        display();
    }

    //display tableview
    
     ObservableList<setvariables> getdatelist() {
        ObservableList<setvariables> invoicelist = FXCollections.observableArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jtb", "root", "");
            PreparedStatement p = c.prepareStatement("select *from invoicebill");
            ResultSet rs = p.executeQuery();
            setvariables s;

            while (rs.next()) {
                s = new setvariables(rs.getInt("invoice_no"), rs.getString("customer_nm"), rs.getString("mobile_no"), rs.getInt("discount"), rs.getFloat("gst"), rs.getFloat("total_amount"),rs.getString("payment_method"));
                invoicelist.add(s);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return invoicelist;

    }

    public void display() {
        try {
            ObservableList<setvariables> list = getdatelist();

            ino.setCellValueFactory(new PropertyValueFactory<setvariables, Integer>("ino"));
            custnm.setCellValueFactory(new PropertyValueFactory<setvariables, String>("custnm"));
            mno.setCellValueFactory(new PropertyValueFactory<setvariables, String>("mno"));
            drs.setCellValueFactory(new PropertyValueFactory<setvariables, Integer>("drs"));
            gsti.setCellValueFactory(new PropertyValueFactory<setvariables, Float>("gst"));
            tam.setCellValueFactory(new PropertyValueFactory<setvariables, Float>("tam"));
             payment.setCellValueFactory(new PropertyValueFactory<setvariables, String>("payment"));
            
            
           
            

            tableview1.setItems(list);
        } catch (Exception e) {
            System.out.println(e + "not display");
        }
    }

    
    
    private void btnback(ActionEvent event) {
         try {
                                AnchorPane pane = FXMLLoader.load(getClass().getResource("displaymedicines.fxml"));
                                medicine_panel.getScene().getWindow().hide();
                                Stage stage = new Stage();
                                Parent p = FXMLLoader.load(getClass().getResource("invoicefx.fxml"));
                                Scene s = new Scene(p);
                                  s.getStylesheets().add(getClass().getResource("purchasecss.css").toExternalForm());
                                stage.setScene(s);
                                stage.show();
                                System.out.println("click");

                            } catch (Exception e) {
                                System.out.println(e);
                            }
    }
}
