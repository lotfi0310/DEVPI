/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.entities.User;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lotfi
 */



public class SignInController implements Initializable {
@FXML  
private TextField txtmail ;
@FXML  
private TextField txtpass ;
@FXML
private Button btnauthentif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btnauthentif.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try {
                   UserCruds uc =new UserCruds();
                   User u =new User();
                   u.setEmail("lotfilouiz@gmail.com");
                   u.setPasswd("lotfi123456");
                   ResultSet rs= uc.Authentification(u.getEmail(), u.getPasswd());
                   
                   if (rs.next()) {
                       if(rs.getBoolean("valide")) {
                           if(rs.getBoolean("etat")){
                               JOptionPane.showMessageDialog(null,"authentification avec succes");

                           }
                           else{
                 JOptionPane.showMessageDialog(null," votre compte est deactiver tu peux le reactiver on cliquant sur activer maintenant ");
 }
                       }
                       else{
             JOptionPane.showMessageDialog(null,"tu dois dabord valider votre email ... via code envoyer sur votre email");
  }
                       
                       
                   } else {
                 JOptionPane.showMessageDialog(null,"email ou passwd incorrect  ");

                   }  } catch (SQLException ex) {
                   Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
               }

        } 
    });
    }    
    
}
