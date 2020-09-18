/**
 *
 * name and id Alexis Bolduc 40126092
 * Comp249
 * Assignment 4
 * due date April 19th
 * @author alexisbolduc
 *  @version v1
 *  
 * 
 * Welcome,
 * This is the class CellListUtilization 
 * the goal is to create instances of a cellList and add cellphones to it by reading a file
 */
package Cell;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Cell.CellList.CellNode;

public class CellListUtilization implements Cloneable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner readable = null;
		/**
		 * attributes of cellphone objects
		 */
		long serialNum = 0;
		String brand = null;
		double price = 0.0;
		int year = 0;
		/** 
		 * creating two instances of a list
		 */
		CellList list1 = new CellList();
		CellList list2 = new CellList();
		/**
		 * filling a list from the info in the file
		 * testing addtostart and equals in cellPhone
		 */
		try {
			readable = new Scanner(new FileInputStream("Cell_Info.txt"));
			while(readable.hasNext()) {
				serialNum = readable.nextLong();
				brand = readable.next();
				price=readable.nextDouble();
				year=readable.nextInt();
				
				CellPhone entry = new CellPhone(serialNum,brand,price,year);
				CellNode temp = new CellNode();
				
				boolean alreadyThere = false;
				if(list1.getSize()==0) {
					list1.addToStart(entry);
					continue;
				}	
				temp = list1.head;
				
				while(temp.getPoint()!=null) {
					
					if((temp.getCell()).equals(entry)) {
					alreadyThere = true;
					break;
					}
					temp = temp.getPoint();
				}
				if(!alreadyThere) {
					list1.addToStart(entry);
				}
			}
			readable.close();
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		/**
		 * displaying first list
		 */
		CellList.showContents(list1);
		
		/**
		 * testing contains and find method 
		 */
		System.out.println("\nHow many serial numbers do you want to check? ");
		Scanner keyboard = new Scanner(System.in);
		int choice = keyboard.nextInt();
		System.out.println("Perfect, ");
		for(int i = 0;i<choice;i++) {
			System.out.println("Enter the serial number: ");
			long serialChoice = keyboard.nextLong();
			if(list1.contains(serialChoice)) {
				System.out.println(list1.find(serialChoice));
			}
			else {
				System.out.println("This serial number is not on the list");
			}
		}
		System.out.println("Job's done");
		keyboard.close();
		/**
		 * testing copy constructor of CellList and testing equals method
		 */
		System.out.println("Testing copy constructor of CellList and adding a cellPhone to list 2");
		
		System.out.println("List2: ");
		
		
		list2 = new CellList(list1);
		CellList.showContents(list2);
		System.out.println("\nTesting equality: "+list1.equals(list2));
		CellPhone test1 = new CellPhone(1,"1",1,1);
		System.out.println("\nList2: ");
		list2.addToStart(test1);
		CellList.showContents(list2);
		System.out.println("\nList 1: (Showing it is a deep copy)");
		CellList.showContents(list1);
		System.out.println("\nTesting equality: "+list1.equals(list2));
		/**
		 * testing delete from start, replace at index, delete from index
		 */
		System.out.println("\nTesting delete and insert methods that have not been tested yet");
		list2.deleteFromStart();
		CellList.showContents(list2);
		System.out.println("");
		list2.replaceAtIndex(test1, 20);
		CellList.showContents(list2);
		System.out.println();
		list2.deleteFromIndex(1);
		CellList.showContents(list2);
		/**
		 * testing clone from cellphone
		 * and clone from CellNode
		 */
		System.out.println("\nTesting clones");
		
		try {
			CellPhone testCell = test1.clone(10);
			
			System.out.println("First clone: "+ testCell+"\nSecond Clone: "+ test1);
		} catch (CloneNotSupportedException e1) {
			
			e1.printStackTrace();
		}
		
		
		CellNode test = new CellNode(test1,null);
		CellNode order = new CellNode(test,10);
		order.setCell(new CellPhone(3,"3",3,3));
		System.out.println("Testing copy constructor of cellNode \nInstance 1:"+test+"\nInstance 2: "+order);
		try {
			CellNode other = test.clone(100);
			
			System.out.println("First clone: "+ test+"\nSecond Clone: "+ other);
			
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
		}
		
			
	}
/**
 * end of program thanks
 */
}
