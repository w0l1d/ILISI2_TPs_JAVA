package com.java.ilisi.tp4.part2;

public class Jouet {
    private final int num;

    public Jouet(int num) {
        this.num = num;
    }

    public synchronized void tuEsVerifiePar(VerificateurJouet verifJouet) throws InterruptedException {
        verifJouet.verifieJouet(num);
    }
}
