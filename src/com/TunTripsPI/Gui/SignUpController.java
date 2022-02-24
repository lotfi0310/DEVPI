/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.entities.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lotfi
 */
public class SignUpController implements Initializable {
    @FXML
    private TextField usr_name; 
    @FXML
    private TextField usr_lastname;
    @FXML
    private TextField usr_email;
    @FXML
    private TextField usr_pass;
    @FXML
    private Button btnregistre;
    @FXML 
      private ChoiceBox usr_role; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnregistre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UserCruds uc=new UserCruds(); 
                User u =new User(); 
                u.setNom(usr_name.getText());
                u.setPrenom(usr_lastname.getText());
                u.setEmail(usr_email.getText());
                u.setPasswd(usr_pass.getText());
                uc.ajouterUser(u);
                
                
            }
        });
    }    
    
}
