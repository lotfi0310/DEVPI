/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.Utils.SessionManager;
import com.TunTripsPI.entities.User;
import com.gluonhq.charm.glisten.control.Icon;
import doryan.windowsnotificationapi.fr.Notification;
import entities.Transport;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Lotfi
 */
public class AcceuilController implements Initializable {

    @FXML
    private Button btnreclamations;
   
    @FXML
    private ImageView imgprofilacc;
    @FXML
    private TextField txtu;
    @FXML
    private Button btnVillesEtCulture;
    @FXML
    private Button transport;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgprofilacc.setImage(SessionManager.getphoto());
        
       
        btnreclamations.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                                    FXMLLoader Loader = new FXMLLoader(getClass().getResource("AjouterReclamation.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 AjouterReclamationController pc = Loader.getController();
                                                btnreclamations.getScene().setRoot(root);
                                               
                                               
                                                
                                            } catch (IOException ex) {
                                                Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
            }
        });
    }    

    

    @FXML
    private void ProfilUser(ActionEvent event) {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("ProfilUser.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 ProfilUserController pc = Loader.getController();
                                                btnreclamations.getScene().setRoot(root);
                                            } catch (IOException ex) {
                                                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
    }

    

   

    @FXML
    private void acceuil(ActionEvent event) {
    }

    @FXML
    private void listDesRegions(ActionEvent event) {
            UserCruds uc =new UserCruds();
        int r=uc.getRole(SessionManager.id);
        if(r==2||r==3){
         FXMLLoader Loader = new FXMLLoader(getClass().getResource("UserRegionList.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                           UserRegionListController pc = Loader.getController();
                                                btnreclamations.getScene().setRoot(root);
                                            } catch (IOException ex) {
                                                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            
    }
    }

    @FXML
    private void btnopenEvent(ActionEvent event) {
           UserCruds uc =new UserCruds(); 
              int r=uc.getRole(SessionManager.id);
              if(r==1||r==2){
                   FXMLLoader Loader = new FXMLLoader(getClass().getResource("TableEvenement.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 TableEvenementController pc = Loader.getController();
                                                btnreclamations.getScene().setRoot(root);
                                                
                                            } catch (IOException ex) {
                                                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            
              }
                /* if(r==2){
                     System.out.println(r);
                   FXMLLoader Loader = new FXMLLoader(getClass().getResource("TableEvenement.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                              AddEvenementController pc = Loader.getController();
                                                btnreclamations.getScene().setRoot(root);
                                            } catch (IOException ex) {
                                                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            
              }*/
                 if(r==3){
                   FXMLLoader Loader = new FXMLLoader(getClass().getResource("TableNomEvenement.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                           TableNomEvenementController pc = Loader.getController();
                                                btnreclamations.getScene().setRoot(root);
                                            } catch (IOException ex) {
                                                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            
         
    }
    }

    @FXML
   private void Taction(ActionEvent event) {
       FXMLLoader Loader = new FXMLLoader(getClass().getResource("menuTransport.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 MenuTransportController pc = Loader.getController();
                                                btnreclamations.getScene().setRoot(root);
                                                
                                            } catch (IOException ex) {
                                                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
      
    }

       
              
    
}
