/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.Utils.SessionManager;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class UserRegionListController implements Initializable {

    @FXML
    private VBox vboxx;
    @FXML
    private Button btnVillesEtCulture;
    @FXML
    private TextField txtuid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        Connection cnxx = MyConnection.getInstance().getCnx();
        String req = "SELECT * FROM region ";
        List<ImageView> buttonlist = new ArrayList<>();
        PreparedStatement pst;
        try {

            pst = cnxx.prepareStatement(req);

            ResultSet resulSet = pst.executeQuery();
            while (resulSet.next()) {

                //  String s = resulSet.getString("nom");
                String photo=resulSet.getString("photo");
                int rid = resulSet.getInt("id");
                BufferedImage bufferedImage = ImageIO.read(new File("C:/Region/"+photo));
                WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
                
                 ImageView img =new ImageView(); 
                 img.setImage(image);
                 img.setFitWidth(1360);
                 img.setFitHeight(250);
                 
             
            
              
                 
              
                

                buttonlist.add(img);

                /**
                 * ******************************** when the user click on the
                 * button he will be redirected to the detailsPage *************
                 */
             
                
               
       
  img.addEventHandler(MouseEvent.MOUSE_ENTERED,
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
             img.setStyle("-fx-border-color: #ffffff ;-fx-border-width: 5 ; -fx-text-fill: #ffffff ");
            
             
          }
        });

  img.addEventHandler(MouseEvent.MOUSE_EXITED,
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
             img.setStyle("-fx-border-color: transparent ;-fx-text-fill: #ffffff ");
               
          }
        });
  

               img.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        try {
                            FXMLLoader Loader = new FXMLLoader(getClass().getResource("UserRegionDetails.fxml"));
                            try {
                                
                                Parent root = Loader.load();
                                
                                btnVillesEtCulture.getScene().setRoot(root);
                                UserRegionDetailsController urd=Loader.getController();
                                System.out.println(SessionManager.id);                        } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
                            
                            UserRegionDetailsController r = Loader.getController();
                            r.setData(rid);
                            Parent p = Loader.getRoot();
                            Stage stage = new Stage();
                            stage.initStyle(StageStyle.TRANSPARENT);
                            stage.setScene(new Scene(p));
                            stage.show();
                        } catch (IOException ex) {
                            Logger.getLogger(UserRegionListController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
 
 
            }
            vboxx.getChildren().clear(); //remove all images that are currently in the container
            vboxx.getChildren().addAll(buttonlist); //then add all your images that you just created

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        } catch (IOException ex) {
            Logger.getLogger(UserRegionListController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void listDesRegions(ActionEvent event) {
         FXMLLoader Loader = new FXMLLoader(getClass().getResource("UserRegionList.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    vboxx.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
    }

    @FXML
    private void acceuil(ActionEvent event) {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    vboxx.getScene().setRoot(root);
                                    AcceuilController ac=Loader.getController();
                                  
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
    }

    @FXML
    private void listeve(ActionEvent event) {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("tableevenements.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    vboxx.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
    }

    @FXML
    private void transport(ActionEvent event) {
    }

    void settxttuser(String text) {
        this.txtuid.setText(text);
    }

}
