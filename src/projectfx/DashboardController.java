package projectfx;

import java.awt.Frame;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import org.apache.xerces.parsers.SAXParser;



public class DashboardController extends Frame implements Initializable {

    @FXML
    public SplitPane split;
    @FXML
    private AnchorPane pane1;
    @FXML
    private MenuButton menu111;
    @FXML
    private MenuButton menu11111;
    @FXML
    private MenuButton menu11112;
    @FXML
    private MenuButton menu111121;
    AnchorPane ap = new AnchorPane();
    @FXML
    public ScrollPane pn2;
    String unm;
    crud cr = new crud();
     Connection conn = cr.connect();
     private static JasperReport jr;
     private static JasperPrint jp;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pn2.prefHeightProperty().bind(split.heightProperty());
    }

    @FXML
    private void cateClick(ActionEvent event) {
        try {
            ap.getChildren().clear();//clear 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("category.fxml"));
            ap = loader.load();
            ap.getStylesheets().add(getClass().getResource("category_design.css").toExternalForm());
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void logOutvalue(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jtb","root","");
            PreparedStatement pst = conn.prepareStatement("select username from user");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                 unm = rs.getString("username");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @FXML
    private void viewCateClick(ActionEvent event) {
        try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewcategory.fxml"));
            ap = loader.load();
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void AddStockClick(ActionEvent event) {
        try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("medicines.fxml"));
            ap = loader.load();
            ap.getStylesheets().add(getClass().getResource("medi_design.css").toExternalForm());
            pn2.setContent(ap);
             ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void reorderclick(ActionEvent event) {
        try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("stock.fxml"));
            ap = loader.load();
            ap.getStylesheets().add(getClass().getResource("stock_design.css").toExternalForm());
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void ReturnClick(ActionEvent event) {
       returnclic();
    }

    public void returnclic()
    {
         try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("returnStock.fxml"));
            ap = loader.load();
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
            //ReturnStockController r = new ReturnStockController();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @FXML
    private void ViewReorderClick(ActionEvent event) {
        try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vieworder.fxml"));
            ap = loader.load();
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void ViewReturnStockClick(ActionEvent event) {
        try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewReturn.fxml"));
            ap = loader.load();
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void CompanyReceived(ActionEvent event) {
        try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("companyReturn.fxml"));
            ap = loader.load();
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void companyClick(ActionEvent event) {
        try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("company.fxml"));
            ap = loader.load();
            ap.getStylesheets().add(getClass().getResource("category_design.css").toExternalForm());
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void manageCompnay(ActionEvent event) {
        try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewCompany.fxml"));
            ap = loader.load();
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void StockReport(ActionEvent event) {
        try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("imageForm.fxml"));
            ap = loader.load();
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void invoice(ActionEvent event) {
         try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("invoicefx.fxml"));
            ap = loader.load();
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    @FXML
    private void purchase(ActionEvent event) {
         try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("purchase.fxml"));
            ap = loader.load();
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void view(ActionEvent event) {
         try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("displayinvoice.fxml"));
            ap = loader.load();
            ap.getStylesheets().add(getClass().getResource("purchasecss.css").toExternalForm());
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void details(ActionEvent event) {
         try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("displaymedicines.fxml"));
            ap = loader.load();
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void doctorForm(ActionEvent event) {
        try {
            ap.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("patient.fxml"));
            ap = loader.load();
             ap.getStylesheets().add(getClass().getResource("purchasecss.css").toExternalForm());
            pn2.setContent(ap);
            ap.prefHeightProperty().bind(pn2.heightProperty());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void logOutClick(ActionEvent event) {
        try {
            logOutvalue();
            crud cr = new crud();
            if (cr.logout(unm)>0) {
                    split.getScene().getWindow().hide();
                     FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
                     Parent root = loader.load();
                     Scene scene = new Scene(root);
                     scene.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
                     Stage primaryStage = new Stage();
                     primaryStage.setScene(scene);
                     primaryStage.show();
            } else {
                JOptionPane.showMessageDialog(null,"Try Again.","LogOut Message",JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void salesGraph(ActionEvent event) {
            try {
              jr = JasperCompileManager.compileReport("D:\\java\\.net\\projectfx\\src\\Reports\\sales.jrxml");
             jp = JasperFillManager.fillReport(jr,null,conn);
             SwingNode swingNode = new SwingNode();
             JRViewer jrv = new JRViewer(jp);
             swingNode.setContent(jrv);
             VBox vbox = new VBox();
             vbox.getChildren().add(swingNode);
             vbox.prefHeightProperty().bind(ap.heightProperty());
             vbox.prefWidthProperty().bind(ap.widthProperty());
             ap.getChildren().clear();
             ap.getChildren().add(vbox);
             pn2.setContent(ap);
             jrv.setOpaque(true);
             jrv.setVisible(true);
//                     this.add(jrv);
//        this.setSize(300, 300);
//        this.setVisible(true);
        } catch (Exception e) {
                System.out.println(e);
        }
    }
    
  

}
