package com.java.ilisi.TP1.ex3;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.InputMismatchException;

import static com.java.ilisi.TP1.ex3.BibliothequeIO.DEFAULT_SAVE_FILE;
import static com.java.ilisi.TP1.ex3.Main.in;

public class MainMenu {
    private static int printMainMenu() throws InputMismatchException {

        System.out.print(
                """
                        ************Menu Bibliotheque************
                        1- Lister tous les livres
                        2- Ajouter un livre
                        3- chercher un livre
                        4- Supprimer un livre
                        5- Sauvegarder la bibliotheque
                        6- Charger la bibiotheque depuis un fichier
                        99- QUITTER

                        Entrer votre choix :\s"""
        );
        int c = in.nextInt();
        in.nextLine();
        return c;

    }


    public static void handleMainMenu(Bibliotheque biblio) {
        int choix = 0;
        do {
            try {
                choix = printMainMenu();
                switch (choix) {
                    case 1 -> System.out.print(biblio);
                    case 2 -> {
                        try {
                            Livre l = saisirLivre();
                            biblio.ajouterLivre(l);
                            System.out.printf("Livre \"%s\" est bien ajoute!", l.getTitre());
                        } catch (Exception e) {
                            System.err.println("Error: Ajout du livre est annule!");
                            System.err.println(e.getMessage());
                        }
                    }
                    case 3 -> SearchMenu.handleSearchMenu(biblio);
                    case 4 -> DeleteMenu.handleDeleteMenu(biblio);
                    case 5 -> {
                        System.out.println("\nvouliez entrer le chemin du fichier de sauvegarde?");
                        System.out.printf("(default %s) : ", Paths.get(DEFAULT_SAVE_FILE).toAbsolutePath());
                        String file = in.nextLine();
                        BibliothequeIO.saveBibliotheque(biblio, file.isEmpty() ? DEFAULT_SAVE_FILE : file);
                    }
                    case 6 -> {
                        System.out.println("vouliez entrer le chemin du fichier de sauvegarde?");
                        System.out.printf("(default %s) : ", Paths.get(DEFAULT_SAVE_FILE).toAbsolutePath());
                        String f = in.nextLine();
                        biblio = BibliothequeIO.loadBibliotheque(f.isEmpty() ? DEFAULT_SAVE_FILE : f);
                    }
                    case 99 -> System.out.println("Good bye");
                    default -> System.err.println("\nError: choix invalide");
                }

            } catch (InputMismatchException e) {
                System.err.println("\nError: choix invalide");
            }
            if (choix != 99)
                pressEnterToContinue();
        } while (choix != 99);
    }

    private static Livre saisirLivre() throws IOException {

        System.out.print("Enter le titre : ");
        String titre = in.nextLine();
        System.out.print("Enter le ISBN : ");
        String isbn = in.nextLine();
        System.out.print("Enter le prix : ");
        double prix = in.nextDouble();
        in.nextLine();

        System.out.print("Enter le nombre d'auteur du livre : ");
        int n = in.nextInt();
        in.nextLine();

        String[] auts = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\nEntrer le nom du auteur " + (i + 1) + " : ");
            auts[i] = in.nextLine();
        }
        return new Livre(titre, isbn, prix, auts);
    }


    public static void pressEnterToContinue() {
        System.out.println("\nPress Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
    }

}
