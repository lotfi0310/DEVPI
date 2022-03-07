/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Nidhal
 */
public class TypeEvenementController implements Initializable {
    
    @FXML
    private TextField description;
    @FXML
    private TextField datedebut;
    @FXML
    private TextField datefin;
    @FXML
    private TextField Lieu;
    @FXML
    private Button btnprecedent;
    @FXML
    private Button btnreserve;
    @FXML
    private TextField iduserdetailev;
    
        /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
    }
    

    public TextField getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public TextField getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {
         this.datedebut.setText(datedebut);
    }

    public TextField getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin.setText(datefin);
    }

    public TextField getLieu() {
        return Lieu;
    }

    public void setLieu(String lieu) {
        this.Lieu.setText(lieu);
    }
    

    public Button getBtnprecedent() {
        return btnprecedent;
    }

    public void setBtnprecedent(Button btnprecedent) {
        this.btnprecedent = btnprecedent;
    }

    @FXML
    private void reserver(MouseEvent event) {
         
   FXMLLoader loader = new FXMLLoader(getClass().getResource("AddReservatio.fxml"));
            try {
                Parent root =loader.load();
                 btnreserve.getScene().setRoot(root);
                 AddReservatioController arc=loader.getController();
                 arc.setiduuu(iduserdetailev.getText());
                 } catch (IOException ex) {
                System.err.println("error"+ex.getMessage());
            }
    }

    void settypeSimpleuserr(String string) {
    iduserdetailev.setText(string);
    }


    
}
