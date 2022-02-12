/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.TestGlob;

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lotfi
 */
public class MainTest {

    public static void main(String[] args) throws SQLException {
                User u1 = new User();
       UserCruds ua=new UserCruds();
               ArrayList<User> listeuser =new ArrayList<>();

   listeuser =ua.consulterlisteuser();
      listeuser.stream().forEach(e->System.out.println(e));


//test authentification 
        
       /*
        User u1 = new User();
        String email = "ouma.san@email.com";
        String passwd = "llll";
       UserCruds ua=new UserCruds();
       ua.Authentification(email, passwd);
       ua.Typeauthentification(email, passwd);
        */
        }

    }

/* ArrayList<User> Mylist =new ArrayList<User>();
            Mylist= uc1.consulterinfo(u1);
            Mylist.stream().forEach(e->System.out.print(e));*/
