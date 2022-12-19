package com.java.ilisi.tp3.critere;

import com.java.ilisi.tp3.Voiture;

public final class CritereMarque implements Critere {

    private final String cMarque;

    public CritereMarque(String cMarque) {
        this.cMarque = cMarque;
    }

    @Override
    public boolean estSatisfaitPar(Voiture v) {
        return cMarque.equals(v.marque());
    }
}
