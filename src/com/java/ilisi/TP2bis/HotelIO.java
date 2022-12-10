package com.java.ilisi.TP2bis;

import java.io.*;
import java.util.Iterator;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class HotelIO {
    public static void saveHotel(String filename, Hotel hotel) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(convertToCSV(hotel.getChambres()));
        writer.close();
    }

    private static Vector<Chambre> loadChambres(String filename) throws IOException {
        Vector<Chambre> chambres = new Vector<>();
        InputStream inputStream = new FileInputStream(filename);
        try (BufferedReader br
                     = new BufferedReader(
                new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null)
                chambres.add(convertToCombre(line));
        }
        return chambres;
    }

    public static String convertToCSV(Iterator<Chambre> data) {
        Iterable<Chambre> iterable = () -> data;
        return StreamSupport
                .stream(iterable.spliterator(), false)
                .map(Chambre::toString)
                .collect(Collectors.joining("\n"));
    }

    public static Chambre convertToCombre(String data) {
        String[] values = data.split(";");
        return new Chambre(
                Integer.parseInt(values[0]),
                Integer.parseInt(values[1]),
                Double.parseDouble(values[2]),
                Integer.parseInt(values[3]),
                values[4].charAt(0));
    }

    public Hotel loadHotel(String filename) throws IOException {
        return new Hotel(loadChambres(filename));
    }


}
