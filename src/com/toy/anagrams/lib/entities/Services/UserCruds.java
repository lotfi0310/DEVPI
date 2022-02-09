
package com.toy.anagrams.lib.entities.Services;
import com.toy.anagrams.lib.entities.User;
import com.toy.anagrams.lib.entities.Utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author saada
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

    
}