package com.java.ilisi.tp5.test;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class CTrait extends Canvas implements MouseListener {
   Point pt;

   public CTrait() {
      addMouseListener(this);
   }

   public void paint(Graphics g) {
      g.drawRect(0, 0, pt.x, pt.y);
      g.setColor(Color.red);
      g.drawString("(" + pt.x + ";" + pt.y + ")", pt.x, pt.y + 5);
   }

   public Dimension getMinimumSize() {
      return new Dimension(200, 100);
   }

   public Dimension getPreferredSize() {
      return getMinimumSize();
   }

   public void mouseClicked(MouseEvent e) {
   }

   public void mousePressed(MouseEvent e) {
   }

   public void mouseReleased(MouseEvent e) {
      pt = e.getPoint();
      repaint();
   }

   public void mouseEntered(MouseEvent e) {
   }

   public void mouseExited(MouseEvent e) {
   }
}
