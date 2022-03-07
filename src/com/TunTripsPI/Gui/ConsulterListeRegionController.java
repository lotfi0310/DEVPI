/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.RegionCrud;
import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.entities.Region;
import com.TunTripsPI.entities.User;
import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class ConsulterListeRegionController implements Initializable {

  Connection cnxx;
    @FXML
    private TableColumn<Region, Integer> cl_id;
    @FXML
    private TableColumn<Region, String> cl_nom;
        @FXML
    private TableView <Region>region_table;
  
    @FXML
    private Button btnaj;
    @FXML
    private TableColumn<Region, String> cl_desc;
    @FXML
    private TableColumn<Region, String>  cl_action;
    
   
  public ConsulterListeRegionController(){
       cnxx = MyConnection.getInstance().getCnx();
  }
  


    
    
     
 private ObservableList<Region> r = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      //fetColumnList();
       //fetRowList();
    //Region r = new Region();
 
         RegionCrud rc =new RegionCrud();
         List<Region> listReg= new ArrayList<Region>();
         listReg=rc.consulterRegion();
       //  System.out.println(listReg);
         r.clear();
         r.addAll(listReg);
         region_table.setItems(r);
        
        cl_id.setCellValueFactory(
            new PropertyValueFactory<>("id")
        );
        cl_nom.setCellValueFactory(
            new PropertyValueFactory<>("nom")
        );
          cl_desc.setCellValueFactory(
            new PropertyValueFactory<>("description")
        );
          
        
        region_table.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                
                
           FXMLLoader Loader = new FXMLLoader(getClass().getResource("ModifierRegion.fxml"));
            try {         
            
                Parent root = Loader.load();
 
                btnaj.getScene().setRoot(root);  
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
              
                ModifierRegionController alertBoxController = Loader.getController();
                alertBoxController.setData( region_table.getSelectionModel().getSelectedItem().getNom(),region_table.getSelectionModel().getSelectedItem().getDescription(),region_table.getSelectionModel().getSelectedItem().getId());
                Parent p = Loader.getRoot();
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(new Scene(p));
                stage.show();
                
                
                
            }
                    
        });
        
        
    }


 
 

    @FXML
    private void ajouterreg(ActionEvent event) {
        
        
          FXMLLoader Loader = new FXMLLoader(getClass().getResource("AjouterUneRegion.fxml"));
            try {         
            
                Parent root = Loader.load();
 
                btnaj.getScene().setRoot(root);  
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        
    }
       
 
    
    
    
     
}


