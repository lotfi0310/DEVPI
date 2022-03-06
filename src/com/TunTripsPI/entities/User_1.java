/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.entities;

import java.sql.Blob;

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

    public User_1(int aInt, String string, String string0, String string1, String string2, String string3, String string4, Blob blob, String string5, boolean aBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getNum_tel() {
        return Num_tel;
    }

    public void setNum_tel(int Num_tel) {
        this.Num_tel = Num_tel;
    }
    private int  Num_tel;

    public User_1() {
    }

    public User_1(int id, String nom, String prenom, String email, String passwd, String nationalite, String role, String photo, int Num_tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.nationalite = nationalite;
        this.role = role;
        this.photo = photo;
        this.Num_tel = Num_tel;
    }

    public User_1(String nom, String prenom, String email, String passwd, String nationalite, String role, String photo, int Num_tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.nationalite = nationalite;
        this.role = role;
        this.photo = photo;
        this.Num_tel = Num_tel;
    }

    
    
    @Override
    public String toString() {
        return "User_1{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", passwd=" + passwd + ", nationalite=" + nationalite + ", role=" + role + ", photo=" + photo + ", Num_tel=" + Num_tel + '}';
    }
    
    
}