package com.java.ilisi.tp4.partie4Int;

public class VerificateurJouet implements Runnable {
   public final Thread thread;
   private final String name;
   private final int vitesse;
   private final int niveau;


   public VerificateurJouet(String name, int niveau, int vitesse) {
      this.name = name;
      this.vitesse = vitesse;
      this.niveau = niveau;
      thread = new Thread(this);
      thread.setName(name);
   }

   public int getNiveau() {
      return niveau;
   }

   public void verifieJouet(int jouet) throws InterruptedException {
      System.out.println(name + " teste le jouet " + jouet + ", il constate qu'il doit le vérifier");
      System.out.println(name + " commence la vérification du jouet " + jouet);
//       System.out.println("Le verificateur \"" + name + "\" verifie le jouet " + jouet);
      Thread.sleep((int) ((Math.random() * 10000) / vitesse));
      System.out.println(name + " a fini la vérification du jouet " + jouet);
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
