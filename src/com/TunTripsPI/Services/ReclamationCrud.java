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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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

    public void ajouterReclamationEvent(Reclamation r, User u) {

        String req = "INSERT INTO reclamation (id,contenu,date,etat,idevent) VALUES (?,?,?,?,?)";
        ResultSet rs;

        try {
            PreparedStatement pst;
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, u.getId());
            pst.setString(2, r.getContenu());
            pst.setDate(3, r.getDate_rec());
            pst.setBoolean(4, r.getEtat());
            pst.setInt(5,r.getIdevent());
           
            
            
            pst.executeUpdate();
            rs = pst.getResultSet();
            System.out.println("Reclamation a été envoyer");

        } catch (SQLException ex) {
            System.out.println("reclamation n'est pas ajoutée");
        }

    }
      public void ajouterReclamationHeberg(Reclamation r, User u) {

        String req = "INSERT INTO reclamation (id,contenu,date,etat,idheberg) VALUES (?,?,?,?,?)";
        ResultSet rs;

        try {
            PreparedStatement pst;
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, u.getId());
            pst.setString(2, r.getContenu());
            pst.setDate(3, r.getDate_rec());
            pst.setBoolean(4, r.getEtat());
            pst.setInt(5,r.getIdheberg());
           
            
            
            pst.executeUpdate();
            rs = pst.getResultSet();
            System.out.println("Reclamation a été envoyer");

        } catch (SQLException ex) {
            System.out.println("reclamation n'est pas ajoutée");
        }

    }
      public void ajouterReclamationTransport(Reclamation r, User u) {

        String req = "INSERT INTO reclamation (id,contenu,date,etat,idtransport) VALUES (?,?,?,?,?)";
        ResultSet rs;

        try {
            PreparedStatement pst;
            pst = cnxx.prepareStatement(req);
            pst.setInt(1, u.getId());
            pst.setString(2, r.getContenu());
            pst.setDate(3, r.getDate_rec());
            pst.setBoolean(4, r.getEtat());
            pst.setInt(5,r.getIdtransport());
           
            
            pst.executeUpdate();
            rs = pst.getResultSet();
            System.out.println("Reclamation a été envoyer");

        } catch (SQLException ex) {
            System.out.println("reclamation n'est pas ajoutée");
        }

    }

    //modifier mon reclamation
    public boolean traiterReclamationUser(Reclamation r) {
        int verf = 0;
        try {
            String reqmurec;
            reqmurec = "UPDATE reclamation set etat=true where idrec=?";
            PreparedStatement res = cnxx.prepareStatement(reqmurec);

            res.setInt(1, r.getIdreclamation());
            verf = res.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Reclamation.class.getName()).log(Level.SEVERE, null, e);
        }
        if (verf == 0) {
            return false;
        } else {
            return true;
        }
    }
    //modifier l'etat de user reclamation comme traiter  du part d 'admin

   

    //afficher les reclamation d un utilisateurs sur event
    public ArrayList<Reclamation> AfficherUserReclamation(User u) {

        ArrayList<Reclamation> mesrec = new ArrayList<Reclamation>();
        String reqmesrec = "SELECT * FROM reclamation WHERE id='"+u.getId()+"'";
        Statement st;
        try {
            st = cnxx.createStatement();
            ResultSet rs = st.executeQuery(reqmesrec);

            while (rs.next()) {
                 Reclamation re = new Reclamation(rs.getInt("idrec"), rs.getInt("id"),rs.getInt("idevent"),rs.getInt("idheberg"),rs.getInt("idtransport"),rs.getString("contenu"),rs.getDate("date"), rs.getBoolean("etat"));
                mesrec.add(re);
            }

            return mesrec;
        } catch (SQLException ex) {
            System.out.println("vous n'avez pas cree des reclamation ");
        }

        return mesrec;

    }
