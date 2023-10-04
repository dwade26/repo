package Patient;
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: Creates a patient object in which all relevant information can be accessed
 * and changed through getters and setters
 * Due: 10/06/2002
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Djim Wade
*/


public class Patient {

	private String firstName;
	private String middleName;
	private String lastName;	
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	private String emergencyContactName;
	private String emergencyContactNumber;
	
	
	public Patient(){
		
	}
	public Patient(String fName, String mName, String lName) {
		firstName = fName;
		middleName = mName;
		lastName = lName;
	}
	public Patient(String fName, String mName, String lName, String sAddress, String c, String s, 
			String zCode, String pNumber, String eName, String eNumber) {
		firstName = fName;
		middleName = mName;
		lastName = lName;
		streetAddress =  sAddress;
		city = c;
		state = s;
		zipCode = zCode;
		phoneNumber = pNumber;
		emergencyContactName = eName;
		emergencyContactNumber = eNumber;
				
	}
	/**
	 * Allows access to the firstName field
	 * @return the firstName field
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Allows access to the middleName field
	 * @return the middleName field
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * Allows access to the lastName field
	 * @return the lastName field
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Allows access to the streetAddress field
	 * @return the streetAddress field
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	/**
	 * Allows access to the city field
	 * @return the city field
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Allows access to the state field
	 * @return the state field
	 */
	public String getState() {
		return state;
	}
	/**
	 * Allows access to the zipCode field
	 * @return the zipCode field
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * Allows access to the phoneNumber field
	 * @return the phoneNumber field
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * Allows access to the emergencyContactName field
	 * @return the emergencyContactName field
	 */
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	/**
	 * Allows access to the emergencyContactNumber field
	 * @return the emergencyContactNumber field
	 */
	public String getEmergencyContactNumber() {
		return emergencyContactNumber;
	}
	
	/**
	 * Sets the firstName field to the given value
	 * @param fName the first name of the patient
	 */
	public void setFirstName(String fName) {
		firstName = fName;
	}
	/**
	 * Sets the middleName field to the given value
	 * @param mName the middle name of the patient
	 */
	public void setMiddleName(String mName) {
		middleName = mName;
	}
	/**
	 * Sets the lastName field to the given value
	 * @param lName the last name of the patient
	 */
	public void setLastName(String lName) {
		lastName = lName;
	}
	/**
	 * Sets the streetAddress field to the given value
	 * @param sAddress the street address of the patient
	 */
	public void setStreetAdress(String sAddress) {
		streetAddress =  sAddress;
	}
	/**
	 * Sets the city field to the given value
	 * @param c the city of the patient
	 */
	public void setCity(String c) {
		city = c;
	}
	/**
	 * Sets the state field to the given value
	 * @param s the state of the patient
	 */
	public void setState(String s) {
		state = s;
	}
	/**
	 * Sets the zipCode field to the given value
	 * @param zCode the zip code of the patient
	 */
	public void setZipCode(String zCode) {
		zipCode = zCode;
	}
	/**
	 * Sets the phoneNumber field to the given value
	 * @param pNumber the phone number of the patient
	 */
	public void setPhoneNumber(String pNumber) {
		phoneNumber = pNumber;
	}
	/**
	 * Sets the emergencyContactName field to the given value
	 * @param eName the name of the emergency contact of the patient
	 */
	public void setEmergencyContactName(String eName) {
		emergencyContactName = eName;
	}
	/**
	 * Sets the emergencyContactName field to the given value
	 * @param eNumber the phone number of the emergency contact of the patient
	 */
	public void setEmergencyContactNumber(String eNumber) {
		emergencyContactNumber = eNumber;
	}
	
	/**
	 * Builds the full name of the patient using the relevant fields
	 * @return a concatenated string of the first, middle, and last name separated by a space.
	 */
	public String buildFullName() {
		return firstName + " "+ middleName + " "+ lastName;
	}
	
	/**
	 * Builds the full address of the patient using the relevant fields
	 * @return a concatenated string of the street address, city, state, and zip code separated by a space.
	 */
	public String buildAddress() {
		return streetAddress + " "+ city + " "+ state + " " + zipCode;
	}
	
	/**
	 * Combines the emergency contact information into 1 string of the patient using the relevant fields
	 * @return a concatenated string of the name and number of the emergency number separated by a space.
	 */
	public String buildEmergencyContact() {
		return emergencyContactName + " "+ emergencyContactNumber;
	}
	
	/**
	 * Combines the information of all fields into one string 
	 * @return a concatenated string with the information of all fields, separated by new lines according
	 * to the category of information
	 */
	public String toString() {
		return "Name: "+ buildFullName() + "\n" +"Address: " + buildAddress()+ "\n" + "Phone Number: "+
				phoneNumber + "\n" + "Emergency Contact: "+  buildEmergencyContact();
	}
	

}
