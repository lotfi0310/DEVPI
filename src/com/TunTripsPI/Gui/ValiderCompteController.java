/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.Utils.JavaMailUtil;
import com.TunTripsPI.entities.User;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lotfi
 */
public class ValiderCompteController implements Initializable {

    @FXML
    private TextField txtvalidemail;
    @FXML
    private Hyperlink linknewcodemail;
    @FXML
    private TextField txtem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        linknewcodemail.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UserCruds uc=new UserCruds();
                JavaMailUtil.sendmail(txtem.getText(),"voici un nouveau code pour valider email"); 
                             uc.UpdateCodeValidationmail(JavaMailUtil.a,txtem.getText());

            }
        });
    }    

    @FXML
    private void validerEmail(ActionEvent event) {
        UserCruds uc=new UserCruds();
        
        String codem=uc.VerifmailValidation(txtem.getText().toString());
        if(codem.equals(txtvalidemail.getText())){
            uc.UpdatevaliditeCompte(txtem.getText());
            JOptionPane.showConfirmDialog(new JButton("S'authentifier"),"Votre compte maintenant activee");
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 HomePageController pc = Loader.getController();
                                                txtvalidemail.getScene().setRoot(root);
                                            } catch (IOException ex) {
                                                Logger.getLogger(ValiderCompte.class.getName()).log(Level.SEVERE, null, ex);
                                            }
            
        }
        else{
            System.out.println("error val mail");
        }
        
    }

    void setText(String string) {
        this.txtem.setText(string);
    }

    

    
    
}
//