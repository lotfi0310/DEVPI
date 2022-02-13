/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.TestGlob;
import java.sql.Date; 
import com.TunTripsPI.Services.ReclamationCrud;
import com.TunTripsPI.Services.UserCruds;
import com.TunTripsPI.entities.Reclamation;
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
        //ajouter un utilisateur 
        /*User u=new User("lotfi","louiz","lotfi.louiz@esprit.tn","lotfi1234","tunisien","fournisseur","/lotfi.jpg");
        UserCruds uc=new UserCruds();
        uc.ajouterUser(u);*/
        
        
        
               //consulter liste utulisateur 
               /*
        User u1 = new User();
        UserCruds ua=new UserCruds();
        ArrayList<User> listeuser =new ArrayList<>();
        listeuser =ua.consulterlisteuser();
        listeuser.stream().forEach(e->System.out.println(e));
*/
              

//test authentification 
      /*  User u1 = new User();
        String email = "ouma.san@email.com";
        String passwd = "llll";
       UserCruds ua=new UserCruds();
       ResultSet s = ua.Authentification(email, passwd);
       String t = ua.Typeauthentification(s);
       
       System.out.println(t);
       */
              
       
        
        //consulter info compte 
          /* ArrayList<User> Mylist =new ArrayList<User>();
            Mylist= uc1.consulterinfo(u1);
            Mylist.stream().forEach(e->System.out.print(e));*/
          
          
          //add reclamation 
          /*
          User u=new User();
          u.setId(2);
          ReclamationCrud cr=new ReclamationCrud();
          Reclamation r=new Reclamation();
          Date d =new Date(20220/12/15);
          r.setDate_rec(d);
          r.setContenu("arnac2465");
          r.setEtat(false);
          cr.ajouterReclamation(r,u);
          */
          //afficher mes reclamation en tant que user 
         /* User u=new User();
          u.setId(2);
          ReclamationCrud cr=new ReclamationCrud();
          ArrayList<Reclamation> a=new ArrayList<>();
          a=cr.AfficherUserReclamation(u);
          a.stream().forEach(System.out::println);
          */
         //admin consulte all reclam 
            ReclamationCrud cr=new ReclamationCrud(); 
          ArrayList<Reclamation> a=new ArrayList<>();
          a=cr.DisplayAllReclamation();
          a.stream().forEach(System.out::println);
          //metier count nbre de reclamation 
          /*
           Reclamation r =new Reclamation(); 
           ReclamationCrud cr=new ReclamationCrud(); 
           System.out.println(cr.countReclamation());
*/
          //modifier reclamation comme un utilisateur  
          /*
          Reclamation r =new Reclamation(); 
          r.setIdreclamation(7);
          r.setContenu("arnacccccccccccccccccccccccccccccccccccc");
           ReclamationCrud cr=new ReclamationCrud(); 
           boolean b =cr.ModifierReclamationUser(r);
           System.out.println(b);
          */
          
          //traiter et repondre reclamation user 
         
          /*
          Reclamation r =new Reclamation();
          r.setContenu("reclamation va etre traiter dans 3jour");
          r.setEtat(true);
          r.setIdreclamation(7);
          ReclamationCrud cr=new ReclamationCrud(); 

          cr.modifierEtatReclamation(r);
          
          */
          //supprimer reclamation 
      /* 
       Reclamation r =new Reclamation();
       r.setIdreclamation(1);
       ReclamationCrud cr=new ReclamationCrud();
       cr.SupprimerReclamation(r);
*/
      
      
        }

    
    
     

    }
         