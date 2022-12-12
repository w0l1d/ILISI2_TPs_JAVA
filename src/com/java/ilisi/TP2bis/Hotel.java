package com.java.ilisi.TP2bis;

import java.util.*;
import java.util.stream.Collectors;

public class Hotel {
    private static final Scanner input = new Scanner(System.in);
    private final List<Chambre> chambres;
    private int seqNumChambre;

    public Hotel(List<Chambre> chambres) {
        this.chambres = chambres;
        seqNumChambre = chambres.stream()
                .max(Comparator.comparingInt(Chambre::numero))
                .map(Chambre::numero).orElse(0) + 1;
    }

    public Hotel() {
        this.chambres = new Vector<>();
        seqNumChambre = 1;
    }

    public void ajouterChambreInput() {
        System.out.print("\nEntrer la categorie de la chambre : ");
        int cat = input.nextInt();

        System.out.print("\nEntrer le prix de la chambre : ");
        double prix = input.nextDouble();

        System.out.print("\nEntrer la capacite de la chambre : ");
        int cap = input.nextInt();

        chambres.add(new Chambre(seqNumChambre++, cat, prix, cap, 'L'));
    }


    public Iterator<Chambre> getChambres() {
        return chambres.iterator();
    }

    public Iterator<Chambre> getByCategorie(int cat) {
        return chambres.stream().filter(chambre -> chambre.categorie() == cat).iterator();
    }

    public void printByCategory(int cat) {
        System.out.println(chambres.stream().filter(c -> c.categorie() == cat).map(Chambre::toString).collect(Collectors.joining("\n")));
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "chambres=" + chambres +
                ", seqNumChambre=" + seqNumChambre +
                '}';
    }

    public void sortByCapaciteAsc() {
        chambres.sort(Comparator.comparingInt(Chambre::capacite));
    }
}
