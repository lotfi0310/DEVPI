/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.EvenementCrud;
import com.TunTripsPI.Services.MailerService;
import com.TunTripsPI.Services.ReservCrud;

import com.TunTripsPI.entities.Evenement;
import com.TunTripsPI.entities.ReservEvenement;
import com.TunTripsPI.entities.User;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.JavaMethod;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation.Status;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nidhal
 */
public class AddReservatioController implements Initializable {

    @FXML
    private TextField tfidu;
    private TextField tfide;
    @FXML
    private DatePicker tfres;
    @FXML
    private Button btnValider;
    @FXML
    private ListView<String> idlist;
    @FXML
    private Button btnPrecedent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EvenementCrud event = new EvenementCrud();
        ObservableList<String> events = FXCollections.observableArrayList();
        event.consulterEvenement().forEach((v) -> {
         //  if (v.getCapacite()>0){
          if (v.getStatus()!="completo"){
                 events.add(v.getNom());
            }
        });

        idlist.setItems(events);
        // TODO
    }

    private int searchEventId(ArrayList<Evenement> list, String eventName) {
        for (Evenement event : list) {
            if (event.getNom().equals(eventName)) {
                return event.getId();
            }
        }
        return 0;
    }

    @FXML
    private void saveReservation(ActionEvent event) {
        EvenementCrud events = new EvenementCrud();

        try {
            //*
            int id_evenement = searchEventId(events.consulterEvenement(), idlist.getSelectionModel().getSelectedItem());
            String email = tfidu.getText();
            ReservCrud rc = new ReservCrud();
            LocalDate myDate = tfres.getValue();
           
            String d1 = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date parsed = format.parse(d1);
            java.sql.Date dd1 = new java.sql.Date(parsed.getTime());
            ReservEvenement re = new ReservEvenement(dd1, id_evenement, 9);
            Evenement e = new Evenement(id_evenement);
            ReservCrud ee = new ReservCrud();
            if (ee.ajouterReservation(re, e)){
            MailerService ms = new MailerService();
             ms.replyMail("ms","aaa","this is a description");
                System.out.println("------");
            }
           
       //     User u = new User();
         //   u.setEmail("nidhal.sassi@esprit.tn");
   //         JavaMail.sendmail(u.getEmail());

        } catch (ParseException ex) {
            Logger.getLogger(AddReservatioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void retourner(ActionEvent event) {
        
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("TableNomEvenement.fxml"));
            try {
                Parent root =loader.load();
                
              
                 btnPrecedent.getScene().setRoot(root);
                 } catch (IOException ex) {
                System.err.println("error"+ex.getMessage());
            }
    }

}
