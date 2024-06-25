/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfx;

import java.awt.Component;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mahek
 */
public class PatientController implements Initializable {

    @FXML
    private Button btnsave;
    @FXML
    private Button btncancel;
    @FXML
    private TextField txtpatientid;
    @FXML
    private TextField txtpatientnm;
    @FXML
    private TextField txtphoneno;
    @FXML
    private RadioButton radiomale;
    @FXML
    private RadioButton radiofemale;
    @FXML
    private RadioButton radioother;
    @FXML
    private TextField txtage;
    @FXML
    private TextField txtcity;
    @FXML
    private TextField txtpincode;
    @FXML
    private TextField txtdoctornm;
    @FXML
    private TextField txtsearch;
    @FXML
    private Button btnsearch;
    @FXML
    private Button btnfirst;
    @FXML
    private Button btnlast;
    @FXML
    private Button btnnext;
    @FXML
    private Button btnprev;
    @FXML
    private TableView<setpatient> tableview;
    @FXML
    private TableColumn<setpatient, Integer> pid;
    @FXML
    private TableColumn<setpatient, String> pnm;
    @FXML
    private TableColumn<setpatient, String> pno;
    @FXML
    private TableColumn<setpatient, String> gender;
    @FXML
    private TableColumn<setpatient, Integer> age;
    @FXML
    private TableColumn<setpatient, String> city;
    @FXML
    private TableColumn<setpatient, Integer> pincode;
    @FXML
    private TableColumn<setpatient, String> dnm;

