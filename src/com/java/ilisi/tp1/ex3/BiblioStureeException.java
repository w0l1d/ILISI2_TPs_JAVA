package com.java.ilisi.tp1.ex3;

public class BiblioStureeException extends Exception {
    public BiblioStureeException(int capacite) {
        super("Bibliotheque est saturee (" + capacite + ")!");
    }
}

