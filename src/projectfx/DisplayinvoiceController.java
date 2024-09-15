
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mahek
 */
public class DisplayinvoiceController implements Initializable {

    @FXML
    private TableView<setvar> tableview;
    @FXML
    private TableColumn<setvar, Date> date;
    @FXML
    private TableColumn<setvar, String> img;

    /**
     * Initializes the controller class.
     */
    Connection c;
    static String path;
    @FXML
    private TableColumn<String, Button> btn;
    @FXML
    private AnchorPane thisanchor;
    AnchorPane apn = new AnchorPane();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getdatelist();
        display();
    }

    ObservableList<setvar> getdatelist() {
        ObservableList<setvar> invoicelist = FXCollections.observableArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jtb", "root", "");
            PreparedStatement p = c.prepareStatement("select *from purchase");
            ResultSet rs = p.executeQuery();
            setvar s;

            while (rs.next()) {
                s = new setvar(rs.getDate("date"), rs.getString("images"));
                //System.out.println(s);
                invoicelist.add(s);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return invoicelist;

    }

    public void display() {
        try {
            ObservableList<setvar> list = getdatelist();

            date.setCellValueFactory(new PropertyValueFactory<setvar, Date>("date"));
            img.setCellValueFactory(new PropertyValueFactory<setvar, String>("images"));

            btn.setCellFactory(col -> new TableCell<String, Button>() {
                @Override
                protected void updateItem(Button obj, boolean b) {
                    super.updateItem(obj, b);
                    if (b) {
                        setGraphic(null);
                    } else {
                        Button B = new Button("Show image");
                        B.setPrefSize(150, 30);
                        B.setId("button");

                        setGraphic(B);
                        B.setOnAction((event) -> {
                            System.out.println("hello");
                            path = tableview.getSelectionModel().getSelectedItem().images;
                            System.out.println(path);
                            try {

                                thisanchor.getScene().getWindow().hide();

                                FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                                Parent root = loader.load();
                                DashboardController d = loader.getController();
                                FXMLLoader loading = new FXMLLoader(getClass().getResource("viewinvoice.fxml"));
                                apn = loading.load();
                                d.pn2.setContent(apn);
                                apn.prefHeightProperty().bind(d.pn2.heightProperty());
                                Stage primaryStage = new Stage();
                                Scene scene = new Scene(root);
                                scene.getStylesheets().add(getClass().getResource("dashboard_design.css").toExternalForm());
                                primaryStage.setScene(scene);
                                primaryStage.setMaximized(true);
                                primaryStage.show();
                              

//                                AnchorPane pane = FXMLLoader.load(getClass().getResource("displayinvoice.fxml"));
//                                thisanchor.getScene().getWindow().hide();
//                                Stage stage = new Stage();
//                                Parent p = FXMLLoader.load(getClass().getResource("viewinvoice.fxml"));
//                                Scene s = new Scene(p);
//                                  s.getStylesheets().add(getClass().getResource("purchasecss.css").toExternalForm());
//                                stage.setScene(s);
//                                stage.show();
//                                System.out.println("click");
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

}
