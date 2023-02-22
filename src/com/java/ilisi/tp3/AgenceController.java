package com.java.ilisi.tp3;

import com.java.ilisi.tp3.model.Voiture;
import com.java.ilisi.tp3.ui.AgenceGUI;
import com.java.ilisi.tp3.ui.LocationGUI;
import com.java.ilisi.tp3.ui.VoitureGUI;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static com.java.ilisi.tp3.ui.Utility.initEnvDialog;
import static com.java.ilisi.tp3.ui.Utility.saveEnvWithDialog;

public class AgenceController {


   public static ActionListener actionListenerAddLoc;
   private final VoitureController voitureController;
   private final AgenceGUI agenceGUI;
   private final LocationController locationController;
   private AgenceDAO agenceDAO;

   public AgenceController() {
      this.agenceDAO = initEnvDialog();


      //TODO ::: create contollers for other interfaces
      this.voitureController = new VoitureController(agenceDAO);
      this.locationController = new LocationController(agenceDAO);

      this.agenceGUI = new AgenceGUI(agenceDAO, voitureController, locationController);

      attachMenuBarListeners();

      actionListenerAddLoc = e -> {
         JTable tblVoitures = ((VoitureGUI) voitureController.getGUI()).getTblVoitures();

         int selectedRow = tblVoitures.getSelectedRow();

         if (selectedRow == -1) {
            JOptionPane.showMessageDialog(tblVoitures,
                    "Vous devez choisir une voiture",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
         }


         TableModel model = tblVoitures.getModel();
         String matricule = model.getValueAt(selectedRow, 0).toString();
         Voiture voiture = agenceDAO.findByMatricule(matricule);
         try {
            agenceDAO.loueVoiture(((LocationGUI) locationController.getGUI()).getClientFromInput(), voiture);
            agenceGUI.refreshTables(locationController, agenceDAO);
         } catch (Exception ex) {
            JOptionPane.showMessageDialog(tblVoitures,
                    ex.getMessage(),
                    "Error lors de la location", JOptionPane.ERROR_MESSAGE);

         }

      };
      getLocationGUI().getAddLoc().addActionListener(actionListenerAddLoc);


      agenceGUI.setVisible(true);

   }

   public LocationGUI getLocationGUI() {
      return ((LocationGUI) locationController.getGUI());
   }

   private void attachMenuBarListeners() {
      // * Attach EXIT event to menu item
      this.agenceGUI.getItemExit().addActionListener(e -> {
         try {
            saveEnvWithDialog(agenceGUI, agenceDAO);
         } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(),
                    "Erreur de sauvegarde d'environnement", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
         }
         System.exit(0);
      });
      // * Attach SAVE event to menu item
      this.agenceGUI.getItemSave().addActionListener(e -> {
         try {
            saveEnvWithDialog(agenceGUI, agenceDAO);
         } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(),
                    "Erreur de sauvegarde d'environnement", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
         }
      });
      // * Attach OPEN event to menu item
      this.agenceGUI.getItemOpen().addActionListener(e -> {
         try {
            saveEnvWithDialog(agenceGUI, agenceDAO);
         } catch (Exception ex) {
            int option = JOptionPane.showConfirmDialog(null,
                    ex.getMessage() + "\n l'environnement courant sera ecrasee, voullez-vous continuer?",
                    "Erreur de sauvegarde d'environnement", JOptionPane.YES_NO_OPTION);
            ex.printStackTrace();
            if (option == JOptionPane.NO_OPTION) {
               return;
            }
         }
         agenceDAO = initEnvDialog();
         agenceGUI.refreshTables(voitureController, agenceDAO);
         agenceGUI.refreshTables(locationController, agenceDAO);
      });
      // * Attach NEW event to menu item
      this.agenceGUI.getItemNew().addActionListener(e -> {
         try {
            saveEnvWithDialog(agenceGUI, agenceDAO);
         } catch (Exception ex) {
            int option = JOptionPane.showConfirmDialog(null,
                    ex.getMessage() + "\n l'environnement courant sera ecrasee, voullez-vous continuer?",
                    "Erreur de sauvegarde d'environnement", JOptionPane.YES_NO_OPTION);
            ex.printStackTrace();
            if (option == JOptionPane.NO_OPTION) {
               return;
            }
         }
//         agenceGUI.add(voitureController.getGUI(), BorderLayout.CENTER);
         agenceDAO = new AgenceDAO(HashMap::new);
         agenceGUI.refreshTables(voitureController, agenceDAO);
         agenceGUI.refreshTables(locationController, agenceDAO);
      });

   }


}
