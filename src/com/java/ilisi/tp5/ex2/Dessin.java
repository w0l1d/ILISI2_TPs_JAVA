package com.java.ilisi.tp5.ex2;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dessin extends Canvas {

   Point startPoint;
   Point endPoint;
   private String shapeName = "Rectangle";
   private Color color = Color.BLACK;
   private boolean isRempli = false;


   public Dessin() {
      Dessin d = this;
      MouseAdapter mouseAdapter = new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            startPoint = e.getPoint();
         }

         @Override
         public void mouseDragged(MouseEvent e) {
            endPoint = e.getPoint();
            d.repaint();
         }
      };
      addMouseListener(mouseAdapter);
      addMouseMotionListener(mouseAdapter);
   }

   @Override
   public Dimension getMinimumSize() {
      return new Dimension(350, 400);
   }


   @Override
   public Dimension getPreferredSize() {
      return getMinimumSize();
   }

   private Pair calcStartPoint(Point p1, Point p2) {
      if (p1.x > p2.x) {
         if (p1.y < p2.y)
            return new Pair(p2.x, p1.y, p1.x, p2.y);
         if (p1.y > p2.y)
            return new Pair(p2, p1);
      }
      if (p1.y > p2.y)
         return new Pair(p1.x, p2.y, p2.x, p1.y);
      return new Pair(p1, p2);
   }

   @Override
   public void paint(Graphics g) {
      if (startPoint == null || endPoint == null)
         return;
      if (startPoint.x == endPoint.x || startPoint.y == endPoint.y)
         return;
      Pair pts = calcStartPoint(startPoint, endPoint);
      int x = pts.p1.x,
              y = pts.p1.y,
              w = Math.abs(pts.p2.x - pts.p1.x),
              h = Math.abs(pts.p2.y - pts.p1.y);

//      System.out.println("Start (%d, %d), end(%d, %d)".formatted(pts.p1.x, pts.p1.y, pts.p2.x, pts.p2.y));

      if (color != null)
         g.setColor(color);

      switch (shapeName) {
         case "Rectangle" -> {
            if ((!isRempli)) g.drawRect(x, y, w, h);
            else g.fillRect(x, y, w, h);
         }
         case "Circle" -> {
            if ((!isRempli)) g.drawOval(x, y, w, h);
            else g.fillOval(x, y, w, h);
         }
         case "Round Rectangle" -> {
            if ((!isRempli)) g.drawRoundRect(x, y, w, h, 4, 4);
            else g.fillRoundRect(x, y, w, h, 4, 4);
         }
         case "3D Rectangle" -> {
            if ((!isRempli)) g.draw3DRect(x, y, w, h, isRempli);
            else g.fill3DRect(x, y, w, h, isRempli);
         }
//         case "Round Rectangle" -> {
//            if ((!isRempli)) g.drawRoundRect(x, y, w, h, 4, 4);
//            else g.fillRoundRect(x, y, w, h, 4, 4);
//         }
         case "Line" -> {
            g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
         }
      }

   }

   public void setShapeName(String shapeName) {
      this.shapeName = shapeName;
   }

   public void setColor(Color color) {
      this.color = color;
   }

   public void setRempli(boolean rempli) {
      isRempli = rempli;
   }

}


class Pair {
   public Point p1, p2;

   public Pair(Point p1, Point p2) {
      this.p1 = p1;
      this.p2 = p2;
   }

   public Pair(int x1, int y1, int x2, int y2) {
      this.p1 = new Point(x1, y1);
      this.p2 = new Point(x2, y2);
   }
}