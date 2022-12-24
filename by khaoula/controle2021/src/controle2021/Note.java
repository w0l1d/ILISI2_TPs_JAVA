package controle2021;

import java.util.Iterator;
import java.util.List;

public class Note {

	private static final int MAXIMUM_NOTE=20;
	private final double valeur;
	private final boolean Absente;
	public static Note NoteMoyenne(List<Note>notes) {
		double resultVal=0;
		int nbrNote=0;
		for(Note it:notes) {
			if(it.Absente)
			return new Note();
			else {
				resultVal+=it.getValeur();
				nbrNote++;
			}
		}
		return new Note(resultVal/nbrNote);
		
	}
	public Note(double valeur,boolean Absente) throws IlligalArgumentException {
			
			if((valeur<0)|| (valeur> MAXIMUM_NOTE))
				throw new IlligalArgumentException(valeur);
			else {
				this.valeur =valeur ;
				this.Absente=Absente;	
			}
	}
	
	public Note(double valeur) {
		this.valeur =valeur ;
		this.Absente=false;	
	}
	public Note() {
		this.valeur =0 ;
		this.Absente=true;	
	}
	
	public boolean Absent() {
		return this.Absente;
	}
	public double getValeur() {
		return this.valeur;
	}
	@Override
	public String toString() {
		if(Absent()) return " ABS\"";
		return "\" " + getValeur()+"/"+MAXIMUM_NOTE+"\"";
	}
}
