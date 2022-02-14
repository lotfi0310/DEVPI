/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.TestGlob;

import com.TunTripsPI.Services.EvenementCrud;
import com.TunTripsPI.Services.ReservCrud;
import com.TunTripsPI.Services.UserCruds_1;
import com.TunTripsPI.entities.Evenement;
import com.TunTripsPI.entities.ReservEvenement;
import com.TunTripsPI.entities.User_1;
import java.text.SimpleDateFormat;  
import java.util.Date;  
/**
 *
 * @author Nidhal
 */
public class MainTest_1 {
  
    public static void main(String[] args) throws Exception{
     /*User_1 u1 = new User_1 ("Ali","sassi","ooooaaaao","1234567","Tunisienne","admin","C:\\Users\\Lotfi\\Pictures\\Saved Pictures\\img.jpg");
        UserCruds_1 uc1 =new UserCruds_1();
       uc1.ajouterUser_1 (u1);*/
       
       
     //  String sDate10="200/02/02";  
   //    String sDate9="2000/03/01";
   // Date date8=new SimpleDateFormat("yyyy/MM/dd").parse(sDate8);
    //Date date10=new SimpleDateFormat("yyyy/MM/dd").parse(sDate10);
        
    //  Evenement e8 = new Evenement(11,"444",sDate8 ,sDate9,"zzz","zzz");
     // EvenementCrud ee = new EvenementCrud();
      ReservCrud ee = new ReservCrud();

  //     ReservEvenement re =new ReservEvenement(111,"236598",100.0,sDate10);
       //ReservEvenement re =new ReservEvenement();
    //  ee.modifierRESEV(re);
      //ee.ajouterReservEvenement(re);
     //  ee.supprimerRESEV(re);
        //  EvenementCrud ree= new EvenementCrud();
      System.out.println("le nombre de reservation est "+ee.countRESEvenement());
 
}
}
  

 