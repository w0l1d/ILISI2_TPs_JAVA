package com.java.ilisi.tp5.ex1;

import java.awt.*;

public class TeleMenu extends MenuBar {

   public TeleMenu() {
      Menu menu = new Menu("File");
      MenuItem item = new MenuItem("Exit");
      item.addActionListener(e -> System.exit(0));
      menu.add(item);
      add(menu);
   }
}
