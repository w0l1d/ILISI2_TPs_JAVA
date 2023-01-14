package com.java.ilisi.tp3;

import com.java.ilisi.tp3.critere.Critere;
import com.java.ilisi.tp3.exceptions.CarAlreadyExistsException;
import com.java.ilisi.tp3.exceptions.VoitureEstLoueeException;
import com.java.ilisi.tp3.exceptions.VoitureNotFoundException;
import com.java.ilisi.tp3.location.Location;

import java.util.*;
import java.util.function.Supplier;

public class AgenceDAO extends Location {
    private final List<Voiture> voitures;
    private final Supplier<Map<Client, Voiture>> mapSupp;

    public AgenceDAO(Supplier<Map<Client, Voiture>> mapSupp, List<Voiture> voitures) {
        this.voitures = new ArrayList<>(voitures);
        this.mapSupp = mapSupp;
    }

    public AgenceDAO(Supplier<Map<Client, Voiture>> mapSupp) {
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

    public void removeVoiture(Voiture v) throws VoitureEstLoueeException, VoitureNotFoundException {
        if (!estDisponible(v))
            throw new VoitureNotFoundException(v);
        if (estLouee(v))
            throw new VoitureEstLoueeException(v);
        voitures.remove(v);
    }

    public void updateVoiture(Voiture v) throws VoitureNotFoundException {
        Voiture v0 = findVoitureByMatricule(v.matricule());
        if (v0 == null)
            throw new VoitureNotFoundException(v);
        voitures.set(voitures.indexOf(v0), v);
    }

    public Iterator<Voiture> getVoituresIterator() {
        return voitures.iterator();
    }

    public List<Voiture> getVoituresImmutable() {
        return Collections.unmodifiableList(voitures);
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

    public void addVoiture(Voiture voiture) throws CarAlreadyExistsException {
        if (voitureExistsByMatricule(voiture.matricule()))
            throw new CarAlreadyExistsException(voiture);
        this.voitures.add(voiture);
    }

    public boolean voitureExists(Voiture v) {
        return estDisponible(v);
    }

    public boolean voitureExistsByMatricule(String matricule) {
        return voitures.stream().anyMatch(v1 -> v1.matricule().equals(matricule));
    }

    public Voiture findVoitureByMatricule(String matricule) {
        return voitures.stream().filter(v -> v.matricule().equals(matricule)).findAny().orElse(null);
    }

}
