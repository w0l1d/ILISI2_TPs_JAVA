package com.java.ilisi.TP2bis;


public record Chambre(int numero, int categorie, double prix, int capacite, char etat) {

    @Override
    public String toString() {
        return numero() + ";" + categorie() + ";" + prix() + ";" + capacite() + ";" + etat();
    }


}
