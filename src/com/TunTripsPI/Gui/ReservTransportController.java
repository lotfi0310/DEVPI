/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import entities.ReservTransport;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import com.TunTripsPI.Services.ReservTransportCRUD;
import com.TunTripsPI.Services.TransportCRUD;
import com.TunTripsPI.Utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Wassim
 */
public class ReservTransportController implements Initializable {

    @FXML
    private TextField depart;
    @FXML
    private TextField destination;
    @FXML
    private TextField distance;
    @FXML
    private Button submit;
    @FXML
    private TextField prix;
    @FXML
    private Label numContact3;
    @FXML
    private Button backBtn;
    @FXML
    private ImageView mapsBtn;
    @FXML
    private TextField idTransport;
    @FXML
    private TextField idLogin;

    public void setIdTransport(int a) {
        this.idTransport.setText(String.valueOf(a));
    }

    public void setIdLogin(int a) {
        this.idLogin.setText(String.valueOf(a));
    }
    
    

    public void setDepart(String a) {
        this.depart.setText(a);
    }

    public void setDestination(String a) {
        this.destination.setText(a);
    }

    public void setDistance(TextField distance) {
        this.distance = distance;
    }

    public void setBackBtn(Button backBtn) {
        this.backBtn = backBtn;
    }

    public void setPrix(Double a) {
        this.prix.setText(String.valueOf(a)); 
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public Boolean validation(TextField a) {

        if ((a.getText() == null) || (a.getText().trim().isEmpty())) {

            Alert fail = new Alert(Alert.AlertType.INFORMATION);
            fail.setHeaderText("Echec");
            fail.setContentText("Indiquer votre position et votre destination via button 'Maps' ");
            fail.showAndWait();
            return false;

        } else {
            return true;
        }

    }
         
    @FXML
    private void saveOffre(ActionEvent event)throws IOException {
         ReservTransport resv = new ReservTransport();
        while (validation(depart)
                && validation(destination)
                && validation(distance)&& validation(prix))

                {
resv.setIdTransport(Integer.parseInt(idTransport.getText()));
resv.setIdUser(Integer.parseInt(idLogin.getText())); 
            resv.setDepart(depart.getText());
            resv.setDestination(destination.getText());
            resv.setDistance(Double.parseDouble(distance.getText()));
                        resv.setPrix(Double.parseDouble(prix.getText()));
resv.setIdUser(SessionManager.id);

            ReservTransportCRUD t = new ReservTransportCRUD();
//t.ajouterReservTransport();
t.ajouterReservTransport2(resv);
Alert fail = new Alert(Alert.AlertType.INFORMATION);
            fail.setHeaderText("Succes");
            fail.setContentText("Votre reservation a été completer avec succes");
            fail.showAndWait();
           break;
       
            
        }

    }
    

    @FXML
    private void backHome(ActionEvent event) {
         try{
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menuTransport.fxml"));
                                                                            
        Parent root =  fxmlLoader.load();
                 
              

             backBtn.getScene().setRoot(root);}catch(IOException ex){System.out.println(ex.getMessage());}
    
    }

    @FXML
    private void openMaps(MouseEvent event) {
    Stage stage=new Stage();   // create web engine and view
        final WebView webView = new WebView();
;
                final WebEngine webEngine;
        webEngine = webView.getEngine();
                   //    File file = new File("C:\\Users\\RANIM\\Desktop\\Places\\test.html");URL url= file.toURI().toURL();
  webEngine.loadContent("<iframe width=\"750\" height=\"550\" frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" "
          + "marginwidth=\"0\" "
          + "src=\"https://www.openstreetmap.org/export/embed.html?bbox=-4.724121093750001%2C28.86391842622456%2C12.85400390625%2C38.788345355085625&amp;layer=mapnik\""
          + " style=\"border: 1px solid black\"></iframe><br/><small>"
          + "<a href=\"https://www.openstreetmap.org/#map=6/33.962/4.065\">"
          + "Afficher une carte plus grande"
          + "</a>"
          + "</small>");
//webEngine.load(url.toString());


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
        stage.show();}

    @FXML
    private void calculPrix(MouseEvent event) {
           DecimalFormat df = new DecimalFormat("0.00");
Double c=Double.parseDouble(distance.getText())/2.28;
      BigDecimal bd = new BigDecimal(c).setScale(2, RoundingMode.HALF_UP);

        setPrix(bd.doubleValue());
    }
    
}
