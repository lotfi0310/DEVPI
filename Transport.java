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
public class Transport extends Service{
            private String type;
            private int numChauffeur;
            private int capacite;
            private String immatricule;

   
 public Transport(int id, float prix, String description,String type, int numChauffeur, int capacite, String immatricule) {
        super(id,prix,description);
     this.type = type;
        this.numChauffeur = numChauffeur;
        this.capacite = capacite;
        this.immatricule = immatricule;
    }    

    @Override
    public void setDescription(String description) {
        super.setDescription(description); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPrix(float prix) {
        super.setPrix(prix); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(int id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDescription() {
        return super.getDescription(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getPrix() {
        return super.getPrix(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    
 
           

    public String getType() {
        return type;
    }

    public int getNumChauffeur() {
        return numChauffeur;
    }

    public int getCapacite() {
        return capacite;
    }

    public String getImmatricule() {
        return immatricule;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumChauffeur(int numChauffeur) {
        this.numChauffeur = numChauffeur;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setImmatricule(String immatricule) {
        this.immatricule = immatricule;
    }
          /*  @Override
            public float getPrix() {
        return super.getPrix();}
            @Override
            public String getDescription() {
        return super.getDescription();}*/
    @Override
    public String toString() {
        return "Transport{" + "type=" + type + ", numChauffeur=" + numChauffeur + ", capacite=" + capacite + ", immatricule=" + immatricule + '}';
    }
    
}
