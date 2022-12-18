package tp2bis;


import  tp2bis.HotelIO;
import  tp2bis.Menu;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class ClassDriver {

	public static void main(String[] args) {
		
		int choix=0;
		String file, fileC;
		int number;
		Scanner in=new Scanner(System.in);
		Hotel hotel=new Hotel(); 
		do {
			
			Menu.afficherMenu();
			choix=in.nextInt();
			switch(choix){		    
		        case 99 : break; 
		        case 1 :
		        	 hotel.showAllRooms();
		        	break; 
		        case 2 :
				try {
					hotel.FillArray(hotel.AddRoom());
				} catch (UserDefinedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        	break; 
		        	
		        case 3 :
		        	System.out.println("numero de la chambre");
		        	number=in.nextInt();
				Chambre room;
				try {
					room = hotel.storeUpDate(number);
				
		        	hotel.updateRoom(room);
				} catch (UserDefinedException e2) {
					 System.out.println("input out of range");
					e2.printStackTrace();
				}
		        	break; 
		        case 4 :
		        	System.out.println("numero de la chambre");
		        	number=in.nextInt();
		        	hotel.deleteRoom( number) ;
		        	break;
		        case 5 :
		        	System.out.println("entrer une categorie");
		          	 int categorie=in.nextInt();
		          	 hotel.SameCategory(categorie);
		        	break;
		        case 6 :
		        	System.out.println("affichage selon l’ordre croissant des capacités");
		        	hotel.sortByCategory();
		        	break;
		        case 7 :
		        	System.out.println("saisir le nom du fichier");
		        	file=in.next();
		        	HotelIO.enregistrerChambresDsFichier(file,hotel);
		        	System.out.println(" fichier sauvgarder");
		        	break; 
		        case 8 :
		        	System.out.println("saisir le nom du fichier");
		        	 file=in.next();
		       	 	HotelIO.readRoomsintoFile(file);
		        	break;
		        	
		        case 9 :
		        	System.out.println("saisir le nom du fichier");
		        	file=in.next();
		        	Chambre chambre;
		        	try {
		        		chambre = hotel.AddRoom();
		        		
		        		try {
		        			HotelIO.addRoomInsideFile( file, chambre);
		        			hotel.FillArray(chambre);
		        		} catch (IOException e) {
		        			// TODO Auto-generated catch block
		        			e.printStackTrace();
		        		}
		        	} catch (UserDefinedException e1) {
					// TODO Auto-generated catch block
		        		e1.printStackTrace();
		        	}
		        	
		        	break; 
		        case 10 :
		           	System.out.println("saisir le nom du fichier");
		        	file=in.next();
		        	System.out.println("saisir le numero du chambre");
		        	number=in.nextInt();
		        	HotelIO.updateHotelIntoFile( file, number,hotel);
		        	break;
		        	
		        case 11 :
		        	System.out.println("saisir le nom du fichier");
		        	file=in.next();
		        	System.out.println("saisir le numero du chambre");
		        	number=in.nextInt();
		        	HotelIO.deleteRoomlIntoFile( file, number);
		        	break;
		        case 12 :
		        	System.out.println("saisir le nom du fichier");
		        	file=in.next();
		        	try {
		        		HotelIO.saveHotel( file, hotel);
		        	} catch (IOException e) {
					
		        		e.printStackTrace();
		        	}
		        	break;
		        	
		        case 13:
		        	System.out.println("saisir le nom du fichier source");
		        	file=in.next();
		        	System.out.println("saisir le nom du fichier destination");
		        	fileC=in.next();
		        	try {
		        		HotelIO.generateFile( file, fileC);
		        	} catch (IOException e) {
		        		e.printStackTrace();
		        	}
		        	break;
		        	
		        case 14:
		        	System.out.println("saisir le nom du fichier");
		        	file=in.next();
		        	System.out.println(HotelIO.freeRoom(file));
		        	break;
		        case 15:
		        	System.out.println("saisir le nom du fichier");
		        	file=in.next();
		        	HotelIO.recette( file) ;
		        	break;
		    }
		
	
		}while(choix != 99);
		
	
}
}
