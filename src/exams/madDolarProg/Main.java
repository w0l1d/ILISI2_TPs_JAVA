package exams.madDolarProg;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Main extends JFrame {

   public Main() throws HeadlessException {
      getContentPane().setLayout(new GridLayout(2, 2));
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      getContentPane().add(new Label("Dollars"));
      JTextField txtDol = new JTextField();
      getContentPane().add(txtDol);
      getContentPane().add(new Label("Dirhams"));
      JTextField txtMad = new JTextField();
      getContentPane().add(txtMad);
      pack();

      txtMad.setEditable(false);
      JFrame frame = this;
      txtDol.getDocument().addDocumentListener(new DocumentListener() {
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
               double value = Double.parseDouble(txtDol.getText().isEmpty() ? "0" : txtDol.getText());
               txtMad.setText(String.valueOf(value * 10));
            } catch (Exception ex) {
               JOptionPane.showMessageDialog(frame, "Valuer n'est pas valide",
                       "Invalide input", JOptionPane.ERROR_MESSAGE);
            }
         }
      });

   }

   public static void main(String[] args) {
      new Main().setVisible(true);
   }
}
