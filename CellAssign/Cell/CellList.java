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
 * This is the class CellList
 * the goal is to create a linkedlist with various objects of cellphone
 */
/**
 * package to simplify visibility
 */
package Cell;
/**
 * imports
 */
import java.util.NoSuchElementException;

/**
 * cloneable so it can use clone method
 * @author alexi
 *
 */
public class CellList implements Cloneable{
	/**
	 * CellNode has a different visibility because we need it in the main method
	 */
	CellNode head;
	/**
	 * the size is the number of objects in the list
	 */
	private int size;
	/**
	 * default constructor 
	 */
	public CellList() {
		
	}
	/**
	 * equals method
	 * @param other
	 * @return
	 */
	public boolean equals(CellList other) {
		if(other == null)
			return false;
		else if(getClass()!=other.getClass())
			return false;
		else {
			CellList otherCellList = (CellList) other;
			CellNode otherN = new CellNode();
			CellNode ogN = new CellNode();
			otherN = otherCellList.head;
			ogN = this.head;
 			while(ogN.point!=null) {
 				ogN = ogN.point;
 				otherN = otherN.point;
 				if(ogN.cell.equals(otherN.cell))
 					continue;
 				else {
 					return false;
 				}
 			}
 			return true;
			
		}
	}
	/**
	 * copy constructor providing deep copy
	 * @param other
	 */
	public CellList(CellList other) {
	super();
	this.size = 0;
	if(other == null) {
		this.head = null;
	}
	else {
		
	CellNode otherNode = new CellNode();
	otherNode = other.head;
	
	for(int i = 0; i<other.size;i++) {
		this.insertAtIndex(otherNode.cell, i);
		otherNode = otherNode.point;
		
	
	}
	this.size = other.size;
	
	}
	}
	/**
	 * getter 
	 * @return
	 */
	public int getSize() {
		return this.size;
	}
	/**
	 * add an object to start of list
	 * @param cell
	 */
	public void addToStart(CellPhone cell) {
		CellNode newEntry = new CellNode(cell,null);
		if(this.head==null) {
			this.head = newEntry;
			this.head.point=null;
			this.size++;
		}
		else {
		newEntry.point = this.head;
		this.head = newEntry;
		this.size++;
		}
	}
	/**
	 * find an object with a specific sserial number
	 * @param serialNumber
	 * @return
	 */
	public CellPhone find(long serialNumber) {
	
		CellNode find = new CellNode();
		find = this.head;
		for(int i=0;i<size-1;i++) {
			if(find.cell.getSerialNum()==serialNumber) {
				System.out.println(i+1+" iterations");
				return find.cell;
			}
			find = find.point;
		}
		
	 return null;
	}
	
	/**
	 * determine if an object with a specific serial number exists
	 * @param serialNumber
	 * @return
	 */
	public boolean contains(long serialNumber) {
		
		CellNode find = new CellNode();
		find = this.head;
		for(int i=0;i<size-1;i++) {
			if(find.cell.getSerialNum()==serialNumber) {
				return true;
			}
			find = find.point;
		}
		
	 return false;
	}
	/**
	 * insert object at a certain index, covers if index is 0,1, n, or the last index
	 * @param cell
	 * @param index
	 * @throws NoSuchElementException
	 */
	public void insertAtIndex(CellPhone cell, int index) throws NoSuchElementException {
		try {
			this.size++;
			
			if(index<0||index>this.size-1) {
				this.size--;
				throw new NoSuchElementException();	
			}
			if(index == 0) {
				addToStart(cell);
			}
			else if(index ==1) {
				CellNode  newEntry = new CellNode(cell,null);
				CellNode temp = new CellNode();
				CellNode temp2 = new CellNode();
				temp =this.head;
				temp2 = temp.point;
				temp.point = newEntry;
				newEntry.point = temp2;
			}
			else if(index==this.size-1) {
			
			CellNode newEntry = new CellNode(cell, null);
			CellNode temp = new CellNode();
			temp = this.head;	 
			while(temp.point!=null) {
				temp = temp.point;
				}
			temp.point = (newEntry);

			}
			
			else if (index>0&&index<(this.size-1)) {
				 CellNode temp = new CellNode();
				 CellNode temp2 = new CellNode();
				 CellNode newEntry = new CellNode(cell, null);
				 temp = this.head;
				 temp2 = temp.point;
				 
				for(int i= 0;i<this.size-1;i++) {
					temp = temp.point;
					temp2=temp.point;
					if(i==index-2) {
						temp.point = newEntry;
						newEntry.point = temp2;
						break;
					}
				}
			}
		}
		catch(NoSuchElementException e) {
		System.out.println("Invalid index");
		System.exit(0);
		}
	}
	
