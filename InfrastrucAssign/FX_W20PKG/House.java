/**
 * House class
 */
package FX_W20PKG;

public class House extends ResidentialBuilding {
	
	private double numberOfRooms;
	private int numOfFloors;
	/**
	 * constructor
	 * @param yearOfCreation
	 * @param cost
	 * @param landSpace
	 * @param material
	 * @param maxNumberOfHabitants
	 * @param numberOfRooms
	 * @param numOfFloors
	 */
	public House(int yearOfCreation, double cost, double landSpace, String material, int maxNumberOfHabitants, double numberOfRooms, int numOfFloors) {
		super (yearOfCreation,  cost,  landSpace,  material, maxNumberOfHabitants);
		this.numberOfRooms = numberOfRooms;
		this.numOfFloors = numOfFloors;
		
	}
	/**
	 * toString method
	 */
	public String toString() {
		return super.toString()+", number of Rooms is: "+this.numberOfRooms+", number of Floors is: "+this.numOfFloors;
	}
	/**
	 * clone method
	 */
	public Object clone() throws CloneNotSupportedException{
		House clone = (House)super.clone();
		return clone;
	}
}
