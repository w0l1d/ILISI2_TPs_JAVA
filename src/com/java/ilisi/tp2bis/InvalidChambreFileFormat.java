package com.java.ilisi.tp2bis;

public class InvalidChambreFileFormat extends Exception {
    public InvalidChambreFileFormat(String line) {
        super("Format du ligne des donnees est Invalide\n" + line);
    }
}
