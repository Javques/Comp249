/**
 * airport class
 */
package FX_W20PKG;

public  class Airport extends Structure {
	
	private int numOfRunaways;
	private String code;
	
	/**
	 * constructor
	 * @param yearOfCreation
	 * @param cost
	 * @param numOfRunaways
	 * @param code
	 */
	public Airport(int yearOfCreation, double cost, int numOfRunaways, String code) {
		super(yearOfCreation, cost);
		this.numOfRunaways = numOfRunaways;
		this.code = code;
	}
	/**
	 * toString method
	 */
	public String toString() {
		return super.toString()+", number of Runaways is: "+ this.numOfRunaways+", code is: "+this.code;
	}
	/**
	 * clone method
	 */
	public Object clone() throws CloneNotSupportedException{
		Airport clone = (Airport)super.clone();
		return clone;
	}
	/**
	 * getter for code used in task 5
	 * @return
	 */
	public String getCode() {
		return this.code;
	}
}