	/**
	 * replace object at a certain index, covers if the index is 0,1, n or the last one
	 * @param cell
	 * @param index
	 * @throws NoSuchElementException
	 */
	public void replaceAtIndex(CellPhone cell, int index) throws NoSuchElementException {
		try {
			
			
			if(index<0||index>this.size-1) {
				
				throw new NoSuchElementException();	
			}
			if(index == 0) {
				CellNode newEntry = new CellNode(cell,null);
				newEntry.point = this.head.point;
				this.head = newEntry;
			}
			
			else if(index==this.size-1) {
			
			CellNode newEntry = new CellNode(cell, null);
			CellNode temp = new CellNode();
			CellNode temp2 = new CellNode();
			temp = this.head;
			temp2 = temp.point;
			while(temp2.point!=null) {
				temp = temp.point;
				temp2 = temp.point;
				}
			temp.point = (newEntry);
			newEntry.point = null;
			temp2 = null;

			}
			else if(index ==1) {
				CellNode newEntry = new CellNode(cell,null);
				CellNode temp = new CellNode(cell,null);
				CellNode temp2 = new CellNode(cell,null);
				temp=this.head;
				temp2 = temp.point;
				temp.point = newEntry;
				newEntry.point = temp2.point;
				temp2 = null;
				
			}
			
			else if (index>1&&index<(this.size-1)) {
				 CellNode temp = new CellNode();
				 CellNode temp2 = new CellNode();
				 CellNode newEntry = new CellNode(cell, null);
				 temp = this.head;
				 temp2 = temp.point;
				 
				for(int i= 0;i<this.size-1;i++) {
					temp = temp.point;
					temp2=temp.point;
					if(i==index-2) {
						temp.point = newEntry;
						newEntry.point = temp2.point;
						
						temp2 = null;
						break;
					}
				}
			}
		}
		catch(NoSuchElementException e) {
		System.out.println("Invalid index");
		System.exit(0);
		}
	}
	
	/**
	 * delete an object at an index, covers index 0,1,n,last
	 * @param index
	 */
	public void deleteFromIndex(int index) {
		try{
			if(index ==0) {
		
			deleteFromStart();
		}
			
		if(index<0||index>this.size-1) {
			throw new NoSuchElementException();	
			}
		else if(index ==1) {
			 CellNode temp = new CellNode();
			 CellNode temp2 = new CellNode();
			 temp = this.head;
			 temp2 = temp.point;
			 
			 temp.point = temp2.point;
			 temp2.point = null;
			 temp2 = null;
			 this.size--;
		}
		else if(index>1&&index<this.size-1) {
			 CellNode temp = new CellNode();
			 CellNode temp2 = new CellNode();
			 temp = this.head;
			 temp2 = temp.point;
			 
			for(int i= 0;i<this.size-1;i++) {
				temp = temp.point;
				temp2=temp.point;
				if(i==index-2) {
					temp.point = temp2.point;
					temp2.point = null;
					temp2 = null;
					this.size--;
					break;

				}
			}
			
		}
		else if(index==this.size-1) {
			 CellNode temp = new CellNode();
			 

			 temp = this.head;
			
			 
			for(int i= 0;i<this.size-1;i++) {
				temp = temp.point;
				if(i==index-2) {
					temp.point = null;
					this.size--;
				}
			}
		}
		
	
		
		}catch(NoSuchElementException e) {
			System.out.println("Invalid Index");
			System.exit(0);
		}
	}
	/**
	 * delete the object from the start
	 */
	public void deleteFromStart() {
		if(this.head==null) {
			
		}
		else {
			this.head = this.head.point;
			this.size--;
		}
	}
	
	/**
	 * print the list
	 * @param l
	 */
	public static void showContents(CellList l) {
		CellNode displayNode = l.head ;
		System.out.println("The current size of the list is "+l.size+". Here are the contents of the list\n"
				+"===============================================================================\n");
		int count = 1;
		while(displayNode != null) {
			System.out.print("["+displayNode.cell+"]---> ");
			if(count%3==0)
				System.out.println();
			displayNode = displayNode.point;
			count++;
		}
		System.out.print("X");
		
	}
	/**
	 * accessible by main
	 * and can be cloned	 
	 */
	public static class CellNode implements Cloneable{
		/**
		 * cell is the data of the node
		 */
	private CellPhone cell;
	/**
	 * point is where the object is pointing to
	 */
	private CellNode point;
	
	
	
	/**
	 * getter
	 * @return
	 */
	public CellPhone getCell() {
			return cell;
		}
	/**
	 * setter
	 * @param cell
	 */
		public void setCell(CellPhone cell) {
			this.cell = cell;
		}
		/**
		 * getter
		 * @return
		 */
		public CellNode getPoint() {
			return point;
		}
		/**
		 * setter
		 * @param point
		 */
		public void setPoint(CellNode point) {
			this.point = point;
		}
	
	/**
	 * default constructor
	 */
	public CellNode() {
		this.cell =  null;
		this.point = null;
	}
	/**
	 * parameter constructor
	 * @param cell
	 * @param point
	 */
	public CellNode(CellPhone cell, CellNode point) {
		super();
		this.cell = cell;
		this.point = point;
	}
	/**
	 * copy constructor 
	 * @param serialNumber 
	 * @param other
	 */
	public CellNode(CellNode other, long serialNumber) {
		this.cell = new CellPhone(other.cell,  serialNumber);
		this.point = other.point;
	}
	/**
	 * clone method
	 */
	public CellNode clone(long serialNumber) throws CloneNotSupportedException {
	
		
		CellNode cloneNode = (CellNode) super.clone();
		cloneNode.setCell((CellPhone)cloneNode.getCell().clone(serialNumber));
		
		return cloneNode;
	}
	
	public String toString() {
		return "cell=" + cell + ", point=" + point;
	}
	
	}
	/**
	 * setter
	 * @param size
	 */
	public void setSize(int size) {
		
		this.size = size;
	}
	/**
	 * end of program thanks
	 */
}
