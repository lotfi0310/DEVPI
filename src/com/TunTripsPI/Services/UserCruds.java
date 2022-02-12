package com.TunTripsPI.Services;

import com.TunTripsPI.entities.User;
import com.TunTripsPI.Utils.MyConnection;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lotfi
 */
public class UserCruds {

    Connection cnxx;

    public UserCruds() {
        cnxx = MyConnection.getInstance().getCnx();

    }

    public void ajouterUser(User u) {

        String req = "INSERT INTO User (nom,prenom,email,passwd,nationalite,role,photo) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setString(1, u.getNom());
            pst.setString(2, u.getPrenom());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getPasswd());
            pst.setString(5, u.getNationalite());
            pst.setString(6, u.getRole());
            pst.setString(7, u.getPhoto());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    //modifier info user 
    public boolean modifierUser(User u) {
        String reqmodif = "UPDATE user SET nom='" + u.getNom() + "',prenom='" + u.getPrenom() + "',email='" + u.getEmail() + "',passwd='" + u.getPasswd() + "',photo='" + u.getPhoto() + "' WHERE user.id='" + u.getId() + "'";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(reqmodif);
            pst.executeUpdate(reqmodif);
            return true;
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
        return false;
    }
//supprimer compte user

    public boolean SupprimerUser(User u) {
        String reqdelete = "DELETE From user WHERE id='" + u.getId() + "'";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(reqdelete);
            pst.executeUpdate(reqdelete);
            return true;
        } catch (SQLException e) {
            e.getErrorCode();

        }
        return false;

    }
//consulter mes info

    public ArrayList<User> consulterinfo(User u) {
        ArrayList listinfo = new ArrayList();
        String reqinfoprofil = "SELECT * FROM user WHERE id='" + u.getId() + "'";
        try {

            Statement st;
            st = cnxx.createStatement();
            ResultSet rs;
            st.executeQuery(reqinfoprofil);
            rs = st.getResultSet();
            System.out.println(rs.next());

            User uu = new User(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("passwd"), rs.getString("nationalite"), rs.getString("role"), rs.getString("photo"));
            listinfo.add(uu);

            return listinfo;

        } catch (SQLException ex) {
            Logger.getLogger(UserCruds.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listinfo;
    }
//Authentification user 

    public ResultSet Authentification(String email, String passwd) {

        boolean s = false;
        ResultSet rs = null;
        String reqverifauth = "SELECT * FROM user WHERE email='" + email + "' and passwd='" + passwd + "'";
        try {

            Statement st;
            st = cnxx.createStatement();
            System.out.println(st.executeQuery(reqverifauth));
            st.executeQuery(reqverifauth);
            rs = st.executeQuery(reqverifauth);

            if (rs.next()) {
                s = true;
                System.out.println(s);
                System.out.println("authentification avec succes");

            } else {
                System.out.println(s);
                System.out.println("email ou passwd non valide ");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserCruds.class.getName()).log(Level.SEVERE, null, ex);

        }
        return rs;
    }

    public String Typeauthentification(ResultSet res) {

        String testrole = null;

        try {
            testrole = res.getString("role");
            return testrole;
        } catch (SQLException ex) {
            System.out.println("ce compte n'existe pas , inscrivez vous ");
        }

        return testrole;
    }

    public ArrayList<User> consulterlisteuser() {
        ArrayList<User> listeuser = new ArrayList<>();
        User u = new User();
        String reqliste = "SELECT * FROM user ";
        Statement st;
        ResultSet rs;
        try {
            st = cnxx.createStatement();
            st.executeQuery(reqliste);
            rs = st.executeQuery(reqliste);
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setEmail(rs.getString("email"));
                u.setPasswd(rs.getString("passwd"));
                u.setNationalite(rs.getString("nationalite"));
                u.setRole(rs.getString("role"));
                u.setPhoto(rs.getString("photo"));
                listeuser.add(u);
                return listeuser;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserCruds.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listeuser;
    }

}
