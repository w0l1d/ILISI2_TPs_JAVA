package byKhaoula.controle2021;

public class CritereNoteMinimale implements Predicat<Etudiant>{
	
	private final double NoteMinimale;

    public CritereNoteMinimale(double NoteMinimale) {
        this.NoteMinimale = NoteMinimale;
    }

    public boolean test(Etudiant E) throws IlligalArgumentException {
        if (E.NoteMoyenne().Absent())
            return false;
        return !(E.NoteMoyenne().getValeur() < NoteMinimale);

    }

}
