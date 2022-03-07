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
public class Reservation {
private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String nomutilisateur;

    private String prenomutilisateur;
    private String emailutilisateur;
    private String nom_evenement;
    private Date date_debut_evenement;
     private Date date_fin_evenement;
    

    public String getNomutilisateur() {
        return nomutilisateur;
    }

    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public String getPrenomutilisateur() {
        return prenomutilisateur;
    }

    public void setPrenomutilisateur(String prenomutilisateur) {
        this.prenomutilisateur = prenomutilisateur;
    }

    public String getEmailutilisateur() {
        return emailutilisateur;
    }

    public void setEmailutilisateur(String emailutilisateur) {
        this.emailutilisateur = emailutilisateur;
    }

    public String getNom_evenement() {
        return nom_evenement;
    }

    public void setNom_evenement(String nom_evenement) {
        this.nom_evenement = nom_evenement;
    }

    public Date getDate_debut_evenement() {
        return date_debut_evenement;
    }

    public void setDate_debut_evenement(Date date_debut_evenement) {
        this.date_debut_evenement = date_debut_evenement;
    }

    public Date getDate_fin_evenement() {
        return date_fin_evenement;
    }

    public void setDate_fin_evenement(Date date_fin_evenement) {
        this.date_fin_evenement = date_fin_evenement;
    }
   

    public Reservation(String nomutilisateur, String prenomutilisateur, String emailutilisateur, String nom_evenement, Date date_debut_evenement, Date date_fin_evenement) {
        this.nomutilisateur = nomutilisateur;
        this.prenomutilisateur = prenomutilisateur;
        this.emailutilisateur = emailutilisateur;
        this.nom_evenement = nom_evenement;
        this.date_debut_evenement = date_debut_evenement;
        this.date_fin_evenement = date_fin_evenement;
    }

    public Reservation() {
    }

    @Override
    public String toString() {
        return "Reservation{" + "nomutilisateur=" + nomutilisateur + ", prenomutilisateur=" + prenomutilisateur + ", emailutilisateur=" + emailutilisateur + ", nom_evenement=" + nom_evenement + ", date_debut_evenement=" + date_debut_evenement + ", date_fin_evenement=" + date_fin_evenement + '}';
    }

}
