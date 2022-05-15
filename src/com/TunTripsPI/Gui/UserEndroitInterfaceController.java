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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class UserEndroitInterfaceController implements Initializable {

    @FXML
    private Button btnVillesEtCulture;
    @FXML
    private Label typeEndroit;
    @FXML
    private Label nomRegion;
    @FXML
    private VBox vboxx;
    String t;
    String r;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void selectEndroits(int idreg, String typee, String regnom) {
        Connection cnxx = MyConnection.getInstance().getCnx();
        String req = "SELECT * FROM endroit WHERE region_id ='" + idreg + "'  AND type ='" + typee + "'";
        List<HBox> Endroitslistfiltré = new ArrayList<>();
        String t = typee;
        String r = regnom;

        PreparedStatement pst;
        try {

            pst = cnxx.prepareStatement(req);

            ResultSet resulSet = pst.executeQuery();
            while (resulSet.next()) {

                InputStream inputStream = new ByteArrayInputStream(resulSet.getBytes("image"));

                Image img = new Image(inputStream);
                BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background background = new Background(backgroundImage);

                HBox content = new HBox();
                Button button = new Button();
                Button btnmap = new Button("Visualiser en map");

                btnmap.setPrefSize(150, 50);

                Label lbl = new Label(resulSet.getString("description"));
                lbl.setWrapText(true);
                lbl.setTextAlignment(TextAlignment.JUSTIFY);
                content.setPrefWidth(150);
                lbl.setPrefWidth(600);
                lbl.setPrefHeight(200);

                btnmap.setStyle(
                        " -fx-background-color: transparent;    -fx-background-radius: 5px;    -fx-border-color: #401317;    -fx-border-radius: 5px;-fx-border-width: 1px;    -fx-text-fill: #401317;");

                content.getChildren().addAll(button, lbl, btnmap);
                content.setSpacing(30);

                button.setPrefWidth(200);
                button.setPrefHeight(200);

                button.setBackground(background);

                Font font = new Font(50); //Button font's size should increase to 50
                button.setFont(font);
                //button.setStyle("-fx-text-fill: #ffffff ");
                content.setStyle("-fx-border-color: #401317 ;-fx-border-width: 1 ; -fx-text-fill: #401317 ");

                Endroitslistfiltré.add(content);

                typeEndroit.setText("|  " + t);
                nomRegion.setText(r);

                /**
                 * *******************************************************************************
                 */
            }
            vboxx.getChildren().clear(); //remove all images that are currently in the container
            vboxx.getChildren().addAll(Endroitslistfiltré); //then add all your images that you just created

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

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

    void setdata(int id, String ty, String nom) {
        typeEndroit.setText("|  " + ty);
        nomRegion.setText(nom);

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
    private void Acceuil(ActionEvent event) {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
        try {

            Parent root = Loader.load();

            vboxx.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
