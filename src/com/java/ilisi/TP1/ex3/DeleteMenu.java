package com.java.ilisi.TP1.ex3;

import java.util.InputMismatchException;

import static com.java.ilisi.TP1.ex3.Main.in;
import static com.java.ilisi.TP1.ex3.MainMenu.pressEnterToContinue;

public class DeleteMenu {
    private static int printDeleteMenu() throws InputMismatchException {

        System.out.print(
                """
                        ************Menu de Suppression ************
                        1- Supprimer ISBN
                        2- Supprimer par titre
                        3- Supprimer par auteur
                        99- RETOURNER

                        Entrer votre choix :\s"""
        );
        int c = in.nextInt();
        in.nextLine();
        System.out.println();
        return c;
    }


    public static void handleDeleteMenu(Bibliotheque biblio) {
        int choix = 0;
        do {
            try {
                choix = printDeleteMenu();
                switch (choix) {
                    case 1:
                        System.out.print("\nEntrer l'ISBN : ");
                        biblio.suppParISBN(in.nextLine());
                        System.out.println("Livre est bien supprime!");
                        break;
                    case 2:
                        System.out.print("\nEntrer le titre : ");
                        biblio.suppParTitre(in.nextLine());
                        System.out.println("Livre est bien supprime!");
                        break;
                    case 3:
                        System.out.print("\nEntrer l'auteur : ");
                        biblio.suppAnyParAuteur(in.nextLine());
                        System.out.println("Livre est bien supprime!");
                        break;
                    case 99:
                        break;
                    default:
                        System.err.println("\nError: choix invalide");
                }
            } catch (InputMismatchException e) {
                System.err.println("\nError: choix invalide");
            } catch (LivreNonTrouveException e) {
                System.err.println("\nLivre n'est pas trouve");
            }
            if (choix != 99)
                pressEnterToContinue();
        } while (choix != 99);
    }
}
