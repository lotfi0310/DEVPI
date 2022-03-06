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
public class ReservEvenement {
    private int id ;
    private int id_evenement ;
   private int  id_user ;
   private Date Date_reservation;

    public ReservEvenement() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_evenement() {
        return id_evenement;
    }

    public void setId_evenement(int id_evenement) {
        this.id_evenement = id_evenement;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Date getDate_reservation() {
        return Date_reservation;
    }

    public void setDate_reservation(Date Date_reservation) {
        this.Date_reservation = Date_reservation;
    }

    public ReservEvenement(Date Date_reservation, int id_evenement, int id_user ) {
        this.id_evenement = id_evenement;
        this.id_user = id_user;
        this.Date_reservation = Date_reservation;
    }

   // public ReservEvenement(Date Date_reservation , int id_evenement, int id_user ) {
  //      this.id_evenement = id_evenement;
   //     this.id_user = id_user;
   ///     this.Date_reservation = Date_reservation;
   // }

    @Override
    public String toString() {
        return "ReservEvenement{" + "id=" + id + ", id_evenement=" + id_evenement + ", id_user=" + id_user + ", Date_reservation=" + Date_reservation + '}';
    }


   
  
}
