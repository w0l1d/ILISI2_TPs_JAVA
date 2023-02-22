package com.java.ilisi.tp3.exceptions;

import com.java.ilisi.tp3.model.Voiture;

public class VoitureNotFoundException extends RuntimeException {
    public VoitureNotFoundException(Voiture voiture) {
        super("Voiture n'existe pas\n" + voiture);
    }
}
