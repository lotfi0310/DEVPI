/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Lotfi
 */
public class ValiderCompte extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
          try {
            Parent loader=new FXMLLoader().load(getClass().getResource("ValiderCompte.fxml"));
            
            Scene scene = new Scene(loader);
            
            primaryStage.setTitle("Valider Email TunTrips");
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProfilUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void stop() throws Exception {
        super.stop(); 
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
