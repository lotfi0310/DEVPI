/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.EvenementCrud;
import com.TunTripsPI.entities.Evenement;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.net.URL;
import static java.sql.JDBCType.INTEGER;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import static sun.net.www.http.HttpClient.New;
import static sun.net.www.http.HttpClient.New;
import static sun.net.www.http.HttpClient.New;
import static sun.net.www.http.HttpClient.New;

/**
 * FXML Controller class
 *
 * @author Nidhal
 */
public class AddEvenementController implements Initializable {

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
    @FXML
    private Button btnretourner;
    
   
  
 
 // myLabel.setText(myFormattedDate);
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ajouter(ActionEvent event) {
      
        try {
            //sauvgarde dans la base

            EvenementCrud ec = new EvenementCrud();
            
            LocalDate myDate = tfDateDebut.getValue();
            String d1 = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
             LocalDate myDate2 = tfDatefin.getValue();
             String d2 = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            
            
            String tNom = tfNom.getText();
        //   String tDate_debut = d1;
          // String tDate_fin = d2;
            String tLieu = tfLieu.getText();
            String tDescription = tfDescription.getText();
            String Status = tfStatus.getText();
   
            int tcapacite = Integer.parseInt(tfCapacite.getText());
            
            
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date parsed = format.parse(d1);
            java.sql.Date dd1 = new java.sql.Date(parsed.getTime());
            
            SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
            Date parsed2 = format2.parse(d2);
            java.sql.Date dd2 = new java.sql.Date(parsed.getTime());
            
            /*    e.setNom(tNom);
            e.setDate_debut((java.sql.Date) d1);
            e.setDate_fin((java.sql.Date) d2);
            e.setDescription(tDescription);
            e.setLieu(tLieu);
            e.setStatus(Status);
            e.setImage(tImage);
            e.setCapacite(tcapacite);*/
            Evenement e = new Evenement(tNom,dd1,dd2,tLieu,tDescription,Status,tcapacite);
            
            ec.ajouterEvenement(e);
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EvenementDetail.fxml"));
            try {
                Parent root =loader.load();
                EvenementDetailController edc =loader.getController();
                edc.setResnom(tfNom.getText());
            //    edc.setResdatedebut().date.parse(tfDateDebut.g);
            /*
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = e.getDate_debut();                 
		String dateToStr1 = dateFormat.format(date1);
               
		 DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd"); 
              Date date2 = e.getDate_fin();
             String dateToStr2 = dateFormat2.form
            .
            +at(date2);
            */
                edc.setResdatedebut(d1);
                edc.setResdatefin(d2);
                edc.setResdescription(e.getDescription());
       //        edc.setResimage(e.getImage());
                edc.setRescapacite(""+e.getCapacite());
                edc.setReslieu(e.getLieu());
                 edc.setResstatus(e.getStatus());
                 tfNom.getScene().setRoot(root);
                 } catch (IOException ex) {
                System.err.println("error"+ex.getMessage());
            }
                
                
                
                
                
                
                
                
//INTEGER.PARSEINT(tfCAPACITE.gettext())
//REDIRECTION VERS LA PAGE D AFFICHAGE
/*FXMLLoader loader =  New FXMLLoader(getClass().getResource("EvenementDetail.fxml"));
/**       FXMLLoader loader
* = new FXMLLoader(getClass().getResource("EvenementDetail.fxml"));
* Parent root = loader.load();
* EvenementDetailController dc = loader.getController();
* dc.setResnom(tfNom.getText());
* dc.setResdatedebut(tfDateDebut.getText());
* dc.setResdatefin(tfDatefin.getText());
* dc.setResdescription(tfDescription.getText());
* dc.setResimage(tfImage.getText());
* dc.setRescapacite(tfCapacite.getText());
* dc.setReslieu(tfLieu.getText());
* dc.setResstatus(tfStatus.getText());
tfNom.getScene().setRoot(root);
*
* } catch (IOException ex) {
* Logger.getLogger(AddEvenementController.class.getName()).log(Level.SEVERE, null, ex);
* }
            * }*/     
 } catch (ParseException ex) {
            Logger.getLogger(AddEvenementController.class.getName()).log(Level.SEVERE, null, ex);
        }


}

    @FXML
    private void retournertable(ActionEvent event) {
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TableEvenement.fxml"));
            try {
                Parent root =loader.load();
                
              
                 btnretourner.getScene().setRoot(root);
                 } catch (IOException ex) {
                System.err.println("error"+ex.getMessage());
            }
        
        
        
    }

    
}
