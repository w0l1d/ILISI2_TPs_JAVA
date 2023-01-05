package com.java.ilisi.tp4.partie4Int;

public class Jouet {
   private final int num;
   private Integer verified;

   public Jouet(int num) {
      this.num = num;
      this.verified = 0;
   }

   public void tuEsVerifiePar(VerificateurJouet verifJouet) throws InterruptedException {
      synchronized (this) {
         // superieur heirarchique en attente des employee pour verifie le jouet
         while (verifJouet.getNiveau() > verified)
            wait();
         // jouet et deja verifier par un autre employee
         if (verifJouet.getNiveau() < verified)
            return;

         // si le jouet est verifier par l'employee et son superieur
         if (verified > 2)
            return;
         verified++;
      }

      verifJouet.verifieJouet(num);
      synchronized (this) {
         verified++;
         notifyAll();
      }
   }

}
