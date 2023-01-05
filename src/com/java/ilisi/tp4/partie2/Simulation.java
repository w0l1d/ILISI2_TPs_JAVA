package com.java.ilisi.tp4.partie2;

public class Simulation {

   public static Jouet[] lesJouets;

   public static void main(String[] args) throws InterruptedException {
      lesJouets = new Jouet[10];
      for (int i = 0; i < lesJouets.length; i++)
         lesJouets[i] = new Jouet(i + 1);

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
