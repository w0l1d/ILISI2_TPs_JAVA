package controle2021;

public class ResultatModule {
	private final String nomModule;
	private final Note note;
	public ResultatModule(String Nommodule,Note note) throws IlligalArgumentException {
			this.nomModule=Nommodule;
			this.note=new Note(note.getValeur(),note.Absent());
		
	}
	public Note getNote() {
		return note;
	}
	public String getNomModule() {
		return nomModule;
	}
	public String toString() {
		return "\""+getNomModule()+":"+getNote();
	}
	
}
