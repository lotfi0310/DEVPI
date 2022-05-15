/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.RegionCrud;
import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.entities.Region;
import static java.awt.SystemColor.text;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class ModifierRegionController implements Initializable {

    Stage stage;

    @FXML
    private Button button2;
    @FXML
    private ImageView myImageView;

    @FXML
    private Button btnModifier;
    @FXML
    private AnchorPane scenepane;

    @FXML
    private Button btnModifier1;
    @FXML
    private TextField tfNomRegionm;
    @FXML
    private TextArea tfDescriptionm;
    @FXML
    private TextField tfid;
    @FXML
    private Button btndelete;
    
    private boolean update;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }

    
    public void setData(String nom, String description, int idd) {
        
    Connection cnxx = MyConnection.getInstance().getCnx();
            String req = "SELECT photo FROM region WHERE id = ?";

            PreparedStatement pst;
            try {
                //int iddd = Integer.parseInt(tfid.getText());
                pst = cnxx.prepareStatement(req);
                pst.setInt(1, idd);
                ResultSet resulSet = pst.executeQuery();
                if (resulSet.first()) {
                 /*  
                    Blob blob = resulSet.getBlob(1);
                    InputStream inputStream = blob.getBinaryStream();
                    Image image = new Image(inputStream);               
                    myImageView.setImage(image);
                    */
                                  
                 
                InputStream inputStream = new ByteArrayInputStream(resulSet.getBytes("photo"));
                Image image = new Image(inputStream, 800, 800, false, false);

                myImageView.setImage(image);

                }
                
            }catch (SQLException ex) {
            System.err.println(ex.getMessage());
                  
        } 
            
        tfDescriptionm.setText(description);
        tfNomRegionm.setText(nom);
        tfid.setText("" + idd);
    }

    @FXML
    private void savechanges(ActionEvent event) {
        
        
        

        String nom = tfNomRegionm.getText();
        String desc = tfDescriptionm.getText();
        int id = Integer.parseInt(tfid.getText());
        Region r1 = new Region(id, nom, desc);
        RegionCrud rc = new RegionCrud();
        rc.modifierRegion(r1);

        //stage = (Stage) scenepane.getScene().getWindow();
        // stage.close();
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("list.fxml"));
        try {

            Parent root = Loader.load();

            btnModifier.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    @FXML
    private void annuler(ActionEvent event) {
       /*
        stage = (Stage) scenepane.getScene().getWindow();
        stage.close();
        */
       
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("List.fxml"));
        try {

            Parent root = Loader.load();

            btnModifier.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @FXML
    private void deleteregion(ActionEvent event) {

        int id = Integer.parseInt(tfid.getText());

        Region r1 = new Region(id);
        RegionCrud rc = new RegionCrud();
        rc.supprimerRegion(r1);

        //stage = (Stage) scenepane.getScene().getWindow();
        // stage.close();
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("List.fxml"));
        try {

            Parent root = Loader.load();

            btnModifier.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    private void loadimage(ActionEvent event) {
       
            Connection cnxx = MyConnection.getInstance().getCnx();
            String req = "SELECT photo FROM region WHERE id = ?";

            PreparedStatement pst;
            try {
                int idd = Integer.parseInt(tfid.getText());
                pst = cnxx.prepareStatement(req);
                pst.setInt(1, idd);
                ResultSet resulSet = pst.executeQuery();
                if (resulSet.first()) {
                    Blob blob = resulSet.getBlob(1);
                    InputStream inputStream = blob.getBinaryStream();
                    Image image = new Image(inputStream,314, 297, false, false);
                    myImageView.setImage(image);

                }
                
            }catch (SQLException ex) {
            System.err.println(ex.getMessage());
       

           
        }
}
    
    void setUpdate(boolean b) {
        this.update = b;

    }

    @FXML
    private void actionPerformed(ActionEvent event) {
    }
    
    
    @FXML
    private void listDesRegions(ActionEvent event) {
         FXMLLoader Loader = new FXMLLoader(getClass().getResource("UserRegionList.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    myImageView.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
    }

    @FXML
    private void acceuil(ActionEvent event) {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    myImageView.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
    }

    @FXML
    private void listeve(ActionEvent event) {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("tableevenements.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    myImageView.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
    }

}