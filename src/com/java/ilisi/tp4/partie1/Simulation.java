package com.java.ilisi.tp4.partie1;

public class Simulation {

   public static Jouet[] lesJouets;

   public static void main(String[] args) throws InterruptedException {
      lesJouets = new Jouet[]{new Jouet(1), new Jouet(2), new Jouet(3), new Jouet(4), new Jouet(5),
              new Jouet(6), new Jouet(7), new Jouet(8), new Jouet(9), new Jouet(10)};

      VerificateurJouet verifAmine = new VerificateurJouet("Ahmed");
      VerificateurJouet verifAhmed = new VerificateurJouet("Amine");
      verifAhmed.thread.start();
      verifAmine.thread.start();
      try {
         verifAhmed.thread.join();
      } catch (InterruptedException ex) {
         System.out.println(ex.getMessage());
      }
      try {
         verifAmine.thread.join();
      } catch (InterruptedException ex) {
         System.out.println(ex.getMessage());
      }
   }
}
