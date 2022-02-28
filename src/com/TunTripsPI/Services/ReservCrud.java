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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public ReservCrud(String sDate7, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ajouterReservation(ReservEvenement R,Evenement e) {
        try { 
            
           String cap = evenementCapacite(e);
           int ii=Integer.parseInt(cap);
            if (ii >0){
                String requete = "INSERT INTO reser_evenement (Date_reservation,id_evenement,id_user)"
                    + "VALUES ('" + R.getDate_reservation() + "','" + R.getId_evenement() + "','" + R.getId_user() + " ')";
                String requete2 = "UPDATE Evenement SET capacite=capacite - 1 WHERE id=?";
        

            Statement st = MyConnection.getInstance().getCnx().createStatement();
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete2);
           pst.setDate(1,R.getDate_reservation());
         //   pst.setInt(2, e.getId());
            
            
            
            st.executeUpdate(requete);
            pst.executeUpdate();
            System.out.println("reservation ajoutée");
            
            }
            else if(ii==0){
               
                String requete3 = "UPDATE Evenement SET status='completo' WHERE id=?";
                PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete3);
                pst.setInt(1, e.getId());
                 pst.executeUpdate();
                 System.out.println("pas disponible");
            }
            
           

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimerReservation(ReservEvenement R) {
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
            return ("le nombre de reservation est  " + rs.getInt("count(*)") + " rows");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    
    
    
    
    
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
