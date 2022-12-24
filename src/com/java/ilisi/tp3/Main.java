package com.java.ilisi.tp3;

import com.java.ilisi.tp3.critere.Critere;
import com.java.ilisi.tp3.critere.CritereMarque;
import com.java.ilisi.tp3.critere.CriterePrix;
import com.java.ilisi.tp3.critere.InterCritere;
import com.java.ilisi.tp3.enums.Civilite;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        List<Voiture> voitures = List.of(
                new Voiture("Renault", "Clio", 2009, 100),
                new Voiture("Volvo", "zeta", 2016, 99),
                new Voiture("peugeot", "partner", 2003, 90),
                new Voiture("skoda", "alpha", 2009, 50),
                new Voiture("rover", "gama", 2016, 20),
                new Voiture("Mazi", "lexa", 2020, 700),
                new Voiture("tesla", "S serie", 2022, 300),
                new Voiture("Ford", "transite", 2006, 40),
                new Voiture("Ferari", "La Ferari", 2016, 600),
                new Voiture("Renault", "R4", 2000, 10)
        );

//        Iterator<Voiture> iterator = voitures.iterator();
//        Collections.sort(voitures, Comparator.comparing(Voiture::marque));

        /*
         * Q 5 . En supposant que la référence agence est de type Agence
         *        et a été initialisée, donnez la ou les lignes de code
         *        permettant d'afficher toutes les voitures de cette agence
         *        dont le prix est inférieur à 100.
         */
        CriterePrix criterePrix = new CriterePrix(100);
        Agence agenceHash = new Agence(HashMap::new);
        agenceHash.addVoitures(voitures);
        System.out.println("""
                                
                ******************************************************
                les voitures qui satisfaient le critere du prix < 100
                ******************************************************
                """);
        agenceHash.afficherSelectionne(criterePrix);


        /*
            Q 7. Donnez la ou les lignes de code permettant de créer
                un critère intersection d'un critère pour la marque "Renaut",
                d’une année de production 2009
                et d'un critère pour un prix inférieur à 100.
         */

        InterCritere interCritere = new InterCritere();
        interCritere.addCritere(List.of(
                new CritereMarque("Renault"),
                new CriterePrix(100),
                new Critere() {
                    @Override
                    public boolean estSatisfaitPar(Voiture v) {
                        return v.annee() == 2009;
                    }
                }
        ));
        System.out.println("""
                                
                ******************************************************
                les voitures qui satisfaient les criteres :
                -> annee de production est 2009
                -> marque est "Renault"
                -> prix < 100
                ******************************************************
                """);
        agenceHash.afficherSelectionne(interCritere);

        // les clients de l'agence
        Client c1 = new Client("cli1", "man1", "X1234", Civilite.M),
                c2 = new Client("cli2", "man2", "Z1234", Civilite.M),
                c3 = new Client("cli3", "woman1", "W1234", Civilite.Mlle),
                c4 = new Client("cli4", "woman2", "R1234", Civilite.Mme);


        /*
         * Tester les locations avec HashMap
         */
        System.out.println("""
                                
                **********************************************************
                                    Test des Locations : HashMap
                **********************************************************
                """);
        {

            agenceHash.loueVoiture(c1, voitures.get(0));
            agenceHash.loueVoiture(c2, voitures.get(4));
            // Error :client "c1" a deja louee une voiture ("v0")
            try {
                agenceHash.loueVoiture(c1, voitures.get(3));
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.err.println();
            }
            // Error :voiture est deja louee par "c1"
            try {
                agenceHash.loueVoiture(c4, voitures.get(0));
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.err.println();
            }
            // Error :voiture n'existe pas dans l'agence
            try {
                agenceHash.loueVoiture(c3,
                        new Voiture("unconnu", "unconnuModel",
                                2000, 50));
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.err.println();
            }
            agenceHash.loueVoiture(c3, voitures.get(5));
            agenceHash.loueVoiture(c4, voitures.get(1));

            // l'ensemble des voitures louees
            agenceHash.afficherVoituresLouees();
        }




        /*
         * Tester les locations avec TreeMap
         */
        System.out.println("""
                                
                **********************************************************
                                    Test des Locations : TreeMap
                **********************************************************
                """);
        {

            Agence agenceTree = new Agence(TreeMap::new);
            agenceTree.addVoitures(voitures);

            agenceTree.loueVoiture(c1, voitures.get(0));
            agenceTree.loueVoiture(c2, voitures.get(4));
            // Error :client "c1" a deja louee une voiture ("v0")
            try {
                agenceTree.loueVoiture(c1, voitures.get(3));
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.err.println();
            }
            // Error :voiture est deja louee par "c1"
            try {
                agenceTree.loueVoiture(c4, voitures.get(0));
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.err.println();
            }
            // Error :voiture n'existe pas dans l'agence
            try {
                agenceTree.loueVoiture(c3,
                        new Voiture("unconnu", "unconnuModel",
                                2000, 50));
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.err.println();
            }
            agenceTree.loueVoiture(c3, voitures.get(5));
            agenceTree.loueVoiture(c4, voitures.get(1));

            // l'ensemble des voitures louees
            agenceTree.afficherVoituresLouees();
        }

    }
}
