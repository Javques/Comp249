/**
 * this is the CommercialAirport
 */
package CommercialAirport;

import FX_W20PKG.Airport;


public class CommercialAirport extends Airport {
	
	private int numOfGates;
	/**
	 * Constructor
	 * @param yearOfCreation
	 * @param cost
	 * @param numOfRunaways
	 * @param code
	 * @param numOfGates
	 */
	public CommercialAirport(int yearOfCreation, double cost, int numOfRunaways, String code, int numOfGates) {
		super(yearOfCreation, cost, numOfRunaways, code);
		this.numOfGates = numOfGates;
	}
	/**
	 * toString method
	 */
	public String toString() {
		return super.toString()+", number of Gates is: "+this.numOfGates;
	}
	/**
	 * clone method
	 */
	public Object clone() throws CloneNotSupportedException{
		CommercialAirport clone = (CommercialAirport)super.clone();
		return clone;
	}
}
