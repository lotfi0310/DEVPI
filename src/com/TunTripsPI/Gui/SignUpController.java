/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.entities.User;
import com.gluonhq.impl.charm.a.b.b.i;
import java.awt.Color;
import static java.awt.Color.RED;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lotfi
 */
public class SignUpController implements Initializable {
    public static String e;
    @FXML
    private TextField usr_name; 
    @FXML
    private TextField usr_lastname;
    @FXML
    private TextField usr_email;
    @FXML
    private TextField usr_pass;
    @FXML
    private Button btnregistre;
    @FXML 
      private ComboBox<String> usr_role; 
      private String [] role = {"Simple User","Fournisseur"}; 
      
	private String[] countries = Locale.getISOCountries();
    @FXML
    private ComboBox<String> countrybox ;
		
		

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(int i = 0; i < countries.length; i++) { 
			
			String country = countries[i];
			Locale locale = new Locale("en", country);
         
			// Get the country name by calling getDisplayCountry()
			String countryName = locale.getDisplayCountry();
         
			// Printing the country name on the console
                        System.out.println(countryName);
			
		}		
        
        usr_role.getItems().addAll(role);
        btnregistre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if(usr_name.getText().isEmpty()){
                usr_name.setText("Remplir votre nom");
                usr_name.setFont(Font.font(20));
                }
                
                else if(usr_lastname.getText().isEmpty()){
                usr_lastname.setText("Remplir votre prenom");
                usr_lastname.setFont(Font.font(20));
                }
                else if(!SignInController.isEmailAdress(usr_email.getText())){
                     usr_email.setText("Format email non valide ");
                usr_email.setFont(Font.font(20));
                }
                else  if(usr_email.getText().isEmpty()){
                usr_email.setText("Remplir email");
                usr_email.setFont(Font.font(20));
                }
                else   if(usr_pass.getText().isEmpty()){
                usr_pass.setText("Remplir password");
                usr_pass.setFont(Font.font(20));
                }  
                else   if(usr_role.getValue().isEmpty())
                    { 
                        usr_role.setFocusTraversable(true);
                        usr_role.setBorder(Border.EMPTY);
                    }
                else if (!usr_name.getText().isEmpty()&&!usr_lastname.getText().isEmpty()&&!usr_email.getText().isEmpty()&&!usr_pass.getText().isEmpty()&&!usr_role.getValue().isEmpty())
             
                {
                                        e=usr_email.getText();

                UserCruds uc=new UserCruds(); 
                User u =new User(); 
                u.setNom(usr_name.getText());
                u.setPrenom(usr_lastname.getText());
                u.setEmail(usr_email.getText());
                u.setPasswd(usr_pass.getText());
                u.setRole(usr_role.getValue());
                if(uc.ifuserExiste(u.getEmail())){
                     JOptionPane.showMessageDialog(null," Bienvenu "+u.getNom()+" Email existe deja , essayer de s'authentifier ");
                }
                else {
                     uc.ajouterUser(u);
                     FXMLLoader Loader = new FXMLLoader(getClass().getResource("ValiderCompte.fxml"));
                                             Parent root;
                                            try {
                                                root = Loader.load();
                                                 ValiderCompteController pc = Loader.getController();
                                                btnregistre.getScene().setRoot(root);
                                                pc.setText(""+usr_email.getText().toString());
                                            } catch (IOException ex) {
                                                Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                    
                    
                    
                    
                }
                
                
                
            }
            }
            
                    
        });
    }


    
}