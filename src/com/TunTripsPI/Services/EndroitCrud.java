/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Services;

import com.TunTripsPI.Utils.MyConnection;

import com.TunTripsPI.entities.Endroit;
import com.TunTripsPI.entities.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oumaima
 */
public class EndroitCrud {

    Connection cnxx;

    public EndroitCrud() {

        cnxx = MyConnection.getInstance().getCnx();
    }
    // Ajouter categorie endroit

    public void ajouterEndroit(Endroit sce) {

        String req = "INSERT INTO Endroit (region_id,nom,type,description,longitude,latitude, numero, image ) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, sce.getRegionId());
            pst.setString(2, sce.getNom());
            pst.setString(3, sce.getType());
            pst.setString(4, sce.getDescription());
            pst.setFloat(5, sce.getLongitude());
            pst.setFloat(6, sce.getLatitude());
            pst.setInt(7, sce.getNumero());
            pst.setString(8, sce.getImage());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
 public void modifierEndroit(Endroit sce) {
        String req = "UPDATE Endroit SET nom=?,description=?,longitude=?,latitude=? WHERE id=?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
 
            pst.setString(1, sce.getNom());
          
            pst.setString(2, sce.getDescription());
            pst.setFloat(3, sce.getLongitude());
            pst.setFloat(4, sce.getLatitude());
           
            pst.setInt(5, sce.getId());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public void modifierEndroit2(Endroit sce) {
        String req = "UPDATE Endroit SET nom=?,type=?,description=?,longitude=?,latitude=?, numero=?, image=? WHERE id=?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
 
            pst.setString(1, sce.getNom());
            pst.setString(2, sce.getType());
            pst.setString(3, sce.getDescription());
            pst.setFloat(4, sce.getLongitude());
            pst.setFloat(5, sce.getLatitude());
            pst.setInt(6, sce.getNumero());
            pst.setString(7, sce.getImage());
            pst.setInt(8, sce.getRegionId());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void supprimerEndroit(Endroit sce) {

        String reqdelete = "DELETE FROM Endroit WHERE id=?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(reqdelete);
            pst.setInt(1, sce.getId());
            pst.executeUpdate();
            // System.out.println("region supprimé");

        } catch (SQLException ex) {

            System.err.println(ex.getMessage());

        }

    }

    public String countEndroit(Region re, Endroit e) {

        String req = "SELECT COUNT(*) FROM Endroit region_id='" + re.getId() + "'   AND type='" + e.getType() + "'    ";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);

            pst.executeQuery(req);
            ResultSet rs = pst.getResultSet();
            rs.next();
            return ("Table contains " + rs.getInt("count(*)") + " rows");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }

    }

    public ArrayList<Endroit> consulterListeEndroits(Region re) {
        ArrayList<Endroit> listEndroit = new ArrayList<Endroit>();

        String req =   "SELECT * FROM Endroit INNER JOIN Region  ON region_id='" + re.getId() + "'   ";              
        Statement st;
        try {

            st = cnxx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Endroit rr = new Endroit(rs.getInt("id"), rs.getString("nom"));
                listEndroit.add(rr);
            }
            return listEndroit;

        } catch (SQLException ex) {
            Logger.getLogger(RegionCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEndroit;
    }
    
    // afficher les endroits par type
    
      public ArrayList<Endroit> afficherEndroitsFiltré(Region re, Endroit e) {
        ArrayList<Endroit> listEndroit = new ArrayList<Endroit>();

        String req =   "SELECT * FROM Endroit WHERE region_id='" + re.getId() + "'   AND type='" + e.getType() + "'    ";               
        Statement st;
        try {
            
            st = cnxx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Endroit rr = new Endroit(rs.getInt("id"), rs.getString("nom"));
                listEndroit.add(rr);
            }
            return listEndroit;

        } catch (SQLException ex) {
            Logger.getLogger(RegionCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEndroit;
    }  
     
     
     
     
     
}
