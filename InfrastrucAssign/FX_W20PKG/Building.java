/**
 * building class
 */
package FX_W20PKG;

public class Building extends Structure implements Cloneable{
	private double landSpace;
	private String material;
	/**
	 * constructors
	 * @param yearOfCreation
	 * @param cost
	 * @param landSpace
	 * @param material
	 */
	public Building(int yearOfCreation, double cost, double landSpace, String material) {
		super(yearOfCreation, cost);
		this.landSpace = landSpace;
		this.material = material;
	}
	/**
	 * toString method
	 */
	public String toString() {
		return super.toString()+", land Space is: "+this.landSpace+", material is: "+this.material;
	}
	/**
	 * clone method
	 */
	public Object clone() throws CloneNotSupportedException{
		Building clone = (Building)super.clone();
		return clone;
	}
}
