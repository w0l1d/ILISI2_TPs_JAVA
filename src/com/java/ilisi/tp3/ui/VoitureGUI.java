package com.java.ilisi.tp3.ui;

import com.java.ilisi.tp3.AgenceDAO;
import com.java.ilisi.tp3.model.Voiture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class VoitureGUI extends JSplitPane {
   private final AddVoiturePanel formCarPanel;
   private final JTable tblVoitures;
   private final AgenceDAO agenceDAO;

   public VoitureGUI(AgenceDAO agenceDAO) {
      super(JSplitPane.VERTICAL_SPLIT);

      this.agenceDAO = agenceDAO;


      List<Voiture> voituresImmutable = agenceDAO.getVoituresImmutable();

      System.out.println(voituresImmutable);


      tblVoitures = new JTable();
      setTableModel(voituresImmutable);
      tblVoitures.setFillsViewportHeight(true);
      tblVoitures.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      tblVoitures.setDefaultEditor(Object.class, null);
      tblVoitures.getColumnModel().setColumnSelectionAllowed(false);
      tblVoitures.getTableHeader().setReorderingAllowed(false);

      JScrollPane tableScrollPane = new JScrollPane();
      tableScrollPane.setPreferredSize(new Dimension(600, 150));


      tableScrollPane.getViewport().setLayout(new GridLayout(1, 1));


      tableScrollPane.getViewport().add(tblVoitures);
      add(tableScrollPane);

      formCarPanel = new AddVoiturePanel();

      JScrollPane cenPan = new JScrollPane();
      cenPan.getViewport().add(formCarPanel);
      add(cenPan);
   }

   public AddVoiturePanel getFormCarPanel() {
      return formCarPanel;
   }

   public JTable getTblVoitures() {
      return tblVoitures;
   }

   public void setTableModel(List<Voiture> voitures) {


      Object[][] carsArray = new Object[voitures.size()][];

      carsArray = voitures.stream().map(Voiture::toArray).toList().toArray(carsArray);


      tblVoitures.setModel(new DefaultTableModel(carsArray,
              Arrays.stream(Voiture.class.getDeclaredFields())
                      .map(Field::getName).toArray()));
   }

}



