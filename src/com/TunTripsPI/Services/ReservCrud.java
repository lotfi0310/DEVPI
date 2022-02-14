/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Services;

import com.TunTripsPI.Utils.MyConnection_1;
import com.TunTripsPI.entities.Evenement;
import com.TunTripsPI.entities.ReservEvenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nidhal
 */
public class ReservCrud {

    Connection cnxx;

    public ReservCrud() {
        cnxx = MyConnection_1.getInstance().getCnx();

    }
//*ajouter evenement

    public void ajouterReservEvenement(ReservEvenement e) {

        String req = "INSERT INTO ReservEvenement(nomreservation,prix,date_reserv) VALUES (?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);

           pst.setString(1, e.getNomreservation());
            pst.setDouble(2, e.getPrix());
            pst.setString(3, e.getDate_reserv());
           
           

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    
    //modifier 
    public void modifierRESEV(ReservEvenement e) {
        String req = "UPDATE ReservEvenement SET nomreservation=?,prix=?,date_reserv=? WHERE id=?";
      
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, e.getNomreservation());
            pst.setDouble(2,e.getPrix());
            pst.setString(3, e.getDate_reserv());


 
            pst.setInt(4, e.getId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     public void supprimerRESEV(ReservEvenement e) {
        
        String reqdelete = "DELETE FROM ReservEvenement WHERE id=?" ;
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(reqdelete);
            pst.setInt(1, e.getId());
            pst.executeUpdate();
           System.out.println("ReservEvenement supprimé");
            
        } catch (SQLException ex) {
            
            System.err.println(ex.getMessage());

        }

    }
      public String countRESEvenement() {

        String req = "SELECT COUNT(*) FROM ReservEvenement";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.executeQuery(req);
            ResultSet rs = pst.getResultSet();
            rs.next();
            return ("le nombre de reservation est  " + rs.getInt("count(*)") + " rows");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }

    }


}
    
  