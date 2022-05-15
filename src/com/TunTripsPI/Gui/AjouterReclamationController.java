/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import com.TunTripsPI.Services.ReclamationCrud;
import com.TunTripsPI.Utils.SessionManager;
import com.TunTripsPI.entities.Reclamation;
import com.TunTripsPI.entities.User;
import com.sun.org.glassfish.gmbal.ParameterNames;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateTimeStringConverter;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Lotfi
 */
public class AjouterReclamationController implements Initializable {
       Parent listev ; 

    @FXML
    private Pane lblafficheEvent;
    @FXML
    private TextArea txtrec;
    @FXML
    private TextField txttrec;
    @FXML
    private TextField txtUserId;
    @FXML
    private ImageView btnprecedentrec;
    
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
btnprecedentrec.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {
      FXMLLoader Loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 AcceuilController pc = Loader.getController();
                                                btnprecedentrec.getScene().setRoot(root);
          }catch(Exception e){ System.out.println("error");
              
          }}
});
    }    


    @FXML
    private void envoyerrec(ActionEvent event) {
        ReclamationCrud rc=new ReclamationCrud();
        Reclamation r=new Reclamation();
         long millis=System.currentTimeMillis();  
         java.sql.Date date = new java.sql.Date(millis);
         
        r.setDate_rec(date);
        r.setContenu(txtrec.getText());
        r.setEtat(false);
        r.setIdevent(Integer.parseInt(txttrec.getText()));
        User u=new User();
        u.setId(SessionManager.id);
        rc.ajouterReclamationEvent(r,u);
                Notifications notificationbuilder=Notifications.create().title("Alert").text("Réclamation Ajouter avec succées")
                        .graphic(null).hideAfter(javafx.util.Duration.seconds(10)).position(Pos.BASELINE_LEFT).onAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });
        notificationbuilder.darkStyle();
        notificationbuilder.show();
          FXMLLoader Loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 AcceuilController pc = Loader.getController();
                                                lblafficheEvent.getScene().setRoot(root);
                                            } catch (IOException ex) {
                                                Logger.getLogger(TableEvenementRecController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
          
    }
    
    
     public void setTxtIDEvent( String message) {
        this.txttrec.setText(message);
    }
     public void setTxtUserID( String message) {
        this.txtUserId.setText(message);
    }

    @FXML
    private void SelectRec(ActionEvent event) {
          FXMLLoader Loader = new FXMLLoader(getClass().getResource("TableEvenementRec.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 TableEvenementRecController pc = Loader.getController();
                                                lblafficheEvent.getScene().setRoot(root);
                                            } catch (IOException ex) {
                                                Logger.getLogger(TableEvenementRecController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
        
    }

    String getTxtIDEvent() {
        return txtUserId.getText();
    }
}
