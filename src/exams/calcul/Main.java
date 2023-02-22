package exams.calcul;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

   public Main() throws HeadlessException {
      super("Calculatrice");
      Container pan = getContentPane();
      pan.setLayout(new BorderLayout());
      JPanel pnl1 = new JPanel(new GridLayout(3, 3));
      JPanel pnl2 = new JPanel(new FlowLayout());
      pan.add(pnl1, BorderLayout.CENTER);
      pan.add(pnl2, BorderLayout.SOUTH);

      JButton btnPs = new JButton("+");
      JButton btnMs = new JButton("-");
      JButton btnMd = new JButton("%");
      JButton btnMl = new JButton("*");
      JButton btnDv = new JButton("/");
      JButton btnQt = new JButton("Quitter");

      JTextField txt1 = new JTextField();
      JTextField txt2 = new JTextField();
      JTextField txtr = new JTextField();
      txtr.setEditable(false);

      pnl1.add(new JLabel("Nbr1"));
      pnl1.add(txt1);
      pnl1.add(btnPs);

      pnl1.add(new JLabel("Nbr2"));
      pnl1.add(txt2);
      pnl1.add(btnMs);

      pnl1.add(new JLabel("Resultat"));
      pnl1.add(txtr);
      pnl1.add(btnMl);


      pnl2.add(btnQt);
      pnl2.add(btnMd);
      pnl2.add(btnDv);

      setDefaultCloseOperation(EXIT_ON_CLOSE);
      btnQt.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });


      ActionListener als = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            JButton btn = ((JButton) e.getSource());
            String rst = "";
            try {
               double a = Double.parseDouble(txt1.getText()), b = Double.parseDouble(txt2.getText());
               if (btn == btnPs)
                  rst = "" + (a + b);
               if (btn == btnMs)
                  rst = "" + (a - b);
               if (btn == btnMl)
                  rst = "" + (a * b);
               if (btn == btnMd)
                  rst = "" + (a % b);
               if (btn == btnDv) {
                  if (b == 0) {
                     throw new Exception("division sur 0 est impossible");
                  }
                  rst = "" + (a / b);
               }

            } catch (Exception ex) {
               JOptionPane.showMessageDialog(pan, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            txtr.setText(rst);
         }
      };


      btnPs.addActionListener(als);
      btnMs.addActionListener(als);
      btnMl.addActionListener(als);
      btnMd.addActionListener(als);
      btnDv.addActionListener(als);

      setSize(new Dimension(500, 300));
   }

   public static void main(String[] args) {
      new Main().setVisible(true);
   }
}
