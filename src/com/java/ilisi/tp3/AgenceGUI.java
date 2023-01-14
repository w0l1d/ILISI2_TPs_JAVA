package com.java.ilisi.tp3;

import com.java.ilisi.tp3.ui.VoitureGUI;

import javax.swing.*;
import java.awt.*;

public class AgenceGUI extends JFrame {


   private final JButton btnClients;
   private final JButton btnVoitures;
   private final JButton btnReservation;

   private final VoitureGUI voitureGUI;
   JPanel sidePanel;

   public AgenceGUI(AgenceDAO agenceDAO) {
      super("Gestion d'agence d'allocation des voitures");
      setLocationRelativeTo(null);
      Container contentPane = getContentPane();
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      contentPane.setLayout(new BorderLayout());
      contentPane.setBounds(100, 100, 450, 300);

      sidePanel = new JPanel();
      sidePanel.setLayout(new GridBagLayout());
      contentPane.add(sidePanel, BorderLayout.WEST);

      GridBagConstraints cons = new GridBagConstraints();
      cons.fill = GridBagConstraints.HORIZONTAL;
      cons.weightx = 1;
      cons.gridx = 0;

      btnClients = new JButton(AgenceLabels.GESTION_CLI_BTN);
      sidePanel.add(btnClients, cons);

      btnVoitures = new JButton(AgenceLabels.GESTION_VOITUBE_BTN);
      sidePanel.add(btnVoitures, cons);

      btnReservation = new JButton(AgenceLabels.GESTION_RESERVATION_BTN);
      sidePanel.add(btnReservation, cons);

      voitureGUI = new VoitureGUI(agenceDAO);
      contentPane.add(voitureGUI, BorderLayout.CENTER);
      pack();
   }


   @Override
   public Dimension getPreferredSize() {
      return getMinimumSize();
   }

   @Override
   public Dimension getMinimumSize() {
      return new Dimension(800, 500);
   }
}
