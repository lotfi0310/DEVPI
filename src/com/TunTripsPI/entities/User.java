package com.TunTripsPI.entities;

import java.sql.Blob;
import java.util.Comparator;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author Lotfi
 */
public class User{

    public static void setCellValueFactory(PropertyValueFactory<Object, Object> propertyValueFactory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int id ; 
    private String nom ; 
    private String prenom ; 
    private String email ; 
    private String passwd ; 
    private String country; 
    private String role; 
    private Blob photo;
    private String num_tel;
    private boolean  valide;
    private boolean etat; 
    
 public User() {
     
    }

    public User(String nom, String prenom, String email, String passwd, String country, String role, Blob photo,String num_tel,boolean valide,boolean etat) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.country = country;
        this.role = role;
        this.photo = photo;
        this.num_tel=num_tel;
        this.valide=valide;
        this.etat=etat; 
    }

    public User(int id,String nom, String prenom, String email, String passwd, String country, String role, Blob photo, String num_tel,boolean  etat ) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.country = country;
        this.role = role;
        this.photo = photo;
        this.num_tel = num_tel;
        this.etat=etat;
    }
 public User(String nom, String prenom, String email, String passwd, String country, String role, Blob photo, String num_tel ) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.country = country;
        this.role = role;
        this.photo = photo;
        this.num_tel = num_tel;
        this.etat=etat;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

  

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", passwd=" + passwd + ", country=" + country + ", role=" + role + ", photo=" + photo + ", num_tel=" + num_tel + ", valide=" + valide + ", etat=" + etat + '}';
    }

   

   

    
    
    
    
}
