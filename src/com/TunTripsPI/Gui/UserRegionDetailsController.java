/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Utils.MyConnection;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private ImageView myImageView;
    @FXML
    private Label txtdesc;
    
    @FXML
    private Button Monuments;
    @FXML
    private Label lblNomreg;
    @FXML
    private Button Musées;
    @FXML
    private Button Cafés;
    @FXML
    private Button Restaurants;
    @FXML
    private TextField txtuu;

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
                Image image = new Image(inputStream, 1366, 350, false, false);
 
 
                myImageView.setImage(image);
     
                txtdesc.setText(resulSet.getString("description"));
                lblNomreg.setText(resulSet.getString("nom"));
                

                }
                
            }catch (SQLException ex) {
            System.err.println(ex.getMessage());
                  
        } 
            
    
        
      
            txtregionId.setText(""+regidd);
             
             
    
    }

    @FXML
    private void listDesRegions(ActionEvent event) {
          FXMLLoader Loader = new FXMLLoader(getClass().getResource("UserRegionList.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    txtdesc.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
    }

      

    @FXML
    private void getmonuments (ActionEvent event) {
        
        
        
          FXMLLoader Loader = new FXMLLoader(getClass().getResource("UserEndroitInterface.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    Monuments.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }

                                UserEndroitInterfaceController e = Loader.getController();
                                e.selectEndroits(Integer.parseInt(txtregionId.getText()),Monuments.getId(), lblNomreg.getText() );
                                e.setdata(Integer.parseInt(txtregionId.getText()),Monuments.getId(), lblNomreg.getText() );
                                Parent p = Loader.getRoot();
                                Stage stage = new Stage();
                                stage.initStyle(StageStyle.TRANSPARENT);
                                stage.setScene(new Scene(p));
                                stage.show();
        
        
        
        
        
    }

    @FXML
    private void getmusees(ActionEvent event) {
         FXMLLoader Loader = new FXMLLoader(getClass().getResource("UserEndroitInterface.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    Musées.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }

                                UserEndroitInterfaceController e = Loader.getController();
                                e.selectEndroits(Integer.parseInt(txtregionId.getText()),Musées.getId(), lblNomreg.getText() );
                                e.setdata(Integer.parseInt(txtregionId.getText()),Musées.getId(), lblNomreg.getText() );
                                Parent p = Loader.getRoot();
                                Stage stage = new Stage();
                                stage.initStyle(StageStyle.TRANSPARENT);
                                stage.setScene(new Scene(p));
                                stage.show();
        
    }

    @FXML
    private void getcafes(ActionEvent event) {
         FXMLLoader Loader = new FXMLLoader(getClass().getResource("UserEndroitInterface.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    Cafés.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }

                                UserEndroitInterfaceController e = Loader.getController();
                                e.selectEndroits(Integer.parseInt(txtregionId.getText()),Cafés.getId(), lblNomreg.getText() );
                                e.setdata(Integer.parseInt(txtregionId.getText()),Cafés.getId(), lblNomreg.getText() );
                                Parent p = Loader.getRoot();
                                Stage stage = new Stage();
                                stage.initStyle(StageStyle.TRANSPARENT);
                                stage.setScene(new Scene(p));
                                stage.show();
        
    }

    @FXML
    private void getrestau(ActionEvent event) {
         FXMLLoader Loader = new FXMLLoader(getClass().getResource("UserEndroitInterface.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    Restaurants.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }

                                UserEndroitInterfaceController e = Loader.getController();
                                e.selectEndroits(Integer.parseInt(txtregionId.getText()),Restaurants.getId(), lblNomreg.getText() );
                                e.setdata(Integer.parseInt(txtregionId.getText()),Restaurants.getId(), lblNomreg.getText() );
                                Parent p = Loader.getRoot();
                                Stage stage = new Stage();
                                stage.initStyle(StageStyle.TRANSPARENT);
                                stage.setScene(new Scene(p));
                                stage.show();
        
    }
    
  

    @FXML
    private void acceuil(ActionEvent event) {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    txtdesc.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
    }

    @FXML
    private void listeve(ActionEvent event) {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("tableevenements.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    txtdesc.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
    }

    void settextuuu(String text) {
this.txtuu.setText(text); 
    }


    
}
