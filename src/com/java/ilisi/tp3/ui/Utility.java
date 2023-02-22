package com.java.ilisi.tp3.ui;

import com.java.ilisi.tp3.AgenceDAO;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;

public class Utility extends JDialog {

   public static AgenceDAO initEnvDialog() {
      int option = JOptionPane.showConfirmDialog(null,
              "Voullez-vous ouvrir un fichier de sauvegarde?",
              "Initialisation d'environnement",
              JOptionPane.YES_NO_CANCEL_OPTION,
              JOptionPane.QUESTION_MESSAGE);

      if (option == JOptionPane.CANCEL_OPTION) {
         System.exit(0);
      }
      AgenceDAO agenceDAO = null;
      if (option == JOptionPane.YES_OPTION) {
         JFileChooser fileChooser = new JFileChooser();
         int fileOption = fileChooser.showOpenDialog(null);
         if (fileOption == JFileChooser.APPROVE_OPTION) {
            try {
               agenceDAO = loadAgenceDao(fileChooser.getSelectedFile());
            } catch (Exception e) {
               JOptionPane.showMessageDialog(null,
                       e.getMessage(),
                       "Erreur de chargement de fichier de sauvegarde", JOptionPane.ERROR_MESSAGE);
               e.printStackTrace();
            }
         }
      }
      if (agenceDAO == null)
         agenceDAO = new AgenceDAO(HashMap::new);

      return agenceDAO;
   }


   public static void saveEnvWithDialog(Component parentComponent, AgenceDAO agenceDAO) throws IOException, ClassNotFoundException {
      int option = JOptionPane.showConfirmDialog(null,
              "Voullez-vous sauvegarder l'environnement actuel?",
              "Sauvegarde d'environnement",
              JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE);
      if (option == JOptionPane.YES_OPTION)
         saveEnv(parentComponent, agenceDAO);

   }

   public static void saveEnv(Component parentComponent, AgenceDAO agenceDAO) throws HeadlessException, IOException, ClassNotFoundException {
      JFileChooser fileChooser = new JFileChooser();
      int fileOption = fileChooser.showSaveDialog(parentComponent);
      if (fileOption == JFileChooser.APPROVE_OPTION)
         saveAgenceDao(agenceDAO, fileChooser.getSelectedFile());
   }


   public static AgenceDAO loadAgenceDao(File file) throws IOException, ClassNotFoundException {
      AgenceDAO agenceDAO = null;
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
      agenceDAO = ((AgenceDAO) ois.readObject());
      ois.close();
      return agenceDAO;
   }

   public static void saveAgenceDao(AgenceDAO agenceDAO, File file) throws IOException {
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
      oos.writeObject(agenceDAO);
      oos.close();
   }


}
