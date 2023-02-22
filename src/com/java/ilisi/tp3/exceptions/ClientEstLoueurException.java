package com.java.ilisi.tp3.exceptions;

import com.java.ilisi.tp3.model.Client;
import com.java.ilisi.tp3.model.Voiture;

public class ClientEstLoueurException extends RuntimeException {
    public ClientEstLoueurException(Client client, Voiture voiture) {
        super("le client a deja louee une voiture\nClient : "
                + client + "\nVoiture : " + voiture);
    }
}
