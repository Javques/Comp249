/**
 * this is the StructureList method
 */
package FX_W20PKG;


public class StructureList {
	private StructureNode head;
	
	/**
	 * ===============================================================
	 * TASK 6C
	 * 
	 * adds an element to the start
	 * @param struc
	 * ==============================================================
	 */
	public void addToStart(Structure struc) {
		StructureNode newEntry = new StructureNode(struc,null);
		if(this.head==null) {
			this.head = newEntry;
			this.head.next=null;
			
		}
		else {
		newEntry.next = this.head;
		this.head = newEntry;
		
		}
	}
	/**
	 * ================================================================
	 * TASK 6 C
	 * displays the content of the list
	 * ========================================================
	 */
	public void showListContents() {
		StructureNode displayNode = new StructureNode(null,null);
		displayNode = this.head;
		if(displayNode == null) {
			System.out.println("Empty List");
			return;
		}
		while(displayNode != null) {
			System.out.print("["+displayNode.sObj+"]-==> \n");
	
			displayNode = displayNode.next;
			
		}
		System.out.println("X");
	}
	/**
	 * =================================================================================
	 * TASK 6C
	 * add at the end of the list
	 * @param struc
	 * =======================================================================================
	 */
	
	public void addAtEnd(Structure struc) {
		if(this.head==null) {
			this.addToStart(struc);
			return;
		}
		StructureNode newEntry = new StructureNode(struc,null);
		StructureNode temp = new StructureNode(null,null);
		
		temp = this.head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = (newEntry);
	}
	/**
	 * ======================================================================
	 * TASK 6C
	 * clone method for the list
	 * ======================================================================
	 */
	public Object clone() {
		StructureList clone = new StructureList();
		StructureNode temp = new StructureNode(null,null);
		temp = this.head;
		clone.addToStart(temp.sObj);
		while(temp.next!=null) {
			temp = temp.next;
			clone.addAtEnd(temp.sObj);
			
		}
		return clone;
	}
	
	/**
	 * ==================================================================
	 * TASK 6C
	 * appending two lists
	 * @param appended
	 * ===================================================================
	 */
	public void append(StructureList appended) {
		StructureNode newEntry = appended.head;
		this.addAtEnd(newEntry.sObj);
		while(newEntry.next!=null) {
		newEntry = newEntry.next;
		this.addAtEnd(newEntry.sObj);
		
		}
		StructureNode temp1 = appended.head.next;
		StructureNode temp2 = temp1.next;
		appended.head = null;
		while(temp1.next!=null) {
			temp1 = temp2;
			temp2 = temp1.next;
			temp1 = null;
		}
	}
	/**
	 * ===========================================================
	 * TASK 6B
	 * inner class StructureNode
	 * @author alexi
	 * ============================================================
	 *
	 */
public class StructureNode{
		
		
		private Structure sObj;
		private StructureNode next;
		/**
		 * constructor
		 * @param sObj
		 * @param next
		 */
		public StructureNode(Structure sObj, StructureNode next) {
			this.sObj = sObj;
			this.next = next;
		}
	
	}
}
