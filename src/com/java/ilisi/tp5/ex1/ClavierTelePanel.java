package com.java.ilisi.tp5.ex1;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClavierTelePanel extends Panel {
   private final List<Button> btns;
   private final Button btnReset;
   private final Button btnBis;

   public ClavierTelePanel() {
      super(new GridLayout(4, 3));
      btns = new ArrayList<>();
      for (int i = 1; i < 10; i++) {
         Button btn = new Button(String.valueOf(i));
         btns.add(btn);
         add(btn);
      }
      add((btnBis = new Button("Bis")));
      btns.add(0, new Button("0"));
      add(btns.get(0));
      add((btnReset = new Button("Reset")));
   }


   public Button getNumberBtn(int number) {
      return btns.get(number);
   }

   public Button getBtnReset() {
      return btnReset;
   }

   public Button getBtnBis() {
      return btnBis;
   }
}
