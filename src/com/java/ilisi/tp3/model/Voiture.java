package com.java.ilisi.tp3.model;

import java.io.Serializable;
import java.util.Objects;

public record Voiture(String matricule, String marque,
                      String model, int annee, int prix) implements Serializable {

   @Override
   public String toString() {
      return matricule + ", " + marque + ", " + model + ", " + annee + ", " + prix;
   }

   public Object[] toArray() {
      return new Object[]{matricule, marque, model,
              annee, prix};
   }

    public String[] toSArray() {
        return new String[]{matricule, marque, model,
                String.valueOf(annee), String.valueOf(prix)};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return annee == voiture.annee && prix == voiture.prix
                && Objects.equals(matricule, voiture.matricule)
                && Objects.equals(marque, voiture.marque)
                && Objects.equals(model, voiture.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricule, marque, model, annee, prix);
    }
}
