/**
 * residentialbuilding class
 */
package FX_W20PKG;

public class ResidentialBuilding extends Building {

	private int maxNumberOfHabitants;
	/**
	 * constructor
	 * @param yearOfCreation
	 * @param cost
	 * @param landSpace
	 * @param material
	 * @param maxNumberOfHabitants
	 */
	public ResidentialBuilding(int yearOfCreation, double cost, double landSpace, String material, int maxNumberOfHabitants) {
		
	super(yearOfCreation, cost, landSpace, material);
	this.maxNumberOfHabitants = maxNumberOfHabitants;
	}
	/**
	 * toString method
	 */
	public String toString() {
		return super.toString()+", max number of Habitants is: "+ this.maxNumberOfHabitants;
	}
	/**
	 * clone method
	 */
	public Object clone() throws CloneNotSupportedException{
		ResidentialBuilding	 clone = (ResidentialBuilding)super.clone();
		return clone;
	}
	}
