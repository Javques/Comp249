/**
 * overpass class
 */
package FX_W20PKG;

public class Overpass extends Bridge{
	private double maxLoad;
	
	/**
	 * constructors
	 * @param yearOfConstruction
	 * @param cost
	 * @param length
	 * @param height
	 * @param maxLoad
	 */
	public Overpass(int yearOfConstruction, double cost, double length, double height, double maxLoad) {
		super(yearOfConstruction, cost, length, height);
		this.maxLoad = maxLoad;
		
	}
	/**
	 * toString
	 */
	public String toString() {
		return super.toString()+", max Load is: "+this.maxLoad;
	}
	/**
	 * clone method
	 */
	public Object clone() throws CloneNotSupportedException{
		Overpass clone = (Overpass)super.clone();
		return clone;
	}
}
