package Controle2016;

public class RendezVous implements Comparable<RendezVous>{
	private String intitule;
	private String date;
	private String heureD;
	private String heureF;
	public RendezVous(String intitule, String date, String heureD, String heureF) {
		 
		this.intitule = intitule;
		this.date = date;
		this.heureD = heureD;
		this.heureF = heureF;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHeureD() {
		return heureD;
	}
	public void setHeureD(String heureD) {
		this.heureD = heureD;
	}
 

	@Override
	public int compareTo(RendezVous o) {
		 if(this.date.compareTo(o.getDate())==0)
			 return(this.heureD.compareTo(o.getHeureD()));
		 
		return (this.date.compareTo(o.getDate()));
	}
	public String toString() {
		return "intitule : "+ intitule +" date: " + date + "heureD: "+heureD+" heureF: "+heureF ;
	}
	
	public String storeRV() {
		return  intitule +" "+ date +" "+heureD+" "+heureF +"\n" ;
	}
	
}
