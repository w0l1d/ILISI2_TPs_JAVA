package com.java.ilisi.tp3.critere;

import com.java.ilisi.tp3.Voiture;

public final class CriterePrix implements Critere {

    private final int cPrix;

    public CriterePrix(int cPrix) {
        this.cPrix = cPrix;
    }

    @Override
    public boolean estSatisfaitPar(Voiture v) {
        return cPrix > v.prix();
    }
}
