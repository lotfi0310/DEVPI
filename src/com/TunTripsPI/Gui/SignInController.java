/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lotfi
 */
public class SignInController implements Initializable {

    @FXML
    private TextField txtmail;
    @FXML
    private TextField txtpass;
    @FXML
    private Button btnauthentif;
    @FXML
    private Hyperlink linksignup;
    @FXML
    private VBox vbox;
    @FXML
    private Parent fxml;
    Boolean a;

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
                if (!ChampVide(txtmail)) {
                    if (isEmailAdress(txtmail.getText())) {
                        try {
                            UserCruds uc = new UserCruds();
                            User u = new User();
                            String email = txtmail.getText();
                            u.setEmail(email);
                             String passwd =uc.hashagePWD(txtpass.getText());
                            ResultSet rs = uc.Authentification(email, passwd);
                            a=uc.ifuserExiste(txtmail.getText());
                            if(rs.next()) {
                                if (!rs.getBoolean("valide")) {
                                    if (rs.getBoolean("etat")) {
                                       JOptionPane.showMessageDialog(null,"authentification avec succes");
                                    } else {
                                       JOptionPane.showMessageDialog(null,"votre compte est deactiver tu peux le reactiver on cliquant sur activer maintenant ");

                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null,"tu dois dabord valider votre email ... via code envoyer sur votre email ");
                                }

                            }else{
                                if (a){
                                JOptionPane.showMessageDialog(null, "Mot de Passe Invalide");
                                }
                            else{
                             JOptionPane.showMessageDialog(null, "Compte n'existe pas ");

                            }
                            } 
                        }catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Mot de Passe ou email incorect ");                   
                        }
                }else {
                    JOptionPane.showMessageDialog(null, "email invalide");
                }
            }

            
                else{
             JOptionPane.showMessageDialog(null, "champ est null ");
            }
        }
    }

);
    }
    public static boolean ChampVide( TextField tf){
        boolean s=false; 
        if(tf.getText().toString().equals("")){ 
            s=true;
        }
        else{
        s=false;
        }
        return s;
    }
    public static boolean isEmailAdress(String email){
Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
Matcher m = p.matcher(email.toUpperCase());
return m.matches();
}
    
}
