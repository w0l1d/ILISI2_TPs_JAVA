package com.java.ilisi.tp3.critere;

import com.java.ilisi.tp3.Voiture;

import java.util.ArrayList;
import java.util.List;

public class InterCritere implements Critere {

    private final List<Critere> criteres;

    public InterCritere() {
        criteres = new ArrayList<>();
    }

    public void addCritere(Critere c) {
        criteres.add(c);
    }

    public void addCritere(List<Critere> cs) {
        criteres.addAll(cs);
    }

    @Override
    public boolean estSatisfaitPar(Voiture v) {
        return criteres.stream()
                .allMatch(critere -> critere.estSatisfaitPar(v));
    }
}
