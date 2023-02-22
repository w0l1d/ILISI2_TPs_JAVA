package com.java.ilisi.tp3;

import com.java.ilisi.tp3.ui.LocationGUI;

import javax.swing.*;

public class LocationController implements AbstractController {
   private AgenceDAO agenceDAO;
   private LocationGUI locationGUI;

   public LocationController(AgenceDAO agenceDAO) {
      this.agenceDAO = agenceDAO;
      locationGUI = new LocationGUI(agenceDAO);
   }

   @Override

   public JComponent getGUI() {
      return locationGUI;
   }


   @Override
   public JComponent refreshGUI(AgenceDAO agenceDAO) {
      this.agenceDAO = agenceDAO;
      locationGUI = new LocationGUI(agenceDAO);
      return locationGUI;
   }
}
