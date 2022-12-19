package tp2bis;

import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Collectors;




public class Hotel {
	private Vector<Chambre> array;
	public Hotel() {
		array= new Vector<>(5);
	}
	Scanner in =new Scanner(System.in);
	
	public Chambre AddRoom() throws UserDefinedException {
		Double price=0.0;
		int Category=0, Capacity=0,number=0;
		System.out.println("enter room's parameters ");
		
		System.out.println("number : ");
		number=in.nextInt();
		
		System.out.println("price : ");
		 price=in.nextDouble();
			if(price<=0) 
				throw new UserDefinedException("invalid price");
			
		System.out.println("Category : ");
		Category=in.nextInt();
		System.out.println("Capacity : ");
		Capacity=in.nextInt();
			if((Capacity<1)||(Capacity>4))
				throw new UserDefinedException("Capacity must be betweeen 1 and 4");
		
		 Chambre chambre =new Chambre(number,Category,price,Capacity,'L');
		 return chambre; 
	}
	
	public Vector<Chambre> getAllRoom() {
		return array;
		
	}
	public void FillArray(Chambre newElm) {
		 array.add(newElm);
	}
	public void showAllRooms() {
		System.out.println("all rooms :");
		System.out.println(array);
	}
	
	public void SameCategory(int category) {
		System.out.println("Room has category :"+ category);
		array.stream()
		.filter(p -> p.getCategorie()==category)
		.collect(Collectors.toCollection(Vector::new))
		.forEach(System.out::println);;
	
	}
	public void sortByCategory() {
		Vector<Chambre> SortedVector= array.stream()
		.sorted((o1, o2) -> o2.getCapacite()-o1.getCapacite())
		.collect(Collectors.toCollection(Vector::new));
		array=SortedVector;
	}
	
	public void deleteRoom(int number) {
		int i=0;
		for(Chambre elm : array) {
		 	if(elm.getNumero()==number) {
				array.remove(i);
				break;
		 	}
		 	i++;
		}
	}
	public Chambre storeUpDate(int number) throws UserDefinedException {
		Double newprice=0.0;
		int newCapacity=0;
		char newstatus='L';
		int newnumber=number;
		System.out.println(" new capacity :");
		newCapacity=in.nextInt();
		if((newCapacity<1)||(newCapacity>4))
			throw new UserDefinedException("Capacity must be betweeen 1 and 4");
		System.out.println(" new status :");
		newstatus=in.next().charAt(0);
		System.out.println(" new price :");
		newprice=in.nextDouble();
		if(newprice<=0) 
			throw new UserDefinedException("invalid price");
		Chambre room=new Chambre(newnumber, 0, newprice, newCapacity, newstatus);
		return room;
	}
	public void updateRoom(Chambre room ) {
		
		boolean exist=false;
		for(Chambre elm : array) {
		 	if(elm.getNumero()==room.getNumero()) {
		 		elm.setCapacite(room.getCapacite());
		 		elm.setEtat(room.getEtat());
		 		elm.setPrix(room.getPrix());
		 		exist=true;
		 		break;
		 		}
		 }
		if(exist) System.out.println(" updated:");
		else System.out.println(" room not exist:");
	}

	 
	
	
	 
	
}
	
