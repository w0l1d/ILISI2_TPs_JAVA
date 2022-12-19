package com.java.ilisi.tp2bis;


public record Chambre(int numero, int categorie, double prix, int capacite, char etat) {
    @Override
    public String toString() {
        return numero() + ";" + categorie() + ";" + prix() + ";" + capacite() + ";" + etat();
    }
}
