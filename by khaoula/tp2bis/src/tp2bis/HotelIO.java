package tp2bis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.Vector;

public class HotelIO {
	public static void saveHotel(String file,Hotel hotel) throws IOException {
		 BufferedWriter writer = new BufferedWriter(new FileWriter(file))  ; 
			for(Chambre elm: hotel.getAllRoom()) {
				 writer.write(elm.storeRoom());
			 }
		writer.close();
	}
	
	public static Vector<Chambre> loadHotel(String file ) throws IOException {
		 Vector<Chambre> chambres = new Vector<>();
		 String line;
		 BufferedReader reader = new BufferedReader(new FileReader(file))  ; 
		 while((line=reader.readLine()) != null)	
		 chambres.add(extractRoom(line));
		 reader.close();
		return chambres;
	}

	
	public static Chambre extractRoom(String line) {
		String[] data =line.split(" ");
		Chambre chambre= new Chambre(Integer.parseInt(data[0]),
				 					  Integer.parseInt(data[1]),
				 					  Double.parseDouble(data[2]),
				 					  Integer.parseInt(data[3]),
				 					  data[4].charAt(0));
        return chambre;
	}
	
	public static void addRoomInsideFile(String file,Chambre chambre) throws IOException {
		File f = new File(file);
		RandomAccessFile raf = new RandomAccessFile(f, "rw");
		raf.seek(f.length());
		raf.writeUTF(chambre.storeRoom());
		raf.close();
		
	}
	 public static void enregistrerChambresDsFichier(String path,Hotel hotel)
	    {
			try {
				File f = new File(path);
				RandomAccessFile raf = new RandomAccessFile(f, "rw");
				for(Chambre elm : hotel.getAllRoom()){
					raf.writeUTF(elm.storeRoom());
				}
				raf.close();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
	    }
	
	public static  void readRoomsintoFile(String file) {
		try {
			File f = new File(file);
			RandomAccessFile raf = new RandomAccessFile(f, "r");
			long length=raf.length();
			while(raf.getFilePointer()<length){
				System.out.println(extractRoom(raf.readUTF()));
			}
			raf.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	 public static void updateHotelIntoFile(String file,int number,Hotel hotel)  { 
		  boolean exist =false;
		  Scanner in = new Scanner(System.in); 
		  try {
				File f=new File(file);
				File fTemp=new File("saveFile.txt");
				RandomAccessFile raf = new RandomAccessFile(f, "r");
				RandomAccessFile nraf = new RandomAccessFile(fTemp, "rw");
				while(raf.getFilePointer()<raf.length()){
					String line=raf.readUTF();
					Chambre room =extractRoom(line);
					if(room.getNumero() != number)
						nraf.writeUTF(line);
					else {
						
						Chambre chambre=hotel.storeUpDate(number);
						room.setCapacite(chambre.getCapacite());
						room.setEtat(chambre.getEtat());
						room.setPrix(chambre.getPrix());
						System.out.println(room);
						nraf.writeUTF(room.storeRoom());
						hotel.updateRoom(chambre);
						exist =true;
					}
				}
				raf.close();
				nraf.close();
				if(exist) {
					f.delete();
					fTemp.renameTo(new File(file));
				}
				
	        } 
	        catch(Exception e) {
				e.printStackTrace();
			}
	    }
	 
	 public static void deleteRoomlIntoFile(String file,int number)  { 
		  boolean exist =false;
		  try {
				File f=new File(file);
				File fTemp=new File("newFile.txt");
				RandomAccessFile raf = new RandomAccessFile(f, "r");
				RandomAccessFile nraf = new RandomAccessFile(fTemp, "rw");
				while(raf.getFilePointer()<raf.length()){
					String line=raf.readUTF();
					Chambre room =extractRoom(line);
					if(room.getNumero() != number)
						nraf.writeUTF(line);
					else {
						exist=true;
					}
				}
				raf.close();
				nraf.close();
				if(exist) {
					f.delete();
					fTemp.renameTo(new File(file));
					System.out.println("Room number :"+number+"deleted");
				}
				else System.out.println("Room number :"+number+" not exist");
				
	        } 
	        catch(Exception e) {
				e.printStackTrace();
			}
	    }
	 
	 public static void generateFile(String file,String fileC) throws IOException {
		 	RandomAccessFile raf = new RandomAccessFile(new File(fileC), "r");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file))  ; 
			while(raf.getFilePointer()<raf.length()){
				Chambre room =extractRoom(raf.readUTF());
				writer.write(room.storeRoom());
			}
			raf.close();
			writer.close();
	}
	 
	 
	public static Vector<Chambre> freeRoom(String file){
		Vector<Chambre> freeR=new Vector<>(5);;
		try {
				RandomAccessFile raf = new RandomAccessFile(new File(file), "r");
				while(raf.getFilePointer()<raf.length()){
					Chambre room =extractRoom(raf.readUTF());
					if(room.getEtat()=='L')
						freeR.add(room);	
				}
				raf.close();
			}
        catch(Exception e) {
			e.printStackTrace();
		}
		
		return freeR;
	}


public static void recette(String file) 
{
	try {
		double max=0,reel=0;
		RandomAccessFile raf = new RandomAccessFile(new File(file), "r");
		while(raf.getFilePointer()<raf.length()){
			Chambre room =extractRoom(raf.readUTF());
			if(room.getEtat()=='O') 
				reel+=room.getPrix();
			max+=room.getPrix();	
		}
		System.out.println("Max= "+max);
		System.out.println("Reel= "+reel);
		raf.close();
	} catch(Exception e) {
		System.out.println(e.getMessage());
	}
}
}