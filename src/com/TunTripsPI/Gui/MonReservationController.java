/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import entities.ReservTransport;
import entities.Transport;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import com.TunTripsPI.Services.TransportCRUD;
import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.Utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Wassim
 */
public class MonReservationController implements Initializable {

    
    @FXML
    private TableView<ReservTransport> transportTb;
    @FXML
    private TableColumn<ReservTransport, String> departTb;
    @FXML
    private TableColumn<ReservTransport, String> destTb;
    @FXML
    private TableColumn<ReservTransport, Double> prixTb;
        ObservableList<ReservTransport> obList = FXCollections.observableArrayList();
    @FXML
    private Button retour;
    int idLoginUser=SessionManager.id;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection cnxx;

            cnxx = MyConnection.getInstance().getCnx();

            PreparedStatement st ;
            String req = "SELECT idUser,idTransport,depart,destination,distance,prix FROM revTransport "
                    + "WHERE `idUser`="+idLoginUser+";";
                        st = cnxx.prepareStatement(req);
                            
          //  st.setInt(1,idLoginUser);
                                        

            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                ReservTransport trsp = new ReservTransport();

                trsp.setIdUser(rs.getInt("idUser"));
                trsp.setIdTransport(rs.getInt("idTransport"));

                trsp.setDepart(rs.getString("depart"));
                trsp.setDestination(rs.getString("destination"));
                 trsp.setPrix(rs.getDouble("prix"));

                obList.add(trsp);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        departTb.setCellValueFactory(new PropertyValueFactory<>("depart"));
        destTb.setCellValueFactory(new PropertyValueFactory<>("destination"));
        prixTb.setCellValueFactory(new PropertyValueFactory<>("prix"));
transportTb.setItems(obList);


        // TODO
    }

    @FXML
    private void backHome(ActionEvent event) {
        
            
                  try{
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menuTransport.fxml"));
                                                                            
        Parent root =  fxmlLoader.load();
                 
              

            retour.getScene().setRoot(root);}catch(IOException ex){System.out.println(ex.getMessage());}
    
    }

    

}