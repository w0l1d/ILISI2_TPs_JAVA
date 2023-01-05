package com.java.ilisi.tp4.partie4;

public class Jouet {
   private final int num;
   private boolean verified;

   public Jouet(int num) {
      this.num = num;
      this.verified = false;
   }

   public void tuEsVerifiePar(VerificateurJouet verifJouet) throws InterruptedException {
      synchronized (this) {
         while (!verified && verifJouet.getNiveau() == 1)
            wait();
         if (verified && verifJouet.getNiveau() == 0)
            return;
         verified = true;
      }

      verifJouet.verifieJouet(num);
      synchronized (this) {
         notifyAll();
      }
   }

}
