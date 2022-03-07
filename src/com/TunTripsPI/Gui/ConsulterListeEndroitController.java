/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Utils.MyConnection;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class ConsulterListeEndroitController implements Initializable {

    @FXML
    private ImageView myImageView;
 
    @FXML
    private HBox vboxx;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        Connection cnxx = MyConnection.getInstance().getCnx();
        String req = "SELECT * FROM region ";
        List<ImageView> ImageList = new ArrayList<>();
        PreparedStatement pst;
        try {
             
            pst = cnxx.prepareStatement(req);

            ResultSet resulSet = pst.executeQuery();
            while (resulSet.next()) {
               
               InputStream inputStream = new ByteArrayInputStream(resulSet.getBytes("photo"));
               Image image = new Image(inputStream, 200, 200, false, false);
               
                

               // myImageView.setImage(image); 
        ImageList.add(new ImageView(image));
        
            }
    vboxx.getChildren().clear(); //remove all images that are currently in the container
    vboxx.getChildren().addAll(ImageList); //then add all your images that you just created

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }

    }

}
