package com.java.ilisi.TP1.ex3;

import java.util.function.Supplier;

public class LivreNonTrouveException extends Exception {
    public LivreNonTrouveException() {
        super("Livre n'est pas trouve");
    }


}
