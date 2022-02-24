/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import javax.imageio.ImageIO;
import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.entities.User;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

private void showAlertWithHeaderText(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sign In");
        alert.setHeaderText("Results:");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       btnauthentif.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               try {
                   UserCruds uc =new UserCruds();
                   User u =new User();
                   u.setEmail(txtmail.getText());
                   u.setPasswd(txtpass.getText());
                   ResultSet rs= uc.Authentification(u.getEmail(), u.getPasswd());
                   
                   if (rs.next()) {
                       if(!rs.getBoolean("valide")) {
                           if(rs.getBoolean("etat")){
                showAlertWithHeaderText("Vous etes authentifier");

                           }
                           else{
                  showAlertWithHeaderText(" votre compte est deactiver tu peux le reactiver on cliquant sur activer maintenant ");
 }
                       }
                       else{
              showAlertWithHeaderText("tu dois dabord valider votre email ... via code envoyer sur votre email");
  }
                       
                       
                   } else {
                showAlertWithHeaderText("email ou mot de pass non valide ");

                   }  } catch (SQLException ex) {
                   Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
               }

        } 
    });
    }    
    
    
    
    public static boolean isEmailAdress(String email){
Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
Matcher m = p.matcher(email.toUpperCase());
return m.matches();
}

}
