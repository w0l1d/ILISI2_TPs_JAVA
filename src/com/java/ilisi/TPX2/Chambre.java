package com.java.ilisi.TPX2;

public class Chambre {
    private int numero;
    private int categorie;
    private double prix;
    private int capacite;
    private char etat;


    public Chambre(int numero, int categorie, double prix, int capacite, char etat) {
        this.numero = numero;
        this.categorie = categorie;
        this.prix = prix;
        this.capacite = capacite;
        this.etat = etat;
    }



    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCategorie() {
        return categorie;
    }

    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public char getEtat() {
        return etat;
    }

    public void setEtat(char etat) {
        this.etat = etat;
    }
}
