package com.java.ilisi.tp3;

import com.java.ilisi.tp3.critere.CritereMarque;
import com.java.ilisi.tp3.critere.CriterePrix;
import com.java.ilisi.tp3.critere.InterCritere;
import com.java.ilisi.tp3.exceptions.CarAlreadyExistsException;
import com.java.ilisi.tp3.exceptions.VoitureEstLoueeException;
import com.java.ilisi.tp3.exceptions.VoitureNotFoundException;
import com.java.ilisi.tp3.model.Voiture;
import com.java.ilisi.tp3.ui.VoitureGUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.BadLocationException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import static com.java.ilisi.tp3.AgenceLabels.*;

public class VoitureController implements AbstractController {

   private VoitureGUI voitureGUI;

   private AgenceDAO agenceDAO;

   public VoitureController(AgenceDAO agenceDAO) {

      this.agenceDAO = agenceDAO;
      voitureGUI = new VoitureGUI(agenceDAO);

      attachVoitureListeners();
   }


   private void attachVoitureListeners() {
      voitureGUI.getFormCarPanel().getBtnAdd().addActionListener(e -> {
         Voiture v;
         try {
            v = voitureGUI.getFormCarPanel().getVoitureFromInput();
         } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this.voitureGUI, ex.getMessage(),
                    ERROR_AJOUT_CAR_TITLE + "55", JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
            return;
         }
         try {
            agenceDAO.addVoiture(v);
            ((DefaultTableModel) voitureGUI.getTblVoitures().getModel()).addRow(v.toArray());
            voitureGUI.getTblVoitures().getSelectionModel().clearSelection();
            voitureGUI.getFormCarPanel().clearInputs();
         } catch (CarAlreadyExistsException ex) {
            JOptionPane.showMessageDialog(this.voitureGUI, ex.getMessage(),
                    ERROR_AJOUT_CAR_TITLE + "8", JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
         }
      });

      voitureGUI.getFormCarPanel().getBtnDel().addActionListener(e -> {
         Voiture v;
         try {
            v = voitureGUI.getFormCarPanel().getVoitureFromInput();
         } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this.voitureGUI, ex.getMessage(),
                    ERROR_DELETE_CAR_TITLE, JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
            return;
         }
         try {
            agenceDAO.removeVoiture(v);
            voitureGUI.getFormCarPanel().clearInputs();
            ((DefaultTableModel) voitureGUI.getTblVoitures().getModel()).removeRow(voitureGUI.getTblVoitures().getSelectedRow());
            voitureGUI.getTblVoitures().getSelectionModel().clearSelection();
         } catch (VoitureNotFoundException | VoitureEstLoueeException ex) {
            JOptionPane.showMessageDialog(this.voitureGUI, ex.getMessage(),
                    ERROR_DELETE_CAR_TITLE, JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
         }
      });

      voitureGUI.getFormCarPanel().getBtnModif().addActionListener(e -> {
         Voiture v;
         try {
            v = voitureGUI.getFormCarPanel().getVoitureFromInput();
         } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this.voitureGUI, ex.getMessage(),
                    ERROR_UPDATE_CAR_TITLE, JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
            return;
         }
         try {
            agenceDAO.updateVoiture(v);
            updateRow(voitureGUI.getTblVoitures().getSelectedRow(), v.toSArray());
            voitureGUI.getFormCarPanel().clearInputs();
            voitureGUI.getTblVoitures().getSelectionModel().clearSelection();
         } catch (VoitureNotFoundException ex) {
            JOptionPane.showMessageDialog(this.voitureGUI, ex.getMessage(),
                    ERROR_UPDATE_CAR_TITLE, JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
         }
      });

      voitureGUI.getFormCarPanel().getBtnSrch().addActionListener(e -> {
         String matricul = voitureGUI.getFormCarPanel().getTxtMat().getText();
         String model = voitureGUI.getFormCarPanel().getTxtMod().getText();
         int prix;
         try {
            String prx = voitureGUI.getFormCarPanel().getTxtPrix().getText();
            prx = prx.isBlank() ? "0" : prx;
            prix = Integer.parseInt(prx);
         } catch (Exception ex) {
            JOptionPane.showMessageDialog(voitureGUI, "prix invalide",
                    "Invalide Input", JOptionPane.ERROR_MESSAGE);
            return;
         }
         int annee;
         try {
            String an = voitureGUI.getFormCarPanel().getTxtAnn().getText();
            an = an.isBlank() ? "0" : an;
            annee = Integer.parseInt(an);
         } catch (Exception ex) {
            JOptionPane.showMessageDialog(voitureGUI, "Annee invalide",
                    "Invalide Input", JOptionPane.ERROR_MESSAGE);
            return;
         }
         String marque = voitureGUI.getFormCarPanel().getTxtMarq().getText();
         InterCritere interCritere = new InterCritere();
         if (!matricul.isBlank())
            interCritere.addCritere(v -> v.matricule().contains(matricul));
         if (!marque.isBlank())
            interCritere.addCritere(new CritereMarque(marque));
         if (!model.isBlank())
            interCritere.addCritere(v -> v.model().contains(model));
         if (prix != 0)
            interCritere.addCritere(new CriterePrix(prix));
         if (annee != 0)
            interCritere.addCritere(v -> v.annee() == annee);


         List<Voiture> list = new ArrayList<>();
         agenceDAO.selectionne(interCritere).forEachRemaining(list::add);
         voitureGUI.setTableModel(list);

      });


      voitureGUI.getTblVoitures().addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int selectedRow = voitureGUI.getTblVoitures().getSelectedRow();
            boolean rowSelected = (selectedRow != -1);

            voitureGUI.getFormCarPanel().getBtnModif().setEnabled(rowSelected);
            voitureGUI.getFormCarPanel().getBtnDel().setEnabled(rowSelected);
            if (!rowSelected)
               return;
            TableModel model = voitureGUI.getTblVoitures().getModel();
            voitureGUI.getFormCarPanel().getTxtMat().setText(model.getValueAt(selectedRow, 0).toString());
            voitureGUI.getFormCarPanel().getTxtMarq().setText(model.getValueAt(selectedRow, 1).toString());
            voitureGUI.getFormCarPanel().getTxtMod().setText(model.getValueAt(selectedRow, 2).toString());
            voitureGUI.getFormCarPanel().getTxtAnn().setText(model.getValueAt(selectedRow, 3).toString());
            voitureGUI.getFormCarPanel().getTxtPrix().setText(model.getValueAt(selectedRow, 4).toString());
         }
      });

      voitureGUI.getFormCarPanel().getTxtMat().getDocument().addDocumentListener(new InputChangeListener());
      voitureGUI.getFormCarPanel().getTxtPrix().getDocument().addDocumentListener(new InputChangeListener());
      voitureGUI.getFormCarPanel().getTxtMarq().getDocument().addDocumentListener(new InputChangeListener());
      voitureGUI.getFormCarPanel().getTxtAnn().getDocument().addDocumentListener(new InputChangeListener());
      voitureGUI.getFormCarPanel().getTxtMod().getDocument().addDocumentListener(new InputChangeListener());
   }


   private void updateRow(int rowIndex, String[] data) {
      if (data.length > 5) {
         throw new IllegalArgumentException("data[] is to long");
      }
      for (int j = 0; j < data.length; j++) {
         voitureGUI.getTblVoitures().setValueAt(data[j], rowIndex, j);
      }
   }


   @Override
   public JComponent getGUI() {
      return voitureGUI;
   }

   @Override
   public JComponent refreshGUI(AgenceDAO agenceDAO) {
      this.agenceDAO = agenceDAO;
      voitureGUI = new VoitureGUI(agenceDAO);

      attachVoitureListeners();
      return voitureGUI;
   }


   class InputChangeListener implements DocumentListener {

      public boolean checkExistince(DocumentEvent e) throws BadLocationException {
         String matricule = voitureGUI.getFormCarPanel().getTxtMat().getText();
         return agenceDAO.voitureExistsByMatricule(matricule);
      }

      public boolean checkEquality(DocumentEvent e) throws BadLocationException, RuntimeException {
         return agenceDAO.voitureExists(voitureGUI.getFormCarPanel().getVoitureFromInput());
      }

      @Override
      public void insertUpdate(DocumentEvent e) {
         changedUpdate(e);
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
         changedUpdate(e);
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
         try {
            boolean exist = checkExistince(e);
            boolean equals = checkEquality(e);
            voitureGUI.getFormCarPanel().getBtnAdd().setEnabled(!exist);
            voitureGUI.getFormCarPanel().getBtnModif().setEnabled(exist && !equals);
            voitureGUI.getFormCarPanel().getBtnDel().setEnabled(exist && equals);
         } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(voitureGUI, ex.getMessage(),
                    ERROR_GET_CAR_MATRICULE, JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
         } catch (RuntimeException ignore) {
         }
      }

   }


}
