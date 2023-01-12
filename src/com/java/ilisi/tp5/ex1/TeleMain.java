package com.java.ilisi.tp5.ex1;

import com.java.ilisi.tp5.ex2.TeleMenu;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TeleMain {


   public static void main(String[] args) {
      Frame telephone = new Frame("Untitled");
      telephone.add(new TelephonePanel(), BorderLayout.CENTER);

      telephone.setMenuBar(new TeleMenu());
      telephone.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });

      telephone.setMinimumSize(new Dimension(300, 350));
      telephone.setVisible(true);
   }
}
