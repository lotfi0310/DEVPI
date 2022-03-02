/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.TestGlob;
import java.sql.Date; 
import com.TunTripsPI.Services.ReclamationCrud;
import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.Utils.JavaMailUtil;
import com.TunTripsPI.entities.Reclamation;
import com.TunTripsPI.entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
        //ajouter un utilisateur 
     /* 
     UserCruds uc =new UserCruds(); 
     User u=new User();
     u.setEmail("lotfilouiz@gmail.com");
     System.out.println(uc.ifuserExiste(u.getEmail()));
        */
       /* User u=new User("Lotfi","Louiz","lotfilouiz@gmail.com","lotfi123456","tunisia","simpleuser","lotfi.png","25649668");
        UserCruds uc=new UserCruds();
//        System.out.println(uc.ajouterUser(u));
            
               //UserCruds uc=new UserCruds();
// String a =uc.generercodevalidationmail();
      // System.out.println(a);
       /* User u1 = new User();
        UserCruds ua=new UserCruds();
        ArrayList listeuser =new ArrayList();
        listeuser =ua.consulterlisteuser();
        listeuser.stream().forEach(System.out::println);
*/
              

//test authentification 
   /*    User u1 = new User();
       UserCruds ua=new UserCruds();

        String email = "lotfilouiz@gmail.com";
        String passwd =ua.hashagePWD("lotfi123456");
       ResultSet s = ua.Authentification(email,passwd);
       String t = ua.Typeauthentification(s);
       
       System.out.println(t);
      
              */
       
        
        //consulter info compte 
        /* User u1 = new User();
         u1.setId(11);
       UserCruds ua=new UserCruds();
          ArrayList<User> Mylist =new ArrayList<User>();
            Mylist=ua.consulterinfo(u1);
            Mylist.stream().forEach(e->System.out.print(e));
              */
        
          //add reclamation event
         
          
          /*
          ReclamationCrud cr=new ReclamationCrud();
          Reclamation r=new Reclamation();
          r.setIdevent(2);
          Date d =new Date(Date.parse("2022/18/15"));
          r.setDate_rec(d);
          r.setContenu("nouéééééééé"+u.getId());
          r.setEtat(false);
          cr.ajouterReclamationEvent(r,u);
          */
       
       //add reclamation hebergement 
             User u = new User();
          u.setId(107);
          Reclamation r=new Reclamation();
          ReclamationCrud cr=new ReclamationCrud();
          r.setIdevent(2);
          Date d =new Date(Date.parse("2022/18/15"));
          r.setDate_rec(d);
          r.setContenu("new Rec "+u.getId());
          r.setEtat(false);
          cr.ajouterReclamationEvent(r,u);
       
      // add reclamation transport 
          /*
                   u.setId(86);
          ReclamationCrud cr=new ReclamationCrud();
          Reclamation r=new Reclamation();
          r.setIdtransport(1);
          Date d =new Date(Date.parse("2022/18/15"));
          r.setDate_rec(d);
          r.setContenu("nouvelle reclamation sur heberg"+u.getId());
          r.setEtat(false);
          cr.ajouterReclamationTransport(r,u);
       
          //afficher mes reclamation  en tant que user
      /*
        User u=new User();
          u.setId(8);
          ReclamationCrud cr=new ReclamationCrud();
          ArrayList<Reclamation> a=new ArrayList<>();
          a=cr.AfficherUserReclamation(u);
          a.stream().forEach(System.out::println);
          */
      
       
      // afficher rec filtre event 
       /*ReclamationCrud cr=new ReclamationCrud(); 
         ArrayList<Reclamation> a=new ArrayList<Reclamation>();
         a=cr.AfficherEventtReclamation();
          a.stream().forEach(System.out::println);
       */
       
       
        // afficher rec filtre heberg
     /*  ReclamationCrud cr=new ReclamationCrud(); 
         ArrayList<Reclamation> a=new ArrayList<Reclamation>();
         a=cr.AfficherHebergtReclamation();
          a.stream().forEach(System.out::println);
       */
     /*
      // afficher rec filtre transport
      ReclamationCrud cr=new ReclamationCrud(); 
         ArrayList<Reclamation> a=new ArrayList<Reclamation>();
         a=cr.AfficherTransportReclamation();
          a.stream().forEach(System.out::println);
      */
     
     
      // System.out.println(a);
         //admin consulte all reclam 
          /*ReclamationCrud cr=new ReclamationCrud(); 
          ArrayList<Reclamation> a=new ArrayList<>();
          a=cr.DisplayAllReclamation();
          a.stream().forEach(System.out::println);
          */
          //metier count nbre de reclamation 
          /*
           Reclamation r =new Reclamation(); 
           ReclamationCrud cr=new ReclamationCrud(); 
           System.out.println(cr.countReclamation());
*/
          //modifier reclamation comme un utilisateur  
         /*
          Reclamation r =new Reclamation(); 
          r.setIdreclamation(3);
          r.setContenu("arnacccccccccccccoumaccccccccccccccccccccccc");
           ReclamationCrud cr=new ReclamationCrud(); 
           boolean b =cr.ModifierReclamationUser(r);
           System.out.println(b);
          */
          
         
          //traiter et repondre reclamation user 
         
          /*
          Reclamation r =new Reclamation();
          r.setContenu("reclamation va etre traiter dans 3jour");
          r.setEtat(true);
          r.setIdreclamation(20);
          ReclamationCrud cr=new ReclamationCrud(); 

          cr.modifierEtatReclamation(r);
          */
          
          //supprimer reclamation 
        /*  Reclamation r =new Reclamation();
       r.setIdreclamation(30);
       ReclamationCrud cr=new ReclamationCrud();
       cr.SupprimerReclamation(r);*/

      
      /*ReclamationCrud r =new ReclamationCrud();
      int d=r.countReclamation();
      System.out.println(d);
      */
        }

    
    
     

    }
         