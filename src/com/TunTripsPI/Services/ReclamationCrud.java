/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Services;

import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lotfi
 */
public class ReclamationCrud {
    
    Connection cnxx;

    public ReclamationCrud() {
        
    cnxx = MyConnection.getInstance().getCnx();

    }

    public void ajouterReclamation(Reclamation r) {

        String req = "INSERT INTO reclamtion (id,contenu,date,etat) VALUES (?,?,?,?) Where reclamation.id=user.id";
        PreparedStatement pst;
        ResultSet rs; 
        try {
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, r.getIdreclamation());
            pst.setString(2, r.getContenu());
            pst.setDate(3,r.getDate_rec());
            pst.setBoolean(4, r.getEtat());
           rs=pst.executeQuery();
           if(rs.rowInserted()){
           }
           else {
            System.out.println("reclamation ajoutéé avec sucées ");

           }
        } catch (SQLException ex) {
            System.err.println("user n'existe pas ");
            
        }

    }
    
    
}
