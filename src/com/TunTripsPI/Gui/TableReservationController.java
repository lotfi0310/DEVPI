/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.EvenementCrud;
import com.TunTripsPI.Services.ReservCrud;
import com.TunTripsPI.Utils.MyConnection_1;
import com.TunTripsPI.entities.Evenement;
import com.TunTripsPI.entities.ReservEvenement;
import com.TunTripsPI.entities.Reservation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Nidhal
 */
public class TableReservationController implements Initializable {

    
     Connection cnxx;
     
   
   
    @FXML
    private TableColumn<Reservation, String> nom;
    
    @FXML
    private TableColumn<Reservation, String> email;
    @FXML
    private TableColumn<Reservation, String> nomevenement;
    @FXML
    private TableColumn<Reservation, Date> datedebut;
    @FXML
    private TableColumn<Reservation, Date> datefin;
    @FXML
    private TableColumn<Reservation, String> prenom;
    @FXML
    private Button btncalculerreservations;
    @FXML
    private TextField nbrereservations;
   
   
  
  public TableReservationController(){
      cnxx = MyConnection_1.getInstance().getCnx();
  }
    
    @FXML
    private TableView tablereservation;
    
    
     
  // private ObservableList<Evenement> e = FXCollections.observableArrayList();
    private ObservableList<Reservation> u = FXCollections.observableArrayList();
 
    /**
     * Initializes the controller class.
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    
           ReservCrud uc=new ReservCrud();
         List<Reservation> listReservation= new ArrayList<Reservation>();
         listReservation=uc.consulterReservation();
         u.clear();
         u.addAll(listReservation);
          tablereservation.setItems(u);
          
          
  
        //id=35, nom=gala, date_debut=2021-12-02, date_fin=2021-12-02, lieu=kelibi, description=gala, Status=complet, image=qiq, capacite=8
       nom.setCellValueFactory(
            new PropertyValueFactory<>("nomutilisateur")
               
        );
       
        
        prenom.setCellValueFactory(
            new PropertyValueFactory<>("prenomutilisateur")
        );
         email.setCellValueFactory(
            new PropertyValueFactory<>("emailutilisateur")
       );
      nomevenement.setCellValueFactory(
            new PropertyValueFactory<>("nom_evenement")
       );
      datedebut.setCellValueFactory(
            new PropertyValueFactory<>("date_debut_evenement")
       );
      
      datefin.setCellValueFactory(
            new PropertyValueFactory<>("date_fin_evenement")
       );
    
    
    
    
    }
   
          public void resetTableReservation()
    {
        List<Reservation> listreservation= new ArrayList<>();
        ReservCrud ec = new ReservCrud();
        listreservation = ec.consulterReservation();
        ObservableList<Reservation> data = FXCollections.observableArrayList(listreservation);
        tablereservation.setItems(data);
    }
      
        
    @FXML
    private void supprimer(javafx.scene.input.MouseEvent event) {
         ReservCrud uc=new ReservCrud();
         Reservation rec=(Reservation) tablereservation.getSelectionModel().getSelectedItem();
          JOptionPane j =new JOptionPane() ;
          j.showConfirmDialog(null,"Are you sure you want to delete this Resevation");
       if(j !=null){
             uc.supprimerReservation(rec);
             
           resetTableReservation();
       }else{
           j.showMessageDialog(null, "liste evenement vide ");
       }
    }

    @FXML
    private void calculerreservations(MouseEvent event) {
    
      ReservCrud ec = new ReservCrud();
        String s = ec.countRESEvenement();
    nbrereservations.setText(s);
        
    
    }

    } 
    
    
    
    
    
    
   

