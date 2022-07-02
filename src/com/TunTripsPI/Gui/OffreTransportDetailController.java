/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;
import com.TunTripsPI.Gui.MenuTransportController;
import com.TunTripsPI.Gui.AjouterOffreTransportController;
import entities.Transport;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import com.TunTripsPI.Services.TransportCRUD;
import com.TunTripsPI.Utils.MyConnection;

/**
 * FXML Controller class
 *
 * @author Wassim
 */
public class OffreTransportDetailController implements Initializable {

    @FXML
    private TextField typeVc;
    @FXML
    private TextField capacite;
    @FXML
    private TextField immatricule;
    @FXML
    private Button retour;
    @FXML
    private TextField lieuDispo;
    @FXML
    private TextField numContact;
    @FXML
    private Label numContact1;
    @FXML
    private Label numContact2;
    @FXML
    private Label numContact3;
    @FXML
    private RadioButton dispo;
    @FXML
    private AnchorPane scInterface;
    @FXML
    private TextField id;

    public void setTypeVc(String message) {
        this.typeVc.setText(message);
    }

    /**
     *
     * @param message
     */
    public void setCapacite(String message) {
        this.capacite.setText(message);
    }

    public void setImmatricule(String message) {
        this.immatricule.setText(message);
    }

    public void setRetour(Button retour) {
        this.retour = retour;
    }

    public void setLieuDispo(String message) {
        this.lieuDispo.setText(message);
    }

    public void setNumContact(String message) {
        this.numContact.setText(message);
    }

    

    public void setDispo(String message) {
        this.dispo.setText(message);
    }

    public void setScInterface(AnchorPane scInterface) {
        this.scInterface = scInterface;
    }

    public TextField getTypeVc() {
        return typeVc;
    }

    public TextField getCapaciteF() {
        return capacite;
    }

    public TextField getImmatriculeF() {
        return immatricule;
    }

    public Button getRetour() {
        return retour;
    }

    public TextField getLieuDispoF() {
        return lieuDispo;
    }

    public TextField getNumContactF() {
        return numContact;
    }

    public Label getNumContact1() {
        return numContact1;
    }

    public Label getNumContact2() {
        return numContact2;
    }

    public Label getNumContact3() {
        return numContact3;
    }

   

    public AnchorPane getScInterface() {
        return scInterface;
    }
    
public Boolean validation(TextField a) {

        if ((a.getText() == null) || (a.getText().trim().isEmpty())) {

            Alert fail = new Alert(Alert.AlertType.INFORMATION);
            fail.setHeaderText("Echec");
            fail.setContentText("Tu n'as pas remplir le champs de " + a.getId());
            fail.showAndWait();
            return false;

        } else {
            return true;
        }

    }
     public boolean isValidNum(String num) {
        String numRegex = "[0-9]{8}";

        Pattern pat = Pattern.compile(numRegex);
        if (num == null) {
            return false;
        }
        if(pat.matcher(num).matches()==false)
        {Alert fail = new Alert(Alert.AlertType.INFORMATION);
            fail.setHeaderText("Echec");
            fail.setContentText("Numero saisié incorrect " );
            fail.showAndWait();}
        return pat.matcher(num).matches();
    }
     public boolean isValidCapacite(String cap) {
        String emailRegex = "[0-9]{1,2}";

        Pattern pat = Pattern.compile(emailRegex);
        if (cap == null) {
            return false;
        }
        
        if(pat.matcher(cap).matches()==false)
        {Alert fail = new Alert(Alert.AlertType.INFORMATION);
            fail.setHeaderText("Echec"); 
           fail.setContentText("Capacité saisié incompatible  " );
            fail.showAndWait();}
        return pat.matcher(cap).matches();
    }
   
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menuTransport.fxml"));
      MenuTransportController mtc = fxmlLoader.getController();
int idLoginUser=Integer.parseInt(mtc.getIdUser());  
          Connection cnxx;

            cnxx = MyConnection.getInstance().getCnx();

            String req = "SELECT idTransport,type,capacite,numChauffeur,immatricule,dispo,lieuDispo "
                    + "FROM transport  WHERE `idUser`="+idLoginUser+";";
                    PreparedStatement pst;

            pst = cnxx.prepareStatement(req);

            ResultSet rs;
            rs = pst.executeQuery(req);
            
while(rs.next()){
                              id.setText(String.valueOf(rs.getInt("idTransport")));

              this.setTypeVc(rs.getString("type"));
             
              capacite.setText(String.valueOf(rs.getInt("capacite")));
                immatricule.setText(rs.getString("immatricule"));
                lieuDispo.setText(rs.getString("lieuDispo"));
                numContact.setText(String.valueOf(rs.getInt("numChauffeur")));
              dispo.setSelected((rs.getBoolean("dispo")));}

            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        // TODO
    }    

    @FXML
    private void backHome(ActionEvent event) {
        
        try{
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menuTransport.fxml"));
                                                                            
        Parent root =  fxmlLoader.load();
                 
              

             retour.getScene().setRoot(root);}catch(IOException ex){System.out.println(ex.getMessage());}
    }
    //.setOnMouseCliked

    @FXML
    private void updateBtn(ActionEvent event) {
        Transport trsp = new Transport();
        if(validation(typeVc)
                && validation(capacite)&& isValidCapacite(capacite.getText())
                && validation(immatricule)
                && validation(lieuDispo) && validation(numContact) 
                && isValidNum(numContact.getText())) {

            trsp.setType(typeVc.getText());
            trsp.setCapacite(Integer.parseInt(capacite.getText()));
            trsp.setNumChauffeur(Integer.parseInt(numContact.getText()));
            trsp.setImmatricule(immatricule.getText());
            trsp.setDispo((dispo.isSelected()));
            trsp.setLieuDispo(lieuDispo.getText());
            trsp.setId(Integer.parseInt(id.getText()));
        TransportCRUD t = new TransportCRUD();
            t.updateTransport(trsp);
            Alert fail = new Alert(AlertType.INFORMATION);
            fail.setHeaderText("Succes"); 
           fail.setContentText("Votre offre de transport a été modifié" );
            fail.showAndWait();}}

            
            
            

    }
    

