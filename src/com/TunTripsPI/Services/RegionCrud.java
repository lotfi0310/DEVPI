/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Services;

import com.TunTripsPI.entities.Region;

import com.TunTripsPI.Utils.MyConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
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
public class RegionCrud {

    Connection cnxx;

    public RegionCrud() {
        cnxx = MyConnection.getInstance().getCnx();

    }

    public void ajouterRegion(Region r)  {

        String req = "INSERT INTO Region (nom,description,photo) VALUES (?,?,?)";
        PreparedStatement pst;
       
        try {
            pst = cnxx.prepareStatement(req);
          //  String s = null;
           // InputStream is ;
          //  is = new FileInputStream(new File(s));
            pst.setString(1, r.getNom());
            pst.setString(2, r.getDescription());

            pst.setBlob(3, r.getImage());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void modifierRegion(Region r) {
        String req = "UPDATE Region SET nom=?, description=? WHERE id=?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, r.getNom());
            pst.setString(2, r.getDescription());

          //  pst.setBlob(3, r.getImage());
             pst.setInt(3, r.getId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

   
    

    public void supprimerRegion(Region r) {

        String reqdelete = "DELETE FROM region WHERE id=?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(reqdelete);
            pst.setInt(1, r.getId());
            pst.executeUpdate();
            // System.out.println("region supprimé");

        } catch (SQLException ex) {

            System.err.println(ex.getMessage());

        }

    }

    
  
     public ArrayList<Region> consulterRegion(){
         ArrayList<Region> listRegion  = new ArrayList<Region>();
         String req="SELECT id,nom,description FROM region" ;
         Statement st; 
        try {
            
         
            st=cnxx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            
                    while(rs.next()){
                          Region rr = new Region(rs.getInt("id"),rs.getString("nom"),rs.getString("description"));
                                  //,rs.getString("description"),rs.getBlob("photo"));
                           listRegion.add(rr);
                    }
                      return listRegion;

        } catch (SQLException ex) {
            Logger.getLogger(RegionCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRegion;
    }

    public void ajouterRegion(String nom, String description, Blob image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
}
