package exams.clickCount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickCount extends JFrame {

   public ClickCount() throws HeadlessException {
      super("Click counts");
      setSize(new Dimension(200, 200));
      JButton count = new JButton("0");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      getContentPane().add(count);
      count.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            count.setText((Integer.parseInt(count.getText()) + 1) + "");
         }
      });

   }

   public static void main(String[] args) {
      new ClickCount().setVisible(true);
   }
}
