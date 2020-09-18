/**
 *
 * name and id Alexis Bolduc 40126092
 * Comp249
 * Assignment 4
 * due date April 19th
 * @author alexisbolduc
 *  @version v1
 *  
 * 
 * Welcome,
 * This is the class CellPhone
 * the goal is to create instances of a cellphone which has various attributes 
 */

/**
 * we need the use of package for simplicity in visibility using main
 */
package Cell;
/**
 * importing declarations
 */

/**
 * implementing cloneable assures the object can be cloned
 * @author alexi
 *
 */
public class CellPhone implements Cloneable {
	/**
	 * serialNum is the serial number, it is assumed that all cellphones have unique serial number
	 */
long serialNum;
/**
 * brand is the brand of the phone, it is assumed to be in one word
 */
private String brand;
/**
 * the year of the creation
 */
private int year;
/**
 * the price of the phone
 */
private double price;
/**
 * Parameters Constructor
 * @param serialNum
 * @param brand
 * @param price
 * @param year
 */
public CellPhone(long serialNum, String brand, double price, int year) {
	super();
	this.serialNum = serialNum;
	
	this.brand = brand;
	this.year = year;
	this.price = price;
}
/**
 * Copy Constructor
 * @param other
 * @param serialNum
 */
public CellPhone(CellPhone other, long serialNum) {
	super();
	
	this.brand = other.brand;
	this.year = other.year;
	this.price = other.price;
	this.serialNum = serialNum;
}
/**
 * Clone method
 */
public CellPhone clone(long serialNumber) throws CloneNotSupportedException {
	
	
	CellPhone cloneCellPhone = (CellPhone) super.clone();
	cloneCellPhone.serialNum = serialNumber;
	return cloneCellPhone;
}

/**
 * equals method
 * @param other
 * @return boolean value of equality
 */
public boolean equals(CellPhone other) {
	if(other == null)
		return false;
	else if(getClass()!=other.getClass())
		return false;
	else {
		CellPhone otherCellPhone = (CellPhone) other;
		return(brand.equals(otherCellPhone.brand)&&(price==otherCellPhone.price)&& 
				(year==otherCellPhone.year));
	}
}

/**
 * 
 * @return String message 
 */
public String toString() {
	return  serialNum + ":  " + brand +  " " + price+"$ " + year  ;
}
/**
 * getter
 * @return serial Number
 */
public long getSerialNum() {
	return serialNum;
}
/**
 * setter
 * @param serialNum
 */
public void setSerialNum(long serialNum) {
	this.serialNum = serialNum;
}
/**
 * getter
 * @return brand
 */
public String getBrand() {
	return brand;
}
/**
 * setter
 * @param brand
 */
public void setBrand(String brand) {
	this.brand = brand;
}
/**
 * getter
 * @return price
 */
public int getYear() {
	return year;
}
/**
 * setter
 * @param year
 */
public void setYear(int year) {
	this.year = year;
}
/**
 * getter
 * @return price
 */
public double getPrice() {
	return price;
}
/**
 * setter 
 * @param price
 */
public void setPrice(double price) {
	this.price = price;
}
/**
 * end of program thanks
 */
}
