/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.entities;

import java.sql.Date;
import java.sql.SQLXML;

/**
 *
 * @author Lotfi
 */
public class Reclamation {
     private int idreclamation;
     private int iduser; 
     private String contenu;
     private Date Date_rec; 
     private boolean etat ; 

    public Reclamation() {
    }

    public Reclamation(int idreclamation, int iduser, String contenu, Date date, boolean etat) {
        this.idreclamation = idreclamation;
        this.iduser = iduser;
        this.contenu = contenu;
        this.Date_rec = Date_rec;
        this.etat = etat;
    }

    public int getIdreclamation() {
        return idreclamation;
    }

    public void setIdreclamation(int idreclamation) {
        this.idreclamation = idreclamation;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDate_rec() {
        return Date_rec;
    }

    public void setDate_rec(Date Date_rec) {
        this.Date_rec = Date_rec;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idreclamation=" + idreclamation + ", iduser=" + iduser + ", contenu=" + contenu + ", Date_rec=" + Date_rec + ", etat=" + etat + '}';
    }

    
    

   
     
     
    
    
}
