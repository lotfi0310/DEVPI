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
        User u1 =new User();
        u1.setId(2);
        u1.setNom("ouma");
        u1.setPrenom("shan");
        u1.setEmail("ouma.san@email.com");
        u1.setPasswd("llll");
        u1.setPhoto("/doc/img.jpg");
        UserCruds uc1=new UserCruds();
        uc1.modifierUser(u1);
        
    }
    
}
