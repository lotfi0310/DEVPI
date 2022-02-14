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
public class User_1 {
     private int id ; 
    private String nom ; 
    private String prenom ; 
    private String email ; 
    private String passwd ; 
    private String nationalite; 
    private String role; 
    private String photo;
public User_1(){
    
}
    public User_1(int id, String nom, String prenom, String email, String passwd, String nationalite, String role, String photo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.nationalite = nationalite;
        this.role = role;
        this.photo = photo;
    }

    
    public User_1( String nom, String prenom, String email, String passwd, String nationalite, String role, String photo) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.nationalite = nationalite;
        this.role = role;
        this.photo = photo;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getNationalite() {
        return nationalite;
    }

    public String getRole() {
        return role;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return "User_1{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", passwd=" + passwd + ", nationalite=" + nationalite + ", role=" + role + ", photo=" + photo + '}';
    }
    
 
    
}
