package com.java.ilisi.tp5;

import java.awt.*;

public class Pair {
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
