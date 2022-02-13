/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Services;

import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.entities.Reclamation;
import com.TunTripsPI.entities.User;
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
 * @author Lotfi
 */
public class ReclamationCrud {
    
    Connection cnxx;

    public ReclamationCrud() {
        
    cnxx = MyConnection.getInstance().getCnx();

    }

    public void ajouterReclamation(Reclamation r,User u) {

        String req = "INSERT INTO reclamation (id,contenu,date,etat) VALUES (?,?,?,?)";
        ResultSet rs;
     
        try {
            PreparedStatement pst;
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, u.getId());
            pst.setString(2,r.getContenu());
            pst.setDate(3,r.getDate_rec());
            pst.setBoolean(4,r.getEtat());
            pst.executeUpdate();
            rs=pst.getResultSet();
            System.out.println("Reclamation a été envoyer");
            
             
        } catch (SQLException ex) {
            System.out.println("reclamation n'est pas ajoutée");
        }

    }
     public ArrayList<Reclamation> AfficherUserReclamation(User u,Reclamation r){
         ArrayList<Reclamation> mesrec=new ArrayList<Reclamation>();
         String reqmesrec = "Select * From reclamation WHERE reclamation.id='"+u.getId()+"'";
         Statement st ; 
        try {
            st=cnxx.createStatement();
            st.executeQuery(reqmesrec);
            ResultSet rs=st.getResultSet();
            Reclamation re=new Reclamation();
            while (rs.next()){
                
            re.setIdreclamation(rs.getInt("idrec"));
            re.setIduser(rs.getInt("id"));
            re.setContenu(rs.getString("contenu"));
            re.setDate_rec(rs.getDate("date"));
            re.setEtat(rs.getBoolean("etat"));
            mesrec.add(re);
            
        }
            return mesrec;
        } catch (SQLException ex) {
            System.out.println("vous n'avez pas cree des reclamation ");        }
         
         
         
         return mesrec ;
         
     }
    
    
}
