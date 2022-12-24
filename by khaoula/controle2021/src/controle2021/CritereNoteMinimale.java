package controle2021;

public class CritereNoteMinimale implements Predicat<Etudiant>{
	
	private final double NoteMinimale;
	public CritereNoteMinimale(double NoteMinimale ) {
		this.NoteMinimale=NoteMinimale;
	}
	public boolean test(Etudiant E) {
		if(E.NoteMoyenne().Absent())
			return false;
		if(E.NoteMoyenne().getValeur()<NoteMinimale)
			return false;
		return true;
		
	};

}
