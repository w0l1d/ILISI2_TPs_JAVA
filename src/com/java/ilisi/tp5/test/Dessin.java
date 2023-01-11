package com.java.ilisi.tp5.test;

import java.awt.*;

public class Dessin extends Frame {
   public Dessin() {
      super("Fenêtre de dessin");
      CTrait c = new CTrait();
      add(BorderLayout.CENTER, c);
      pack();
      setVisible(true);
   }

   public static void main(String[] args) {
      Dessin f = new Dessin();
   }
}
