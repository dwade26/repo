package application;

import java.util.Arrays;
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description:  This class creates a managemnt company that contains a list of non-overlaping properties
 * all contained in one plot
 * Due: 11/10/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Djim Wade
*/


public class ManagementCompany {
	private String name;
	private String taxID;
	private double mgmFee;
	
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_WIDTH = 10;
	public static final int MGMT_DEPTH = 10;
	
	private Property[] properties = new Property[MAX_PROPERTY];
	private Plot plot;
	private int numberOfProperties = 0;
	
	public ManagementCompany() {
		name = "";
		taxID = "";
		mgmFee = 0;
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		plot = new Plot(x,y,width,depth);
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		name = otherCompany.name;
		taxID = otherCompany.taxID;
		mgmFee = otherCompany.mgmFee;
		plot = new Plot(otherCompany.plot);
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		if(isPropertiesFull()) {
			return -1;
		}
		Property newProperty = new Property(name,city,rent,owner);
		if(!plot.encompass(newProperty.getPlot())) {
			return -3;
		}
		for(int i= 0; i<MAX_PROPERTY; i++) {			
			if(properties[i] == null) {
				properties[i] = newProperty;
				numberOfProperties++;
				return i;
			}
			if(newProperty.getPlot().overlaps(properties[i].getPlot()) == true) {
				return -4;
			}
		}
		return 5; // should never get here
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property newProperty = new Property(name,city,rent,owner,x,y,width,depth);
		if(!plot.encompass(newProperty.getPlot())) {
			return -3;
		}
		for(int i= 0; i<MAX_PROPERTY; i++) {			
			if(properties[i] == null) {
				properties[i] = newProperty;
				numberOfProperties++;
				return i;
			}
			if(newProperty.getPlot().overlaps(properties[i].getPlot()) == true) {
				return -4;
			}
		}
		return -1;
	}
	
	public int addProperty(Property otherProperty) {
		if (otherProperty == null) {
			return -2;
		}
		Property newProperty = new Property(otherProperty);
		if(!plot.encompass(newProperty.getPlot())) {
			return -3;
		}
		for(int i= 0; i<MAX_PROPERTY; i++) {
			if(properties[i] == null) {
				properties[i] = newProperty;
				numberOfProperties++;
				return i;
			}
			if(newProperty.getPlot().overlaps(properties[i].getPlot()) == true) {
				return -4;
			}
		}
		return -1;
	}
	
	public void removeLastProperty() {
		if(!(properties[0] == null)) {
			for(int i= 1; i<MAX_PROPERTY; i++) {
				if(properties[i] == null) {
					properties[i-1] = null;
					numberOfProperties--;
					return;
				}
			}
			properties[MAX_PROPERTY-1] = null;
			numberOfProperties--;
		}
	}
	
	public boolean isPropertiesFull() {
		if(MAX_PROPERTY==numberOfProperties) {
			return true;
		}
		return false;
	}
	
	public int getPropertiesCount() {
		return numberOfProperties;
	}
	
	public double getTotalRent() {
		double sum = 0;
		for(int i= 0; i<MAX_PROPERTY; i++) {
			if(properties[i] == null) {
				return sum;
			}
			sum+=properties[i].getRentAmount();
		}
		return sum;
	}
	
	public Property getHighestRentPropperty() {
		if (properties[0] == null) {
			return null;
		}
		Property highest = properties[0];
		for(int i= 0; i<MAX_PROPERTY; i++) {
			if(properties[i] == null) {
				return highest;
			}
			if(highest.getRentAmount()<properties[i].getRentAmount()) {
				highest = properties[i];
			}
		}
		return new Property(highest);
	}
	
	public boolean isMangementFeeValid() {
		if(mgmFee > 0 && mgmFee <100) {
			return true;
		}
		return false;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTaxID() {
		return taxID;
	}
	
	public Property[] getProperties() {
		return Arrays.copyOf(properties, MAX_PROPERTY);	
	}
	
	public double getMgmFeePer() {
		return mgmFee;
	}
	
	public Plot getPlot() {
		return new Plot(plot);	
	}
	
	public String toString() {
		String s = "List of the properties for " + name + ", taxID: " + taxID;
		s+="\n______________________________________________________";
		for(int i= 0; i<MAX_PROPERTY; i++) {
			if(properties[i] == null) {
				return s+="\n______________________________________________________\n\n" + " total management Fee: "+ (getTotalRent()*mgmFee)/100;
			}
			s+="\n"+ properties[i].toString();
		}
		return s+="\n______________________________________________________\n\n" + " total management Fee: "+ (getTotalRent()*mgmFee)/100;
	}
}
