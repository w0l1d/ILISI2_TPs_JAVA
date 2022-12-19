package com.java.ilisi.tp3.location;

import com.java.ilisi.tp3.Client;
import com.java.ilisi.tp3.Voiture;

import java.util.Iterator;

public interface ILocation {

    /**
     * Permet au client client de louer la voiture v.
     * si elle est déjà louée (utilisez des exceptions).
     *
     * @param client client loueur
     * @param v      voiture a louee
     */
    void loueVoiture(Client client, Voiture v);

    /**
     * Renvoie true si et seulement
     * si client est un client qui loue actuellement une voiture.
     *
     * @param client client en question
     * @return si le client est loueur
     */
    boolean estLoueur(Client client);

    /**
     * Renvoie true si et seulement si la voiture est actuellement louée.
     *
     * @param v voiture en question
     * @return true la voiture est actuellement louée.
     */
    boolean estLouee(Voiture v);

    /**
     * Le client rend la voiture qu'il a louée.
     * Il ne se passe rien s’il n'avait pas loué de voiture.
     *
     * @param client clietn qui rend la voiture louee
     */
    void rendVoiture(Client client);


    /**
     * @return renvoie la collection des voitures de l'agence
     * qui sont actuellement louées
     */
    Iterator<Voiture> lesVoituresLouees();
}

