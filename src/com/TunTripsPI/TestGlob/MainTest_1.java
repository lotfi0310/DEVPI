/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.TestGlob;


import com.TunTripsPI.Services.EvenementCrud;
import com.TunTripsPI.Services.MailerService;
import com.TunTripsPI.Services.ReservCrud;

//import com.TunTripsPI.Services.UserCruds_1;
import com.TunTripsPI.entities.Avis;
import com.TunTripsPI.entities.Evenement;
import com.TunTripsPI.entities.ReservEvenement;
import com.TunTripsPI.entities.Reservation;
import com.TunTripsPI.entities.User_1;
import java.text.SimpleDateFormat;  
import java.util.ArrayList;
import java.util.Date;  
/**
 *
 * @author Nidhal
 */
public class MainTest_1 {
  
    public static void main(String[] args) throws Exception{
        
        
      ReservCrud ec = new ReservCrud();
        String s = ec.countRESEvenement();
         System.out.println(s);
        
      /*    EvenementCrud ee = new EvenementCrud();
    ArrayList<Evenement> r =new ArrayList<Evenement>();
  // r=ee.consulterEvenement();
     
  r = ee.recherche("aa");
        
           System.out.println(r);
        
        
        
       
        
        
        
    //    MailerService ms = new MailerService();
     //    ms.replyMail("nidhal.sassi@esprit.tn","zaher","wa");
         
         
      /*   SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
      Date parsed = format.parse("20110210");
        java.sql.Date sql1 = new java.sql.Date(parsed.getTime());
        
      SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
         Date parsed2 = format2.parse("20110211");
         java.sql.Date sql2 = new java.sql.Date(parsed.getTime());  
     Date d =new Date(Date.parse("2000/02/02"));
   
      Date date12=new SimpleDateFormat("yyyy/MM/dd").parse(parsed);
    Evenement e1 = new Evenement(18,"mm",sql1,sql2,"l","m","l","k",10);
     EvenementCrud ec = new EvenementCrud();
     ec.ajouterEvenement(e1);
         
         
        
    //     UserCruds_1 u1=new UserCruds_1();
      //   ArrayList<User_1> r =new ArrayList<User_1>();
        // r=u1.consulterlisteuser();
         //System.out.println(r);
   //    ReservCrud re =new ReservCrud();
       
    ///   ArrayList<Reservation> r =new ArrayList<Reservation>();
      // r=re.consulterReservation();
        //System.out.println(r);
        
        
        //SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
        //Date parsed2 = format2.parse("20110211");
        //java.sql.Date sql2 = new java.sql.Date(parsed.getTime());  
   // Date d =new Date(Date.parse("2000/02/02"));
        
     //   EvenementCrud ee = new EvenementCrud();
   // ArrayList<Evenement> r =new ArrayList<Evenement>();
  //  r=ee.consulterEvenement();
   //     System.out.println(r);
   /// ee.recherche("gala");
     /*User_1 u1 = new User_1 ("Ali","sassi","ooooaaaao","1234567","Tunisienne","admin","C:\\Users\\Lotfi\\Pictures\\Saved Pictures\\img.jpg");
        UserCruds_1 uc1 =new UserCruds_1();
       uc1.ajouterUser_1 (u1);*/
    
  //SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    //   Date parsed = format.parse("20110210");
     //   java.sql.Date sql1 = new java.sql.Date(parsed.getTime());
        
    //   SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
    ///    Date parsed2 = format2.parse("20110211");
    //    java.sql.Date sql2 = new java.sql.Date(parsed.getTime());  
   // Date d =new Date(Date.parse("2000/02/02"));
   
 //  Date date12=new SimpleDateFormat("yyyy/MM/dd").parse(parsed);
   // Evenement e1 = new Evenement(18,"mm",sql1,sql2,"l","m","l","k",10);
   // EvenementCrud ec = new EvenementCrud();
  //  ec.ajouterEvenement(e1);
    
  //  ReservEvenement re =new ReservEvenement(date12,6,6); 
     //ReservCrud ee = new ReservCrud();
    // ee.ajouterReservation(re);
  //   ee.supprimerReservation(re); 
  //  Evenement e1 = new Evenement(18);
 //ReservEvenement re =new ReservEvenement(sDate7,18,10);
  //   ReservCrud er =new ReservCrud();
   //   er.ajouterReservation(re,e1);

      
    
   // EvenementCrud ee = new EvenementCrud();
   // ArrayList<Evenement> r =new ArrayList<Evenement>();
   // r= ee.recherche("galaa");
   //     System.out.println(r);
   //  */
         //String ssss=  ee.evenementCapacite(e1);
          // System.out.println(ssss);
     //  ee.ajouterEvenement(e1);
         // ee.modifierEvenemenet(e1);
   //      ee.supprimerEvenement(e1);
    
   //   re.setId(2);
    //  re.setDate_reservation(sDate7);
       
    //   ee.updateReservation(re);
       // System.out.println("le nombre de reservation est " +ee.countRESEvenement());
   //   ee.supprimerReservation(re);
      //  ee.supprimerRESEV(re);
      
      
    //  EvenementCrud ree= new EvenementCrud();
    
   //  ArrayList<Evenement> r =new ArrayList<Evenement>();
        
   // r=ree.consulterEvenement();
  //r=ree.recherche("festival");
  //r=ree.afficherEvenementFiltré("galaa");
  // System.out.println(r);
  //    */
  
       // ac.ajouterAvis(a);
      //  ac.supprimeravis(a);
    //  ac.modifieravis(a);
    
    // Evenement a =new Evenement(3);
   //     AvisCrud ac= new AvisCrud();
    //     ArrayList<Avis> avList = new ArrayList<Avis>();
   // avList=ac.displayAvis(a);
   //   System.out.println(avList);
   
  //  Evenement a =new Evenement();
   //   EvenementCrud ac= new EvenementCrud();
   //     ArrayList<Evenement> evList = new ArrayList<Evenement>();
    // evList=ac.consulterEvenement();
   // System.out.println(evList);
}
    
}
  

 