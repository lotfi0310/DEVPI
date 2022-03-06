    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.entities;

import java.sql.Date;

/**
 *
 * @author Nidhal
 */
public class Evenement {
    private int id;
    private String  nom;
    private Date date_debut;
    private Date date_fin;
    private String lieu;
    private String description;
    private String Status;
  //   private String image;
    private int capacite;
    public Evenement(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Evenement(String nom) {
        this.nom = nom;
    }
    
   
     public Evenement(){
         
     }
     public Evenement(int id){
              this.id = id;
    
     }

    public Evenement(int id, int capacite) {
        this.id = id;
        this.capacite = capacite;
    }

    public Evenement(int id, String nom, Date date_debut, Date date_fin, String lieu, String description, String Status, int capacite) {
        this.id = id;
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.lieu = lieu;
        this.description = description;
        this.Status = Status;
       // this.image = image;
        this.capacite = capacite;
    }

 

  

    public Evenement(String nom, Date date_debut, Date date_fin, String lieu, String description, String Status, int capacite) {
        this.nom = nom;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.lieu = lieu;
        this.description = description;
         this.Status = Status;
      //  this.image = image;
        this.capacite=capacite;
    }

    public Evenement(String tNom, java.util.Date d1, java.util.Date d2, String tLieu, String tDescription, String Status, int tcapacite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public String getStatus() {
        return Status;
    }

    //public String getImage() {
    //    return image;
    //}

    public void setStatus(String Status) {
        this.Status = Status;
    }

    ///public void setImage(String image) {
    //    this.image = image;
    //}

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", nom=" + nom + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", lieu=" + lieu + ", description=" + description + ", Status=" + Status + ", capacite=" + capacite + '}';
    }

  
   
    
    
    
    
    
}
