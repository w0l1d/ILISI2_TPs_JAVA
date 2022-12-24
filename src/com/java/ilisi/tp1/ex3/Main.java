package com.java.ilisi.tp1.ex3;

import java.nio.file.Paths;
import java.util.Scanner;

import static com.java.ilisi.tp1.ex3.BibliothequeIO.DEFAULT_SAVE_FILE;

public class Main {

    public static final Scanner in = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("vous voulez initilaise une nouvelle bibliotheque : (y/n)");
        String choix = in.nextLine();
        if (choix.toUpperCase().startsWith("Y")) {
            System.out.println("Entrer la capacite du bibliotheque : ");
            Bibliotheque biblio = new Bibliotheque(in.nextInt());
            in.nextLine();
            MainMenu.handleMainMenu(biblio);
        } else {
            System.out.println("\nEntrer le chemin du fichier de sauvegarde:");
            System.out.printf("(default %s) : ", Paths.get(DEFAULT_SAVE_FILE).toAbsolutePath());
            String f = in.nextLine();
            Bibliotheque biblio;
            try {
                biblio = BibliothequeIO.loadBibliotheque(f.isEmpty() ? DEFAULT_SAVE_FILE : f);
            } catch (Exception ex) {
                System.err.println("Erreur lors du chargement du bibiliotheque");
                biblio = new Bibliotheque(50);
            }
            MainMenu.handleMainMenu(biblio);
        }

    }
}
