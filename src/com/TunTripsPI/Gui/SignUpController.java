/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.entities.Reclamation;
import com.TunTripsPI.entities.User;
import com.gluonhq.charm.glisten.control.AutoCompleteTextField;
import com.gluonhq.impl.charm.a.b.b.i;
import impl.org.controlsfx.autocompletion.AutoCompletionTextFieldBinding;
import java.awt.Color;
import static java.awt.Color.RED;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;

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
      
	private String[] countries ={ "Andorre",
"Emirats Arabes Unis",
"Afghanistan",
"Antigua et Barbuda",
"Anguilla",
"Albanie",
"Arménie",
"Antilles Néerlandaises",
"Angola",
"Antarctique",
"Argentine",
"Samoa américaines",
"Autriche",
"Australie",
"Aruba",
"Îles Åland",
"Azerbaïdjan",
"Bosnie-Herzégovine",
"Barbade",
"Bangladesh",
"Belgique",
"Burkina Faso",
"Bulgarie",
"Bahreïn",
"Burundi",
"Benin",
"Saint-Barthélemy",
"Bermudes",
"Brunei",
"Bolivie",
"Bonaire Saint-Eustache et Saba",
"Brésil",
"Bahamas",
"Bhoutan",
"Île Bouvet",
"Botswana",
"Biélo-Russie",
"Bélize",
"Canada",
"Îles Cocos",
"République démocratique du Congo",
"République Centre-Africaine",
"Congo",
"Suisse",
"Côte d'Ivoire",
"Îles Cook",
"Chili",
"Cameroun",
"Chine",
"Colombie",
"Costa Rica",
"Cuba",
"Cap Vert",
"Curaçao",
"Île Christmas",
"Chypre",
"République Tchèque",
"Allemagne",
"Djibouti",
"Danemark",
"Dominique",
"République Dominicaine",
"Algérie",
"Equateur",
"Estonie",
"Egypte",
"Sahara Occidental",
"Erythrée",
"Espagne",
"Ethiopie",
"Finlande",
"Fidji",
"Îles Malouines",
"Micronésie",
"Îles Féroé",
"France",
"Gabon",
"Royaume-Uni",
"Grenade",
"Géorgie",
"Guyane française",
"Guernesey",
"Ghana",
"Gibraltar",
"Groenland",
"Gambie",
"Guinée",
"Guadeloupe",
"Guinée Equatoriale",
"Grèce",
"Géorgie du Sud et îles Sandwich du Sud",
"Guatemala",
"Guam",
"Guinée-Bissau",
"Guyana",
"Hong-Kong",
"Île Heard et îles McDonald",
"Honduras",
"Croatie",
"Haïti",
"Hongrie",
"Indonésie",
"Irlande",
"Ile de Man",
"Inde",
"Territoires britanniques de l'Océan Indien",
"Irak",
"Iran",
"Islande",
"Italie",
"Jersey",
"Jamaïque",
"Jordanie",
"Japon",
"Kenya",
"Kyrgyzstan",
"Cambodge",
"Kiribati",
"Comores",
"Saint-Christophe-et-Niévès",
"Corée du Nord",
"Corée du Sud",
"Koweit",
"Îles Caïmans",
"Kazakhstan",
"Laos",
"Liban",
"Sainte-Lucie",
"Liechtenstein",
"Sri Lanka",
"Liberia",
"Lesotho",
"Lithuanie",
"Luxembourg",
"Lettonie",
"Libye",
"Maroc",
"Monaco",
"Moldavie",
"Monténégro",
"Saint-Martin",
"Madagascar",
"Îles Marshall",
"Macédoine",
"Mali",
"Myanmar",
"Mongolie",
"Macao",
"Îles Mariannes du Nord",
"Martinique",
"Mauritanie",
"Montserrat",
"Malte",
"Maurice",
"Maldives",
"Malawi",
"Mexique",
"Malaisie",
"Mozambique",
"Namibie",
"Nouvelle-Calédonie",
"Niger",
"Île Norfolk",
"Nigéria",
"Nicaragua",
"Pays-Bas",
"Norvège",
"Népal",
"Nauru",
"Niue",
"Nouvelle-Zélande",
"Oman",
"Panama",
"Pérou",
"Polynésie Française",
"Papouasie-Nouvelle-Guinée",
"Philippines",
"Pakistan",
"Pologne",
"Saint-Pierre-et-Miquelon",
"Pitcairn",
"Porto Rico",
"Palestine",
"Portugal",
"Belau",
"Paraguay",
"Qatar",
"La Réunion",
"Roumanie",
"Serbie",
"Russie",
"Rwanda",
"Arabie Saoudite",
"Îles Salomon",
"Seychelles",
"Soudan",
"Suède",
"Singapour",
"Sainte-Hélène",
"Slovénie",
"Svalbardet Jan Mayen",
"Slovaquie",
"Sierra Leone",
"Saint-Marin",
"Sénégal",
"Somalie",
"Suriname",
"Sud-Soudan",
"Sao Tomé et Principe",
"El Salvador",
"Saint-Martin (partie néerlandaise)",
"Syrie",
"Swaziland",
"Îles Turks et Caicos",
"Tchad",
"Territoires Français du Sud",
"Togo",
"Thaïlande",
"Tadjikistan",
"Tokelau",
"Timor-Leste",
"Turkménistan",
"Tunisie",
"Tonga",
"Turquie",
"Trinité-et-Tobago",
"Tuvalu",
"Taiwan",
"Tanzanie",
"Ukraine",
"Ouganda",
"Dépendances américaines du Pacifique",
"Etats-Unis",
"Uruguay",
"Ouzbékistan",
"Vatican",
"Saint-Vincent-et-les Grenadines",
"Vénézuela",
"Iles Vierges Britanniques",
"Iles Vierges Américaines",
"Vietnam",
"Vanuatu",
"Wallis-et-Futuna",
"Samoa",
"Yémen",
"Mayotte",
"Afrique du Sud",
"Zambie",
"Zimbabwe"};

                private Set<String> possible =new HashSet<>(Arrays.asList(countries));
               @FXML
               private TextField countrybox;
    
     
    
		
		

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TextFields.bindAutoCompletion(countrybox, possible);
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
                else   if(countrybox.getText().isEmpty())
                    { 
                        countrybox.setFocusTraversable(true);
                        countrybox.setFont(Font.font(20));
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
                u.setCountry(countrybox.getText());
                
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
    
