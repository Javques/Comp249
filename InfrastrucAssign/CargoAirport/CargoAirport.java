/**
 * this is the cargoAirport class
 */

package CargoAirport;

import FX_W20PKG.Airport;


public class CargoAirport extends Airport{

	/**
	 * constructor
	 */
	private double landedWeight;
	public CargoAirport(int yearOfCreation, double cost, int numOfRunaways, String code, double landedWeight) {
		super(yearOfCreation, cost, numOfRunaways, code);
		this.landedWeight = landedWeight;
	}
	/**
	 * to String method, the weight is assumed to be in million of pounds for clarity purposes
	 */
	public String toString() {
		return super.toString()+", landed Weight is: "+ this.landedWeight+" million";
	}
	/**
	 * clone method
	 */
	public Object clone() throws CloneNotSupportedException{
		CargoAirport clone = (CargoAirport)super.clone();
		return clone;
	}
}
