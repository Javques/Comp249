/**
 * highrise class
 */
package FX_W20PKG;

public class HighRise extends Building {
	
	private double height;
	/**
	 * constructors
	 * @param yearOfCreation
	 * @param cost
	 * @param landSpace
	 * @param material
	 * @param height
	 */
	public HighRise(int yearOfCreation, double cost, double landSpace, String material, double height) {
		super(yearOfCreation, cost, landSpace, material);
		this.height = height;
	}
	/**
	 * toString method
	 */
	public String toString() {
		return super.toString()+", height is: "+this.height;
	}
	/**
	 * getter for height, used in task 3.C
	 * @return
	 */
	public double getHeight() {
		return this.height;
	}
	/**
	 * clone method
	 */
	public Object clone() throws CloneNotSupportedException{
		HighRise clone = (HighRise)super.clone();
		return clone;
	}
}
