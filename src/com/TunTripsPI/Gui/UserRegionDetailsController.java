/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Utils.MyConnection;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class UserRegionDetailsController implements Initializable {

    @FXML
    private TextField txtregionId;
    @FXML
    private Button btnVillesEtCulture;
    @FXML
    private FontAwesomeIcon close;
   
    @FXML
    private ImageView myImageView;
    @FXML
    private TextArea txtdesc;
    @FXML
    private Label lbl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
      public void setData( int regidd) {
    Connection cnxx = MyConnection.getInstance().getCnx();
            String req = "SELECT * FROM region WHERE id = ?";

            PreparedStatement pst;
            try {
                //int iddd = Integer.parseInt(tfid.getText());
                pst = cnxx.prepareStatement(req);
                pst.setInt(1, regidd);
                ResultSet resulSet = pst.executeQuery();
                if (resulSet.first()) {
    
                InputStream inputStream = new ByteArrayInputStream(resulSet.getBytes("photo"));
                Image image = new Image(inputStream);

                myImageView.setImage(image);
     
                txtdesc.setText(resulSet.getString("description"));
                

                }
                
            }catch (SQLException ex) {
            System.err.println(ex.getMessage());
                  
        } 
            
    
        
      
            txtregionId.setText(""+regidd);
             
             
    
    }

    @FXML
    private void listDesRegions(ActionEvent event) {
    }
    
}
