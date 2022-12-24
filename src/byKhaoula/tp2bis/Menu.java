package byKhaoula.tp2bis;

public class Menu {
	
	public static void afficherMenu() {
		System.out.println(
                """
                        ***********************************MENU*******************************************************
                        ************************traitement local*****************************************
                        			
                        	1) 	afficher les chambres
                        	2) 	ajouter une chambre
                        	3) 	modifier une chambre
                        	4) 	supprimer une chambre
                        	5) 	afficher la liste des chambres d’une catégorie
                        	6) 	afficher la liste des chambres l’ordre croissant des capacités
                        	
                        ************************traitement FICHIER*****************************************
                        	
                        	7)  stocker dans un fichier
                        	8)  lire depuis un fichier
                        	9) ajouter une chambre
                        	10) modifier une chambre
                        	11) supprimer une chambre
                        	12)copier toutes les chambres vers un fichier séquentiel.
                        	13) generer un fichier text
                        	14) liste des chambres libres
                        	15) recette  journalière
                        	99) Quitter
                        	
                        	 
                        		
                        	""");
	}
}