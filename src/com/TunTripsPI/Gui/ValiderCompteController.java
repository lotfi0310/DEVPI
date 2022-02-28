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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void validerEmail(ActionEvent event) {
        UserCruds uc=new UserCruds();
        
        String codem=uc.VerifmailValidation(SignUpController.e);
        if(codem.equals(txtvalidemail.getText())){
            uc.UpdatevaliditeCompte(txtvalidemail.getText());
            JOptionPane.showConfirmDialog(new JButton("S'authentifier"),"Votre compte maintenant activee");
            
        }
        else{
            System.out.println("error val mail");
        }
        
    }

   

    
    
}
//