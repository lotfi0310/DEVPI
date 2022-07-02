/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Wassim
 */
public class ReservTransport {

    private int idRes;
    private int idUser;
    private int idTransport;
    private String depart;
    private String destination;
    private double distance;
    private double prix;

    public ReservTransport(int idRes, int idUser, int idTransport, String depart, String destination, double distance, double prix) {
        this.idRes = idRes;
        this.idUser = idUser;
        this.idTransport = idTransport;
        this.depart = depart;
        this.destination = destination;
        this.distance = distance;
        this.prix = prix;
    }

    public ReservTransport() {
    }

    public ReservTransport(int idUser, int idTransport, String depart, String destination,
            double distance, double prix) {
        this.idUser = idUser;
        this.idTransport = idTransport;
        this.depart = depart;
        this.destination = destination;
        this.distance = distance;
        this.prix = prix;
    }

    
    

    public int getIdRes() {
        return idRes;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdTransport() {
        return idTransport;
    }

    public String getDepart() {
        return depart;
    }

    public String getDestination() {
        return destination;
    }

    public double getDistance() {
        return distance;
    }

    public double getPrix() {
        return prix;
    }

    

    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdTransport(int idTransport) {
        this.idTransport = idTransport;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

   

    @Override
    public String toString() {
        return "ReservTransport{" + "idRes=" + idRes + ", idUser=" + idUser + ", "
                + "idTransport=" + idTransport + ", depart=" + depart + ", destination=" + destination + ", distance=" + distance + ", prix=" + prix + '}';
    }

}
