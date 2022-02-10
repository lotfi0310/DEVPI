package com.TunTripsPI.entities;


/**
 *
 * @author Lotfi
 */
public class User {
    private int id ; 
    private String nom ; 
    private String prenom ; 
    private String email ; 
    private String passwd ; 
    private String nationalite; 
    private String role; 
    private String photo;
    
 public User() {
     
    }

    public User(String nom, String prenom, String email, String passwd, String nationalite, String role, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.nationalite = nationalite;
        this.role = role;
        this.photo = photo;
    }

    public User(int id, String nom, String prenom, String email, String passwd, String nationalite, String role, String photo) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.nationalite = nationalite;
        this.role = role;
        this.photo = photo;
        
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

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", passwd=" + passwd + ", nationalite=" + nationalite + ", role=" + role + ", photo=" + photo + '}';
    }
    
    
    
}
