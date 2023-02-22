package exams.copy2txt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {


   public Main() throws HeadlessException {
      Container pane = getContentPane();
      pane.setLayout(new BorderLayout());
      JPanel pnlCtr = new JPanel();
      pnlCtr.setLayout(new GridLayout(2, 2));
      pnlCtr.add(new Label("Zone d'ecriture"));
      JTextField txt1 = new JTextField();
      pnlCtr.add(txt1);
      pnlCtr.add(new Label("Zone de copie"));
      JTextField txt2 = new JTextField();
      txt2.setEditable(false);
      pnlCtr.add(txt2);
      pane.add(pnlCtr, BorderLayout.CENTER);

      JPanel pnlSouth = new JPanel();
//      pnlSouth.setLayout(new FlowLayout());
      JButton btnExt = new JButton("sortir");
      pnlSouth.add(btnExt);
      JButton btnCp = new JButton("copier");
      pnlSouth.add(btnCp);
      ActionListener copyActionListener = new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            txt2.setText(txt1.getText());
            txt1.setText("");
         }
      };
      btnCp.addActionListener(copyActionListener);
      txt1.addActionListener(copyActionListener);

      btnExt.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });
      pane.add(pnlSouth, BorderLayout.SOUTH);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      setBounds(100, 100, 100, 100);
      pack();

   }

   public static void main(String[] args) {
      new Main().setVisible(true);
   }

}
