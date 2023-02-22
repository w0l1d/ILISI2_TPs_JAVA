package com.java.ilisi.tp3.ui;

import com.java.ilisi.tp3.AgenceDAO;
import com.java.ilisi.tp3.LocationController;
import com.java.ilisi.tp3.VoitureController;

import javax.swing.*;
import java.awt.*;

public class AgenceGUI extends JFrame {


   //   private final JButton btnClients;
//   private final JButton btnVoitures;
//   private final JButton btnReservation;
   private final JMenuItem itemNew;
   private final JMenuItem itemOpen;
   private final JMenuItem itemSave;
   private final JMenuItem itemExit;
   private final JSplitPane pnlMain;
   private final LocationController locationController;
   private AgenceDAO agenceDAO;

   public AgenceGUI(AgenceDAO agenceDAO, VoitureController voitureController, LocationController locationController) {
      super("Gestion d'agence d'allocation des voitures");
      this.agenceDAO = agenceDAO;
      setLocationRelativeTo(null);
      Container contentPane = getContentPane();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      contentPane.setLayout(new BorderLayout());
      contentPane.setBounds(100, 100, 100, 100);

      this.locationController = locationController;

      JMenuBar menubar = new JMenuBar();
      JMenu fileMenu = new JMenu("File");
      itemNew = new JMenuItem("New");
      fileMenu.add(itemNew);
      itemOpen = new JMenuItem("Open");
      fileMenu.add(itemOpen);
      fileMenu.add(new JSeparator());
      itemSave = new JMenuItem("Entregistrer");
      fileMenu.add(itemSave);
      fileMenu.add(new JSeparator());
      itemExit = new JMenuItem("Exit");
      fileMenu.add(itemExit);
      menubar.add(fileMenu);
      this.setJMenuBar(menubar);

//      sidePanel = new JPanel();
//      sidePanel.setLayout(new GridBagLayout());
//      contentPane.add(sidePanel, BorderLayout.WEST);
//
//      GridBagConstraints cons = new GridBagConstraints();
//      cons.fill = GridBagConstraints.HORIZONTAL;
//      cons.weightx = 1;
//      cons.gridx = 0;
//
//      btnVoitures = new JButton(AgenceLabels.GESTION_VOITUBE_BTN);
//      sidePanel.add(btnVoitures, cons);
//
//      btnReservation = new JButton(AgenceLabels.GESTION_RESERVATION_BTN);
//      sidePanel.add(btnReservation, cons);

      pnlMain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
      getContentPane().add(pnlMain, BorderLayout.CENTER);
      pnlMain.setLeftComponent(voitureController.getGUI());
      pnlMain.setRightComponent(locationController.getGUI());

      pack();
   }

   public LocationController getLocationController() {
      return locationController;
   }

   public void refreshTables(VoitureController controller, AgenceDAO agenceDAO) {
      this.agenceDAO = agenceDAO;
      getContentPane().setVisible(false);
      pnlMain.remove(pnlMain.getLeftComponent());
      pnlMain.setLeftComponent(controller.refreshGUI(agenceDAO));
      pnlMain.repaint();
      getContentPane().setVisible(true);

   }

   public void refreshTables(LocationController controller, AgenceDAO agenceDAO) {
      this.agenceDAO = agenceDAO;
      getContentPane().setVisible(false);
      pnlMain.remove(pnlMain.getRightComponent());
      LocationGUI comp = (LocationGUI) controller.refreshGUI(agenceDAO);
      pnlMain.setRightComponent(comp);
      pnlMain.repaint();
      getContentPane().setVisible(true);

   }

   @Override
   public Dimension getPreferredSize() {
      return getMinimumSize();
   }

   @Override
   public Dimension getMinimumSize() {
      return new Dimension(800, 500);
   }

   public JMenuItem getItemNew() {
      return itemNew;
   }

   public JMenuItem getItemOpen() {
      return itemOpen;
   }

   public JMenuItem getItemSave() {
      return itemSave;
   }


   public JMenuItem getItemExit() {
      return itemExit;
   }


}
