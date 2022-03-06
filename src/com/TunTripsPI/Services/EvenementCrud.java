/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Services;

import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.Utils.MyConnection_1;
import com.TunTripsPI.entities.Evenement;
import com.TunTripsPI.entities.ReservEvenement;
import static com.mysql.jdbc.Messages.getString;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

        String req = "INSERT INTO Evenement (nom,date_debut,date_fin,lieu,description,status,capacite) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);

            pst.setString(1, e.getNom());
            pst.setDate(2, e.getDate_debut());
            pst.setDate(3, e.getDate_fin());
            pst.setString(4, e.getLieu());
            pst.setString(5, e.getDescription());
            pst.setString(6, e.getStatus());
           // pst.setString(7, e.getImage());
            pst.setInt(7, e.getCapacite());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void modifierEvenemenet(Evenement e) {
        String req = "UPDATE Evenement SET nom=?,date_debut=?,date_fin=?,lieu=?,description=?,status=?,capacite=? WHERE id=?";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, e.getNom());
            pst.setDate(2, e.getDate_debut());
            pst.setDate(3, e.getDate_fin());
            pst.setString(4, e.getLieu());
            pst.setString(5, e.getDescription());
            pst.setString(6, e.getStatus());
        

            pst.setInt(8, e.getCapacite());
            pst.setInt(9, e.getId());
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
            return ("  " + rs.getInt("count(*)") + " evenement");
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

    public ArrayList<Evenement> recherche(String nom) {

        ArrayList<Evenement> EvenementList = new ArrayList<Evenement>();
        try {
            String requete = "select * from Evenement where nom='" + nom + "'";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Evenement r = new Evenement();
                r.setId(rs.getInt("id"));
                r.setDate_debut(rs.getDate("date_debut"));
                r.setDate_fin(rs.getDate("date_fin"));
                r.setCapacite(rs.getInt("capacite"));
                r.setDescription(rs.getNString("description"));
              
        //      r.setImage(rs.getString("image"));
                r.setLieu(rs.getNString("lieu"));
                r.setStatus(rs.getNString("status"));

                EvenementList.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return EvenementList;
    }

    /*
      public String Disponibilite(Evenement E) {

      
    

    }
     */
 
    public ArrayList<Evenement> consulterEvenement() {
         ResultSet rs ;
        ArrayList<Evenement> listEvenement = new ArrayList<Evenement>();
        String req = "SELECT * FROM Evenement";
        Statement st;
        try {

            st = cnxx.createStatement();
           rs= st.executeQuery(req);

            while (rs.next()) {
                 Evenement r = new Evenement();
                r.setId(rs.getInt("id"));
                r.setNom(rs.getString("nom"));
                 r.setStatus(rs.getString("status"));
                 r.setDate_debut(rs.getDate("date_debut"));
                r.setDate_fin(rs.getDate("date_fin"));
                
              
                r.setLieu(rs.getString("lieu"));
               
                  r.setDescription(rs.getString("description"));
               //   r.setImage(rs.getString("image"));
                     r.setCapacite(rs.getInt("capacite"));

                listEvenement.add(r);
                
            }
          return  listEvenement;

        } catch (Exception ex) {
            System.out.print("erreur" +ex);
         //   Logger.getLogger(Evenement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listEvenement;
    }
    ///
    
    
    
    /*  public ObservableList<Evenement> afficherEvenement(){
ObservableList<Evenement> Evenement = FXCollections.observableArrayList();
String sql="select * from evenement";
 Statement st;
        try {
             st = cnxx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Evenement ev = new Evenement();
                ev.setId(rs.getInt("id"));
                ev.setNom(rs.getString("nom"));
               ev.setStatus(rs.getString("status"));
                ev.setDate_debut(rs.getDate("date_debut"));
                ev.setDate_fin(rs.getDate("date_fin"));
                 ev.setLieu(rs.getString("lieu"));
                  ev.setDescription(rs.getString("description"));
                  ev.setImage(rs.getString("image"));
                  ev.setCapacite(rs.getInt("capacite"));
             
                Evenement.add(ev);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return Evenement;
    }
    
     public ArrayList<Evenement> afficherEvenementFiltré(String n) {
        ArrayList<Evenement> liEvenement= new ArrayList<Evenement>();

        String req =   "SELECT id,nom FROM Evenement WHERE nom='" + n + "'    ";               
        Statement st;
        try {
            
            st = cnxx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
               Evenement rr = new Evenement(rs.getInt("id"),rs.getString("nom"));
                liEvenement.add(rr);
            }
            return liEvenement;

        } catch (SQLException ex) {
            Logger.getLogger(EvenementCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liEvenement;
    }  
     
     

 /*  public void modifierEvenement(Evenement E) {
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

    }



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
    
    
    
    
    
    
    public ArrayList<Region> consulterRegion(){
         ArrayList<Region> listRegion  = new ArrayList<Region>();
         String req="SELECT * FROM region" ;
         Statement st; 
        try {
            
         
            st=cnxx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            
                    while(rs.next()){
                          Region rr = new Region(rs.getInt("id"),rs.getString("nom"),rs.getString("description"),rs.getString("photo"));
                           listRegion.add(rr);
                    }
                      return listRegion;

        } catch (SQLException ex) {
            Logger.getLogger(RegionCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRegion;
    }
     */

    public void ajouterEvenement(ReservEvenement re) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
