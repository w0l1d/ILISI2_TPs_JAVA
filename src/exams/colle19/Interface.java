package exams.colle19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {


   public Interface() throws HeadlessException {
      super("Evenements...");

      JButton red = new JButton("Rouge");
      JButton green = new JButton("Vert");
      JButton bleu = new JButton("Bleu");

      getContentPane().setLayout(new FlowLayout());
      getContentPane().add(red);
      getContentPane().add(green);
      getContentPane().add(bleu);
      pack();
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      JFrame frame = this;
      red.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            frame.getContentPane().setBackground(Color.RED);
         }
      });
      green.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            frame.getContentPane().setBackground(Color.GREEN);
         }
      });
      bleu.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            frame.getContentPane().setBackground(Color.BLUE);
         }
      });

   }

   public static void main(String[] args) {
      new Interface().setVisible(true);
   }
}
