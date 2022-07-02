/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Gui.ReservTransportController;
import entities.Transport;
import java.awt.Event;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JButton;
import com.TunTripsPI.Services.TransportCRUD;
import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.Utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Wassim
 */
public class ConsulteTransportController implements Initializable {

    @FXML
    private TableColumn<Transport, String> typeTb;
    @FXML
    private TableColumn<Transport, Integer> capaciteTb;
    @FXML
    private TableColumn<Transport, String> immTb;
    @FXML
    private TableColumn<Transport, String> lieuTb;
    @FXML
    private TableView<Transport> transportTb;
    ObservableList<Transport> obList = FXCollections.observableArrayList();
    
    @FXML
    private Button back;
    @FXML
    private ImageView pdfBtn;
    int idLoginUser=SessionManager.id;

   
    
    
    

    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection cnxx;

            cnxx = MyConnection.getInstance().getCnx();

            Statement st = cnxx.createStatement();
            String req = "SELECT idTransport,type,capacite,immatricule,lieuDispo,idUser FROM transport  WHERE `dispo`=1;";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Transport trsp = new Transport();
                trsp.setId(rs.getInt("idTransport"));
                trsp.setType(rs.getString("type"));

                trsp.setCapacite(rs.getInt("capacite"));
                trsp.setImmatricule(rs.getString("immatricule"));
                trsp.setLieuDispo(rs.getString("lieuDispo"));
                trsp.setIdUser(rs.getInt("idUser"));

                obList.add(trsp);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        typeTb.setCellValueFactory(new PropertyValueFactory<>("type"));
        capaciteTb.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        immTb.setCellValueFactory(new PropertyValueFactory<>("immatricule"));
        lieuTb.setCellValueFactory(new PropertyValueFactory<>("lieuDispo"));
transportTb.setItems(obList);


        // TODO
    }

    @FXML
    private void itemSelect(javafx.scene.input.MouseEvent event) {
       Transport rdv =transportTb.getSelectionModel().getSelectedItem();
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menuTransport.fxml"));

        
            
       if(idLoginUser==rdv.getIdUser()||idLoginUser==2/*admin idLogin*/)
       {Alert fail = new Alert(Alert.AlertType.CONFIRMATION);
            fail.setHeaderText("Ceci est votre offre! "
                    + "Vous voulez ");
            //fail.setContentText("Vous voulez réserver ce transport:  " + rdv.getType());
ButtonType buttonTypeOne = new ButtonType("Modifier");
ButtonType buttonTypeTwo = new ButtonType("Supprimer");
ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

fail.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

Optional<ButtonType> result = fail.showAndWait();
if (result.get() == buttonTypeOne){
    try {
            
                 Parent root = FXMLLoader.load(getClass().getResource("OffreTransportDetail.fxml"));
                 


            Scene scene = new Scene(root);
            Stage aStage=new Stage();
            aStage.setTitle("Modifier votre offre transport");
            aStage.setScene(scene);
            aStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
       
    // ... user chose "One"
} else if (result.get() == buttonTypeTwo) {
    Alert conf = new Alert(Alert.AlertType.CONFIRMATION);
            conf.setHeaderText("Voulez vous supprimer cette offre");
    Optional<ButtonType> result1 = conf.showAndWait();
if (result1.get() == ButtonType.OK){

    TransportCRUD t=new TransportCRUD();
    t.deleteTransport(rdv);
    Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setHeaderText("Cette offre a été supprimé avec succes");
            //fail.setContentText("Vous voulez réserver ce transport:  " + rdv.getType());
                  Optional<ButtonType> option = info.showAndWait();



}}}
             
                 
       
       else{Alert fail = new Alert(Alert.AlertType.CONFIRMATION);
            fail.setHeaderText("Vous voulez réserver ce transport:  " + rdv.getType());
            //fail.setContentText("Vous voulez réserver ce transport:  " + rdv.getType());
                  Optional<ButtonType> option = fail.showAndWait();

              if  (option.get() == ButtonType.OK) {
 try{
    
          int idTrsp   = rdv.getId();
                 FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("ReservTransport.fxml"));
                                                                            
        Parent root =  fxmlLoader1.load();
                 
                ReservTransportController otd =fxmlLoader.getController();
              otd.setIdTransport(idTrsp);
                otd.setIdLogin(idLoginUser);
                otd.setDepart(rdv.getLieuDispo());
               

Scene scene = new Scene(root);
            Stage aStage=new Stage();
            aStage.setTitle("Réservation transport");
            aStage.setScene(scene);
            aStage.show();            
       
     
    }catch(IOException ex){System.out.println(ex.getMessage());}
          }
              
                  
              
              
              }
     
    }

    @FXML
    private void backHome(ActionEvent event) {
    try{
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menuTransport.fxml"));
                                                                            
        Parent root =  fxmlLoader.load();
                 
              

             back.getScene().setRoot(root);}catch(IOException ex){System.out.println(ex.getMessage());}
    
    
    }
     

    @FXML
    private void imgAction(javafx.scene.input.MouseEvent event) {
     PrinterJob job = PrinterJob.createPrinterJob();
 if(job != null){
            
   job.printPage(transportTb);
   job.endJob();
 }}
}
