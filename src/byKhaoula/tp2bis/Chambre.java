package byKhaoula.tp2bis;

public class Chambre {
	
	private final int numero;
	private final int categorie;
	private Double prix ;
	private int capacite ;
	private char etat;
	
	public Chambre(int numero, int categorie,Double prix , int capacite,char etat) {
		this.numero=numero;
		this.categorie=categorie;
		this.prix=prix;
		this.capacite=capacite;
		this.etat=etat;
		
	}

	public int getNumero() {
		return numero;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}


	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}


	public void setEtat(char etat) {
		this.etat = etat;
	}


	public int getCategorie() {
		return categorie;
	}

	public Double getPrix() {
		return prix;
	}

	public int getCapacite() {
		return capacite;
	}

	 
	  public char getEtat() { return etat; }
	 
@Override
public String toString() {
	 
	return "number :"+ getNumero()+ " category :"+ getCategorie()
			+ " price :"+getPrix()+ " capacity :"+getCapacite()+
			" etat :"+getEtat()+" \n";
}
//definir une format de stockage d'une chambre (separer par espace)
public String storeRoom() {
	return getNumero()+" "+getCategorie()+" "+getPrix()+" "+getCapacite()+" "+getEtat()+"\n";
}
}
