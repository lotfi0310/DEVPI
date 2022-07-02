/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.EvenementCrud;
import com.TunTripsPI.entities.Evenement;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
    private DatePicker tfDateDebut;
    @FXML
    private DatePicker tfDatefin;
    @FXML
    private Button btnModifier;
    @FXML
    private TextField txtid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     public void setData( int idd) {
        
       txtid.setText(""+idd);
     
      
   
        
        
     

    }

    @FXML
    private void modifier(ActionEvent event) throws ParseException, IOException {
       int ii = Integer.parseInt(txtid.getText());
     String nom = tfNom.getText();
        String lieu = tfLieu.getText();
        
          String description = tfDescription.getText();
             String statue = tfStatus.getText();
               
            LocalDate myDate = tfDateDebut.getValue();
            String d1 = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
             LocalDate myDate2 = tfDatefin.getValue();
             String d2 = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
              SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            java.util.Date parsed = format.parse(d1);
            java.sql.Date dd1 = new java.sql.Date(parsed.getTime());
            
            SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
            java.util.Date parsed2 = format2.parse(d2);
            java.sql.Date dd2 = new java.sql.Date(parsed.getTime());
            
        
        int capacite = Integer.parseInt(tfCapacite.getText());
        
         Evenement e = new Evenement(ii,nom,lieu,description,statue,capacite);
         //Evenement e = new Evenement(ii,nom,dd1,dd2,lieu,description,statue,capacite);
        EvenementCrud rc = new EvenementCrud();
        rc.modifierEvenemenet(e);

        //stage = (Stage) scenepane.getScene().getWindow();
        // stage.close();
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("TableEvenement.fxml"));
        try {

            Parent root = Loader.load();

            btnModifier.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        
        
    }
}
}
