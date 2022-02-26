/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.entities.User;
import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
      private ChoiceBox<String> usr_role; 
      private String [] role ={"Simple User","Fournisseur"}; 
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usr_role.getItems().addAll(role);
        btnregistre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane valideremail=new JOptionPane();
               
                UserCruds uc=new UserCruds(); 
                User u =new User(); 
                u.setNom(usr_name.getText());
                u.setPrenom(usr_lastname.getText());
                u.setEmail(usr_email.getText());
                u.setPasswd(usr_pass.getText());
                u.setRole(usr_role.getValue());
                if(uc.ifuserExiste(u.getEmail())){
                     valideremail.showMessageDialog(null," Bienvenu "+u.getNom()+" Email existe deja , essayer de s'authentifier ");
                }
                else {
                    valideremail.setLocation(100, 100);
                     uc.ajouterUser(u);
                }
                
                
                
            }
        });
    }    
    
}
