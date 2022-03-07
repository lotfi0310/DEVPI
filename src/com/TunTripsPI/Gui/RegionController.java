/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.entities.Region;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class RegionController implements Initializable {

    @FXML
    private ImageView myImageView;
    @FXML
    private Label txtNomRegion;
    private Region r;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
  
    }    
    
  private void buildGrid(GridPane grid, List<String> panelNames) {
    int row = 0;
    int col = 0;

    for (String name : panelNames) {
      Label label = new Label(name);
      Button btn = new Button("Click Me!");
      btn.setOnAction(event -> {
        event.consume();
        showAlert(grid.getScene().getWindow(), name);
      });

      VBox box = new VBox(10, label, btn);
      box.setPadding(new Insets(10));
      box.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)));
      box.setMinSize(10, 3);
      grid.add(box, col, row);

      if (++col > 3) {
        col = 0;
        row++;
      }
    }

  }

  private List<String> getPanelNames() {
    return IntStream.rangeClosed(0, 13)
        .mapToObj(i -> "Panel #" + i)
        .collect(Collectors.toList());
  }

  private void showAlert(Window owner, String panelName) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.initOwner(owner);
    alert.setTitle(panelName);
    alert.setHeaderText(null);
    alert.setContentText("Hello from \"" + panelName + "\"!");
    alert.show();
  }
    
    

}
