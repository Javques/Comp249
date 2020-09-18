/**
 * Structure class
 */
package FX_W20PKG;

public class Structure implements Cloneable {

	private int yearOfCreation;
	private double cost;
	/**
	 * constructor
	 * @param yearOfCreation
	 * @param cost
	 */
	public Structure(int yearOfCreation, double cost) {
		this.yearOfCreation = yearOfCreation;
		this.cost = cost;
	}
	/**
	 * toString method
	 */
	public String toString() {
		String temp = getClass().getName();
		temp = temp.substring(temp.indexOf(".")+1);
		return temp+" object info: year of Creation is: "+this.yearOfCreation+", cost is: "+this.cost;
	}
	/**
	 * clone method
	 */
	public Object clone() throws CloneNotSupportedException{
		Structure clone = (Structure)super.clone();
		return clone;
	}
}
