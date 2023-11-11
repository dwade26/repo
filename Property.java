package application;
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description:  This class creates a property that is within a plot
 * all contained in one plot
 * Due: 11/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Djim Wade
*/

public class Property {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	public Property() {
		propertyName = "";
		city = "";
		owner = "";
		rentAmount = 0;
		plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();
		
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x,y,width,depth);
		
	}
	
	public Property(Property otherProperty) {
		propertyName = otherProperty.propertyName;
		city = otherProperty.city;
		rentAmount = otherProperty.rentAmount;
		owner = otherProperty.owner;
		plot = new Plot(otherProperty.plot);
		
	}
	
	
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public String getCity() {
		return city;
	}
	
	public double getRentAmount() {
		return rentAmount;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public Plot getPlot() {
		return new Plot(plot);
	}
	
	public String toString() {
		return propertyName + "," + city + "," + owner + "," + rentAmount;
	}
	
	
	
}
