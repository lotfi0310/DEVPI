package com.TunTripsPI.Gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.Utils.SessionManager;
import com.TunTripsPI.entities.User;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Lotfi
 */
public class ProfilUserController implements Initializable {

    @FXML
    private TextField txtModifPrenom;
    @FXML
    private TextField txtModifNom;
    @FXML
    private TextField txtmodifemail;
    @FXML
    private TextField txtmodifpass;
    @FXML
    private TextField txtmodifrole;
    @FXML
    private TextField txtmodifnumtel;
    @FXML
    private ImageView txtmodifimageprofil;
    @FXML
    private Button btnpreced;
    @FXML
   
    private Button btnmodifinfoprofil;
String s;
    @FXML
    private TextField txtiduss;
    String email; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       setData(SessionManager.id);

    }    


    @FXML
    private void modifimageprofil(ActionEvent event) {
FileChooser fileChooser = new FileChooser();
            
          
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
             fileChooser .setInitialDirectory(new File("C:\\"));
                       

            String path = file.getAbsolutePath(); 
            s=file.getName();
             System.out.println(s);
         
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
                txtmodifimageprofil.setImage(image);
                
                
            } catch (IOException ex) {
                Logger.getLogger(ProfilUserController.class.getName()).log(Level.SEVERE, null, ex);
            }       
      
    }
// get user photo 
    public void setData( int idd) {
        
        try {
            Connection cnxx = MyConnection.getInstance().getCnx();
            String req = "SELECT * FROM user WHERE id=?";

            PreparedStatement pst;
            
            // int iddd = Integer.parseInt(tfid.getText());
            pst = cnxx.prepareStatement(req);
            pst.setInt(1,idd);
            ResultSet resulSet = pst.executeQuery();
            if (resulSet.first()) {
                String nom=resulSet.getString("nom");
               String picname = resulSet.getString("photo");
                if(picname!=null){
                       BufferedImage img = null;
try {
    img = ImageIO.read(new File(picname));
      BufferedImage bufferedImage = ImageIO.read(new File(picname));
                WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
                txtmodifimageprofil.setImage(image);
} catch (IOException e) {
}
                 }
                String prenom = resulSet.getString("prenom");
                String num=resulSet.getString("num_tel");
                 email=resulSet.getString("email");

                txtModifNom.setText(nom);
                txtModifPrenom.setText(prenom);
                txtmodifnumtel.setText(num);
                txtmodifemail.setText(email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfilUserController.class.getName()).log(Level.SEVERE, null, ex);
        }

                
            
        
    }
    @FXML
    private void precedent(ActionEvent event) {
       
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 AcceuilController pc = Loader.getController();
                                                btnpreced.getScene().setRoot(root);
                                            } catch (IOException ex) {
                                                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
    }

    @FXML
    private void enregistrer(ActionEvent event) throws FileNotFoundException {
        if(s!=null){
            
      try {
            Connection cnxx = MyConnection.getInstance().getCnx();
            
            String req = "UPDATE user set photo=? where id=? ";
            PreparedStatement ps = cnxx.prepareStatement(req);
            
            
            ps.setString(1,s);
            ps.setInt(2,SessionManager.id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProfilUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
            User u=new User();
            UserCruds uc=new UserCruds();
           u.setId(SessionManager.id);
            u.setNom(txtModifNom.getText());
            u.setPrenom(txtModifPrenom.getText());
            u.setEmail(txtmodifemail.getText());
            u.setNum_tel(txtmodifnumtel.getText());
            if(!txtmodifnumtel.getText().isEmpty())
            {
                if(!isPhoneNumberCorrect(txtmodifnumtel.getText())){
                    txtmodifnumtel.setFocusTraversable(true);
                    txtmodifnumtel.setFont(Font.font(10));
                }
            }
            if(txtmodifemail.getText().isEmpty()){
                txtmodifemail.setText(email);
            }
                 uc.modifierprofil(u);
                Notifications notificationbuilder=Notifications.create().title("Alert").text("Information modifiée avec succées")
                        .graphic(null).hideAfter(javafx.util.Duration.seconds(10)).position(Pos.BASELINE_LEFT).onAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            }
        });
        notificationbuilder.darkStyle();
        notificationbuilder.show();
            
           

     
    }
 
     
    public void setTxtModifPrenom(String message ) {
        this.txtModifPrenom.setText(message) ;
    }

    public void setTxtModifNom( String message) {
        this.txtModifNom.setText(message);
    }

    public void setTxtmodifemail(String message ) {
        this.txtmodifemail.setText(message) ;
    }

    
    public void setTxtmodifrole(String  message) {
        this.txtmodifrole.setText(message);
    }

    public void setTxtmodifnumtel(String  message) {
        this.txtmodifnumtel.setText(message);
    }

    

     public void setuid(String message) {
        this.txtiduss.setText(message);
    }

  
   private boolean isPhoneNumberCorrect(String pPhoneNumber) {

    Pattern pattern = Pattern
            .compile("((\\+[1-9]{3,4}|0[1-9]{4}|00[1-9]{3})\\-?)?\\d{8,20}");
    Matcher matcher = pattern.matcher(pPhoneNumber);

    return (matcher.matches());


   
}
   
    
}