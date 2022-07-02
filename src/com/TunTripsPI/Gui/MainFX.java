/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
  // utilise API 3 au minimum ** Maps:GeoCoding..MapBox..OpenStreetMap***Payement:STRIPE

/**
 *
 * @author Wassim
 */
public class MainFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        try {
            
                 Parent root = FXMLLoader.load(getClass().getResource("menuTransport.fxml"));
                 


            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Menu transport");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        
    }
    
}
/*public void start(Stage stage) {
        // create web engine and view
        final WebEngine webEngine = new WebEngine(getClass().getResource("googlemap.html").toString());
        final WebView webView = new WebView(webEngine);
        // create scene
        stage.setTitle("Web Map");
        Scene scene = new Scene(webView,1000,700, Color.web("#666970"));
        stage.setScene(scene);
        // show stage
        stage.setVisible(true);
    }*/