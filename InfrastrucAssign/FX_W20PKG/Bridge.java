/**
 * bridge class
 */
package FX_W20PKG;

public class Bridge extends Structure {

	
	private double length;
	private double height;
	/**
	 * constructor
	 * @param yearOfCreation
	 * @param cost
	 * @param length
	 * @param height
	 */
	public Bridge(int yearOfCreation, double cost, double length, double height) {
		super(yearOfCreation, cost);
		this.length = length;
		this.height = height;
	}
	/**
	 * toString method
	 */
	public String toString() {
		return super.toString()+", length is: "+this.length+", height is: "+this.height;
	}
	/**
	 * clone method
	 */
	public Object clone() throws CloneNotSupportedException{
		Bridge clone = (Bridge)super.clone();
		return clone;
	}
	
}
