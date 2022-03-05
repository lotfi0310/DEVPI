/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.entities;

import java.sql.Date;

/**
 *
 * @author Lotfi
 */
public class Reclamation {
     private int idreclamation;
     private int iduser; 
     private int idevent ;
     private int idheberg;
     private int idtransport;
     private String contenu;
     private Date Date_rec; 
     private boolean etat ; 

    public Reclamation()  {
    }

    public Reclamation(int idreclamation, int iduser,int idevent,int idheberg,int idtransport,String contenu, Date date, boolean etat ) {
        this.idreclamation = idreclamation;
        this.iduser = iduser;
        this.idevent=idevent; 
        this.idheberg=idheberg; 
        this.idtransport=idtransport;
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

    public int getIdheberg() {
        return idheberg;
    }

    public void setIdheberg(int idheberg) {
        this.idheberg = idheberg;
    }

    public int getIdtransport() {
        return idtransport;
    }

    public void setIdtransport(int idtransport) {
        this.idtransport = idtransport;
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

    public int getIdevent() {
        return idevent;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }

   

    

    

    
    

   
     
     
    
    
}
