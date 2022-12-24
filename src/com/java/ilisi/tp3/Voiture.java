package com.java.ilisi.tp3;

import java.util.Objects;

public record Voiture(String marque, String model, int annee, int prix) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return annee == voiture.annee
                && prix == voiture.prix
                && Objects.equals(marque, voiture.marque)
                && Objects.equals(model, voiture.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marque, model, annee, prix);
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "marque='" + marque + '\'' +
                ", model='" + model + '\'' +
                ", prix=" + prix +
                '}';
    }

}
