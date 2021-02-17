package org.utl.hospital.gui;
import javafx.scene.Parent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    Parent root;
    

    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/gui/fxml/main_window.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }        
    
}
