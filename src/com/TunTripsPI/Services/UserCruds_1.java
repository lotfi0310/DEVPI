/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Services;

import com.TunTripsPI.Utils.MyConnection_1;
import com.TunTripsPI.entities.User_1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Nidhal
 */
public class UserCruds_1 {
    Connection cnxx;

    public UserCruds_1() {
                cnxx = MyConnection_1.getInstance().getCnx();

    }

    public void ajouterUser_1 (User_1 u) {

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
