/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.TestGlob;

import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lotfi
 */
public class MainTest {
   
    public static void main(String[] args) {
        User u1 =new User();
        u1.setId(2);
        UserCruds uc1=new UserCruds();
       
       ArrayList<User> Mylist =new ArrayList<User>();
 Mylist= uc1.consulterinfo(u1);
      Mylist.stream().forEach(e->System.out.print(e));
      
    }
    
}
