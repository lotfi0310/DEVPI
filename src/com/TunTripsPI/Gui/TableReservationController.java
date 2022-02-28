/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Gui;

import com.TunTripsPI.Utils.MyConnection_1;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Nidhal
 */
public class TableReservationController implements Initializable {

    
     Connection cnxx;
  public TableReservationController(){
       cnxx = MyConnection_1.getInstance().getCnx();
  }
    
    @FXML
    private TableView tablereservation;
  
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     fetColumnList();
        fetRowList();
   
    }   
    private ObservableList<ObservableList> data;
    String req = "SELECT * FROM reser_evenement";
     Statement st; 
    //only fetch columns
    private void fetColumnList() {

        try {
            st=cnxx.createStatement();
            ResultSet rs = st.executeQuery(req);

            //SQL FOR SELECTING ALL OF CUSTOMER
            for (int i = 0; i <rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1).toUpperCase());
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tablereservation.getColumns().removeAll(col);
                tablereservation.getColumns().addAll(col);

                System.out.println("Column [" + i + "] ");

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }
    }

    //fetches rows and data from the list
    private void fetRowList() {
        data = FXCollections.observableArrayList();
       
        try {
             st=cnxx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                //Iterate Row
                ObservableList row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);

            }

            tablereservation.setItems(data);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    }
    
    
    
    
    
    


