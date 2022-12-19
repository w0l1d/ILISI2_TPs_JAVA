package com.java.ilisi.tp1.ex3;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Vector;


public class Livre implements Serializable {
    private final String titre;
    private final Vector<String> auteurs;
    private final String isbn;
    private final double prix;

    public Livre(String titre, String isbn, double prix, String... auteurs) {
        this.auteurs = new Vector<>(Arrays.asList(auteurs));
        this.titre = titre;
        this.isbn = isbn.toUpperCase();
        this.prix = prix;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livre livre = (Livre) o;
        return Double.compare(livre.prix, prix) == 0
                && Objects.equals(titre, livre.titre)
                && Objects.equals(auteurs, livre.auteurs)
                && Objects.equals(isbn, livre.isbn);
    }

    boolean containsAuthor(String s) {
        return auteurs.stream().anyMatch(s1 -> s1.toUpperCase().startsWith(s.toUpperCase()));
    }

    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteurs=" + auteurs +
                ", isbn='" + isbn + '\'' +
                ", prix=" + prix +
                '}';
    }


    public String getTitre() {
        return titre;
    }

    public Vector<String> getAuteurs() {
        return auteurs;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrix() {
        return prix;
    }

}
