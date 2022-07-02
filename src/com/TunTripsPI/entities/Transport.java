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
public class Transport {

    private int id;
    private String type;
    private int capacite;
    private int numChauffeur;

    private String immatricule;
    private boolean dispo;
    private String  lieuDispo;
    private int idUser; 

    public Transport(int id, String type, int capacite, int numChauffeur, String immatricule, boolean dispo, String lieuDispo) {
        this.id = id;
        this.type = type;
        this.capacite = capacite;
        this.numChauffeur = numChauffeur;
        this.immatricule = immatricule;
        this.dispo = dispo;
        this.lieuDispo = lieuDispo;
    }
    

    public Transport(String type, int capacite, int numChauffeur, String immatricule, boolean dispo, String lieuDispo) {
        this.type = type;
        this.capacite = capacite;
        this.numChauffeur = numChauffeur;
        this.immatricule = immatricule;
        this.dispo = dispo;
        this.lieuDispo = lieuDispo;
    }

    public int getId() {
        return id;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getType() {
        return type;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setNumChauffeur(int numChauffeur) {
        this.numChauffeur = numChauffeur;
    }

    public void setImmatricule(String immatricule) {
        this.immatricule = immatricule;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public void setLieuDispo(String lieuDispo) {
        this.lieuDispo = lieuDispo;
    }

    public int getNumChauffeur() {
        return numChauffeur;
    }

    public String getImmatricule() {
        return immatricule;
    }

    public boolean isDispo() {
        return dispo;
    }

    public String getLieuDispo() {
        return lieuDispo;
    }

    @Override
    public String toString() {
        return "Transport{" + "id=" + id + ", type=" + type + ", capacite=" + capacite + ", numChauffeur=" + numChauffeur + ", immatricule=" + immatricule + ", dispo=" + dispo + ", lieuDispo=" + lieuDispo + '}';
    }

    public Transport() {
    }
}
