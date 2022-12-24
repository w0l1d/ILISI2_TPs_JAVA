package com.java.ilisi.tp4.part2;

public class Jouet {
    private int num;

    public void tuEsVerifiePar(VerificateurJouet verifJouet) throws InterruptedException {
        verifJouet.verifieJouet(num);
    }

}
