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
        String reqdelete = "DELETE From user WHERE id='"+u.getId()+ "'";
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
    
    
    public ArrayList<User> consulterinfo(User u){
         ArrayList listinfo =new ArrayList();
         String reqinfoprofil="SELECT * FROM user WHERE id='"+u.getId()+"'";
        try {
            
            Statement st; 
            st=cnxx.createStatement();
            ResultSet rs;
            st.executeQuery(reqinfoprofil);
            rs=st.getResultSet();
                      System.out.println(rs.next());
                      while(rs.next()){
  User uu = new User(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("passwd"),rs.getString("nationalite"),rs.getString("role"),rs.getString("photo"));
                           listinfo.add(uu);
                      }
                      return listinfo;

        } catch (SQLException ex) {
            Logger.getLogger(UserCruds.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listinfo;
    }
   

}
