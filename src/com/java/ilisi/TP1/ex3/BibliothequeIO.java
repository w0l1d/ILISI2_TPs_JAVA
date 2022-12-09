package com.java.ilisi.TP1.ex3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class BibliothequeIO {
    static final String DEFAULT_SAVE_FILE= "biblio.save";
    public static void saveBibliotheque(Bibliotheque biblio, String saveFile) {
        try {
            File f = new File(saveFile);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // write object to file
            oos.writeObject(biblio);
            // closing resources
            oos.close();
            fos.close();
        } catch (IOException e) {

            System.err.println("Error: suavegarde n'est pas reussi! " + e.getClass().getName());
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static Bibliotheque loadBibliotheque(String saveFile) {
        Bibliotheque biblio = null;
        try {
            FileInputStream is = new FileInputStream(saveFile==null?DEFAULT_SAVE_FILE:saveFile);
            ObjectInputStream ois = new ObjectInputStream(is);
            biblio = (Bibliotheque) ois.readObject();
            ois.close();
            is.close();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: suavegarde n'est pas reussi!");
            System.err.println(e.getMessage());
        }
        return biblio;
    }
}
