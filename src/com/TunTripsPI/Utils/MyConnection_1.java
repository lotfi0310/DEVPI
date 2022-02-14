/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nidhal
 */
public class MyConnection_1 {
     public Connection getCnx() {
        return cnx;
    }
    public String url = "jdbc:mysql://localhost:3306/tuntripsbd";
    public String login = "root";
    public String pwd = "";
    Connection cnx;
    /* 2 etpae*/
    public static MyConnection_1 instance;

    /* 1 etpae*/
    private MyConnection_1() {
        try {

            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
    }

    /* 3 etape */

    public static MyConnection_1 getInstance() {

        if (instance == null) {

            instance = new MyConnection_1();
        }
        return instance;

    }
}
