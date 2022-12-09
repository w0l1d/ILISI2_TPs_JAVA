package com.java.ilisi.TPX2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Hotel {


    private final Vector<Chambre> chambres;
    private final Scanner input;
    private int seqNumChambre;
    public Hotel() {
        this.chambres = new Vector<>();
        input = new Scanner(System.in);
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
        return chambres.stream().filter(chambre -> chambre.getCategorie() == cat).iterator();
    }

    public void sortByCapaciteAsc() {
        chambres.sort((o1, o2) -> o1.getCapacite() - o2.getCapacite());
    }
}
