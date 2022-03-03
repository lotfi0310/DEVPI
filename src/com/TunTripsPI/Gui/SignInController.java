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
import javafx.scene.text.Font;
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
    int id;
    String nom; 
    String prenom; 
    String num; 
    String country;
    String role;
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
    @FXML
    Parent home;

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
                      FXMLLoader Loader = new FXMLLoader(getClass().getResource("ForgetPassword.fxml"));
            Parent root = Loader.load();
            ForgetPasswordController Hc = Loader.getController();
            btnauthentif.getScene().setRoot(root);
            
                   

                } catch (IOException ex) {
                    Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        btnauthentif.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (!txtmail.getText().isEmpty()) {
                    if (isEmailAdress(txtmail.getText())) {
                        try {
                            UserCruds uc = new UserCruds();
                            User u = new User();
                            String email = txtmail.getText();
                            String password=uc.hashagePWD(txtpass.getText());
                            u.setEmail(email);
                           
                            String p =txtpass.getText();
                            ResultSet rs = uc.Authentification(email,password);
                            a = uc.ifuserExiste(txtmail.getText());
                            if(rs.next()) {
                                id=rs.getInt("id");
                                  nom =rs.getString("nom");
                                  prenom =rs.getString("prenom");
                                  country= rs.getString("country");
                                  p=password;
                                 role=rs.getString("role");
                                 num=rs.getString("num_tel");
                                
                               
                                if (!rs.getBoolean("valide")) {

                                    if (rs.getBoolean("etat")) {
                                
                                        String Typeauth = uc.Typeauthentification(rs);
                                        Stage primaryStage = new Stage();
                                        if (Typeauth.equals("Simple User")||Typeauth.equals("Fournisseur")){
                                            
                                          FXMLLoader Loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 AcceuilController pc = Loader.getController();
                                                btnauthentif.getScene().setRoot(root);
                                                pc.setTxtUserID(""+id);
                                            } catch (IOException ex) {
                                                Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);}
                                          /* FXMLLoader Loader = new FXMLLoader(getClass().getResource("AjouterReclamation.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 AjouterReclamationController pc = Loader.getController();
                                                btnauthentif.getScene().setRoot(root);
                                                pc.setTxtUserID(""+id);
                                            } catch (IOException ex) {
                                                Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                               
                                          /*  FXMLLoader Loader = new FXMLLoader(getClass().getResource("ProfilUser.fxml"));
                                            try {

                                                Parent root = Loader.load();
                                                ProfilUserController pc = Loader.getController();
                                                txtmail.getScene().setRoot(root);
                                                pc.setTxtmodifnumtel(num);
                                                pc.setTxtmodifrole(role);
                                                pc.setTxtModifPrenom(prenom);
                                                pc.setTxtModifNom(nom);
                                                pc.setTxtmodifpass(p);
                                                pc.setTxtmodifemail(email);
                                            } catch (IOException ex) {
                                                System.out.println("Error: " + ex.getMessage());
                                            }*/

                                        } else {
                                               FXMLLoader Loader = new FXMLLoader(getClass().getResource("GererUserAdmin.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 GererUserAdminController pc = Loader.getController();
                                                btnauthentif.getScene().setRoot(root);
                                            } catch (IOException ex) {
                                                Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);}
                                            
                                        }

                                    } else {
                                        showAlertWithHeaderText("votre compte est deactiver tu peux le reactiver on cliquant sur activer maintenant ");

                                    }
                                } else {
                                    showAlertWithHeaderText("tu dois dabord valider votre email ... via code envoyer sur votre email ");
                                }

                            } else if (a) {
                                showAlertWithHeaderText("Mot de Passe Invalide");
                            } else {
                                showAlertWithHeaderText("Compte n'existe pas ");

                            }
                        } catch (SQLException ex) {
                            showAlertWithHeaderText("Mot de Passe ou email incorect ");
                        }
                    } else {
                        showAlertWithHeaderText("email invalide");
                    }
                } else {
                    txtmail.setText("Remplir le champ mail ");
                    txtmail.setFont(Font.font(20));

                }
            }
        }
        );
    }

    public static boolean isEmailAdress(String email) {
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
        Matcher m = p.matcher(email.toUpperCase());
        return m.matches();
    }

}
