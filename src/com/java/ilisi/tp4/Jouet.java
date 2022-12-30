package com.java.ilisi.tp4;

public class Jouet {
    private final int num;
    private Boolean verified;

    public Jouet(int num) {
        this.num = num;
        this.verified = false;
    }

    public void tuEsVerifiePar(VerificateurJouet verifJouet) throws InterruptedException {
        synchronized (verified) {
            if (verified)
                return;
            verified = true;
        }
        verifJouet.verifieJouet(num);

    }
}
