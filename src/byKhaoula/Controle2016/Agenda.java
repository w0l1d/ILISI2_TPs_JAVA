package byKhaoula.Controle2016;

import java.io.*;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class Agenda<T extends Object> {

    private final String file = "Agenda.txt";
    private final Set<RendezVous> lesRendezvs;

    public Agenda() {
        lesRendezvs = new TreeSet<>();
    }

    public void ajouter(RendezVous rv) {
        lesRendezvs.add(rv);
    }

    public void afficher() {
        Iterator<RendezVous> it = lesRendezvs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void sauver() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(this.file));

            Iterator<RendezVous> it = lesRendezvs.iterator();
            while (it.hasNext()) {
                writer.write(it.next().storeRV());
            }
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public RendezVous extractRv(String line) {
        String[] data = line.split(" ");
        RendezVous rv = new RendezVous(data[0], data[1], data[2], data[3]);
        return rv;

    }

    public void charger() {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(this.file));

            String ligne;
            try {
                while ((ligne = br.readLine()) != null) {
                    lesRendezvs.add(extractRv(ligne));
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            try {
                br.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
	

