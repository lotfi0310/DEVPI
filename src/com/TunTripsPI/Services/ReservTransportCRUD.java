/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Services;

import entities.ReservTransport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.TunTripsPI.Utils.MyConnection;

/**
 *
 * @author Wassim
 */
public class ReservTransportCRUD {

    Connection cnxx;

    public ReservTransportCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterReservTransport() {

        String requete = "INSERT INTO revTransport (  idUser, idTransport,depart, destination, distance,  prix,  confirme) "
                + "VALUES( 89,13,Aeorport Tunis-Carthage,Sousse,161,20,true);";

        Statement st;
        try {
            st = cnxx.createStatement();
            st.executeUpdate(requete);

            System.out.println("reservTransport ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void ajouterReservTransport2(ReservTransport p) {
        String req = "INSERT INTO revtransport(idUser, idTransport,depart,destination,distance,prix) VALUES (?,?,?, ?, ?,?);";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);

            pst.setInt(1, p.getIdUser());
            pst.setInt(2, p.getIdTransport());
            pst.setString(3, p.getDepart());

            pst.setString(4, p.getDestination());
            pst.setDouble(5, p.getDistance());
            pst.setDouble(6, p.getPrix());
            

            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<ReservTransport> afficher() {

        List<ReservTransport> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM revTransport";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {
                ReservTransport trsp = new ReservTransport();
                trsp.setIdRes(rs.getInt("id"));

                trsp.setIdUser(rs.getInt(2));
                trsp.setIdTransport(rs.getInt(3));
                trsp.setDepart(rs.getString(4));
                trsp.setDepart(rs.getString(5));
                trsp.setDistance(rs.getDouble("distance"));
                trsp.setPrix(rs.getDouble(7));
                
                

                myList.add(trsp);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

    public void updateTransport(ReservTransport p) {
        String req = "UPDATE `revTransport` SET idUser=?, idTransport=?,depart=?, destination=?, distance=?,  prix=?,   where id=? ;";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            ReservTransport trsp = new ReservTransport();

            pst.setInt(1, p.getIdUser());
            pst.setInt(2, p.getIdTransport());
            pst.setString(3, p.getDepart());

            pst.setString(4, p.getDestination());
            pst.setDouble(5, p.getDistance());
            pst.setDouble(6, p.getPrix());
            pst.setInt(7, p.getIdRes());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void deleteTransport(ReservTransport p) {
        String req = "delete from revTransport where 'id'=?;";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);

            pst.setInt(1, p.getIdRes());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
