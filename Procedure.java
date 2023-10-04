package Patient;
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: Creates a procedure object in which all relevant information can be accessed
 * and changed through getters and setters
 * Due: 10/06/2002
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Djim Wade
*/
public class Procedure {
	private String procedureName;
	private String date;
	private String practitionerName;
	private double charge;
	
	public Procedure() {
		
	}
	public Procedure(String procedureN, String d) {
		procedureName = procedureN;
		date = d;
	}
	
	public Procedure(String procedureN, String d, String practitionerN, double c) {
		procedureName = procedureN;
		date = d;
		practitionerName = practitionerN;
		charge = c;
	}
	
	/**
	 * Allows access to the procedureName field
	 * @return the procedureName field
	 */
	public String getProcedureName() {
		return procedureName;
	}
	/**
	 * Allows access to the date field
	 * @return the date field
	 */
	public String getDate() {
		return date;
	}
	/**
	 * Allows access to the practitionerName field
	 * @return the practitionerName field
	 */
	public String getPractitionerName() {
		return practitionerName;
	}
	/**
	 * Allows access to the charges field
	 * @return the charges field
	 */
	public double getCharge() {
		return charge;
	}
	
	/**
	 * Sets the procedureName field to the given value
	 * @param name the name of the procedure
	 */
	public void setProcedureName(String name) {
		procedureName = name;
	}
	/**
	 * Sets the date field to the given value
	 * @param d the date of the procedure
	 */
	public void setDate(String d) {
		date = d;
	}
	/**
	 * Sets the practitionerName field to the given value
	 * @param name the name of the practitioner
	 */
	public void setPractitionerName(String name) {
		practitionerName = name;
	}
	/**
	 * Sets the charge field to the given value
	 * @param c the cost of the procedure
	 */
	public void setCharge(double c) {
		charge = c;
	}
	
	/**
	 * Combines the information of all fields into one string 
	 * @return a concatenated string with the information of all fields, separated by new lines according
	 */
	public String toString() {
		return "Procedure=" + procedureName + "\n" + "ProcedureDate="+ date +"\n" + "Practioner=" + 
				practitionerName + "\n" + "Charge=" + String.valueOf(charge); 
	}
	
	
}
