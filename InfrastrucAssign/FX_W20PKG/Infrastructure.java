/**
 * Welcome to the driver of the final exam, the tasks that requires a printing message are done so, the other task will be pointed at by the comments
 * Alexis Bolduc 40126092
 * 22 April 2020
 */
package FX_W20PKG;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import CargoAirport.CargoAirport;
import CommercialAirport.CommercialAirport;

public class Infrastructure {

	public static void main(String[] args) {
		/**
		 * It is assumed that the desired objects are the ones that are specified enough, building, bridge, structure, and airplane were only used as parents, not displayed in this driver
		 */
		Structure[] StrArr = new Structure[42];
		int arrayCount = 0;
		for(int i = 0; i<6;i++) {
			
			/**
			 *=====================================================================================
			 * TASK 3.A, and 3.B
			 * ====================================================================================
			 */
			StrArr[arrayCount++] = new Overpass(2000+i,i,i,i,i);
			StrArr[arrayCount++] = new ResidentialBuilding(2000+i,i,i,"material"+i,i);
			StrArr[arrayCount++] = new CondoBuilding(2000+i,i,i,"material"+i,i,i);
			StrArr[arrayCount++] = new CargoAirport(2000+i,i,i,"codeCargo"+i,100+i);
			StrArr[arrayCount++] = new CommercialAirport(2000+i,i,i,"codeCommercial"+i,i);
			StrArr[arrayCount++] = new House(2000+i,i,i,"material"+i,i,i,i);
			StrArr[arrayCount++] = new HighRise(2000+i,i,i,"material"+i,i);
					
			
		}
		/**
		 * =======================================================================================================
		 * TASK 3.C See method below main
		 * =======================================================================================================
		 */
		System.out.println("Starting Task 3.C");
		int i = findTallestHighRise(StrArr);
		if (i!=-1) {
			System.out.println("Tallest HighRise was found at index: "+i+" Here is the info of that object");
			System.out.println(StrArr[i]);
		}
		else
			System.out.println("No HighRise objects were found in the array!");
		System.out.println("End of Task 3.C");
		/**
		 * ========================================================================================================
		 * Task 3.D See method below main
		 * This is assumed to work with all instances of building
		 * ========================================================================================================
		 */
		System.out.println("\nStarting Task 3.D");
		showBuildingInfo(StrArr);
		System.out.println("\nEnd of Task 3.D");
		/**
		 * ========================================================================================================
		 * Task 3.E See method below main
		 * ========================================================================================================
		 */
		System.out.println("\nStarting Task 3.E");
		displayAllObjects(StrArr,StrArr.length-1);
		System.out.println("\nEnd of Task 3.E");
		/**
		 * ========================================================================================================
		 * Task 3.F See method below main
		 * ========================================================================================================
		 */
		System.out.println("\nStarting Task 3.F");
		
		Structure copy [] =  copyStructures(StrArr);
		
		
		displayAllObjects(copy, copy.length-1);
		
		System.out.println("\nEnd of Task 3.F");
		/**
		 * ========================================================================================================
		 * Task 4
		 * ========================================================================================================
		 */
		System.out.println("\nStart of Task 4");
		/**
		 * ========================================================================================================
		 * Task 4.A
		 * ========================================================================================================
		 */
		ArrayList<Structure> strArrLst= new ArrayList<Structure>(30);
		/**
		 * ========================================================================================================
		 * Task 4.B
		 * ========================================================================================================
		 */
		for(int a = 0; a<StrArr.length;a++) {
			strArrLst.add(StrArr[a]);
		}
		
		/**
		 * ========================================================================================================
		 * Task 4.C
		 * ========================================================================================================
		 */
		strArrLst.remove(12);
		strArrLst.remove(1);
		strArrLst.remove(32);
		strArrLst.remove(10);
		strArrLst.remove(19);
		
	
		/**
		 * ========================================================================================================
		 * Task 4.D, it is expected for the object at index 0 to be found and for index at 1 not to be found since, it was removed in 4.C
		 * ========================================================================================================
		 */
		if(strArrLst.contains(StrArr[0])) {
			System.out.println("Object "+StrArr[0]+" found at index "+ strArrLst.indexOf(StrArr[0]));
		}
		else {
			System.out.println("Object"+StrArr[0]+" not found");
		}
		if(strArrLst.contains(StrArr[1])) {
			System.out.println("Object "+StrArr[1]+" found at index"+ strArrLst.indexOf(StrArr[1]));
		}
		else {
			System.out.println("Object"+StrArr[1]+" not found");
		}
		System.out.println("\nEnd of Task 4");
		/**
		 * ========================================================================================================
		 * Task 5
		 * ========================================================================================================
		 */
		System.out.println("\nStart of Task 5");
		PrintWriter write = null;
		try {
			/**
			 * ========================================================================================================
			 * Task 5.A
			 * ========================================================================================================
			 */
			write = new PrintWriter(new FileOutputStream("AirportCodes.txt"));
			/**
			 * ========================================================================================================
			 * Task 5.B, 5.C see method below main
			 * ========================================================================================================
			 */
			findExistingAirportCodes(write, StrArr);
			write.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		/**
		 * ========================================================================================================
		 * Task 5.D
		 * ========================================================================================================
		 */
		BufferedReader read = null;
		try {
			read = new BufferedReader(new FileReader("AirportCodes.txt"));
			/**
			 * ========================================================================================================
			 * Task 5.E, 5.F see method below main
			 * ========================================================================================================
			 */
			displayAirportCodes(read);
			read.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nEnd of Task 5");
		/**
		 * ========================================================================================================
		 * Task 6
		 * ========================================================================================================
		 */
		 
		System.out.println("\nStart of Task 6");
		/**
		 * ========================================================================================================
		 * Task 6 D, Previous tasks are in StructureList class
		 * ========================================================================================================
		 */
		StructureList try1 = new StructureList();
		StructureList try2 = new StructureList();
		/**
		 * ========================================================================================================
		 * Testing addAtEnd, and addToStart
		 * ========================================================================================================
		 */
		try2.addAtEnd(StrArr[4]);
		try2.addAtEnd(StrArr[9]);
		try1.addToStart(StrArr[0]);
		
		try1.addAtEnd(StrArr[1]);
		System.out.println("List1: ");
		/**
		 * ========================================================================================================
		 * Testing showListContents
		 * ========================================================================================================
		 */
		try1.showListContents();
		System.out.println("Printing clone of List1: ");
		/**
		 * ========================================================================================================
		 * Testing clone and displaying it
		 * ========================================================================================================
		 */
		StructureList tryClone = (StructureList) try1.clone();
		tryClone.showListContents();
		
		System.out.println("List2: ");
		
		try2.showListContents();
		/**
		 * ========================================================================================================
		 * Testing append, the list 2 is expected to be null afterwards
		 * ========================================================================================================
		 */
		try1.append(try2);
		System.out.println("List1.appended(list2): ");
		try1.showListContents();
		System.out.println("List2");
		try2.showListContents();
		
		System.out.println("\nEnd of Task 6");
		
	
	
	
	
	}
	
	
	
	
	
	
	
	
	/**
	 * ========================================================================================================
	 * Task 3C Method used in main
	 * this method makes use of .getHeight in HighRise class
	 * ========================================================================================================
	 */
	
	public static int findTallestHighRise(Structure[] strArr) {
		int indexHighest = -1;
		HighRise temp = new HighRise(2,2,2,"material",2);
		for(int i=0;i<strArr.length;i++) {
			if(strArr[i].getClass()==temp.getClass()) {
				if(indexHighest == -1)
				indexHighest = i;
				else {
					if(((HighRise) strArr[i]).getHeight()>((HighRise) strArr[indexHighest]).getHeight()){
						indexHighest = i;
					}
				}
			}
			else continue;
		}
		return indexHighest;
	}
	/**
	 * ========================================================================================================
	 * Task 3D Method used in main
	 * This was assumed to work for all instances of building
	 * ========================================================================================================
	 */
	public static void showBuildingInfo(Structure[] strArr) {
		boolean hasBuilding = false;
		
		for(int i=0; i<strArr.length;i++) {
			if(strArr[i] instanceof Building) {
				System.out.println(strArr[i]);
				hasBuilding = true;
			}
			
		}
		if(hasBuilding == false) {
			System.out.println("No Building Objects in that array");
		}
	}
	/**
	 * ========================================================================================================
	 * Task 3.E MEthod used in main
	 * ========================================================================================================
	 */
	public static void displayAllObjects(Structure [] strArr, int size) {
		if(size == -1)
		return;
		else {
			System.out.println(strArr[size]);
			displayAllObjects(strArr, size-1);
			
		}
	}
	/**
	 * ========================================================================================================
	 * Task 3.F Method used in main
	 * This method makes use of the clone method in the classes
	 * ========================================================================================================
	 */
	public static Structure [] copyStructures(Structure [] strArr) {
		Structure [] copy = new Structure [strArr.length];
		for(int i=0; i<strArr.length;i++) {
			try {
				copy[i] =  (Structure)strArr[i].clone();
			} catch (CloneNotSupportedException e) {
				
				e.printStackTrace();
			}
		}
		return copy;
	}
	/**
	 * ========================================================================================================
	 * Task 5.B Method used in main, makes use of getCode method in airplane children
	 * ========================================================================================================
	 */
	public static void findExistingAirportCodes(PrintWriter writer, Structure [] strArr) {
		for(int i = 0; i<strArr.length;i++) {
			if(strArr[i] instanceof Airport) {
				writer.println(((Airport) strArr[i]).getCode());
			}
	
		}
	}
	/**
	 * ========================================================================================================
	 * Task 5.E Method used in main, makes use of read() method only
	 * ========================================================================================================
	 */
	public static void displayAirportCodes(BufferedReader reader) {
		try {
			int nextElement = reader.read();
			while(nextElement!=-1) {
				char nextChar = (char) nextElement;
				System.out.print(nextChar);
				nextElement = reader.read();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	

}
