/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.ReclamationCrud;
import com.TunTripsPI.entities.Reclamation;
import com.TunTripsPI.entities.User;
import com.sun.org.glassfish.gmbal.ParameterNames;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lotfi
 */
public class AjouterReclamationController implements Initializable {
       Parent listev ; 

    @FXML
    private Pane lblafficheEvent;
    @FXML
    private TextArea txtrec;
    @FXML
    private TextField txttrec;
    @FXML
    private TextField txtUserId;
    
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      

    }    
 

    @FXML
    private void envoyerrec(ActionEvent event) {
        ReclamationCrud rc=new ReclamationCrud();
        Reclamation r=new Reclamation();
         Date d =new Date(Date.parse("2022/18/15"));
        r.setDate_rec(d);
        r.setContenu(txtrec.getText());
        r.setEtat(false);
        r.setIdevent(Integer.parseInt(txttrec.getText()));
        User u=new User();
        u.setId(Integer.parseInt(txtUserId.getText()));
        rc.ajouterReclamationEvent(r,u);
        JOptionPane.showMessageDialog(null,"REVLAMATION ENVOYEE AVEC SUCCEES");
          FXMLLoader Loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 AcceuilController pc = Loader.getController();
                                                lblafficheEvent.getScene().setRoot(root);
                                                pc.setTxtUserID(txtUserId.getText());
                                            } catch (IOException ex) {
                                                Logger.getLogger(TableEvenementController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
          
    }
    
    
     public void setTxtIDEvent( String message) {
        this.txttrec.setText(message);
    }
     public void setTxtUserID( String message) {
        this.txtUserId.setText(message);
    }

    @FXML
    private void SelectRec(ActionEvent event) {
          FXMLLoader Loader = new FXMLLoader(getClass().getResource("TableEvenement.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 TableEvenementController pc = Loader.getController();
                                                lblafficheEvent.getScene().setRoot(root);
                                                pc.setTxtUserID(txtUserId.getText());
                                            } catch (IOException ex) {
                                                Logger.getLogger(TableEvenementController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
        
    }

    String getTxtIDEvent() {
        return txtUserId.getText();
    }
}
