/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.ReclamationCrud;
import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.Utils.JavaMailUtil;
import com.TunTripsPI.entities.Reclamation;
import com.TunTripsPI.entities.User;
import com.gluonhq.charm.glisten.control.AutoCompleteTextField;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.controlsfx.dialog.ProgressDialog;

/**
 * FXML Controller class
 *
 * @author Lotfi
 */

public class GererUserAdminController implements Initializable {
    Parent fxml ;
    Parent fxml1; 
@FXML 
private AnchorPane frame_Userrec; 
    @FXML
    private Tab panegestionusers;
    @FXML
    private TableView<User> tabviewusers;
    @FXML
    private TableColumn<User,Integer> idusercol;
    @FXML
    private TableColumn<User,String> nomusercol;
    @FXML
    private TableColumn<User, String> prenomcol;
    @FXML
    private TableColumn<User,String> emailcol;
    @FXML
    private TableColumn<User,String> passwdcol;
    @FXML
    private TableColumn<User, String> countrycol;
    @FXML
    private TableColumn<User,String> rolecol;
    @FXML
    private TableColumn<User,Image> photocol;
    @FXML
    private TableColumn<User,String> num_telcol;
    @FXML
    private TableColumn<User,String> validecol;
    @FXML
    private TableColumn<User, String> etatcol;
    @FXML
    private Tab panegestionreclamation;
    InputStream input ; 
    
     private ObservableList<User> u = FXCollections.observableArrayList();
          private ObservableList<Reclamation> rec = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Reclamation, Integer> idrec;
    @FXML
    private TableColumn<Reclamation, Integer> id;
    @FXML
    private TableColumn<Reclamation,Integer> idev;
    @FXML
    private TableColumn<Reclamation,Integer> idheb;
    @FXML
    private TableColumn<Reclamation, Integer> idtrans;
    @FXML
    private TableColumn<Reclamation,String> con;
    @FXML
    private TableColumn<Reclamation,Date> date;
    @FXML
    private TableColumn<Reclamation,Boolean> etattrait;
    @FXML
    private TableView<Reclamation> tabviewrec;
    @FXML
    private TextField searchBox;
    @FXML
    private DialogPane Dialogboxuser;
    @FXML
    private Button btnconfirmsippuser;
    @FXML
    private Button btnannulersuppuser;
    @FXML
    private VBox dialogboxuser2;
    @FXML
    private TextField txtrecfilter;
    @FXML
    private AnchorPane dialog3;
    @FXML
    private Button btnsp;
    @FXML
    private Button btntrait;
    @FXML
    private VBox vbtrait;
    @FXML
    private Button btnenvrecc;
    @FXML
    private HBox dialog4;
    @FXML
    private TextArea txtresprecl;
    @FXML
    private AnchorPane eventsView;
    @FXML
    private Tab event;
   
    @FXML
    private AnchorPane regview;

