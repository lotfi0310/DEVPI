/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.TestGlob;

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.entities.User;

/**
 *
 * @author Lotfi
 */
public class MainTest {
   
    public static void main(String[] args) {
        User u1 =new User("oumayma","hajri","oumayma.hajri","1234567","Tunisienne","admin","C:\\Users\\Lotfi\\Pictures\\Saved Pictures\\img.jpg");
        UserCruds uc1=new UserCruds();
        uc1.ajouterUser(u1);
        
    }
    
}
