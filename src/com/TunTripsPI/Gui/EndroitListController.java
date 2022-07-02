/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.entities.Endroit;
import com.TunTripsPI.entities.Region;
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
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class EndroitListController implements Initializable {

    @FXML
    private TableColumn<Endroit, Integer> cl_id;
    @FXML
    private TableColumn<Endroit, String> cl_nom;
    @FXML
    private TableColumn<Endroit, String> cl_action;
    @FXML
    private Button btnaj;
    @FXML
    private ComboBox comb;
    @FXML
    private TextField searchBox;
    @FXML
    private Button searchbtnclose;
  
    @FXML
    private Label lblType;
    
    @FXML
    private TableColumn<Endroit, String> cl_type;
    @FXML
    private TableView<Endroit> endroit_table;
    
        String query = null;
    Connection cnxx = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Endroit endroit = null;

      ObservableList<Endroit> EndroitList = FXCollections.observableArrayList(); 
      
 ObservableList<String> TypeList = FXCollections.observableArrayList("Monuments", "museum", "Cafes", "Restaurants ");
    @FXML
    private TextField txtregionid;
    
    int idd;
    @FXML
    private Button btnVillesEtCulture;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comb.setItems(TypeList);
        
         loadData();
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
        
    FilteredList<Endroit> filteredData = new FilteredList<>(FXCollections.observableList(EndroitList));
        endroit_table.setItems(filteredData);

        endroit_table.setRowFactory(tableView -> {
            TableRow<Endroit> row = new TableRow<>();
            row.pseudoClassStateChanged(PseudoClass.getPseudoClass("highlighted"), false);
            row.itemProperty().addListener((obs, oldOrder, newOrder) -> {
                boolean assignClass = filteredData.contains(newOrder) &&
                        (newOrder.getNom().equals("bizerte") ||
                                newOrder.getNom().equals("tunis"));

                row.pseudoClassStateChanged(PseudoClass.getPseudoClass("highlighted"), assignClass);
            });
            return row;
        });

        searchBox.textProperty().addListener((observable, oldValue, newValue) ->
                endroit_table.setItems(filterList(EndroitList, newValue.toLowerCase()))
        );
    }

    
    
    
    
    private Predicate<Endroit> createPredicate(String searchText){
        return order -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchFindsOrder(order, searchText);
        };
    }

    private ObservableList<Endroit> filterList(List<Endroit> list, String searchText){
        List<Endroit> filteredList = new ArrayList<>();

        for (Endroit e : list){
            if(searchFindsOrder(e, searchText)){
                filteredList.add(e);
            }
        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchFindsOrder(Endroit e, String searchText){
        return (e.getNom().toLowerCase().contains(searchText))  ;
    }
    
    
    private void handleExitButtonClicked(ActionEvent event) {
        Platform.exit();
        event.consume();
    }

   

    @FXML
    public void handleClearSearchText(ActionEvent event) {
        searchBox.setText("");
       // event.consume();
    }
    
    
    
  void setData  (int id) {
        txtregionid.setText(""+id);

    }
  
    
    
 public void refreshETable( int idd ) {
        try {
            EndroitList.clear();
            
             txtregionid.setText(""+idd);
                txtregionid.setText(""+idd);
           
            
            
            query = "SELECT * FROM endroit WHERE region_id_id = '"+idd+"' "  ;
            preparedStatement = cnxx.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EndroitList.add(new Endroit(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("type")));
                endroit_table.setItems(EndroitList);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadData() {

        cnxx = MyConnection.getInstance().getCnx();
        //refreshETable( idd);

        cl_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cl_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        cl_type.setCellValueFactory(new PropertyValueFactory<>("type"));

        //add cell of button edit 
        Callback<TableColumn<Endroit, String>, TableCell<Endroit, String>> cellFoctory = (TableColumn<Endroit, String> param) -> {
            // make cell containing buttons
            final TableCell<Endroit, String> cell = new TableCell<Endroit, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        Button deleteIcon = new Button("Supprimer");
                        Button editIcon = new Button("Modifier");

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"                               
                                + " -fx-background-color: #ffffff;"
                                + "-fx-background-radius: 5px;"
                                + " -fx-border-color: #bf3131;"
                                + "-fx-border-radius: 5px;"
                                + "  -fx-border-width: 2px;"
                                +"-fx-text-fill: #bf3131;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + " -fx-background-color:  #ffffff;"
                                + "-fx-background-radius: 5px;"
                                + " -fx-border-color: #186b41;"
                                + "-fx-border-radius: 5px;"
                                + "  -fx-border-width: 2px;"
                                +"-fx-text-fill: #186b41;"
                        );

                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {

                            try {
                                endroit = endroit_table.getSelectionModel().getSelectedItem();
                                query = "DELETE FROM endroit WHERE id  ='" + endroit.getId() + "' ";
                                cnxx = MyConnection.getInstance().getCnx();
                                preparedStatement = cnxx.prepareStatement(query);
                                preparedStatement.execute();

                            //   refreshETable(idd);

                            } catch (SQLException ex) {
                                Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });
                        
                        
                        editIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {

                            @Override
                            public void handle(MouseEvent event) {

                                FXMLLoader Loader = new FXMLLoader(getClass().getResource("ModifierEndroit.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    btnaj.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }

                                ModifierEndroitController alertBoxController = Loader.getController();
                                alertBoxController.setData( endroit_table.getSelectionModel().getSelectedItem().getId(),Integer.parseInt(txtregionid.getText()));
                                Parent p = Loader.getRoot();
                                Stage stage = new Stage();
                                stage.initStyle(StageStyle.TRANSPARENT);
                                stage.setScene(new Scene(p));
                                stage.show();

                            }
                      
                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        cl_action.setCellFactory(cellFoctory);
        endroit_table.setItems(EndroitList);

    }


    @FXML
    private void select(ActionEvent event) {
        
        String s = comb.getSelectionModel().getSelectedItem().toString();
        lblType.setText(s);
        
    }

    @FXML
    private void ajouterEndroit(ActionEvent event) {
         
      
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("AjouterEndroit.fxml"));
                                try {

                                    Parent root = Loader.load();

                                    btnaj.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }

                                AjouterEndroitController aController = Loader.getController();
                                aController.setData(Integer.parseInt(txtregionid.getText()));
                                Parent p = Loader.getRoot();
                                Stage stage = new Stage();
                                stage.initStyle(StageStyle.TRANSPARENT);
                                stage.setScene(new Scene(p));
                                stage.show();
    }

    @FXML
    private void listeDesRegions(ActionEvent event) {
        
          FXMLLoader Loader = new FXMLLoader(getClass().getResource("List.fxml"));
            try {         
            
                Parent root = Loader.load();
 
                btnaj.getScene().setRoot(root);  
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
    }

   
    
}