//admin filter sur event
    public ArrayList<Reclamation> AfficherEventtReclamation() {

        ArrayList<Reclamation> mesrec = new ArrayList<Reclamation>();
        String reqmesrec = "SELECT * FROM reclamation INNER JOIN user ON reclamation.id=user.id INNER JOIN evenement ON reclamation.idevent=evenement.idevent ";
        Statement st;
        try {
            st = cnxx.createStatement();
            ResultSet rs = st.executeQuery(reqmesrec);

            while (rs.next()) {
               
                Reclamation re = new Reclamation(rs.getInt("idrec"), rs.getInt("id"),rs.getInt("idevent"),rs.getInt("idheberg"),rs.getInt("idtransport"),rs.getString("contenu"),rs.getDate("date"), rs.getBoolean("etat"));
                mesrec.add(re);
            }

            return mesrec;
        } catch (SQLException ex) {
            System.out.println("vous n'avez pas cree des reclamation ");
        }

        return mesrec;

    }
    public String DisplayMailClient(Reclamation r ){
        String email="" ;
        MyConnection m = MyConnection.getInstance(); 
        
        String demandemailreq = "SELECT email FROM user WHERE id='"+r.getIduser()+"'";
        Statement st;
        try {
            st = cnxx.createStatement();
            ResultSet rs = st.executeQuery(demandemailreq);

            if(rs.first()) {
                 email=rs.getString(1);
                 System.out.println(email);
            }

           
        } catch (SQLException ex) {
            System.out.println("error ");
        }
return email ;
       
    }
// afficher reclamation hebergement
    public ArrayList<Reclamation> AfficherHebergtReclamation() {

        ArrayList<Reclamation> mesrec = new ArrayList<Reclamation>();
        String reqmesrec = "SELECT * FROM reclamation INNER JOIN user ON reclamation.id=user.id INNER JOIN hebergement ON reclamation.idheberg=hebergement.idheberg ";
        Statement st;
        try {
            st = cnxx.createStatement();
            ResultSet rs = st.executeQuery(reqmesrec);

            while (rs.next()) {
               
                Reclamation re = new Reclamation(rs.getInt("idrec"), rs.getInt("id"),rs.getInt("idevent"),rs.getInt("idheberg"),rs.getInt("idtransport"),rs.getString("contenu"),rs.getDate("date"), rs.getBoolean("etat"));
                mesrec.add(re);
            }

            return mesrec;
        } catch (SQLException ex) {
            System.out.println("vous n'avez pas cree des reclamation ");
        }

        return mesrec;

    }// afficher reclamation transport
    public ArrayList<Reclamation> AfficherTransportReclamation() {

        ArrayList<Reclamation> mesrec = new ArrayList<Reclamation>();
        String reqmesrec = "SELECT * FROM reclamation INNER JOIN user ON reclamation.id=user.id INNER JOIN transport ON reclamation.idtransport=transport.idtransport ";
        Statement st;
        try {
            st = cnxx.createStatement();
            ResultSet rs = st.executeQuery(reqmesrec);

            while (rs.next()) {
               
                Reclamation re = new Reclamation(rs.getInt("idrec"), rs.getInt("id"),rs.getInt("idevent"),rs.getInt("idheberg"),rs.getInt("idtransport"),rs.getString("contenu"),rs.getDate("date"), rs.getBoolean("etat"));
                mesrec.add(re);
            }

            return mesrec;
        } catch (SQLException ex) {
            System.out.println("vous n'avez pas cree des reclamation ");
        }

        return mesrec;

    }
    
//admin consulte all Reclam

    public List<Reclamation> DisplayAllReclamation() {

        ArrayList<Reclamation> mesrec = new ArrayList<Reclamation>();
        String reqmesrec = "SELECT * FROM reclamation ";
        Statement st;
        try {
            st = cnxx.createStatement();
            ResultSet rs = st.executeQuery(reqmesrec);

            while (rs.next()) {
               Reclamation re = new Reclamation(rs.getInt("idrec"), rs.getInt("id"),rs.getInt("idevent"),rs.getInt("idheberg"),rs.getInt("idtransport"),rs.getString("contenu"),rs.getDate("date"), rs.getBoolean("etat"));
                mesrec.add(re);
                System.out.println(re);
                
            }
            return mesrec;
        } catch (SQLException ex) {
            System.out.println("il y'a pas  des reclamation a traiter ");
        }

        return mesrec;

    }

    public int countReclamation() {
        int j = 0;
        try {
            Statement st = cnxx.createStatement();
            ResultSet rs;
            boolean b=true;
            rs = st.executeQuery("SELECT COUNT(*) FROM reclamation where etat='"+b+"'");
            rs.next();
            j = rs.getInt(1);
        } catch (SQLException e) {
            e.getMessage();
        }
        return j;
    }
    
    

    public boolean SupprimerReclamation(Reclamation r) {
        try {
            Statement st;
            String req = "DELETE FROM reclamation WHERE idrec='" + r.getIdreclamation() + "' ";
            st = cnxx.createStatement();
            st.executeUpdate(req);
            System.out.println("supprimer avec succee");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Reclamation.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }

    }


}
