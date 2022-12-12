package com.java.ilisi.TP2bis;

import java.io.IOException;
import java.util.List;

import static com.java.ilisi.TP2bis.HotelIO.loadHotel;
import static com.java.ilisi.TP2bis.HotelIO.saveHotel;

public class Main {

    public static String DEFAULT_HOTEL_SAVEFILE = "hotel_save.dat";

    public static void main(String[] args) throws IOException {
        Hotel hotel1 = new Hotel(List.of(
                new Chambre(1, 1, 55.66, 2, 'L'),
                new Chambre(2, 1, 39.99, 1, 'L'),
                new Chambre(3, 2, 199.99, 3, 'L'),
                new Chambre(4, 3, 500.50, 5, 'L'),
                new Chambre(5, 9, 299.95, 3, 'O'),
                new Chambre(6, 100, 999.99, 1, 'L')
        ));

        System.out.println(hotel1);
        saveHotel(DEFAULT_HOTEL_SAVEFILE, hotel1);

        Hotel hotel = null;
        hotel = loadHotel(DEFAULT_HOTEL_SAVEFILE);
        System.out.printf(hotel.toString());

    }
}
