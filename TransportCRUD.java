/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Service;
import entities.Transport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tools.MyConnection;

/**
 *
 * @author Wassim
 */
public class TransportCRUD {


    Connection cnxx;

    public TransportCRUD() {
        cnxx = MyConnection.getInstance().getCnx();
    }

    public void ajouterTransport(){

         String requete = "INSERT INTO Transport (prix,description,type,capacite,numChauffeur,immatricule) "
                 + "VALUES(50,disponible chaque jour sauf les weekends,MiniVan,8,22548765,145 TUN 8905 );";

        Statement st;
        try {
            st = cnxx.createStatement();
            st.executeUpdate(requete);

            System.out.println("Personne ajouté avec succés");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void ajouterPersonne2(Transport p) {
        String req = "INSERT INTO Transport(prix,description,type,capacite,numChauffeur,immatricule) VALUES  (?,?,?, ?, ?, ?);";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(req);
            pst.setFloat(2, p.getPrix());
            pst.setString(3, p.getDescription());
            
            pst.setString(4, p.getType());
            pst.setInt(5, p.getCapacite());
            pst.setInt(6, p.getNumChauffeur());
            pst.setString(7, p.getImmatricule());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public List<Transport> afficher() {

        List<Transport> myList = new ArrayList();

        try {
            Statement st = cnxx.createStatement();
            String req = "SELECT * FROM Transport";
            ResultSet rs;
            rs = st.executeQuery(req);
            while (rs.next()) {

                Transport trsp = (Transport) new Service();
                trsp.setId(rs.getInt("id"));
                trsp.setPrix(rs.getFloat(2));
                trsp.setDescription(rs.getString(3));
                trsp.setType(rs.getString(4));

                trsp.setCapacite(rs.getInt(5));
                trsp.setNumChauffeur(rs.getInt(6));
                trsp.setImmatricule(rs.getString(7));

                myList.add(trsp);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            //   return null;
        }
        return myList;
    }

}

