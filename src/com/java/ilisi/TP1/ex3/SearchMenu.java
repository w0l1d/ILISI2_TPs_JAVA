package com.java.ilisi.TP1.ex3;

import java.util.InputMismatchException;
import java.util.Vector;

import static com.java.ilisi.TP1.ex3.Main.in;
import static com.java.ilisi.TP1.ex3.MainMenu.pressEnterToContinue;

public class SearchMenu {
    public static void handleSearchMenu(Bibliotheque biblio) {
        int choix = 0;
        do {
            try {
                choix = printSearchMenu();
                Livre l = null;
                Vector<Livre> v = null;
                switch (choix) {
                    case 1:
                        System.out.print("\nEntrer l'ISBN : ");
                        l = biblio.getParISBN(in.nextLine());
                        System.out.println(l);
                        break;
                    case 2:
                        System.out.print("\nEntrer le titre : ");
                        l = biblio.getParTitre(in.nextLine());
                        System.out.println(l);
                        break;
                    case 3:
                        System.out.print("\nEntrer l'auteur : ");
                        l = biblio.getAnyParAuteur(in.nextLine());
                        System.out.println(l);
                        break;
                    case 4:
                        System.out.print("\nEntrer l'auteur : ");
                        v = biblio.getAllParAuteur(in.nextLine());
                        System.out.println(v.isEmpty()?"Aucun livre n'est pas trouve":v);
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


    private static int printSearchMenu() throws InputMismatchException {
        System.out.print(
                """

                        ************ Menu de Recherche ************
                        1- Chercher par isbn
                        2- Chercher par titre
                        3- Chercher par auteur
                        3- Chercher tous les livres d'un auteur
                        99- Retourner

                        Entrer votre choix :\s"""
        );
        int c = in.nextInt();
        in.nextLine();
        return c;
    }
}
