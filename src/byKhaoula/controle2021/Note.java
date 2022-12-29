package byKhaoula.controle2021;

import java.util.List;

public class Note {

    private static final int MAXIMUM_NOTE = 20;
    private final double valeur;
    private final boolean Absente;

    public Note(double valeur, boolean Absente) throws IlligalArgumentException {
        if ((valeur < 0) || (valeur > MAXIMUM_NOTE))
            throw new IlligalArgumentException(valeur);
        this.valeur = valeur;
        this.Absente = Absente;
    }

    public Note(double valeur) throws IlligalArgumentException {
        this(valeur, false);
    }

    public Note() throws IlligalArgumentException {
        this(0, true);
    }

    public static Note NoteMoyenne(List<Note> notes) throws IlligalArgumentException {
        double resultVal = 0;
        int nbrNote = 0;
        for (Note it : notes) {
            if (it.Absente)
                return new Note();
            else {
                resultVal += it.getValeur();
                nbrNote++;
            }
        }
        return new Note(resultVal / nbrNote);

    }

    public boolean Absent() {
        return this.Absente;
    }

    public double getValeur() {
        return this.valeur;
    }

    @Override
    public String toString() {
        if (Absent()) return " ABS\"";
        return "\" " + getValeur() + "/" + MAXIMUM_NOTE + "\"";
    }
}
