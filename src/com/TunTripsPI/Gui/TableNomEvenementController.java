/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.EvenementCrud;
import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.entities.Evenement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Nidhal
 */
public class TableNomEvenementController implements Initializable {
Connection cnxx;
 
    @FXML
    private TableColumn<Evenement,String> nomevenement;
    @FXML
    private TextField txtidsimpleuser;
    @FXML
    private Button btnreserv;

    
    
    public  TableNomEvenementController (){
    
    cnxx = MyConnection.getInstance().getCnx();
    }
       @FXML
    private TableView tablenomevenement;
    /**
     * Initializes the controller class.
     */
        private ObservableList<Evenement> u = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
         EvenementCrud uc=new EvenementCrud();
         List<Evenement> listEvenement= new ArrayList<Evenement>();
         listEvenement=uc.consulterEvenement();
         u.clear();
         u.addAll(listEvenement);
          tablenomevenement.setItems(u);
        //id=35, nom=gala, date_debut=2021-12-02, date_fin=2021-12-02, lieu=kelibi, description=gala, Status=complet, image=qiq, capacite=8
      
        nomevenement.setCellValueFactory(
            new PropertyValueFactory<>("nom")
        );}
    
        @FXML
    private void showEventDetails(javafx.scene.input.MouseEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TypeEvenement.fxml"));
            EvenementCrud uc=new EvenementCrud();
            Evenement rc = (Evenement)tablenomevenement.getSelectionModel().getSelectedItem();
            EvenementCrud evenementCrud = new EvenementCrud();
            Evenement eventData = evenementCrud.recherche(rc.getNom()).get(0);
            Parent root1 = (Parent) loader.load();
            TypeEvenementController edc =loader.getController();
            edc.setDescription(eventData.getDescription());
            edc.setDatedebut(eventData.getDate_debut().toString());
            edc.setDatefin(eventData.getDate_fin().toString());
            edc.setLieu(eventData.getLieu());
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        }   

   
          @FXML
    private void reserver(MouseEvent event) {
         
   FXMLLoader loader = new FXMLLoader(getClass().getResource("AddReservatio.fxml"));
            try {
                Parent root =loader.load();
              
                 btnreserv.getScene().setRoot(root);
                 AddReservatioController ad=loader.getController();
                 ad.setiduuu(txtidsimpleuser.getText());
                 UserCruds uc=new UserCruds(); 
                 String em=uc.getemail(Integer.parseInt(txtidsimpleuser.getText()));
                 ad.settxtaddres(em);
                 } catch (IOException ex) {
                System.err.println("error"+ex.getMessage());
            }
    }

    void seidusers(String string) {
     txtidsimpleuser.setText(string);
    }

        
    }

    
   
    
     

       
  
          
