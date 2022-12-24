package com.java.ilisi.tp2bis;

import java.io.*;
import java.util.Iterator;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class HotelIO {

    public static String DEFAULT_HOTEL_SAVEFILE = "hotel_save.dat";

    public static void saveHotel(String filename, Hotel hotel) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(convertToCSV(hotel.getChambres()));
        writer.close();
    }

    public static Hotel loadHotel(String filename) throws IOException, InvalidChambreFileFormat {
        return new Hotel(loadChambres(filename));
    }

    private static Vector<Chambre> loadChambres(String filename) throws IOException, InvalidChambreFileFormat {
        Vector<Chambre> chambres = new Vector<>();
        InputStream inputStream = new FileInputStream(filename);
        try (var br = new BufferedReader(
                new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null)
                chambres.add(convertToCombre(line));
        }
        return chambres;
    }

    private static String convertToCSV(Iterator<Chambre> data) {
        Iterable<Chambre> iterable = () -> data;
        return StreamSupport
                .stream(iterable.spliterator(), false)
                .map(Chambre::toString)
                .collect(Collectors.joining("\n"));
    }

    private static Chambre convertToCombre(String data) throws InvalidChambreFileFormat {
        String[] values = data.split(";");
        try {
            return new Chambre(
                    Integer.parseInt(values[0]),
                    Integer.parseInt(values[1]),
                    Double.parseDouble(values[2]),
                    Integer.parseInt(values[3]),
                    values[4].charAt(0));
        } catch (Exception ex) {
            throw new InvalidChambreFileFormat(data);
        }
    }


}
