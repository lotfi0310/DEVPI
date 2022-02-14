/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.entities;

/**
 *
 * @author Nidhal
 */
public class ReservEvenement {
    private int id ;
     private String nomreservation;
      private double  prix;
     private String date_reserv;
    


    public ReservEvenement() {
    }

    public ReservEvenement(int id, String nomreservation, double  prix, String date_reserv) {
        this.id = id;
        this.nomreservation = nomreservation;
        this.prix = prix;
        this.date_reserv = date_reserv;
    }

    public ReservEvenement(String nomreservation, double prix, String date_reserv) {
        this.nomreservation = nomreservation;
        this.prix = prix;
        this.date_reserv = date_reserv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomreservation() {
        return nomreservation;
    }

    public void setNomreservation(String nomreservation) {
        this.nomreservation = nomreservation;
    }

    public String getDate_reserv() {
        return date_reserv;
    }

    public void setDate_reserv(String date_reserv) {
        this.date_reserv = date_reserv;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    

  
}
