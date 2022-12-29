package byKhaoula.controle2021;

public class Driver {

    public static void main(String[] args) throws IlligalArgumentException {
        Etudiant etudiant1 = new Etudiant("Ahmed", "Afifi");
        Etudiant etudiant2 = new Etudiant("Fatima", "Toto");
        Etudiant etudiant3 = new Etudiant("khadija", "lala");
        Promotion promotion = new Promotion("licence informatique");
        Note note1 = new Note();
        Note note2 = new Note(13);
        Note note3 = new Note(15);
        Note note4 = new Note(11);
        Note note5 = new Note(10);
        Note note6 = new Note(11);
	
	etudiant1.addResultats("Langage C", note1);
	etudiant2.addResultats("Langage C", note2);
	etudiant3.addResultats("Langage C", note5);
	
	etudiant1.addResultats("SDD", note3);
	etudiant2.addResultats("SDD", note4);
	etudiant3.addResultats("SDD", note6);
	
	promotion.addEtudiant(etudiant1);
	promotion.addEtudiant(etudiant2);
	promotion.addEtudiant(etudiant3);
	
	promotion.PritEtudiantResults();
	

	}

}
