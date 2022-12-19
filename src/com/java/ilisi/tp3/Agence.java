package com.java.ilisi.tp3;

import com.java.ilisi.tp3.critere.Critere;
import com.java.ilisi.tp3.location.Location;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Agence extends Location {
    private final List<Voiture> voitures;
    private final Supplier<Map<Client, Voiture>> mapSupp;

    public Agence(Supplier<Map<Client, Voiture>> mapSupp, List<Voiture> voitures) {
        this.voitures = new ArrayList<>(voitures);
        this.mapSupp = mapSupp;
    }

    public Agence(Supplier<Map<Client, Voiture>> mapSupp) {
        this.voitures = new ArrayList<>();
        this.mapSupp = mapSupp;
    }

    @Override
    protected Map<Client, Voiture> getInstanceOf() {
        return mapSupp.get();
    }

    @Override
    public boolean estDisponible(Voiture v) {
        return voitures.stream()
                .anyMatch(voiture -> voiture.equals(v));
    }

    public Iterator<Voiture> selectionne(Critere c) {
        return voitures.stream().filter(c::estSatisfaitPar).iterator();
    }

    public void afficherSelectionne(Critere c) {
        Iterator<Voiture> i = selectionne(c);
        if (!i.hasNext())
            System.out.println("Pas de voitures selectionnees");
        while (i.hasNext())
            System.out.println(i.next());
    }

    public void addVoitures(List<Voiture> voitures) {
        this.voitures.addAll(voitures);
    }

    public void addVoiture(Voiture voiture) {
        this.voitures.add(voiture);
    }


}
