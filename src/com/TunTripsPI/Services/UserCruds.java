package com.TunTripsPI.Services;

import com.TunTripsPI.Utils.JavaMailUtil;
import com.TunTripsPI.entities.User;
import com.TunTripsPI.Utils.MyConnection;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lotfi
 */
public class UserCruds {

    Connection cnxx;

    public UserCruds() {
        cnxx = MyConnection.getInstance().getCnx();

    }
  
     public Boolean ifuserExiste(String email){
        Boolean ex=false;
        Statement st;
        ResultSet rs;
      String chercher ="Select * From user where email='"+email+"'";
      try{
          st=cnxx.createStatement();
          rs=st.executeQuery(chercher);
         if(rs.next()){
             ex=true;
         }
         else{
             ex=false ; 
             
         }
      }catch (SQLException e) {
            Logger.getLogger(UserCruds.class.getName()).log(Level.SEVERE, null, ex);
        }
     return ex; 
     }
     
   
     
    public String ajouterUser(User u) {
 String s=""; 
        
        String req = "INSERT INTO User (nom,prenom,email,passwd,role,etat) VALUES (?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            
            pst = cnxx.prepareStatement(req);
            pst.setString(1, u.getNom());
            pst.setString(2, u.getPrenom());
            pst.setString(3, u.getEmail());
            pst.setString(4, hashagePWD(u.getPasswd()));
            pst.setString(5, u.getRole());
            pst.setBoolean(6,true);
            if (ifuserExiste(u.getEmail())) {
                System.out.println("utilisateur existe deja tu peux pas ajoutee  ");
                
            }
            else{
            pst.executeUpdate();
            s="Utilisateur ajouté avec succees ";
                JavaMailUtil.sendmail(u.getEmail(),"votre code de validation mail est: ");
                AddCodeValidationmail(JavaMailUtil.a,u.getEmail());
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            s="utilisateur n'est pas ajoutee";
        }
return s; 
    }
    
   public String hashagePWD(String pwd){
        String hashPWD="";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pwd.getBytes());
            
            byte byteData[] = md.digest();
            
            //convertir le tableau de bits en une format hexadécimal
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashPWD = sb.toString();
           
            //System.out.println("En format hexa : " + sb.toString());
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserCruds.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hashPWD;
    }
   
  
  
   

    //modifier info user 
    public boolean modifierUser(User u) {
        String reqmodif = "UPDATE user SET nom='" + u.getNom() + "',prenom='" + u.getPrenom() + "',email='" + u.getEmail() + "',passwd='" + u.getPasswd() + "',photo='" + u.getPhoto() + "',num_tel='" + u.getNum_tel()+ "',etat='" + u.isEtat()+ "' WHERE user.id='" + u.getId() + "'";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(reqmodif);
            pst.executeUpdate(reqmodif);
            return true;
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
        return false;
    }
//supprimer compte user

    public boolean SupprimerUser(User u) {
        String reqdelete = "DELETE From user WHERE id='" + u.getId() + "'";
        PreparedStatement pst;
        try {
            pst = cnxx.prepareStatement(reqdelete);
            pst.executeUpdate(reqdelete);
            return true;
        } catch (SQLException e) {
            e.getErrorCode();

        }
        return false;

    }
