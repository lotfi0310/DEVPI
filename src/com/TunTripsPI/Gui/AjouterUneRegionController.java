/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.RegionCrud;
import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.entities.Region;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class AjouterUneRegionController implements Initializable {

    @FXML
    private TextField tfNomRegion;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button button2;
    @FXML
    private ImageView myImageView;
    @FXML
    private TextArea tfDescription;
  String s;
    @FXML
    private Button btnclose;
    Stage stage;
    @FXML
    private AnchorPane scenepane;
    @FXML
    private Button btnannuler;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    

    @FXML
    private void actionPerformed(ActionEvent event) {
        
         FileChooser fileChooser = new FileChooser();
            
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
             
            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);
       
            String path = file.getAbsolutePath(); 
              s = path;           
         
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
                
                myImageView.setImage(image);
            } catch (IOException ex) {
                Logger.getLogger(AjouterUneRegionController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @FXML
    private void enregistrerRegion(ActionEvent event) throws FileNotFoundException {
              
        if(tfNomRegion.getText().isEmpty())
                    { 
                        tfNomRegion.setText("Ajouter le nom de region");
                        tfNomRegion.setFont(Font.font(20));
                        
                    }
          else if(tfDescription.getText().isEmpty()){
                tfDescription.setText("Ajouter une description");
                tfDescription.setFont(Font.font(20));
                
                }
                else if (!tfNomRegion.getText().isEmpty()&&!tfDescription.getText().isEmpty())
             
                {
        try {
            
            Connection cnxx = MyConnection.getInstance().getCnx();

            String req = "INSERT INTO Region (nom,description,photo) VALUES (?,?,?)";
            PreparedStatement ps = cnxx.prepareStatement(req);
            InputStream is = new FileInputStream(new File(s));
            
           

            ps.setString(1, tfNomRegion.getText());
            ps.setString(2, tfDescription.getText());
            ps.setBlob(3, is);
            ps.executeUpdate();
            
            RegionCrud rc = new RegionCrud();
            Region r = new Region();
            
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("list.fxml"));
            try {
          
            
                Parent root = Loader.load();
           
                tfNomRegion.getScene().setRoot(root);  
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            
            
            
          } catch (SQLException ex) {
            System.err.println(ex.getMessage());
          }
            
                }
    }

    @FXML
    private void closemodal(ActionEvent event) {
       /*   stage = (Stage) scenepane.getScene().getWindow();
           stage = (Stage) scenepane.getScene().getWindow();
      stage.close(); 
        */
       
       
    }

    @FXML
    private void annuler(ActionEvent event) {
        
        
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("ConsulterListeRegion.fxml"));
        try {

            Parent root = Loader.load();

            btnannuler.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
