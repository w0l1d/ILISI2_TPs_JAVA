package com.java.ilisi.tp5.ex1;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelephoneFrame extends Frame {
   private final ClavierTelePanel clvTele;
   private final TextField txtPrinter;
   private static String AFFICHEUR_TELEPHONE = "";

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

      ActionListener numBtnActLstn = e -> {
         AFFICHEUR_TELEPHONE += ((Button) e.getSource()).getLabel();
         getTxtPrinter().setText(String.valueOf(AFFICHEUR_TELEPHONE.charAt(AFFICHEUR_TELEPHONE.length() - 1)));
      };

      for (int i = 0; i < 10;
           getClvTele()
                   .getNumberBtn(i++)
                   .addActionListener(numBtnActLstn))
         ;

      getClvTele().getBtnReset().addActionListener(e -> getTxtPrinter().setText((AFFICHEUR_TELEPHONE = "")));
      getClvTele().getBtnBis().addActionListener(e -> getTxtPrinter().setText(AFFICHEUR_TELEPHONE));


      setVisible(true);
   }

   public ClavierTelePanel getClvTele() {
      return clvTele;
   }

   public TextField getTxtPrinter() {
      return txtPrinter;
   }
}
