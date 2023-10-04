package Patient;
import java.text.NumberFormat;
import java.util.Locale;
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: Creates a patient and 3 procedure instances and displays all information within those objects
 * Due: 10/06/2002
 * Platform/compiler: Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Djim Wade
*/

public class PatientDriverApp {

	public static void main(String[] args) {
		Patient patient = new Patient("Bob", "Allen","Johnson", "211 Willow St", "Silver Spring", "Maryland", 
				"20850", "1234567890", "Emily Johnson", "9876543210");
		Procedure procedure1 = new Procedure();
		procedure1.setProcedureName("back surgery");
		procedure1.setDate("9/28/21");
		procedure1.setPractitionerName("Tom Lee");
		procedure1.setCharge(1000);
		Procedure procedure2 = new Procedure("leg surgery", "9/28/22");
		procedure2.setPractitionerName("David Brown");
		procedure2.setCharge(2000);
		Procedure procedure3 = new Procedure("eye exam", "9/28/23", "Mary Lewis", 100);
		
		// creates a number format class and sets it to formato to US dollars ($##.##)
		NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(Locale.US);
		
		// Displays information of the objects
		displayPatient(patient);
		System.out.print("\n\n");
		displayProcedure(procedure1);
		System.out.print("\n");
		displayProcedure(procedure2);
		System.out.print("\n");
		displayProcedure(procedure3);
		
		// Uses the number format class to display the total charge in a US dollar formatt ($##.##)
		System.out.print("\nTotal Charges: "+ numberFormatter.format(calculateTotalCharges(procedure1,procedure2,procedure3)));
		
		
		System.out.println("\n\nStudent Name: Djim Wade");
		System.out.println("MC#: M21075958");
		System.out.println("Due Date: 10/6/23");
	
	}
	
	/**
	 * Displays the information of the patient
	 * @param p the patient
	 */
	public static void displayPatient(Patient p) {
		System.out.print(p.toString());
	}
	/**
	 * Displays the information of the procedure
	 * @param p the procedure
	 */
	public static void displayProcedure(Procedure p) {
		System.out.print(p.toString());
	}
	/**
	 * Finds the sum of the charges of the 3 given procedures
	 * @param p1 the cost of procedure 1
	 * @param p2 the cost of procedure 2
	 * @param p3 the cost of procedure 3
	 * @return the sum of the given charges
	 */
	public static double calculateTotalCharges(Procedure p1,Procedure p2,Procedure p3) {
		return p1.getCharge()+p2.getCharge()+p3.getCharge();
	}

}
