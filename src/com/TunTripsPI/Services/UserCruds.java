
package com.TunTripsPI.Services;
import com.TunTripsPI.entities.User;
import com.TunTripsPI.Utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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
            pst.setString(6,u.getRole() );
            pst.setString(7, u.getPhoto());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    //modifier info user 
    public boolean modifierUser(User u )
    {
        String reqmodif ="UPDATE user SET nom='"+u.getNom()+"',prenom='"+u.getPrenom()+"',email='"+u.getEmail()+"',passwd='"+u.getPasswd()+"',photo='"+u.getPhoto()+"' WHERE user.id='"+u.getId()+"'";
        PreparedStatement pst;
       try
    {
        pst=cnxx.prepareStatement(reqmodif);
        pst.executeUpdate(reqmodif);
       return true;       
    }
        
       catch (SQLException ex) {
           System.err.println("error");
    }
return false;
    }

    }

    
