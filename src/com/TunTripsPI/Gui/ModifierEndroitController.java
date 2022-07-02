/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.EndroitCrud;
import com.TunTripsPI.Services.RegionCrud;
import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.entities.Endroit;
import com.TunTripsPI.entities.Region;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class ModifierEndroitController implements Initializable {

    @FXML
    private TextField tfNomEndroit;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnajouterimg;
    @FXML
    private TextArea tfDescription;
    @FXML
    private Button btnannuler;
    @FXML
    private ComboBox<?> comb;
    @FXML
    private TextField tfLongitude;
    @FXML
    private TextField tfLatitude;
    @FXML
    private ImageView myImageView1;
    @FXML
    private TextField tfid;
    @FXML
    private TextField txtidreg;
String s ;
String name ; 
 File file;
 BufferedImage bufferedImage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
      
    public void setData( int idd,int regidd) {
      
    Connection cnxx = MyConnection.getInstance().getCnx();
            String req = "SELECT * FROM endroit WHERE id = ?";
            
            PreparedStatement pst;
            try {
               
                pst = cnxx.prepareStatement(req);
                pst.setInt(1, idd);
                ResultSet resulSet = pst.executeQuery();
                if (resulSet.first()) {
                
                                  
                   BufferedImage bufferedImage = ImageIO.read(new File("C:/Endroit/"+resulSet.getString("image")));
                WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
               myImageView1.setImage(image);
                    tfDescription.setText(resulSet.getString("description"));
                    tfNomEndroit.setText(resulSet.getString("nom"));
            tfLongitude.setText(resulSet.getString("longitude"));
            tfLatitude.setText(resulSet.getString("latitude"));
            
            
            

                }
                
            }catch (SQLException ex) {
            System.err.println(ex.getMessage());
       

           
        } catch (IOException ex) { 
            Logger.getLogger(ModifierEndroitController.class.getName()).log(Level.SEVERE, null, ex);
        }
            txtidreg.setText(""+regidd);
             tfid.setText("" + idd);
    
    }

    

    @FXML
    private void annuler(ActionEvent event) {
       /*
        stage = (Stage) scenepane.getScene().getWindow();
        stage.close();
        */
       
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("EndroitList.fxml"));
        try {

            Parent root = Loader.load();

            btnModifier.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
/*
    private void deleteregion(ActionEvent event) {

        int id = Integer.parseInt(tfid.getText());

        Endroit e = new Endroit(id);
        EndroitCrud rc = new EndroitCrud();
        rc.supprimerEndroit(e);

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
*/
    private void loadimage(ActionEvent event) {
       
            Connection cnxx = MyConnection.getInstance().getCnx();
            String req = "SELECT image FROM endroit WHERE id = ?";

            PreparedStatement pst;
            try {
                int idd = Integer.parseInt(tfid.getText());
                pst = cnxx.prepareStatement(req);
                pst.setInt(1, idd);
                ResultSet resulSet = pst.executeQuery();
                if (resulSet.first()) {
                    Blob blob = resulSet.getBlob(1);
                    InputStream inputStream = blob.getBinaryStream();
                    Image image = new Image(inputStream,600, 600, false, false);
                    myImageView1.setImage(image);

                }
                
            }catch (SQLException ex) {
            System.err.println(ex.getMessage());
       

           
        }
}
    
  @FXML
    private void actionPerformed(ActionEvent event) {
        
        
         FileChooser fileChooser = new FileChooser();
            
            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
             
            //Show open file dialog
             file = fileChooser.showOpenDialog(null);
       
            String path = file.getAbsolutePath(); 
              s = path;   
              name=file.getName();
         
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
                
                myImageView1.setImage(image);
            } catch (IOException ex) {
                Logger.getLogger(AjouterUneRegionController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
public static boolean isEmpty(ImageView imageView) {
    if (imageView.getImage() == null){ System.out.println("t");}
    return true;
}
    @FXML
    private void saveChanges(ActionEvent event) throws FileNotFoundException, IOException {
        
          boolean emp =  isEmpty(myImageView1);
      
        if (emp == true){
             try {
            
            Connection cnxx = MyConnection.getInstance().getCnx();

            String req = "UPDATE Endroit SET nom=?,description=?,longitude=?,latitude=?, image=? WHERE id=?";
            PreparedStatement ps = cnxx.prepareStatement(req);
            
           

            ps.setString(1, tfNomEndroit.getText());
          
            ps.setString(2,  tfDescription.getText());
            ps.setFloat(3, Float.parseFloat(tfLongitude.getText()));
            ps.setFloat(4, Float.parseFloat(tfLatitude.getText())); 
            ps.setString(5,name);
            ps.setInt(6,Integer.parseInt(tfid.getText()));
            ps.executeUpdate();
              bufferedImage = ImageIO.read(file);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            myImageView1.setImage(image);
             String Location="C:/Endroit/"+name;
                String format="JPG";
                ImageIO.write(bufferedImage, format, new File(Location));
            
            RegionCrud rc = new RegionCrud();
            Region r = new Region();
            
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Endroitlist.fxml"));
        try {

            Parent root = Loader.load();

            tfNomEndroit.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        EndroitListController el = Loader.getController();
                el.refreshETable( Integer.parseInt(txtidreg.getText()));
                Parent p = Loader.getRoot();
                
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(new Scene(p));
                stage.show();
          
            
            
          } catch (SQLException ex) {
            System.err.println(ex.getMessage());
          }
        
            
        }
           
        
      

       
    }

   

    @FXML
    private void select(ActionEvent event) {
    }
    
}
