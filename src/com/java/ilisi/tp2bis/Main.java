package com.java.ilisi.tp2bis;

import java.io.IOException;
import java.util.List;

import static com.java.ilisi.tp2bis.HotelIO.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Hotel hotel1 = new Hotel(List.of(
                new Chambre(1, 1, 55.66, 2),
                new Chambre(2, 1, 39.99, 1),
                new Chambre(3, 2, 199.99, 3),
                new Chambre(4, 3, 500.50, 5),
                new Chambre(5, 9, 299.95, 3),
                new Chambre(6, 100, 999.99, 1),
                new Chambre(7, 2, 100.99, 5)
        ));


        System.out.println("""
                                
                *****************************************************************
                  sauvegarde des chambres initialles dans le fichier par defaut
                *****************************************************************
                """);
        System.out.println(hotel1);
        saveHotel(DEFAULT_HOTEL_SAVEFILE, hotel1);

        System.out.println("""
                                
                ********************************************************
                     chargement des chambre du fichier par default
                ********************************************************
                """);
        Hotel hotel;
        try {
            hotel = loadHotel(DEFAULT_HOTEL_SAVEFILE);
        } catch (IOException | InvalidChambreFileFormat e) {
            System.err.println("Erreur lors du chargement des donnees du fichier : ");
            System.err.println("l'application va demarre avec un hotel vide!!!");
            System.err.println(e.getMessage());
            hotel = new Hotel();
        }
        System.out.printf(hotel.toString());

        /*
        Trie les chambre par capacite
         */
        System.out.println("""
                                
                ***********************************************
                            Trier par capacite
                ***********************************************
                """);
        hotel.sortByCapaciteAsc();
        System.out.println(hotel);

        System.out.println("""
                                
                ***********************************************
                        Ajout d'une chambre du clivier
                ***********************************************
                """);
        /*
        ajouter une chambre depuis dant ses informations sont entrees par l'utilisateur
         */
        hotel.ajouterChambreInput();
        System.out.println(hotel);

    }
}
