package com.java.ilisi.tp1.ex3;

import java.io.*;


public class BibliothequeIO {
    static final String DEFAULT_SAVE_FILE = "biblio.save";

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
        try (var ois = new ObjectInputStream(new FileInputStream(saveFile))) {
            Object tmp = ois.readObject();
            if (tmp instanceof Bibliotheque)
                biblio = (Bibliotheque) tmp;
            else
                throw new InvalidObjectException("Bibioltheque format est invalid!!");

        } catch (Exception e) {
            System.err.println("Error: Chargement n'est pas reussi!");
            System.err.println(e.getMessage());
            biblio = new Bibliotheque(100);
        }
        return biblio;
    }
}
