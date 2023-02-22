package com.java.ilisi.tp3.exceptions;

import com.java.ilisi.tp3.model.Voiture;

public class VoitureEstLoueeException extends RuntimeException {
    public VoitureEstLoueeException(Voiture voiture) {
        super("Voiture est deja louee\n" + voiture);
    }
}
