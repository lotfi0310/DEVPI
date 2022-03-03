package com.TunTripsPI.Gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.Utils.MyConnection;
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
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //setData(Integer.parseInt(txtiduss.getText()));

    }    


    @FXML
    private void modifimageprofil(ActionEvent event) {
FileChooser fileChooser = new FileChooser();
            
          
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
       
            String path = file.getAbsolutePath(); 
              s = path;           
         
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
                Blob blob = resulSet.getBlob("photo");
                InputStream inputStream = blob.getBinaryStream();
                Image image = new Image(inputStream);
                txtmodifimageprofil.setImage(image);
                txtModifNom.setText(nom);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfilUserController.class.getName()).log(Level.SEVERE, null, ex);
        }

                
            
        
    }
    @FXML
    private void precedent(ActionEvent event) {

        
    }

    @FXML
    private void enregistrer(ActionEvent event) throws FileNotFoundException {
      try {
            Connection cnxx = MyConnection.getInstance().getCnx();
            
            String req = "UPDATE user set photo=? where id=? ";
            PreparedStatement ps = cnxx.prepareStatement(req);
            InputStream is = new FileInputStream(new File(s));
            
            
            ps.setBlob(1, is);
            ps.setInt(2,Integer.parseInt(txtiduss.getText()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfilUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        User u=new User(); 
        UserCruds uc=new UserCruds();
        u.setEmail(txtmodifemail.getText());
        u.setNom(txtModifNom.getText());
        u.setNum_tel(txtmodifnumtel.getText());
        u.setPrenom(txtModifPrenom.getText());
        u.setPasswd(txtmodifpass.getText());
        u.setRole(txtmodifrole.getText());
        uc.modifierUser(u);
        JOptionPane.showMessageDialog(null,"info modifiee avec succees");
     
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

    public void setTxtmodifpass(String message) {
        this.txtmodifpass.setText(message);
    }

    public void setTxtmodifrole(String  message) {
        this.txtmodifrole.setText(message);
    }

    public void setTxtmodifnumtel(String  message) {
        this.txtmodifnumtel.setText(message);
    }

    void setTxtUser(String string) {
        this.txtiduss.setText(string);
    }

  
   
   
    
}
