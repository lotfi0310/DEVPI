/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TunTripsPI.Utils;

import java.util.prefs.Preferences;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;


/**
 *
 * @author Lotfi
 */
public class SessionManager {
    
        public static int id ; 
        public static int idevent;
    public static WritableImage photo;

    public static int getId() {
       return id;
    }
    public static void setId(int i) {
      id=i;
    }

    public static int getIdevent() {
        return idevent;
    }

    public static void setIdevent(int idevent) {
        SessionManager.idevent = idevent;
    }

    public static WritableImage getphoto() {
        return photo;
    }

    public static void Setphoto(WritableImage photo) {
        SessionManager.photo = photo;
    }
    
    
    }
  
