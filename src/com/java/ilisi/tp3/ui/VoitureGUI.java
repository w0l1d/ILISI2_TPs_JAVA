package com.java.ilisi.tp3.ui;

import com.java.ilisi.tp3.AgenceDAO;
import com.java.ilisi.tp3.Voiture;
import com.java.ilisi.tp3.exceptions.CarAlreadyExistsException;
import com.java.ilisi.tp3.exceptions.VoitureEstLoueeException;
import com.java.ilisi.tp3.exceptions.VoitureNotFoundException;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static com.java.ilisi.tp3.AgenceLabels.*;

public class VoitureGUI extends JSplitPane {
   private final AddVoiturePanel formCarPanel;

   private final AgenceDAO agenceDAO;
   private final JTable tblVoitures;

   public VoitureGUI(AgenceDAO agenceDAO) {
      super(JSplitPane.VERTICAL_SPLIT);
      this.agenceDAO = agenceDAO;

//      String[][] clientsArray = new String[clients.size()][];;
//      clientsArray=clients.toArray(clientsArray);
//
//      JTable tblClients = new JTable( clientsArray,
//              Arrays.stream(Client.class.getDeclaredFields()).map(Field::getName).toArray());
//      mainPanel.add(tblClients);

      List<Voiture> voituresImmutable = agenceDAO.getVoituresImmutable();
      Object[][] carsArray = new Object[voituresImmutable.size()][];

      carsArray = voituresImmutable.stream().map(Voiture::toArray).toList().toArray(carsArray);


      var model = new DefaultTableModel(carsArray,
              Arrays.stream(Voiture.class.getDeclaredFields())
                      .map(Field::getName).toArray());
      tblVoitures = new JTable(model);
      tblVoitures.setFillsViewportHeight(true);
      tblVoitures.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      tblVoitures.setDefaultEditor(Object.class, null);
      tblVoitures.getColumnModel().setColumnSelectionAllowed(false);
      tblVoitures.getTableHeader().setReorderingAllowed(false);
      JScrollPane tableScrollPane = new JScrollPane();
      tableScrollPane.setPreferredSize(new Dimension(600, 150));


      tableScrollPane.getViewport().add(tblVoitures);
      add(tableScrollPane);

      formCarPanel = new AddVoiturePanel();

      JScrollPane cenPan = new JScrollPane();
      cenPan.getViewport().add(formCarPanel);
      add(cenPan);


      tblVoitures.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int selectedRow = tblVoitures.getSelectedRow();
            boolean rowSelected = (selectedRow != -1);
            formCarPanel.getBtnModif().setEnabled(rowSelected);
            formCarPanel.getBtnDel().setEnabled(rowSelected);
            if (!rowSelected)
               return;
            TableModel model = tblVoitures.getModel();
            formCarPanel.getTxtMat().setText(model.getValueAt(selectedRow, 0).toString());
            formCarPanel.getTxtMarq().setText(model.getValueAt(selectedRow, 1).toString());
            formCarPanel.getTxtMod().setText(model.getValueAt(selectedRow, 2).toString());
            formCarPanel.getTxtAnn().setText(model.getValueAt(selectedRow, 3).toString());
            formCarPanel.getTxtPrix().setText(model.getValueAt(selectedRow, 4).toString());
         }
      });


      formCarPanel.getBtnAdd().addActionListener(e -> {
         Voiture v;
         try {
            v = formCarPanel.getVoitureFromInput();
         } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    ERROR_AJOUT_CAR_TITLE, JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
            return;
         }
         try {
            agenceDAO.addVoiture(v);
            ((DefaultTableModel) tblVoitures.getModel()).addRow(v.toArray());
            formCarPanel.clearInputs();
         } catch (CarAlreadyExistsException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    ERROR_AJOUT_CAR_TITLE, JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
         }
      });

      formCarPanel.getBtnDel().addActionListener(e -> {
         Voiture v;
         try {
            v = formCarPanel.getVoitureFromInput();
         } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    ERROR_DELETE_CAR_TITLE, JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
            return;
         }
         try {
            agenceDAO.removeVoiture(v);
            formCarPanel.clearInputs();
            ((DefaultTableModel) tblVoitures.getModel()).removeRow(tblVoitures.getSelectedRow());
         } catch (VoitureNotFoundException | VoitureEstLoueeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    ERROR_DELETE_CAR_TITLE, JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
         }
      });

      formCarPanel.getBtnModif().addActionListener(e -> {
         Voiture v;
         try {
            v = formCarPanel.getVoitureFromInput();

         } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    ERROR_UPDATE_CAR_TITLE, JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
            return;
         }
         try {
            agenceDAO.updateVoiture(v);
            updateRow(tblVoitures.getSelectedRow(), v.toSArray());
            formCarPanel.clearInputs();
         } catch (VoitureNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    ERROR_UPDATE_CAR_TITLE, JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
         }


      });
      formCarPanel.getTxtMat().getDocument().addDocumentListener(new InputChangeListener());
      formCarPanel.getTxtPrix().getDocument().addDocumentListener(new InputChangeListener());
      formCarPanel.getTxtMarq().getDocument().addDocumentListener(new InputChangeListener());
      formCarPanel.getTxtAnn().getDocument().addDocumentListener(new InputChangeListener());
      formCarPanel.getTxtMod().getDocument().addDocumentListener(new InputChangeListener());

   }


   private void updateRow(int rowIndex, String[] data) {
      if (data.length > 5)
         throw new IllegalArgumentException("data[] is to long");

      for (int j = 0; j < data.length; j++)
         tblVoitures.setValueAt(data[j], rowIndex, j);
   }

   class InputChangeListener implements DocumentListener {

      public boolean checkExistince(DocumentEvent e) throws BadLocationException {
         String matricule = formCarPanel.getTxtMat().getText();
         return agenceDAO.voitureExistsByMatricule(matricule);
      }

      public boolean checkEquality(DocumentEvent e) throws BadLocationException, RuntimeException {
         return agenceDAO.voitureExists(formCarPanel.getVoitureFromInput());
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
            formCarPanel.getBtnAdd().setEnabled(!exist);
            formCarPanel.getBtnModif().setEnabled(exist && !equals);
            formCarPanel.getBtnDel().setEnabled(exist && equals);
         } catch (BadLocationException ex) {
            JOptionPane.showMessageDialog(formCarPanel, ex.getMessage(), ERROR_GET_CAR_MATRICULE, JOptionPane.ERROR_MESSAGE);
            System.err.println(ex.getMessage());
         } catch (RuntimeException ignore) {
         }
      }

   }
}