    /**
     * Initializes the controller class.
     */
    int id,ag,pin;
    String name,phoneno,g,ct,doctor;
    Connection c;
    @FXML
    private ImageView ref;
    @FXML
    private ToggleGroup gen;
    @FXML
    private TableColumn<String, Button> edit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getdatelist();
        display();
    }

    public void clear() {
        txtpatientid.setText(null);
        txtpatientnm.setText(null);
        txtphoneno.setText(null);
        txtage.setText(null);
        txtcity.setText(null);
        txtpincode.setText(null);
        txtdoctornm.setText(null);

    }

    ObservableList<setpatient> getdatelist() {
        ObservableList<setpatient> addlist = FXCollections.observableArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jtb", "root", "");
            PreparedStatement p = c.prepareStatement("select *from pastient");
            ResultSet rs = p.executeQuery();
            setpatient s;

            while (rs.next()) {
                s = new setpatient(rs.getInt("pid"), rs.getString("pnm"), rs.getString("mobileno"), rs.getString("gender"),
                        rs.getInt("age"), rs.getString("city"), rs.getInt("pincode"), rs.getString("doctornm"));
                addlist.add(s);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return addlist;

    }

    public void display() {
        try {
            ObservableList<setpatient> list = getdatelist();

            pid.setCellValueFactory(new PropertyValueFactory<setpatient, Integer>("pid"));
            pnm.setCellValueFactory(new PropertyValueFactory<setpatient, String>("pnm"));
            pno.setCellValueFactory(new PropertyValueFactory<setpatient, String>("mobileno"));
            gender.setCellValueFactory(new PropertyValueFactory<setpatient, String>("gender"));
            age.setCellValueFactory(new PropertyValueFactory<setpatient, Integer>("age"));
            city.setCellValueFactory(new PropertyValueFactory<setpatient, String>("city"));
            pincode.setCellValueFactory(new PropertyValueFactory<setpatient, Integer>("pincode"));
            dnm.setCellValueFactory(new PropertyValueFactory<setpatient, String>("doctonm"));

            edit.setCellFactory(col -> new TableCell<String, Button>() {
                @Override
                protected void updateItem(Button obj, boolean b) {
                    super.updateItem(obj, b);
                    if (b) {
                        setGraphic(null);
                    } else {
                        Button btn = new Button();
                        btn.setPrefSize(30, 30);
                        btn.setId("buttonedit");
                        setGraphic(btn);
                        btn.setOnAction((event) -> {
                            try {
                                update();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        });

                    }
                }
            });

            tableview.setItems(list);
        } catch (Exception e) {
            System.out.println(e + "not display");
        }
    }

    ObservableList<setpatient> getdatasearch() {
        ObservableList<setpatient> search = FXCollections.observableArrayList();
        String se = txtsearch.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jtb", "root", "");
            PreparedStatement p = null;
            if (Character.isAlphabetic(se.charAt(0)) || Character.isAlphabetic(4)) {
                p = c.prepareStatement("select *from pastient  where pnm  like '%" + se + "%' or gender like '%" + se + "%' or   city like '%" + se + "%' or doctornm like '%" + se + "%'");
            } else if (Character.isDigit(se.charAt(0))) {
                p = c.prepareStatement("select *from pastient where pid=" + se);
//                          + "or qty="+se+" or rate="+se+" or amo="+se+"or mno="+se+" or drs="+se+" or gst="+se+" or tam="+se); 
            }
            ResultSet rs = p.executeQuery();
            setpatient s;

            while (rs.next()) {
                s = new setpatient(rs.getInt("pid"), rs.getString("pnm"), rs.getString("mobileno"), rs.getString("gender"),
                        rs.getInt("age"), rs.getString("city"), rs.getInt("pincode"), rs.getString("doctornm"));
                search.add(s);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return search;
    }

    public void search() {
        try {
            ObservableList<setpatient> l = getdatasearch();
            pid.setCellValueFactory(new PropertyValueFactory<setpatient, Integer>("pid"));
            pnm.setCellValueFactory(new PropertyValueFactory<setpatient, String>("pnm"));
            pno.setCellValueFactory(new PropertyValueFactory<setpatient, String>("mobileno"));
            gender.setCellValueFactory(new PropertyValueFactory<setpatient, String>("gender"));
            age.setCellValueFactory(new PropertyValueFactory<setpatient, Integer>("age"));
            city.setCellValueFactory(new PropertyValueFactory<setpatient, String>("city"));
            pincode.setCellValueFactory(new PropertyValueFactory<setpatient, Integer>("pincode"));
            dnm.setCellValueFactory(new PropertyValueFactory<setpatient, String>("doctonm"));

            tableview.setItems(l);
        } catch (Exception e) {
            System.out.println(e + "not display");
        }
    }
    
    public void update()
    {
       try {
             id = Integer.parseInt(txtpatientid.getText());
             name = txtpatientnm.getText();
            phoneno = txtphoneno.getText();

            if (radiomale.isSelected()) {
                g = radiomale.getText();
            } else if (radiofemale.isSelected()) {
                g = radiofemale.getText();
            } else {
                g = radioother.getText();
            }
             ag = Integer.parseInt(txtage.getText());
            ct = txtcity.getText();
            pin = Integer.parseInt(txtpincode.getText());
           doctor = txtdoctornm.getText();
            iobj obj = new iobj();
            System.out.println(id+" "+name);
            if (obj.updatepatient(id, name, phoneno, g ,ag, ct, pin, doctor) > 0) {
                 System.out.println(id+" "+name);
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "update record", "update", JOptionPane.INFORMATION_MESSAGE);
                display();
                //   clear();

            } else {
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "try again", "try", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, e, "try", JOptionPane.ERROR_MESSAGE);

        }  
    }        
    

    @FXML
    private void btnsave(ActionEvent event) {

        try {
             id = Integer.parseInt(txtpatientid.getText());
             name = txtpatientnm.getText();
            phoneno = txtphoneno.getText();

            if (radiomale.isSelected()) {
                g = radiomale.getText();
            } else if (radiofemale.isSelected()) {
                g = radiofemale.getText();
            } else {
                g = radioother.getText();
            }
             ag = Integer.parseInt(txtage.getText());
            ct = txtcity.getText();
            pin = Integer.parseInt(txtpincode.getText());
           doctor = txtdoctornm.getText();
            iobj obj = new iobj();
            if (obj.insertpatientdata(id, name, phoneno, g, ag, ct, pin, doctor) > 0) {
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "insert record", "insert", JOptionPane.INFORMATION_MESSAGE);
                display();
                //   clear();

            } else {
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, "try again", "try", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, e, "try", JOptionPane.ERROR_MESSAGE);

        }
    }

    @FXML
    private void btncancel(ActionEvent event) {
        clear();
    }

    @FXML
    private void txtratekeyreleased(KeyEvent event) {
    }

    @FXML
    private void btnsearch(ActionEvent event) {
        search();

    }

    @FXML
    private void btnfirstt(ActionEvent event) {
        TableView.TableViewSelectionModel<setpatient> s = tableview.getSelectionModel();
        s.selectFirst();

    }

    @FXML
    private void btnlast(ActionEvent event) {
        TableView.TableViewSelectionModel<setpatient> s = tableview.getSelectionModel();
        s.selectLast();
    }

    @FXML
    private void btnnext(ActionEvent event) {
        TableView.TableViewSelectionModel<setpatient> s = tableview.getSelectionModel();
        s.selectNext();
    }

    @FXML
    private void btnprev(ActionEvent event) {
        TableView.TableViewSelectionModel<setpatient> s = tableview.getSelectionModel();
        s.selectPrevious();
    }

    @FXML
    private void btnref(MouseDragEvent event) {
    }

    @FXML
    private void btnref(MouseEvent event) {
        display();
    }

    @FXML
    private void mouseClick(MouseEvent event) {
        txtpatientid.setText(String.valueOf(tableview.getSelectionModel().getSelectedItem().getPid()));
        txtpatientnm.setText(tableview.getSelectionModel().getSelectedItem().getPnm());
        txtphoneno.setText(tableview.getSelectionModel().getSelectedItem().getMobileno());
        if(radiomale.getText().equals(tableview.getSelectionModel().getSelectedItem().getGender()))
        {
            radiomale.setSelected(true);
        }
        else if(radiofemale.getText().equals(tableview.getSelectionModel().getSelectedItem().getGender()))
        {
            radiofemale.setSelected(true);
        }
        else
        {
            radioother.setSelected(true);
        }
        
        txtage.setText(String.valueOf(tableview.getSelectionModel().getSelectedItem().getAge()));
         txtcity.setText(tableview.getSelectionModel().getSelectedItem().getCity());
         txtpincode.setText(String.valueOf(tableview.getSelectionModel().getSelectedItem().getPincode()));
         txtdoctornm.setText(tableview.getSelectionModel().getSelectedItem().getDoctonm());
    }

}
