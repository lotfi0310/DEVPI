/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestGlob;

import com.toy.anagrams.lib.entities.Services.UserCruds;
import com.toy.anagrams.lib.entities.User;

/**
 *
 * @author Lotfi
 */
public class MainTest {
   
    public static void main(String[] args) {
        User u1 =new User("lotfi","louiz","lotfi.louiz@esprit.tn","123456","Tunisien","admin","C:\\Users\\Lotfi\\Pictures\\Saved Pictures\\img.jpg");
        UserCruds uc1=new UserCruds();
        uc1.ajouterUser(u1);
        
    }
    
}