    /**
     * Initializes the controller class.
     */
    
           
   
   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            fxml1=FXMLLoader.load(getClass().getResource("List.fxml"));
             regview.getChildren().removeAll();
                regview.getChildren().setAll(fxml1);
                
        } catch (IOException ex) {
            Logger.getLogger(GererUserAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
                
                
    try {
        fxml = FXMLLoader.load(getClass().getResource("TableEvenement.fxml"));
        
                eventsView.getChildren().removeAll();
                eventsView.getChildren().setAll(fxml);
        
    } catch (IOException ex) {
        Logger.getLogger(GererUserAdminController.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
         TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbtrait);
        t.setToX(0);
        
        
       
         
          idusercol.setCellValueFactory(
            new PropertyValueFactory<>("id")
        );
        nomusercol.setCellValueFactory(
            new PropertyValueFactory<>("nom")
        );
        prenomcol.setCellValueFactory(
            new PropertyValueFactory<>("prenom")
        );
         emailcol.setCellValueFactory(
            new PropertyValueFactory<>("email")
        );
             passwdcol.setCellValueFactory(
            new PropertyValueFactory<>("passwd")
        );
             countrycol.setCellValueFactory(
              new PropertyValueFactory<>("country")
             );
           
                rolecol.setCellValueFactory(
            new PropertyValueFactory<>("role")
        );
                 photocol.setCellValueFactory(
            new PropertyValueFactory<>("photo")
        );
                  num_telcol.setCellValueFactory(
            new PropertyValueFactory<>("num_tel")
        );
                   validecol.setCellValueFactory(
            new PropertyValueFactory<>("valide")
        );
                    etatcol.setCellValueFactory(
            new PropertyValueFactory<>("etat")
        );
              
                    
      

        UserCruds uc=new UserCruds();
         List<User> listUser= new ArrayList<User>();
         listUser=uc.consulterlisteuser();
         u.clear();
         u.addAll(listUser);
          tabviewusers.setItems(u);
           // Wrap the ObservableList in a FilteredList (initially display all data).
         FilteredList<User> filteredData = new FilteredList<>(u,b->true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(u-> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (u.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (u.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (u.getEmail().toLowerCase().indexOf(lowerCaseFilter)!=-1)
				     return true;
				     
                                else if (String.valueOf(u.getId()).indexOf(lowerCaseFilter)!=-1)
                                    return true;
                                     
                                else if (String.valueOf(u.getCountry()).indexOf(lowerCaseFilter)!=-1)
                                    return true;
                             
                                else 
                                    return false ;
                                
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<User> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tabviewusers.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tabviewusers.setItems(sortedData);
               
                    
                    
         tabviewusers.setOnMouseClicked(new EventHandler<MouseEvent>() {
              
            @Override
            public void handle(MouseEvent event) {
             if(tabviewusers.getSelectionModel().getSelectedItem()==null){
                
                     dialogboxuser2.setVisible(true);
                     dialogboxuser2.setVisible(false);
                 
                 
             }else{
              User rec=(User) tabviewusers.getSelectionModel().getSelectedItem();
           Dialogboxuser.setVisible(true);
               btnconfirmsippuser.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent event) {
                  uc.SupprimerUser(rec);
                  resetTableUserData();
                   Dialogboxuser.setVisible(false);
              }
          });
               btnannulersuppuser.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent event) {
                   Dialogboxuser.setVisible(false);
              }
          });
         
            }
             }
         
        });
          
          
          
         
          
          
          //rec
          ReclamationCrud ur=new ReclamationCrud();
         List<Reclamation> listRec= new ArrayList<Reclamation>();
         listRec=ur.DisplayAllReclamation();
         rec.clear();
         rec.addAll(listRec);
          tabviewrec.setItems(rec);
        
        idrec.setCellValueFactory(
            new PropertyValueFactory<>("idreclamation")
        );
        id.setCellValueFactory(
            new PropertyValueFactory<>("iduser")
        );
        idev.setCellValueFactory(
            new PropertyValueFactory<>("idevent")
        );
         idheb.setCellValueFactory(
            new PropertyValueFactory<>("idheberg")
        );
             idtrans.setCellValueFactory(
            new PropertyValueFactory<>("idtransport")
        );
               con.setCellValueFactory(
            new PropertyValueFactory<>("contenu")
        );
                date.setCellValueFactory(
            new PropertyValueFactory<>("Date_rec")
        );
                 etattrait.setCellValueFactory(
            new PropertyValueFactory<>("etat")
        );
                 
                 
                     // Wrap the ObservableList in a FilteredList (initially display all data).
         FilteredList<Reclamation> filteredDatarec = new FilteredList<>(rec,b->true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		txtrecfilter.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredDatarec.setPredicate(rec-> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (rec.getContenu().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} 
				
                                else 
                                    return false ;
                                
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Reclamation> sortedDatarec = new SortedList<>(filteredDatarec);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedDatarec.comparatorProperty().bind(tabviewrec.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tabviewrec.setItems(sortedDatarec);
               
                 
                 
                 
                 
           
                 
                 
          tabviewrec.setOnMouseClicked(new EventHandler<MouseEvent>() {
              
            @Override
            public void handle(MouseEvent event) {
             if(tabviewrec.getSelectionModel().getSelectedItem()==null){
               dialog3.setVisible(true);
               dialog3.setVisible(false);
              
                 
             }else{
              Reclamation rec=(Reclamation) tabviewrec.getSelectionModel().getSelectedItem();
           dialog4.setVisible(true);
               btnsp.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent event) {
                  ur.SupprimerReclamation(rec);
                  resetTableRecData();
                   dialog4.setVisible(false);
              }
          });
               btntrait.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent event) {
                   
                   vbtrait.setVisible(true);
                    TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbtrait);
                    t.setToX(0);
                    t.play();
                    dialog4.setVisible(false);
                      ur.traiterReclamationUser(rec);
                      resetTableRecData();
                     btnenvrecc.setOnAction(new EventHandler<ActionEvent>() {
                       @Override
                       public void handle(ActionEvent event) {
                           String email =ur.DisplayMailClient(rec);
                           JavaMailUtil.sendmail(email,txtresprecl.getText().toString());
                       }
                   });
                    
                    
                    
                   
              }
          });
         
            }
             }
         
        });
        
          
          
          
                 
    }
         //refresh user liste 
     public void resetTableUserData()
    {
        List<User> listUser = new ArrayList<>();
        UserCruds uc = new UserCruds();
        listUser = uc.consulterlisteuser();
        ObservableList<User> data = FXCollections.observableArrayList(listUser);
        tabviewusers.setItems(data);
    }
      public void resetTableRecData()
    {
        List<Reclamation> listRec = new ArrayList<>();
        ReclamationCrud rc = new ReclamationCrud();
        listRec = rc.DisplayAllReclamation();
        ObservableList<Reclamation> data = FXCollections.observableArrayList(listRec);
        tabviewrec.setItems(data);
    }
            
     
     
     
     
     
     
     
     //reclamation 
   
    }   
    
    

