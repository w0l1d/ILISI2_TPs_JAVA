package com.java.ilisi.tp5.ex1;

import java.awt.*;
import java.awt.event.ActionListener;

public class TelephonePanel extends Panel {
   private static String AFFICHEUR_TELEPHONE = "";
   private final ClavierTelePanel clvTele;
   private final TextField txtPrinter;

   public TelephonePanel() {

      setLayout(new BorderLayout());

      txtPrinter = new TextField();
      add(txtPrinter, BorderLayout.NORTH);
      add((clvTele = new ClavierTelePanel()), BorderLayout.CENTER);
      this.setMinimumSize(new Dimension(300, 350));

      ActionListener numBtnActLstn = e -> {
         getTxtPrinter().setText(
                 getTxtPrinter().getText() + ((Button) e.getSource()).getLabel()
         );
      };

      for (int i = 0; i < 10;
           getClvTele()
                   .getNumberBtn(i++)
                   .addActionListener(numBtnActLstn))
         ;

      getClvTele().getBtnReset().addActionListener(e -> {
         AFFICHEUR_TELEPHONE = getTxtPrinter().getText();
         getTxtPrinter().setText("");
      });
      getClvTele().getBtnBis().addActionListener(e -> getTxtPrinter().setText(AFFICHEUR_TELEPHONE));


   }

   public ClavierTelePanel getClvTele() {
      return clvTele;
   }

   public TextField getTxtPrinter() {
      return txtPrinter;
   }
}
