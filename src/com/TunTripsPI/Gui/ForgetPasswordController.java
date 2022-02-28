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
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lotfi
 */
public class ForgetPasswordController implements Initializable {

    @FXML
    private Button btncancel;
    @FXML
    private TextField txtenvoyercode;
    @FXML
    private TextField txtSmail;
    Parent fxml;
    @FXML
    private Pane paneforgetpass;
    @FXML
    private Button btnenvoyer;
    @FXML
    private Pane panecode;
    @FXML
    private AnchorPane anchorpaneRecpass;
    @FXML
    private Button btnenvoyercode;
    @FXML
    private TextField txtnewpass;
    @FXML
    private TextField txtnewpassconfirme;
    @FXML
    private Button btnconfirmenewpass;
    @FXML
    private Pane panenewpass;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void On_cancel(ActionEvent event) {
       
     
    }

    @FXML
    private void On_envoyer(ActionEvent event) {
        UserCruds uc = new UserCruds();

        Boolean b = uc.ifuserExiste(txtSmail.getText());
        if ((b) && (JavaMailUtil.sendmail(txtSmail.getText(), "votre code de recuperation mot de passe est : "))) {
            try {

                JavaMailUtil.sendmail(txtSmail.getText(), "votre code de recuperation mot de passe est : ");
                uc.AddCodeRecuperationCompte(JavaMailUtil.a, txtSmail.getText());
                panecode.setVisible(true);
                paneforgetpass.setVisible(false);
                User u = new User();
            } catch (Exception ex) {
                Logger.getLogger(ForgetPasswordController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "email doesn't exist");
        }
    }

    @FXML
    private void Envoyercode(ActionEvent event) {
        UserCruds uc = new UserCruds();
        if (uc.VerifcodeRecuperationCompte(txtSmail.getText().toString()).equals(txtenvoyercode.getText().toString())) {
            panecode.setVisible(false);
            panenewpass.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Code invalide");
        }

    }

    @FXML
    private void ConfirmerNewPass(ActionEvent event) {
UserCruds uc=new UserCruds();
        if ((txtnewpass.getText() != null) || (txtnewpassconfirme.getText() != null)) {

            if (txtnewpass.getText().equals(txtnewpassconfirme.getText())) {

                uc.UpdatePassword(uc.hashagePWD(txtnewpass.getText()), txtSmail.getText());
                JOptionPane.showMessageDialog(null, "Mot de passe Modifier avec succees");
            } else {
                JOptionPane.showMessageDialog(null, "Deux Champ differents.. verifier");
            }

        }
    
        else{
            JOptionPane.showMessageDialog(null, "Champs Vides");
    }

}
}

