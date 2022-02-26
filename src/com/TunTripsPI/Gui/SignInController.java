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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    private Hyperlink linkforgetpass;
    @FXML
    private Label labelalert;
    Boolean a;

    /**
     * Initializes the controller class.
     */
    private void showAlertWithHeaderText(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sign In");
        alert.setHeaderText("Results:");
        alert.setGraphic(labelalert);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        linkforgetpass.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                     Parent root=FXMLLoader.load(getClass().getResource("ForgetPassword.fxml"));
                     Stage s=new Stage();
            Scene scene = new Scene(root);
           
            s.initStyle(StageStyle.DECORATED);
            s.setTitle("Récuperer votre Compte TunTrips");
            s.setResizable(false);
            
            s.setTitle("Recuperer votre Compte ");
            s.setScene(scene);
            s.show();
                    
                } catch (IOException ex) {
                    Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
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
                                        showAlertWithHeaderText("authentification avec succes");
                                    } else {
                                       showAlertWithHeaderText("votre compte est deactiver tu peux le reactiver on cliquant sur activer maintenant ");

                                    }
                                } else {
                                    showAlertWithHeaderText("tu dois dabord valider votre email ... via code envoyer sur votre email ");
                                }

                            }else{
                                if (a){
                                showAlertWithHeaderText("Mot de Passe Invalide");
                                }
                            else{
                            showAlertWithHeaderText("Compte n'existe pas ");

                            }
                            } 
                        }catch (SQLException ex) {
                            showAlertWithHeaderText( "Mot de Passe ou email incorect ");                   
                        }
                }else {
                        showAlertWithHeaderText("email invalide");
                }
            }

            
                else{
             showAlertWithHeaderText("champ est null ");
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
