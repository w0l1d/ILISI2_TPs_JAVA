package com.java.ilisi.tp4.partie41;

public class Simulation {
   public static Jouet[] lesJouets;

   public static void main(String[] args) throws InterruptedException {
      lesJouets = new Jouet[10];
      for (int i = 0; i < lesJouets.length; i++)
         lesJouets[i] = new Jouet(i + 1);

      VerificateurJouet verifAhmed = new VerificateurJouet("Ahmed", false);
      VerificateurJouet verifAmine = new VerificateurJouet("Amine", false);
      VerificateurJouet verifBachir = new VerificateurJouet("Bachir", true);
      verifAhmed.thread.start();
      verifAmine.thread.start();
      verifBachir.thread.start();
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

      try {
         verifBachir.thread.join();
      } catch (InterruptedException ex) {
         System.out.println(ex.getMessage());
      }
   }
}
