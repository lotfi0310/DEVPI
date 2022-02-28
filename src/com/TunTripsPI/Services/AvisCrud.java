/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.TunTripsPI.Services;

import com.TunTripsPI.Utils.MyConnection;
import com.TunTripsPI.Utils.MyConnection_1;
import com.TunTripsPI.entities.Avis;
import com.TunTripsPI.entities.Evenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nidhal
 */
/*
public class AvisCrud {
    Connection cnxx;

    public AvisCrud() {
        cnxx = MyConnection_1.getInstance().getCnx();
    }

    public void ajouterAvis(Avis a) {
        PreparedStatement pst;
        try {
            String requete = "INSERT INTO avis(commentaire,nombre_personne,id,Datereservation)"
                   + "VALUES (?,?,?,?)";
           pst = cnxx.prepareStatement(requete);
//            Statement pst = MyConnection.getInstance().getCnx()
//                    .createStatement();
            pst.setString(1, a.getCommentaire());
            pst.setInt(2, a.getNombre_personne());
            pst.setInt(3, a.getId());
            pst.setString(4, a.getDatereservation());

            pst.executeUpdate();
            System.out.println("avis  inserée");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimeravis(Avis a) {
        try {
            String requete = "DELETE FROM avis where id_avis=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, a.getId_avis());
            pst.executeUpdate();
            System.out.println("avis supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifieravis(Avis a) {
        try {
            String requete = "UPDATE avis SET commentaire=?,rate=?,Datereservation  WHERE id=" + a.getId();
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);

            pst.setString(1, a.getCommentaire());
            pst.setInt(2, a.getNombre_personne());
            pst.setString(3, a.getDatereservation());

            pst.executeUpdate();
            System.out.println("avis  modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
   
}
*/