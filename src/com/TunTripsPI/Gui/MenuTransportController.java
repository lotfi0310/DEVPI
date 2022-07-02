/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import entities.Transport;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import com.TunTripsPI.Utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author Wassim
 */
public class MenuTransportController implements Initializable {

    @FXML
    private Button ajoutBtn;
    private Button updateBtn;
    @FXML
    private Button listeBtn;
int idUser1;
    @FXML
    private Button goTabBtn;
    private TextField idUser;

    public void setIdUser(String a) {
        this.idUser.setText(a); 
    }

    public String getIdUser() {
        return idUser.getText();
    }
   
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutAction(ActionEvent event) {
         try{
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ajouterOffreTransport.fxml"));
                                                                            
        Parent root =  fxmlLoader.load();
                 
              /*otd.setTypeVc(trsp.getType());
                otd.setCapacite(trsp.getCapacite);
                otd.setImmatricule(trsp.getImmatricule); 
                otd.setLieuDispo(trsp.getLieuDispo);
                otd.setNumContact(trsp.getNumContact);*/
              //  otd.setDispo(trsp.getDispo);

             ajoutBtn.getScene().setRoot(root);}
         catch(IOException ex){System.out.println(ex.getMessage());}
        
    }

    private void updateAction(ActionEvent event) {
       try{
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OffreTransportDetail.fxml"));
                                                                            
        Parent root =  fxmlLoader.load();
                 
        
        
        
       
        
             
             updateBtn.getScene().setRoot(root);}catch(IOException ex){System.out.println(ex.getMessage());}
    }

    private void deleteAction(ActionEvent event) throws MalformedURLException {
    Stage stage=new Stage();   // create web engine and view
        final WebView webView = new WebView();
;
                final WebEngine webEngine;
        webEngine = webView.getEngine();
                       File file = new File("C:\\Users\\RANIM\\Desktop\\Places\\test.html");
URL url= file.toURI().toURL();
//  webEngine.loadContent("<iframe width=\"425\" height=\"350\" frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" src=\"https://www.openstreetmap.org/export/embed.html?bbox=-8.195800781250002%2C28.69058765425071%2C16.325683593750004%2C38.92522904714054&amp;layer=mapnik\" style=\"border: 1px solid black\"></iframe><br/><small><a href=\"https://www.openstreetmap.org/#map=6/33.962/4.065\">Afficher une carte plus grande</a></small>");
webEngine.load(url.toString());


        // create scene
         VBox root = new VBox();
        // Add the WebView to the VBox
        root.getChildren().add(webView);
 
        // Set the Style-properties of the VBox
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" );
 
        // Create the Scene
        Scene scene = new Scene(root);
        // Add  the Scene to the Stage
        stage.setScene(scene);
        // Display the Stage
        stage.show();
    }
    

    @FXML
    private void consulteAction(ActionEvent event) {
        try{
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("consulteTransport.fxml"));
                                                                            
        Parent root =  fxmlLoader.load();
                 
             

             listeBtn.getScene().setRoot(root);}catch(IOException ex){System.out.println(ex.getMessage());}
    }

    @FXML
    private void goTab(ActionEvent event) { try{
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("monReservation.fxml"));
                                                                            
        Parent root =  fxmlLoader.load();
                 
             

             listeBtn.getScene().setRoot(root);}catch(IOException ex){System.out.println(ex.getMessage());}
    }
    
}
