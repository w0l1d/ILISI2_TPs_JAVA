package com.java.ilisi.tp3.exceptions;

import com.java.ilisi.tp3.Client;
import com.java.ilisi.tp3.Voiture;

public class ClientEstLoueurException extends RuntimeException {
    public ClientEstLoueurException(Client client, Voiture voiture) {
        super("le client a deja louee une voiture\nClient : "
                + client + "\nVoiture : " + voiture);
    }
}
