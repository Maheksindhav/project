package projectfx;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Projectfx extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jtb", "root", "");
            PreparedStatement pst = conn.prepareStatement("select islogin from user");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getBoolean("islogin") == false) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("design.css").toExternalForm());
                    primaryStage.setScene(scene);
                    primaryStage.show();
                } else if (rs.getBoolean("islogin") == true) {
                    Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                    Scene scene = new Scene(root);
                    scene.getStylesheets().add(getClass().getResource("dashboard_design.css").toExternalForm());
                    primaryStage.setScene(scene);
                    primaryStage.setMaximized(true);
                    primaryStage.show();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
