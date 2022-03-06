/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Nidhal
 */
public class EvenementDetailController implements Initializable {

    @FXML
    private TextField resnom;
    @FXML
    private TextField resdatedebut;
    @FXML
    private TextField resdatefin;
    @FXML
    private TextField reslieu;
    @FXML
    private TextField resdescription;
    @FXML
    private TextField resstatus;
    @FXML
    private TextField rescapacite;
    @FXML
    private AnchorPane btnprece;
    @FXML
    private Button btnprecedent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public TextField getResnom() {
        return resnom;
    }

    public TextField getResdatedebut() {
        return resdatedebut;
    }

    public TextField getResdatefin() {
        return resdatefin;
    }

    public TextField getReslieu() {
        return reslieu;
    }

    public TextField getRescapacite() {
        return rescapacite;
    }

    public TextField getResdescription() {
        return resdescription;
    }

  

    public TextField getResstatus() {
        return resstatus;
    }

    public void setResnom(String  resnom) {
        this.resnom.setText(resnom);
    }

    public void setResdatedebut(String resdatedebut) {
        this.resdatedebut.setText(resdatedebut);
    }

    public void setResdatefin(String resdatefin) {
        this.resdatefin.setText(resdatefin);
    }

    public void setRescapacite(String rescapacite) {
        this.rescapacite.setText(rescapacite);
    }

    public void setResdescription(String resdescription) {
        this.resdescription.setText(resdescription);
    }

    public void setReslieu(String reslieu) {
        this.reslieu.setText(reslieu);
    }

   

    public void setResstatus(String resstatus) {
        this.resstatus.setText(resstatus);
    }

    @FXML
    private void retourner(ActionEvent event) {
        
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddEvenement.fxml"));
            try {
                Parent root =loader.load();
                
              
                 btnprecedent.getScene().setRoot(root);
                 } catch (IOException ex) {
                System.err.println("error"+ex.getMessage());
            }
    }
    
    
}
