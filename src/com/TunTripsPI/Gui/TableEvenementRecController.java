/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.EvenementCrud;
import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.entities.Evenement;
import com.mysql.jdbc.MySQLConnection;
import com.oracle.webservices.internal.api.message.PropertySet;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Nidhal
 */
public class TableEvenementRecController implements Initializable {

    
     Connection cnxx;
    @FXML
    private TableColumn<Evenement, Integer> id;
    @FXML
    private TableColumn<Evenement, String> nomevenement;
    @FXML
    private TableColumn<Evenement,Date> datedebut;
    @FXML
    private TableColumn<Evenement,Date> datefin;
    @FXML
    private TableColumn<Evenement, String> lieu;
    @FXML
    private TableColumn<Evenement, String> descriotion;
    @FXML
    private TableColumn<Evenement, String> status;
    @FXML
    private TableColumn<Evenement, Integer> capacite;
    
     private ObservableList<Evenement> u = FXCollections.observableArrayList();
    @FXML
    private Button reservbtn;
    @FXML
    private AnchorPane listeev;
    @FXML
    private TextField txtidus;
    @FXML
    private TextField txtiddev;
  public TableEvenementRecController(){
       cnxx = MyConnection.getInstance().getCnx();
  }
    
    @FXML
    private TableView tableevenement;
  
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
       
           
           EvenementCrud uc=new EvenementCrud();
         List<Evenement> listEvenement= new ArrayList<Evenement>();
         listEvenement=uc.consulterEvenement();
         u.clear();
         u.addAll(listEvenement);
          tableevenement.setItems(u);
        //id=35, nom=gala, date_debut=2021-12-02, date_fin=2021-12-02, lieu=kelibi, description=gala, Status=complet, image=qiq, capacite=8
        id.setCellValueFactory(
            new PropertyValueFactory<>("id")
        );
        nomevenement.setCellValueFactory(
            new PropertyValueFactory<>("nom")
        );
        datedebut.setCellValueFactory(
            new PropertyValueFactory<>("date_debut")
        );
         datefin.setCellValueFactory(
            new PropertyValueFactory<>("date_fin")
        );
           lieu.setCellValueFactory(
            new PropertyValueFactory<>("lieu")
        );
             descriotion.setCellValueFactory(
            new PropertyValueFactory<>("description")
        );
               status.setCellValueFactory(
            new PropertyValueFactory<>("Status")
        );
             
                 capacite.setCellValueFactory(
            new PropertyValueFactory<>("capacite")
        );
                 
                 
           
        
    }   
    
      public void resetTableEvenement()
    {
        List<Evenement> listevenement= new ArrayList<>();
        EvenementCrud ec = new EvenementCrud();
        listevenement = ec.consulterEvenement();
        ObservableList<Evenement> data = FXCollections.observableArrayList(listevenement);
        tableevenement.setItems(data);
    }

    private void supprimer(javafx.scene.input.MouseEvent event) {
         EvenementCrud uc=new EvenementCrud();
         Evenement rec=(Evenement) tableevenement.getSelectionModel().getSelectedItem();
          
          JOptionPane j =new JOptionPane() ;
          j.showConfirmDialog(null,"Are you sure you want to delete this evenement");
       if(j !=null){
             uc.supprimerEvenement(rec);
              resetTableEvenement();
       }else{
           j.showMessageDialog(null, "liste evenement vide ");
       }
    }

   
    @FXML
    private void reservereve(ActionEvent event) {
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AddReservatio.fxml"));
            try {
                Parent root =loader.load();
                
              
                 reservbtn.getScene().setRoot(root);
                 } catch (IOException ex) {
                System.err.println("error"+ex.getMessage());
            }
    }

    @FXML
    private void reserver(javafx.scene.input.MouseEvent event) {
    }

    @FXML
    private void SelectEventRec(javafx.scene.input.MouseEvent event) {
        
            Evenement rec=(Evenement) tableevenement.getSelectionModel().getSelectedItem();
           
             FXMLLoader Loader = new FXMLLoader(getClass().getResource("AjouterReclamation.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                
                                                 AjouterReclamationController pc = Loader.getController();
                                                reservbtn.getScene().setRoot(root);
                                                pc.setTxtIDEvent(""+rec.getId());
                                                pc.setTxtUserID(txtidus.getText());
                                            } catch (IOException ex) {
                                                Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
            
            
    }
     public void setTxtUserID( String message) {
        this.txtidus.setText(message);
    }
      
    
}
    
    
    
    