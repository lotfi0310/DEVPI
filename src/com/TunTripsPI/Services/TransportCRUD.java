/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Services;

import entities.Transport;
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
public class TransportCRUD {

    Connection cnxx;

    public TransportCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterTransport() {

        String requete = "INSERT INTO transport (type,capacite,immatricule,dispo,lieuDispo) VALUES ('MiniVan',8,'145 TUN 8907',1,'Sfax');";

        Statement st;
        try {
            st = cnxx.createStatement();
            st.executeUpdate(requete);

            System.out.println("Transport ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void ajouterTransport2(Transport p) {
        String req = "INSERT INTO Transport(type,capacite,immatricule,dispo,lieuDispo,idUser) "
                + "VALUES  (?,?,?,?,?,?);";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);

            pst.setString(1, p.getType());
            pst.setInt(2, p.getCapacite());
            pst.setString(3, p.getImmatricule());
            pst.setBoolean(4, p.isDispo());
            pst.setString(5, p.getLieuDispo());
            pst.setInt(6, p.getIdUser());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Transport> afficher() {

        List<Transport> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM transport";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Transport trsp = new Transport();
                trsp.setId(rs.getInt("idTransport"));

                trsp.setType(rs.getString(2));

                trsp.setCapacite(rs.getInt(3));
                trsp.setNumChauffeur(rs.getInt(4));
                trsp.setImmatricule(rs.getString("immatricule"));
                trsp.setDispo(rs.getBoolean(6));
                trsp.setLieuDispo(rs.getString(7));

                myList.add(trsp);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

    public void updateTransport(Transport p) {
        String req = "UPDATE `transport` SET `type`=?,`capacite`=?,"
                +"`immatricule`=?,`dispo`=?,`lieuDispo`=? where `idTransport`=?;";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);

            pst.setString(1, p.getType());
            pst.setInt(2, p.getCapacite());
            pst.setString(3, p.getImmatricule());
            pst.setBoolean(4, p.isDispo()); 
            pst.setString(5, p.getLieuDispo());
            pst.setInt(6, p.getId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void deleteTransport(Transport p) {
        String req = "delete from Transport where 'idtransport'=?;";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);

            pst.setInt(1, p.getId());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
