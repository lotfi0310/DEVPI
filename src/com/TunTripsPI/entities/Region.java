/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.entities;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;

/**
 *
 * @author Oumaima
 */
public class Region {
    private int id ; 
    private String nom ; 
    private String description ;      
    private Blob image;
    
    public Region(){
        
    }

    public Region(String nom) {
        this.nom = nom;
    }

    public Region(int id) {
        this.id = id;
    }

    public Region(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public Region(int id, String nom, String description, Blob image) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.image = image;
    }

    public Region(String nom, String description, Blob image) {
        this.nom = nom;
        this.description = description;
        this.image = image;
    }

    public Region(String nom, String description) {
 
        this.nom = nom;
        this.description = description;
    }

    public Region(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

 
   
 
  

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Blob getImage() {
        return image;
    }
 
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

 

    @Override
    public String toString() {
        return "Region{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", photo=" + image + '}';
    }
   
    
    
    
}

