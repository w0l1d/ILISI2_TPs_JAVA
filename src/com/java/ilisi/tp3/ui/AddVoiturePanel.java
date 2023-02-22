package com.java.ilisi.tp3.ui;

import com.java.ilisi.tp3.model.Voiture;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import static com.java.ilisi.tp3.AgenceLabels.*;

public class AddVoiturePanel extends JPanel {
   private final JButton btnAdd;
   private final JButton btnModif;
   private final JButton btnDel;
   private final JButton btnSrch;
   private final JFormattedTextField txtMat;
   private final JTextField txtMarq;
   private final JTextField txtAnn;
   private final JTextField txtMod;
   private final JFormattedTextField txtPrix;

   /**
    * Create the panel.
    */
   public AddVoiturePanel() {
      setLayout(new BorderLayout(0, 0));

      JPanel panel = new JPanel();
      add(panel, BorderLayout.SOUTH);
      panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      btnAdd = new JButton(LABEL_ADD);
      btnAdd.setForeground(new Color(240, 248, 255));
      btnAdd.setBackground(new Color(100, 149, 237));
      btnAdd.setEnabled(false);
      panel.add(btnAdd);

      btnModif = new JButton(LABEL_UPDATE);
      btnModif.setForeground(new Color(240, 248, 255));
      btnModif.setBackground(new Color(255, 140, 0));
      btnModif.setEnabled(false);
      panel.add(btnModif);

      btnDel = new JButton(LABEL_DELETE);
      btnDel.setForeground(new Color(240, 248, 255));
      btnDel.setBackground(new Color(220, 20, 60));
      btnDel.setEnabled(false);
      panel.add(btnDel);

      btnSrch = new JButton(LABEL_SEARCH);
      btnSrch.setForeground(new Color(240, 248, 255));
      btnSrch.setBackground(new Color(168, 165, 101));
      btnSrch.setEnabled(true);
      panel.add(btnSrch);

      JPanel panel_1 = new JPanel();
      add(panel_1, BorderLayout.CENTER);

      panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

      Component verticalStrut_5 = Box.createVerticalStrut(5);
      panel_1.add(verticalStrut_5);

      JLabel lblMat = new JLabel(LABEL_MATRICUL);
      panel_1.add(lblMat, "1, 2, left, fill");

//      try {
//         MaskFormatter formatter = new MaskFormatter("######-?-###");
//         formatter.setPlaceholder("000000-a-000");
//         txtMat = new JFormattedTextField(formatter);
//         txtMat.setInputVerifier(inputVerifier);
//      } catch (ParseException e) {
//         e.printStackTrace();
//         txtMat = new JFormattedTextField();
//         JOptionPane.showMessageDialog(this,
//                 "Error : "+e.getMessage(),
//                 "Matricule Input Formatter Error",
//                 JOptionPane.ERROR_MESSAGE);
//      }
      txtMat = new JFormattedTextField();
      lblMat.setLabelFor(txtMat);
      txtMat.setColumns(10);
      panel_1.add(txtMat, "1, 4, fill, default");

      JSeparator separator = new JSeparator();
      panel_1.add(separator);

      Component verticalStrut_1 = Box.createVerticalStrut(7);
      panel_1.add(verticalStrut_1);


      JLabel lblMarq = new JLabel(LABEL_MARQUE);
      panel_1.add(lblMarq, "1, 6");

      txtMarq = new JTextField();
      lblMarq.setLabelFor(txtMarq);
      txtMarq.setColumns(5);
      panel_1.add(txtMarq, "1, 8, fill, default");

      JSeparator separator_1 = new JSeparator();
      panel_1.add(separator_1);

      Component verticalStrut = Box.createVerticalStrut(7);
      panel_1.add(verticalStrut);

      JLabel lblMod = new JLabel(LABEL_MODEL);
      panel_1.add(lblMod, "1, 10");

      txtMod = new JTextField();
      txtMod.setColumns(10);
      panel_1.add(txtMod, "1, 12, fill, default");

      JSeparator separator_2 = new JSeparator();
      panel_1.add(separator_2);

      Component verticalStrut_2 = Box.createVerticalStrut(7);
      panel_1.add(verticalStrut_2);


      JLabel lblAnn = new JLabel(LABEL_YEAR);
      panel_1.add(lblAnn, "1, 14");

      DateFormatter dateFormatter = new DateFormatter(new SimpleDateFormat("yyyy"));
      txtAnn = new JFormattedTextField(dateFormatter);
      txtAnn.setText(String.valueOf(LocalDate.now().getYear()));
      txtAnn.setColumns(10);
      panel_1.add(txtAnn, "1, 16, fill, default");

      JSeparator separator_3 = new JSeparator();
      panel_1.add(separator_3);

      Component verticalStrut_3 = Box.createVerticalStrut(7);
      panel_1.add(verticalStrut_3);

      JLabel lblPrix = new JLabel(LABEL_PRIX);
      panel_1.add(lblPrix, "1, 18");

      txtPrix = new JFormattedTextField();
      txtPrix.setColumns(10);
      panel_1.add(txtPrix, "1, 20, fill, default");

      JSeparator separator_4 = new JSeparator();
      panel_1.add(separator_4);

      Component verticalStrut_4 = Box.createVerticalStrut(7);
      panel_1.add(verticalStrut_4);
   }

   public Voiture getVoitureFromInput() throws RuntimeException {
      int annee;
      try {
         annee = Integer.parseInt(txtAnn.getText());
      } catch (NumberFormatException e) {
         throw new RuntimeException("Invalide format de l'annee de la voiture");
      }
      int prix;
      try {
         prix = Integer.parseInt(txtPrix.getText());
      } catch (NumberFormatException e) {
         throw new RuntimeException("Invalide format du prix de la voiture");
      }

      //TODO :: handle format of matricule
      if (txtMat.getInputVerifier() != null && !txtMat.getInputVerifier().verify(txtMat))
         throw new RuntimeException("Invalide format du matricule de la voiture");
      String matricul = txtMat.getText();

      String marque = txtMarq.getText();
      String model = txtMod.getText();

      return new Voiture(matricul, marque, model, annee, prix);
   }

   public JButton getBtnAdd() {
      return btnAdd;
   }

   public JButton getBtnModif() {
      return btnModif;
   }

   public JButton getBtnDel() {
      return btnDel;
   }

   public JButton getBtnSrch() {
      return btnSrch;
   }

   public JFormattedTextField getTxtMat() {
      return txtMat;
   }

   public JTextField getTxtMarq() {
      return txtMarq;
   }

   public JTextField getTxtAnn() {
      return txtAnn;
   }

   public JTextField getTxtMod() {
      return txtMod;
   }

   public JFormattedTextField getTxtPrix() {
      return txtPrix;
   }

   public void clearInputs() {
      List.of(txtAnn, txtMarq, txtMod, txtMat, txtPrix).forEach(jtf -> jtf.setText(""));
   }
}
