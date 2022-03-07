/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Services;

import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.entities.Evenement;
import com.TunTripsPI.entities.ReservEvenement;
import com.TunTripsPI.entities.Reservation;
import com.TunTripsPI.entities.User;
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
public class ReservCrud {

    Connection cnxx;

    public ReservCrud() {
        cnxx = MyConnection.getInstance().getCnx();

    }
//*ajouter evenement

    public ReservCrud(String sDate7, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  public boolean ajouterReservation(ReservEvenement R,Evenement e) {
        try { 
           String cap = evenementCapacite(e);
           int ii=Integer.parseInt(cap); 
            if (ii >0){
                String requete = "INSERT INTO reser_evenement (Date_reservation,id_even,id_user)"
                    + "VALUES ('" + R.getDate_reservation() + "','" + R.getId_evenement() + "','" + R.getId_user() + " ')";
                String requete2 = "UPDATE Evenement SET capacite=capacite-1 WHERE id=?";
        

            Statement st = MyConnection.getInstance().getCnx().createStatement();
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete2);
            pst.setInt(1,e.getId());
                if (st.executeUpdate(requete) != 0 && pst.executeUpdate()!=0 ){
                return (true);}else{ return (false);}}
                else{
                System.out.println(ii);
                String requete3 = "UPDATE Evenement SET status='completo' WHERE id=?";
                PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete3);
                pst.setInt(1, e.getId());
                pst.executeUpdate();
                return false;            }
        } catch (SQLException ex) {
            return(false);
        }
    }

    public void supprimerReservation(Reservation R) {
        try {
            String requete = "DELETE FROM reser_evenement where id_reser=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, R.getId());
            pst.executeUpdate();
            System.out.println("reser_evenement supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void updateReservation(ReservEvenement R) {
        try {
            //
               String requete = "UPDATE reser_evenement Inner JOIN user ON reser_evenement.id_user=user.id INNER JOIN evenement ON reser_evenement.id_evenement=evenement.id SET Date_reservation=? WHERE reser_evenement.id_reser=?; ";
           // String requete = "UPDATE reser_evenement  SET Date_reservation=?  WHERE id_user=? and id_evenement=?" + R.getDate_reservation() + R.getId_user() + R.getId_evenement();
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);

            pst.setDate(1, R.getDate_reservation());
            pst.setInt(2,R.getId());

            pst.executeUpdate();
            System.out.println("  reservation modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
      public String countRESEvenement() {

        String req = "SELECT COUNT(*) FROM reser_evenement";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.executeQuery(req);
            ResultSet rs = pst.getResultSet();
            rs.next();
            return ("   " + rs.getInt("count(*)") + " ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    
      }
    public ArrayList<Reservation> consulterReservation() {
         ResultSet rs ;
        ArrayList<Reservation> listReservation = new ArrayList<Reservation>();
       String req = "SELECT u.nom,u.prenom,u.email,e.nom,e.date_debut,e.date_fin FROM user u,evenement e,reser_evenement r where u.id=r.id_user and e.id=r.id_evenement; ";
        Statement st;
        try {

            st = cnxx.createStatement();
           rs= st.executeQuery(req);

            while (rs.next()) {
                
                
                
                 Reservation r = new Reservation();
                r.setNomutilisateur(rs.getString("u.nom"));
                r.setPrenomutilisateur(rs.getString("u.prenom"));
                r.setEmailutilisateur(rs.getString("u.email"));
                r.setNom_evenement(rs.getString("e.nom"));
                r.setDate_debut_evenement(rs.getDate("e.date_debut"));
                  r.setDate_fin_evenement(rs.getDate("e.date_fin"));
           
           
                 

                listReservation.add(r);
                
            }
          return  listReservation;

        } catch (Exception ex) {
            System.out.print("erreur" +ex);
         //   Logger.getLogger(Evenement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listReservation;
    }
       
       
       
    

      
      
        public String evenementCapacite(Evenement e) {
        
        String req = "SELECT capacite FROM evenement WHERE id='" + e.getId() + "'";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.executeQuery(req);
            ResultSet rs = pst.getResultSet();
            rs.next();
            return rs.getString("capacite") ;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
        }
}
       
        
        
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
        /*public ArrayList<ReservEvenement> consulterReservation() {
         ResultSet rs ;
        ArrayList<ReservEvenement> listReservation = new ArrayList<ReservEvenement>();
    /    String req = "SELECT * FROM reser_evenement";
        Statement st;
        try {

            st = cnxx.createStatement();
           rs= st.executeQuery(req);

            while (rs.next()) {
                 ReservEvenement r = new ReservEvenement();
                r.setId(rs.getInt("id_reser"));
                r.setId_evenement(rs.getInt("id_evenement"));
                r.setId_user(rs.getInt("id_user"));
                 r.setDate_reservation(rs.getDate("Date_reservation"));
           
                 

                listReservation.add(r);
                
            }
          return  listReservation;

        } catch (Exception ex) {
            System.out.print("erreur" +ex);
         //   Logger.getLogger(Evenement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listReservation;
    }*/
       
       
       
       
       
       
       
       
    


/*
    public void modifierRESEV(ReservEvenement e) {
        String req = "UPDATE ReservEvenement SET nomreservation=?,prix=?,date_reserv=? WHERE id=?";

        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, e.getDate_reservation());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
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
    
 */
