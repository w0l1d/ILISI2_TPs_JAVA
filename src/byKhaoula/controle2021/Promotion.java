package byKhaoula.controle2021;

import java.util.ArrayList;
import java.util.List;
public class Promotion {
	
	private final String name;
	private final List<Etudiant> etudiants;
	public Promotion(String name) {
		this.name=name;
		this.etudiants=new ArrayList<>();
	}
	public void addEtudiant(Etudiant etudiant) {
		
		etudiants.add(etudiant);		
	}

    public void PritEtudiantResults() throws IlligalArgumentException {
        System.out.println("promotion : " + name);
        for (Etudiant it : etudiants)
            it.printResultats();
        System.out.println("\n\nNombre des etudiants ayant valide :" + CompteurEtudiantValides());
    }

    public int CompteurEtudiantsFiltres(Predicat<Etudiant> predicat) throws IlligalArgumentException {
        int compteur = 0;
        for (Etudiant it : etudiants) {
            if (predicat.test(it))
                compteur++;
        }
        return compteur;
    }

    public int CompteurEtudiantValides() throws IlligalArgumentException {
        Predicat<Etudiant> pr = new CritereNoteMinimale(10);
        return CompteurEtudiantsFiltres(pr);
    }
	
	
}

