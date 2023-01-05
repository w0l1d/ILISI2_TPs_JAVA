package com.java.ilisi.tp5;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelephoneFrame extends Frame {
   private final ClavierTelePanel clvTele;
   private final TextField txtPrinter;

   public TelephoneFrame() {
      super("Untitled");
      setLayout(new BorderLayout());
      txtPrinter = new TextField();
      add(txtPrinter, BorderLayout.NORTH);
      add((clvTele = new ClavierTelePanel()), BorderLayout.CENTER);
      this.setMinimumSize(new Dimension(300, 350));
      this.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });

   }

   public ClavierTelePanel getClvTele() {
      return clvTele;
   }

   public TextField getTxtPrinter() {
      return txtPrinter;
   }
}
