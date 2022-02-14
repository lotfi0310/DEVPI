/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Services;

import com.TunTripsPI.Utils.MyConnection_1;
import com.TunTripsPI.entities.Evenement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Nidhal
 */
public class EvenementCrud {

    Connection cnxx;

    public EvenementCrud() {
        cnxx = MyConnection_1.getInstance().getCnx();

    }
//*ajouter evenement

    public void ajouterEvenement(Evenement e) {

        String req = "INSERT INTO Evenement (nom,date_debut,date_fin,lieu,description) VALUES (?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);

            pst.setString(1, e.getNom());
            pst.setString(2, e.getDate_debut());
            pst.setString(3, e.getDate_fin());
            pst.setString(4, e.getLieu());
            pst.setString(5, e.getDescription());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void modifierEvenemenet(Evenement e) {
        String req = "UPDATE Evenement  nom=?,date_debut=?,date_fin=?,lieu=?,description=? WHERE id=?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, e.getNom());
            pst.setString(2, e.getDate_debut());
            pst.setString(3, e.getDate_fin());
            pst.setString(4, e.getLieu());
            pst.setString(5, e.getDescription());

            pst.setInt(6, e.getId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
 
public String countEvenement() {

        String req = "SELECT COUNT(*) FROM Evenement";
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
    
    public void supprimerEvenement(Evenement e) {

        String reqdelete = "DELETE FROM Evenement WHERE id=?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(reqdelete);
            pst.setInt(1, e.getId());
            pst.executeUpdate();
            System.out.println("evenement  supprimé");

        } catch (SQLException ex) {

            System.err.println(ex.getMessage());

        }

    }
/*
    public ArrayList<Evenement> consulterevenement(Evenement e) {
        ArrayList listevenement = new ArrayList();
        String reqevenement = "SELECT * FROM evenement WHERE id='" + e.getId() + "'";
        try {

            Statement st;
            st = cnxx.createStatement();
            ResultSet rs;
            st.executeQuery(reqevenement);
            rs = st.getResultSet();
            System.out.println(rs.next());

            Evenement ee = new Evenement(rs.getInt("id"), rs.getString("date_debut"), rs.getString("date_fin"), rs.getString("lieu"), rs.getString("description"));
            listevenement.add(ee);

            return listevenement;

        } catch (SQLException ex) {
            Logger.getLogger(EvenementCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listevenement;
    }
    /*
    
     public void modifierEvenement (Evenement E) {
        String req = "UPDATE Region SET date_debut=?, date_fin=?, lieu=? ,description=? WHERE lieu=?";
          PreparedStatement pst;
          try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, "bizerte");
            pst.setString(2, "rtrtrtrt");

            pst.setString(3, "C:\\Users\\Bizerte\\Pictures\\Saved Pictures\\img.jpg");
            pst.setString(4, "bizerte");

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
       

         
    } */

 /*modifier Evenement
    public void modifierEvenement(Evenement e) {
        String reqmodif = "UPDATE evenement SET date_debut='" + e.getDate_debut() + "',date_fin='" + e.getDate_fin() + "',lieu='" + e.getLieu() + "',description='" + e.getDescription() + "'";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(reqmodif);
            pst.executeUpdate(reqmodif);
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
       
    }
     */
 /*
//supprimer evenement
    public   void  SupprimerEvenement(String nom) {
        String reqdelete ;
        reqdelete = nom+"DELETE From evenement WHERE nom=";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(reqdelete);
            pst.executeUpdate(reqdelete);
           System.out.println("produit supprimé");
        } 
        catch (SQLException s) {
            s.getErrorCode();
            
           System.out.println("produit nom supprimé");

        }
        


    
    }
     */
}