//consulter mes info

    public ArrayList<User> consulterinfo(User u) {
        ArrayList listinfo = new ArrayList();
        String reqinfoprofil = "SELECT * FROM user WHERE id='" + u.getId() + "'";
        try {

            Statement st;
            st = cnxx.createStatement();
            ResultSet rs;
            st.executeQuery(reqinfoprofil);
            rs = st.getResultSet();
            System.out.println(rs.next());

            User uu = new User(rs.getInt("id"),rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("passwd"), rs.getString("country"), rs.getString("role"),rs.getString("photo"),rs.getString("num_tel"),rs.getBoolean("etat"));
            listinfo.add(uu);

            return listinfo;

        } catch (SQLException ex) {
            Logger.getLogger(UserCruds.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listinfo;
    }
//Authentification user 

    public ResultSet Authentification(String email, String passwd) {

        boolean s = false;
        ResultSet rs = null;
        String reqverifauth = "SELECT * FROM user WHERE email='" + email + "' and passwd='" + passwd + "'";
        try {
            Statement st;
            st = cnxx.createStatement();
            System.out.println(st.executeQuery(reqverifauth));
            st.executeQuery(reqverifauth);
            rs = st.executeQuery(reqverifauth);
            

        
    }catch (SQLException ex) {
            Logger.getLogger(UserCruds.class.getName()).log(Level.SEVERE, null, ex);

        }
        return rs;
    }

    public String Typeauthentification(ResultSet res) {

        String testrole = null;

        try {
            testrole = res.getString("role");
            return testrole;
        } catch (SQLException ex) {
            System.out.println("ce compte n'existe pas , inscrivez vous ");
        }

        return testrole;
    }

    public ArrayList<User> consulterlisteuser() {
        User u;
       ArrayList<User> listeuser=new ArrayList<User>(); ;

        String reqliste = "SELECT * FROM user ";
        Statement st;
        ResultSet rs;
        try {
            st = cnxx.createStatement();
            st.executeQuery(reqliste);
            rs=st.getResultSet();
           
            while(rs.next()) {
                
                u = new User(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),
                rs.getString("passwd"),rs.getString("country"),rs.getString("role"),rs.getString("photo"),
                rs.getString("num_tel"),rs.getBoolean("etat"));
                listeuser.add(u);
            } 
           return listeuser;
           
        }
        
        catch (SQLException ex) {
            Logger.getLogger(UserCruds.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeuser;
    }
    
        public void  AddCodeValidationmail(String code,String email){
            String req = "insert INTO codevalidation (code,email) VALUES (?,?)";
        PreparedStatement pst;
        
        try {
            pst = cnxx.prepareStatement(req);
           
            pst.setString(1,code);
            pst.setString(2,email);
          
          pst.executeUpdate();
       }
        catch(Exception e){
        e.getMessage();
               }
        
        }
        
        
    public void  AddCodeRecuperationCompte(String code,String email){
            String req = "Update codevalidation SET coderec_mp='"+code+"' where codevalidation.email='"+email+"' ";
        PreparedStatement pst;
        
        try {
            pst = cnxx.prepareStatement(req);
          pst.executeUpdate();
            System.out.println("code recuperation sauvegarder a la base ");
       }
        catch(Exception e){
            System.out.println("code recuperation non sauvegarder a la base ");
               }
        
        }
    
    public String VerifmailValidation(String email){
        try {
            String s="";
            String requeteverifmail="Select code from codevalidation Inner Join user ON codevalidation.email=user.email and user.email='"+email+"'";
            Statement st=cnxx.createStatement();
            ResultSet rs= st.executeQuery(requeteverifmail);
            s=rs.getString("code");
             
            return s;
        } catch (SQLException ex) {
            Logger.getLogger(UserCruds.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }
    
    public String VerifcodeRecuperationCompte(String email){
        try {
            String requeteverifmail="Select coderec_mp from codevalidation Inner Join user ON codevalidation.email=user.email and user.email='"+email+"'";
            Statement st=cnxx.createStatement();
            st.executeQuery(requeteverifmail);
            ResultSet rs=st.getResultSet();
            
            if(rs.next()){
            String s=rs.getString("coderec_mp");
                System.out.println(s);
                        return s;

            }
          
        } catch (SQLException ex) {
            Logger.getLogger(UserCruds.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }

    
    public void UpdatePassword(String text,String email) {
            String req = "Update user SET passwd='"+text+"' where email='"+email+"' ";
        PreparedStatement pst;
        
        try {
            pst = cnxx.prepareStatement(req);
          pst.executeUpdate();
            System.out.println("Mot de passe modifier avec succees  ");
       }
        catch(Exception e){
            System.out.println("erreur modification mot de passe");
    }
   

}
}