/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.ReclamationCrud;
import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.entities.Reclamation;
import com.TunTripsPI.entities.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lotfi
 */

public class GererUserAdminController implements Initializable {
@FXML 
private AnchorPane frame_Userrec; 
    @FXML
    private Tab panegestionusers;
    @FXML
    private TableView<User> tabviewusers;
    @FXML
    private TableColumn<User,Integer> idusercol;
    @FXML
    private TableColumn<User,String> nomusercol;
    @FXML
    private TableColumn<User, String> prenomcol;
    @FXML
    private TableColumn<User,String> emailcol;
    @FXML
    private TableColumn<User,String> passwdcol;
    @FXML
    private TableColumn<User, String> countrycol;
    @FXML
    private TableColumn<User,String> rolecol;
    @FXML
    private TableColumn<User,ImageView> photocol;
    @FXML
    private TableColumn<User,String> num_telcol;
    @FXML
    private TableColumn<User,String> validecol;
    @FXML
    private TableColumn<User, String> etatcol;
    @FXML
    private Tab panegestionreclamation;
    InputStream input ; 
    
     private ObservableList<User> u = FXCollections.observableArrayList();
          private ObservableList<Reclamation> rec = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Reclamation, Integer> idrec;
    @FXML
    private TableColumn<Reclamation, Integer> id;
    @FXML
    private TableColumn<Reclamation,Integer> idev;
    @FXML
    private TableColumn<Reclamation,Integer> idheb;
    @FXML
    private TableColumn<Reclamation, Integer> idtrans;
    @FXML
    private TableColumn<Reclamation,String> con;
    @FXML
    private TableColumn<Reclamation,Date> date;
    @FXML
    private TableColumn<Reclamation,Boolean> etattrait;
    @FXML
    private TableView<Reclamation> tabviewrec;

    /**
     * Initializes the controller class.
     */
    
           
   
   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
     

        
        UserCruds uc=new UserCruds();
         List<User> listUser= new ArrayList<User>();
         listUser=uc.consulterlisteuser();
     
         u.clear();
         u.addAll(listUser);
         
          tabviewusers.setItems(u);
        
        idusercol.setCellValueFactory(
            new PropertyValueFactory<>("id")
        );
        nomusercol.setCellValueFactory(
            new PropertyValueFactory<>("nom")
        );
        prenomcol.setCellValueFactory(
            new PropertyValueFactory<>("prenom")
        );
         emailcol.setCellValueFactory(
            new PropertyValueFactory<>("email")
        );
             passwdcol.setCellValueFactory(
            new PropertyValueFactory<>("passwd")
        );
               countrycol.setCellValueFactory(
            new PropertyValueFactory<>("country")
        );
                rolecol.setCellValueFactory(
            new PropertyValueFactory<>("role")
        );
                 photocol.setCellValueFactory(
            new PropertyValueFactory<>("photo")
        );
                  num_telcol.setCellValueFactory(
            new PropertyValueFactory<>("num_tel")
        );
                   validecol.setCellValueFactory(
            new PropertyValueFactory<>("valide")
        );
                    etatcol.setCellValueFactory(
            new PropertyValueFactory<>("etat")
        );
              
            
                    
                    
          tabviewusers.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
          User rec=(User) tabviewusers.getSelectionModel().getSelectedItem();
          JOptionPane j =new JOptionPane() ;
          j.showConfirmDialog(null,"Are you sure you want to delete this users");
       if(j !=null){
              uc.SupprimerUser(rec);
              resetTableUserData();
       }else{
           j.showMessageDialog(null, "liste user vide ");
       }
            }
        });
          
          
          
          
          
          
          //rec
          ReclamationCrud ur=new ReclamationCrud();
         List<Reclamation> listRec= new ArrayList<Reclamation>();
         listRec=ur.DisplayAllReclamation();
         rec.clear();
         rec.addAll(listRec);
          tabviewrec.setItems(rec);
        
        idrec.setCellValueFactory(
            new PropertyValueFactory<>("idreclamation")
        );
        id.setCellValueFactory(
            new PropertyValueFactory<>("iduser")
        );
        idev.setCellValueFactory(
            new PropertyValueFactory<>("idevent")
        );
         idheb.setCellValueFactory(
            new PropertyValueFactory<>("idheberg")
        );
             idtrans.setCellValueFactory(
            new PropertyValueFactory<>("idtransport")
        );
               con.setCellValueFactory(
            new PropertyValueFactory<>("contenu")
        );
                date.setCellValueFactory(
            new PropertyValueFactory<>("Date_rec")
        );
                 etattrait.setCellValueFactory(
            new PropertyValueFactory<>("etat")
        );
             
                 
    }
         //refresh user liste 
     public void resetTableUserData()
    {
        List<User> listUser = new ArrayList<>();
        UserCruds uc = new UserCruds();
        listUser = uc.consulterlisteuser();
        ObservableList<User> data = FXCollections.observableArrayList(listUser);
        tabviewusers.setItems(data);
    }
            
     
     
     
     
     
     
     
     //reclamation 
   
    }   
    
    

