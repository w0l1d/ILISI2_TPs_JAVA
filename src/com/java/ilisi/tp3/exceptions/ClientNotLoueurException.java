package com.java.ilisi.tp3.exceptions;

import com.java.ilisi.tp3.model.Client;

public class ClientNotLoueurException extends RuntimeException {
    public ClientNotLoueurException(Client client) {
        super("le client n'a pas louee une voiture\n" + client);
    }
}
