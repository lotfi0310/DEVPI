/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.entities;

/**
 *
 * @author Oumaima
 */
public class Endroit {

    private int id;
    private int regionId;
    private String nom;
    private String description;
    private float longitude;
    private float latitude;
    private int numero;
    private String type;
    private String image;

    public Endroit() {
    }

    public Endroit(int id,String nom, String type) {
        this.id = id;
      
        this.nom = nom;
        this.type = type;
    }

    public Endroit(int id, String nom, String description, float longitude, float latitude) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Endroit(int id, int regionId, String nom, String type, String description, float longitude, float latitude, int numero, String image) {
        this.id = id;
        this.regionId = regionId;
        this.nom = nom;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.numero = numero;
        this.type = type;
        this.image = image;
    }

    public Endroit(int regionId, String nom, String description, float longitude, float latitude, int numero, String type) {
        this.regionId = regionId;
        this.nom = nom;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.numero = numero;
        this.type = type;
    }

    public Endroit(String type) {
        this.type = type;
    }

    public Endroit(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Endroit(int regionId, String nom, String type, String description, float longitude, float latitude, int numero, String image) {

        this.regionId = regionId;
        this.nom = nom;
        this.description = description;
        this.longitude = longitude;
        this.latitude = latitude;
        this.numero = numero;
        this.type = type;
        this.image = image;
    }
 

    public Endroit(int regionId) {
        this.regionId = regionId;
    }

    public int getId() {
        return id;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public int getNumero() {
        return numero;
    }

    public String getType() {
        return type;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
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

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Endroit{" + "id=" + id + ", regionId=" + regionId + ", nom=" + nom + ", description=" + description + ", longitude=" + longitude + ", latitude=" + latitude + ", numero=" + numero + ", type=" + type + ", image=" + image + '}';
    }

}
