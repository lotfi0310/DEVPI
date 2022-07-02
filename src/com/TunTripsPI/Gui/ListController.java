/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.entities.Endroit;
import com.TunTripsPI.entities.Region;
import java.io.IOException;
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
import javafx.application.Application;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
 
/**
 * FXML Controller class
 *
 * @author Oumaima
 */
public class ListController implements Initializable {

    private List<Region> regions;
    @FXML
    private TableView<Region> region_table;
    @FXML
    private TableColumn<Region, Integer> cl_id;
    @FXML
    private TableColumn<Region, String> cl_nom;
    @FXML
    private TableColumn<Region, String> cl_desc;
    @FXML
    private TableColumn<Region, String> cl_action;

    String query = null;
    Connection cnxx = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Region region = null;

    ObservableList<Region> RegionList = FXCollections.observableArrayList();
    
    @FXML
    private Button btnaj;
    @FXML
    private TextField searchBox;
    @FXML
    private Button btnVillesEtCulture;
    @FXML
    private Button searchbtnclose;
    @FXML
    private FontAwesomeIcon close;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        loadData();

 FilteredList<Region> filteredData = new FilteredList<>(FXCollections.observableList(RegionList));
        region_table.setItems(filteredData);

        region_table.setRowFactory(tableView -> {
            TableRow<Region> row = new TableRow<>();
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
                region_table.setItems(filterList(RegionList, newValue.toLowerCase()))
        );
    }

    
    
    
    
    private Predicate<Region> createPredicate(String searchText){
        return order -> {
            if (searchText == null || searchText.isEmpty()) return true;
            return searchFindsOrder(order, searchText);
        };
    }

    private ObservableList<Region> filterList(List<Region> list, String searchText){
        List<Region> filteredList = new ArrayList<>();

        for (Region r : list){
            if(searchFindsOrder(r, searchText)){
                filteredList.add(r);
            }
        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchFindsOrder(Region r, String searchText){
        return (r.getNom().toLowerCase().contains(searchText))  ;
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void close(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void refreshTable() {
        try {
            RegionList.clear();

            query = "SELECT * FROM region";
            preparedStatement = cnxx.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RegionList.add(new Region(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("description")));
                region_table.setItems(RegionList);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadData() {

        cnxx = MyConnection.getInstance().getCnx();
        refreshTable();

        cl_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cl_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        cl_desc.setCellValueFactory(new PropertyValueFactory<>("description"));

        //add cell of button edit 
        Callback<TableColumn<Region, String>, TableCell<Region, String>> cellFoctory = (TableColumn<Region, String> param) -> {
            // make cell containing buttons
            final TableCell<Region, String> cell = new TableCell<Region, String>() {
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
                                region = region_table.getSelectionModel().getSelectedItem();
                                query = "DELETE FROM Region WHERE id  ='" + region.getId() + "' ";
                                cnxx = MyConnection.getInstance().getCnx();
                                preparedStatement = cnxx.prepareStatement(query);
                                preparedStatement.execute();

                                refreshTable();

                            } catch (SQLException ex) {
                                Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });
                        
                        editIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {

                            @Override
                            public void handle(MouseEvent event) {

                                try {
                                    
                                    FXMLLoader Loader = new FXMLLoader(getClass().getResource("ModifierRegion.fxml"));
                                    try {
                                        
                                        Parent root = Loader.load();
                                        
                                        btnaj.getScene().setRoot(root);
                                    } catch (IOException ex) {
                                        System.out.println("Error: " + ex.getMessage());
                                    }
                                    
                                    ModifierRegionController alertBoxController = Loader.getController();
                                    alertBoxController.setData(region_table.getSelectionModel().getSelectedItem().getNom(),
                                            region_table.getSelectionModel().getSelectedItem().getDescription(),
                                            region_table.getSelectionModel().getSelectedItem().getId());
                                    Parent p = Loader.getRoot();
                                    Stage stage = new Stage();
                                    stage.initStyle(StageStyle.TRANSPARENT);
                                    stage.setScene(new Scene(p));
                                    stage.show();
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            }
                            /*
                            region = region_table.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("ModifierRegion.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                      
                            ModifierRegionController addStudentController = loader.getController();
                            //addStudentController.setUpdate(true);
                            addStudentController.setData( region.getNom(),region.getDescription(),region.getId());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                             */

                        });
                        /*
                         region_table.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                
                
           FXMLLoader Loader = new FXMLLoader(getClass().getResource("EndroitList.fxml"));
            try {         
            
                Parent root = Loader.load();
 
                btnaj.getScene().setRoot(root);  
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
              
                EndroitListController el = Loader.getController();
                el.refreshETable( region_table.getSelectionModel().getSelectedItem().getId());
                Parent p = Loader.getRoot();
                //el.setIdReg(region_table.getSelectionModel().getSelectedItem().getId());
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(new Scene(p));
                stage.show();
                
                
                
            }
                    
        });   */
             region_table.setOnMousePressed(new EventHandler<MouseEvent>() {
    @Override 
    public void handle(MouseEvent event) {
        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
               FXMLLoader Loader = new FXMLLoader(getClass().getResource("EndroitList.fxml"));
            try {         
            
                Parent root = Loader.load();
 
                btnaj.getScene().setRoot(root);  
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            EndroitListController el = Loader.getController();
                el.refreshETable( region_table.getSelectionModel().getSelectedItem().getId());
                Parent p = Loader.getRoot();
                
                Stage stage = new Stage();
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.setScene(new Scene(p));
                stage.show();
                
                                      
        }
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
        region_table.setItems(RegionList);

    }

    @FXML
    private void ajouterRegion(ActionEvent event) {
         
          FXMLLoader Loader = new FXMLLoader(getClass().getResource("AjouterUneRegion.fxml"));
            try {         
            
                Parent root = Loader.load();
 
                btnaj.getScene().setRoot(root);  
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
    }

    @FXML
    private void listDesRegions(ActionEvent event) {
          
          FXMLLoader Loader = new FXMLLoader(getClass().getResource("List.fxml"));
            try {         
            
                Parent root = Loader.load();
 
                btnaj.getScene().setRoot(root);  
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
    }

}
