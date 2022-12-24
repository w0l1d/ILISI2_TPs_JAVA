package controle2021;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static controle2021.Note.NoteMoyenne;
public class Etudiant {

	private final String prenom;
	private final String nom;
	private final List<ResultatModule> resultats;
	
	public Etudiant(String prenom,String nom) {
		this.prenom=prenom;
		this.nom=nom;
		resultats=new ArrayList<>();
	}
	
	public void addResultats(String NomModule,Note note) {
		try {
		ResultatModule elm=new ResultatModule(NomModule,note);
		resultats.add(elm);
		}
		catch(IlligalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	public List<Note> getNotes(){
		List<Note> notes=new ArrayList<>();
		for(ResultatModule it:resultats)
			notes.add(it.getNote());
		return notes;
	}
	public Note NoteMoyenne() {
		return  Note.NoteMoyenne( getNotes());
	}

	public void printAllModuleResult() {
		Iterator it=resultats.iterator();
		System.out.println("\nmodules :");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void printResultats() {
		System.out.println("\nnom:	"+nom+ "\nprenom : "+prenom);
		printAllModuleResult();
		System.out.println("\nmoyen :"+NoteMoyenne());
	}
}
