/**
 * condoBuilding class
 */
package FX_W20PKG;

public class CondoBuilding extends ResidentialBuilding {
	private int numOfUnits;
	/**
	 * constructors
	 * @param yearOfCreation
	 * @param cost
	 * @param landSpace
	 * @param material
	 * @param maxNumberOfHabitants
	 * @param numOfUnits
	 */
	public CondoBuilding(int yearOfCreation, double cost, double landSpace, String material, int maxNumberOfHabitants, int numOfUnits) {
		super (yearOfCreation,  cost,  landSpace,  material, maxNumberOfHabitants);
		this.numOfUnits = numOfUnits;
		
	}
	/**
	 * toString method
	 */
	public String toString() {
		return super.toString()+", number Of Units is: "+this.numOfUnits;
	}
	/**
	 * clone method
	 */
	public Object clone() throws CloneNotSupportedException{
		CondoBuilding clone = (CondoBuilding)super.clone();
		return clone;
	}

}
