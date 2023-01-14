package com.java.ilisi.tp4.partie4Int;

public class Simulation {
   public static Jouet[] lesJouets;

   public static void main(String[] args) throws InterruptedException {
      lesJouets = new Jouet[10];
      for (int i = 0; i < lesJouets.length; i++)
         lesJouets[i] = new Jouet(i + 1);

      VerificateurJouet verifAhmed = new VerificateurJouet("Ahmed", 0, 10);
      VerificateurJouet verifAmine = new VerificateurJouet("Amine", 0, 5);
      VerificateurJouet verifBachir = new VerificateurJouet("Bachir", 2, 10);
      verifAhmed.thread.start();
      verifAmine.thread.start();
      verifBachir.thread.start();
      try {
         verifAhmed.thread.join();
         verifAmine.thread.join();
         verifBachir.thread.join();
      } catch (InterruptedException ex) {
         System.out.println(ex.getMessage());
      }

   }
}
