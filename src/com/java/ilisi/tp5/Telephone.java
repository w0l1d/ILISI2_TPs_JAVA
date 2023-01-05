package com.java.ilisi.tp5;

import java.awt.*;
import java.awt.event.ActionListener;

public class Telephone {

   private static String AFFICHEUR_TELEPHONE = "";


   public static void main(String[] args) {
      TelephoneFrame teleFrame = new TelephoneFrame();
      teleFrame.pack();
      teleFrame.setVisible(true);

      ActionListener numBtnActLstn = e -> {
         AFFICHEUR_TELEPHONE += ((Button) e.getSource()).getLabel();
         teleFrame.getTxtPrinter().setText(String.valueOf(AFFICHEUR_TELEPHONE.charAt(AFFICHEUR_TELEPHONE.length() - 1)));
      };
      for (int i = 0; i < 10;
           teleFrame.getClvTele().getNumberBtn(i++)
                   .addActionListener(numBtnActLstn))
         ;

      teleFrame.getClvTele().getBtnReset().addActionListener(e -> teleFrame.getTxtPrinter().setText((AFFICHEUR_TELEPHONE = "")));
      teleFrame.getClvTele().getBtnBis().addActionListener(e -> teleFrame.getTxtPrinter().setText(AFFICHEUR_TELEPHONE));
   }
}
