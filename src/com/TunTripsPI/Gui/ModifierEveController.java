/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nidhal
 */
public class ModifierEveController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfLieu;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfStatus;
    @FXML
    private TextField tfCapacite;
    @FXML
    private Button btnAjouter;
    @FXML
    private DatePicker tfDateDebut;
    @FXML
    private DatePicker tfDatefin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setData( String nom, Date date_debut,Date date_fin,String lieu,String status,int capacite,String description) {
        
       // tfNomRegion.setText(""+id);
        //tfsetText(nom);nom
        tfNom.setText(nom);
        tfLieu.setText(lieu);
        tfDescription.setText(description);
        tfStatus.setText(status);
        tfCapacite.setText(""+capacite);
        
        
        
    //
 //   tfDateDebut.setValue(LocalDate.g);
        
        
        
     

    }

    @FXML
    private void ajouter(ActionEvent event) {
    }
}
