package com.java.ilisi.tp2bis;


public class Chambre {
    int numero;
    int categorie;
    double prix;
    int capacite;
    char etat;


    public Chambre(int numero, int categorie, double prix, int capacite) {
        this.numero = numero;
        this.categorie = categorie;
        this.prix = prix;
        this.capacite = capacite;
        this.etat = 'L';
    }

    public Chambre(int numero, int categorie, double prix, int capacite, char etat) {
        this.numero = numero;
        this.categorie = categorie;
        this.prix = prix;
        this.capacite = capacite;
        this.etat = etat;
    }

    public int numero() {
        return numero;
    }

    public int categorie() {
        return categorie;
    }

    public double prix() {
        return prix;
    }

    public int capacite() {
        return capacite;
    }

    public char etat() {
        return etat;
    }

    @Override
    public String toString() {
        return numero() + ";" + categorie() + ";" + prix() + ";" + capacite() + ";" + etat();
    }
}
