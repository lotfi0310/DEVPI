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
public class Avis {

    private int id_avis;
    private String commentaire;

    private int id;
    private String datereservation;
    private int nombre_personne;

    public Avis(int id_avis, String commentaire, int nombre_personne, int id, String datereservation) {
        this.id_avis = id_avis;
        this.commentaire = commentaire;
        this.id = id;
        this.datereservation = datereservation;
        this.nombre_personne = nombre_personne;
    }

    public Avis(String commentaire, int     nombre_personne, int id, String datereservation) {
        this.commentaire = commentaire;
        this.id = id;
        this.datereservation = datereservation;
        this.nombre_personne = nombre_personne;
    }

    public int getId_avis() {
        return id_avis;
    }

    public void setId_avis(int id_avis) {
        this.id_avis = id_avis;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatereservation() {
        return datereservation;
    }

    public void setDatereservation(String datereservation) {
        this.datereservation = datereservation;
    }

    public int getNombre_personne() {
        return nombre_personne;
    }

    public void setNombre_personne(int nombre_personne) {
        this.nombre_personne = nombre_personne;
    }

    @Override
    public String toString() {
        return "Avis{" + "id_avis=" + id_avis + ", commentaire=" + commentaire + ", id=" + id + ", datereservation=" + datereservation + ", nombre_personne=" + nombre_personne + '}';
    }

   

 

}