package com.java.ilisi.tp5.ex2;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;

public class Planche extends Frame {

   public static final List<String> SHAPES_LIST
           = List.of("Rectangle", "Circle", "Round Rectangle", "Line");
   public static final Map<String, Color> COLORS_MAP = Map.of("Noir", Color.BLACK, "Rouge", Color.RED,
           "Jaune", Color.YELLOW, "Bleu", Color.BLUE,
           "Vert", Color.GREEN, "Orange", Color.ORANGE);
   Checkbox isRempliCheckBox;
   private final Dessin dessin;
   private final CheckboxGroup colorsGroup;
   private final Choice shapeCh;

   public Planche() throws HeadlessException {
      super("Planche de dessin");
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
      setLayout(new BorderLayout());

      Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (int) ((dimension.getWidth() - getWidth()) / 2);
      int y = (int) ((dimension.getHeight() - getHeight()) / 2);
      setLocation(x, y);


      dessin = new Dessin();
      dessin.setMinimumSize(new Dimension(350, 220));
      add(dessin, BorderLayout.CENTER);

      Panel toolbarPanel = new Panel(new GridLayout(3, 2));
      toolbarPanel.add(new Label("Shape choice"));

      shapeCh = new Choice();
      SHAPES_LIST.forEach(shapeCh::add);
      shapeCh.addItemListener(e -> dessin.setShapeName(((Choice) e.getSource()).getSelectedItem()));
      toolbarPanel.add(shapeCh);


      toolbarPanel.add(new Label("Color choice"));
      Panel colorsPanel = new Panel(new GridLayout(COLORS_MAP.size() / 3, 3));
      colorsGroup = new CheckboxGroup();
      COLORS_MAP.forEach((key, value) -> {
         var c = new Checkbox(key);
         c.setBackground(value);
         c.setCheckboxGroup(colorsGroup);
         c.addItemListener(e -> dessin.setColor(value));
         colorsPanel.add(c);
      });
      toolbarPanel.add(colorsPanel);


      toolbarPanel.add(new Label("Choix de remplissage"));
      isRempliCheckBox = new Checkbox();
      isRempliCheckBox.addItemListener(e -> dessin.setRempli(((Checkbox) e.getSource()).getState()));
      toolbarPanel.add(isRempliCheckBox);
      add(toolbarPanel, BorderLayout.SOUTH);
   }
}
