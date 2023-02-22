package com.java.ilisi.tp3.location;

import com.java.ilisi.tp3.exceptions.ClientEstLoueurException;
import com.java.ilisi.tp3.exceptions.ClientNotLoueurException;
import com.java.ilisi.tp3.exceptions.VoitureEstLoueeException;
import com.java.ilisi.tp3.exceptions.VoitureNotFoundException;
import com.java.ilisi.tp3.model.Client;
import com.java.ilisi.tp3.model.Voiture;

import java.util.Iterator;
import java.util.Map;

public abstract class Location implements ILocation {
    private Map<Client, Voiture> locations;

    public Map<Client, Voiture> getLocation() {
        if (locations == null)
            locations = getInstanceOf();
        return locations;
    }

    protected abstract Map<Client, Voiture> getInstanceOf();

    @Override
    public void loueVoiture(Client client, Voiture voiture) {
        if (estLoueur(client))
            throw new ClientEstLoueurException(client, voiture);
        if (!estDisponible(voiture))
            throw new VoitureNotFoundException(voiture);
        if (estLouee(voiture))
            throw new VoitureEstLoueeException(voiture);

        getLocation().put(client, voiture);
    }

    @Override
    public boolean estLoueur(Client client) {
        return getLocation().containsKey(client);
    }

    @Override
    public boolean estLouee(Voiture v) {
        return getLocation().containsValue(v);
    }

    public abstract boolean estDisponible(Voiture v);

    @Override
    public void rendVoiture(Client client) {
        if (!estLoueur(client))
            throw new ClientNotLoueurException(client);

        getLocation().remove(client);
    }

    @Override
    public Iterator<Voiture> lesVoituresLouees() {
        return getLocation().values().iterator();
    }

    public void afficherVoituresLouees() {
        Iterator<Voiture> voitureIterator = lesVoituresLouees();
        if (!voitureIterator.hasNext()) {
            System.err.println("Aucun voiture n'est louee");
            return;
        }
        System.out.println("les voitures louees :");
        while (voitureIterator.hasNext())
            System.out.println(voitureIterator.next());
    }
}
