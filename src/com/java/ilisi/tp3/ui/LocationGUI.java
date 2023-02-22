package com.java.ilisi.tp3.ui;

import com.java.ilisi.tp3.AgenceController;
import com.java.ilisi.tp3.AgenceDAO;
import com.java.ilisi.tp3.enums.Civilite;
import com.java.ilisi.tp3.model.Client;
import com.java.ilisi.tp3.model.Voiture;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Map;
import java.util.Set;

public class LocationGUI extends JSplitPane {


   private final JPanel formClientPanel;
   private final AgenceDAO agenceDAO;
   private final JTable tblLocation;
   private final JTextField txtNom;
   private final JTextField txtPrenom;
   private final JTextField txtCin;
   private final JComboBox<Civilite> cmbCiv;
   private final JButton addLoc;
   private final JButton rendreLoc;

   public LocationGUI(AgenceDAO agenceDAO) {
      super(JSplitPane.VERTICAL_SPLIT);
      this.agenceDAO = agenceDAO;


      tblLocation = new JTable();
      setTableModel(agenceDAO.getLocation().entrySet());
      tblLocation.setFillsViewportHeight(true);
      tblLocation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      tblLocation.setDefaultEditor(Object.class, null);
      tblLocation.getColumnModel().setColumnSelectionAllowed(false);
      tblLocation.getTableHeader().setReorderingAllowed(false);

      JScrollPane tableScrollPane = new JScrollPane();
      tableScrollPane.setPreferredSize(new Dimension(600, 150));


      tableScrollPane.getViewport().setLayout(new GridLayout(1, 1));

      tableScrollPane.getViewport().add(tblLocation);
      add(tableScrollPane);

      formClientPanel = new JPanel(new GridLayout(8, 1));
      formClientPanel.add(new JLabel("Nom"));
      txtNom = new JTextField();
      formClientPanel.add(txtNom);
      formClientPanel.add(new JLabel("Prenom"));
      txtPrenom = new JTextField();
      formClientPanel.add(txtPrenom);
      formClientPanel.add(new JLabel("CIN"));
      txtCin = new JTextField();
      formClientPanel.add(txtCin);
      formClientPanel.add(new JLabel("Civillite"));
      cmbCiv = new JComboBox<>();
      cmbCiv.addItem(Civilite.Mme);
      cmbCiv.addItem(Civilite.M);
      cmbCiv.addItem(Civilite.M);
      cmbCiv.addItem(Civilite.Mlle);
      formClientPanel.add(cmbCiv);
      formClientPanel.add(new JSeparator());
      addLoc = new JButton("Ajouter Location");
      formClientPanel.add(addLoc);
      rendreLoc = new JButton("Rendre Voiture");
      formClientPanel.add(rendreLoc);


      addLoc.addActionListener(AgenceController.actionListenerAddLoc);
      rendreLoc.addActionListener(e -> {
         int selectedRow = tblLocation.getSelectedRow();
         boolean rowSelected = (selectedRow != -1);
         if (!rowSelected) {
            JOptionPane.showMessageDialog(tblLocation, "selectionner une Location");
            return;
         }

         TableModel model = tblLocation.getModel();

         String cli = model.getValueAt(selectedRow, 0).toString();
//         agenceDAO.rendVoiture(agenceDAO.getLocation().keySet()
//                 .stream().filter(c -> c.toString().equals(cli.toString()))
//                 .findAny().orElse(null));
         tblLocation.remove(selectedRow);

      });

      JScrollPane cenPan = new JScrollPane();
      cenPan.getViewport().add(formClientPanel);
      add(cenPan);

   }


   public Client getClientFromInput() {
      String nom = txtNom.getText();
      String prenom = txtPrenom.getText();
      String cin = txtCin.getText();
      Civilite civilite = ((Civilite) cmbCiv.getSelectedItem());

      return new Client(nom, prenom, cin, civilite);
   }

   public void setTableModel(Set<Map.Entry<Client, Voiture>> entries) {

      Object[][] locationImmutable = new Object[agenceDAO.getLocation().size()][];
      locationImmutable = entries.stream().map(lc -> {
         return new String[]{lc.getKey().toString(), lc.getValue().matricule()};
      }).toList().toArray(locationImmutable);

      tblLocation.setModel(new DefaultTableModel(locationImmutable, new String[]{"Client", "Voiture"}));
   }


   public JPanel getFormClientPanel() {
      return formClientPanel;
   }

   public AgenceDAO getAgenceDAO() {
      return agenceDAO;
   }

   public JTable getTblLocation() {
      return tblLocation;
   }

   public JTextField getTxtNom() {
      return txtNom;
   }

   public JTextField getTxtPrenom() {
      return txtPrenom;
   }

   public JTextField getTxtCin() {
      return txtCin;
   }

   public JComboBox<Civilite> getCmbCiv() {
      return cmbCiv;
   }

   public JButton getAddLoc() {
      return addLoc;
   }
}



