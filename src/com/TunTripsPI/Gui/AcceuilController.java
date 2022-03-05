/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.entities.User;
import doryan.windowsnotificationapi.fr.Notification;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Lotfi
 */
public class AcceuilController implements Initializable {

    @FXML
    private Button btnreclamations;
    @FXML
    private TextField txtu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        btnreclamations.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                                    FXMLLoader Loader = new FXMLLoader(getClass().getResource("AjouterReclamation.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 AjouterReclamationController pc = Loader.getController();
                                                btnreclamations.getScene().setRoot(root);
                                               
                                                pc.setTxtUserID(""+txtu.getText().toString());
                                                
                                            } catch (IOException ex) {
                                                Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
            }
        });
    }    

    void setTxtUserID(String string) {
        this.txtu.setText(string);
    }

    @FXML
    private void ProfilUser(ActionEvent event) {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("ProfilUser.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 ProfilUserController pc = Loader.getController();
                                                btnreclamations.getScene().setRoot(root);
                                              pc.setData(Integer.parseInt(txtu.getText().toString()));
                                              pc.setuid(txtu.getText());
                                            } catch (IOException ex) {
                                                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
    }
    
    
    
}