/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.entities.User;
import java.awt.Color;
import static java.awt.Color.RED;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.text.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Lotfi
 */
public class SignUpController implements Initializable {
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
      private ChoiceBox<String> usr_role; 
      private String [] role ={"Simple User","Fournisseur"}; 
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
                     TextField txtcodevmail=new TextField();
                     
                     JOptionPane.showInputDialog("Entrer Votre code de validation mail ",txtcodevmail);
                     try{
                    if(!txtcodevmail.getText().isEmpty()&& JOptionPane.OK_OPTION>0){
                        
                        System.out.println(txtcodevmail);
                    }
                     }catch(Exception e){
                         System.out.println("error");;
                    }
                }
                
                
                
            }
            }
            
                    
        });
    }    
    
}