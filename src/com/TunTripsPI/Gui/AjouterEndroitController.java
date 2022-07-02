/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.RegionCrud;
import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.entities.Endroit;

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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class AjouterEndroitController implements Initializable {

    @FXML
    private TextField tfNomEndroit;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnajouterimg;
    @FXML
    private TextArea tfDescription;
    @FXML
    private Button btnannuler;
    @FXML
    private ImageView myImageView1;
    @FXML
    private ComboBox comb;
    @FXML
    private TextField tfLongitude;
    @FXML
    private TextField tfLatitude;
    String s;
    String name ; 

    ObservableList<String> TypeList = FXCollections.observableArrayList("Monuments", "museum", "Cafes", "Restaurants ");
    @FXML
    private TextField txtregid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        comb.setItems(TypeList);
         
    }
   public void setData(int iddreg){
        txtregid.setText(""+iddreg);
        
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
        name =file.getName();

        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            myImageView1.setImage(image);
             String Location="C:/Endroit/"+name;
                String format="JPG";
                ImageIO.write(bufferedImage, format, new File(Location));
        } catch (IOException ex) {
            Logger.getLogger(AjouterUneRegionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void enregistrerEndroit(ActionEvent event) throws FileNotFoundException {
        if (tfNomEndroit.getText().isEmpty()) {
            tfNomEndroit.setText("*");
            tfNomEndroit.setFont(Font.font(20));

        } else if (tfDescription.getText().isEmpty()) {
            tfDescription.setText("*");
            tfDescription.setFont(Font.font(20));

        } else if (!tfNomEndroit.getText().isEmpty() && !tfDescription.getText().isEmpty()) {
            try {

                Connection cnxx = MyConnection.getInstance().getCnx();

                String req = "INSERT INTO endroit (nom,description,type,longitude,latitude,image,region_id_id) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement ps = cnxx.prepareStatement(req);
                InputStream is = new FileInputStream(new File(s));
                String s = comb.getSelectionModel().getSelectedItem().toString();
                
                
                
                ps.setString(1, tfNomEndroit.getText());
                ps.setString(2, tfDescription.getText());
                ps.setString(3, s);
                ps.setFloat(4, Float.parseFloat(tfLongitude.getText()));
                ps.setFloat(5, Float.parseFloat(tfLatitude.getText()));

                ps.setString(6, name);
                ps.setInt(7, Integer.parseInt(txtregid.getText()));
                
                ps.executeUpdate();
 

                FXMLLoader Loader = new FXMLLoader(getClass().getResource("EndroitList.fxml"));
                try {

                    Parent root = Loader.load();
                           
        
                    btnAjouter.getScene().setRoot(root);
                } catch (IOException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }
    }

    @FXML
    private void annuler(ActionEvent event) {

        FXMLLoader Loader = new FXMLLoader(getClass().getResource("EndroitList.fxml"));
        try {

            Parent root = Loader.load();

            btnAjouter.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @FXML
    private void select(ActionEvent event) {
        String s = comb.getSelectionModel().getSelectedItem().toString();

    }

}
