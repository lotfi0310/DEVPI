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
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import com.TunTripsPI.Services.TransportCRUD;
import com.TunTripsPI.Utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Wassim
 */
public class AjouterOffreTransportController implements Initializable {

    @FXML
    private TextField typeVc;
    @FXML
    private TextField capacite;
    @FXML
    private TextField immatricule;
    @FXML
    private Button submit;
    @FXML
    private TextField lieuDispo;
    @FXML
    private TextField numContact;
    @FXML
    private Label numContact1;
    @FXML
    private Label numContact2;
    @FXML
    private Label numContact3;
    @FXML
    private RadioButton dispo1;
    @FXML
    private Button backBtn;
    @FXML
    private ImageView mapsBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
    public Boolean validation(TextField a) {

        if ((a.getText() == null) || (a.getText().trim().isEmpty())) {

            Alert fail = new Alert(AlertType.INFORMATION);
            fail.setHeaderText("Echec");
            fail.setContentText("Tu n'as pas remplir le champs de " + a.getId());
            fail.showAndWait();
            return false;

        } else {
            return true;
        }

    }
     public boolean isValidNum(String num) {
        String numRegex = "[0-9]{8}";

        Pattern pat = Pattern.compile(numRegex);
        if (num == null) {
            return false;
        }
        if(pat.matcher(num).matches()==false)
        {Alert fail = new Alert(AlertType.INFORMATION);
            fail.setHeaderText("Echec");
            fail.setContentText("Numero saisié incorrect " );
            fail.showAndWait();}
        return pat.matcher(num).matches();
    }
     public boolean isValidCapacite(String cap) {
        String emailRegex = "[0-9]{1,2}";

        Pattern pat = Pattern.compile(emailRegex);
        if (cap == null) {
            return false;
        }
        
        if(pat.matcher(cap).matches()==false)
        {Alert fail = new Alert(AlertType.INFORMATION);
            fail.setHeaderText("Echec"); 
           fail.setContentText("Capacité saisié incompatible  " );
            fail.showAndWait();}
        return pat.matcher(cap).matches();
    }
    
    
    
    
    

    @FXML
    private void saveOffre(ActionEvent event) throws IOException {
        Transport trsp = new Transport();
        while (validation(typeVc)
                && validation(capacite)&& isValidCapacite(capacite.getText())
                && validation(immatricule)
                && validation(lieuDispo) && validation(numContact) 
                && isValidNum(numContact.getText())) {

            trsp.setType(typeVc.getText());
            trsp.setCapacite(Integer.parseInt(capacite.getText()));
            trsp.setNumChauffeur(Integer.parseInt(numContact.getText()));
            trsp.setImmatricule(immatricule.getText());
            trsp.setDispo((dispo1.isSelected()));
            trsp.setLieuDispo(lieuDispo.getText());
            trsp.setIdUser(SessionManager.id);

            TransportCRUD t = new TransportCRUD();
            t.ajouterTransport2(trsp);
             Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setHeaderText("ajout reusié");
            info.showAndWait();
            break;
           /* try {
            
                 Parent root = FXMLLoader.load(getClass().getResource("menuTransport.fxml"));
                 


            Scene scene = new Scene(root);
            Stage aStage=new Stage();
            aStage.setTitle("Ajouter un offre transport");
            aStage.setScene(scene);
            aStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());        }
           /* try{
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OffreTransportDetail.fxml"));
                                                                            
        Parent root =  fxmlLoader.load();
                 
                OffreTransportDetailController otd =fxmlLoader.getController();
              /*otd.setTypeVc(trsp.getType());
                otd.setCapacite(trsp.getCapacite);
                otd.setImmatricule(trsp.getImmatricule);
                otd.setLieuDispo(trsp.getLieuDispo);
                otd.setNumContact(trsp.getNumContact);*/
              //  otd.setDispo(trsp.getDispo);

            // submit.getScene().setRoot(root);}catch(IOException ex){System.out.println(ex.getMessage());}
           /* Scene scene = new Scene(root);
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("ABC");
        stage.setScene(new Scene(root));
        stage.show();*/
       
            
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
    private void openMaps(MouseEvent event) throws MalformedURLException {
        
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
        stage.show();
    }

}
/* configureLogging();

       

        VonageClient client = VonageClient.builder().apiKey("86ecbfd5").apiSecret("RKD8CAVR9lyZZhqL").build();

        TextMessage message = new TextMessage("21622604067",
                numContact.getText(),
                "A text message sent using the Vonage SMS API"
        );

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
            System.out.println("Message sent successfully.");
        } else {
            System.out.println("Message failed with error: " + response.getMessages().get(0).getErrorText());
        }

public boolean isValidImmatricule(String im) {
        String imRegex ="\"^[0-9]{1,2,3}TUN,tun,Tun[0-9]{1,2,3,4}$\";" ;

        Pattern pat = Pattern.compile(imRegex);
        if (im == null) {
            return false;
        }
        
        if(pat.matcher(cap).matches()==false)
        {Alert fail = new Alert(AlertType.INFORMATION);
            fail.setHeaderText("Echec"); 
           fail.setContentText("Immatricule saisié incorrect(Veuillez saisie de cette forme XXXTUNXXX  ) " );
            fail.showAndWait();}
        return pat.matcher(cap).matches();
    }


*/