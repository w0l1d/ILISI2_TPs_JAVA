package com.java.ilisi.tp4.partie3;


public class VerificateurJouet implements Runnable {
   public final Thread thread;
   private final String name;

   public VerificateurJouet(String name) {
      this.name = name;
      thread = new Thread(this);
   }

   public void verifieJouet(int jouet) throws InterruptedException {
      System.out.println(name + " teste le jouet " + jouet + ", il constate qu'il doit le vérifier");
      System.out.println(name + " commence la vérification");
//        System.out.println("Le verificateur \"" + name + "\" verifie le jouet " + jouet);
      Thread.sleep((int) (Math.random() * 1000));
   }

   @Override
   public void run() {
      for (Jouet jouet : Simulation.lesJouets) {
         try {
            jouet.tuEsVerifiePar(this);
         } catch (InterruptedException e) {
            System.out.println(e.getMessage());
         }
      }
   }
}
