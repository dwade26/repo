package ESPGame; 
import java.util.Scanner;
import java.util.Random;

/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description: The ESP Game class takes the users name, MC#, and description, and then allows them to 
 * guess the color the was randomly picked out of 5. The user guesses 11 different times and is told
 * how many times out of 11 they are correct.
 * Due: 9/22/2023
 * Platform/compiler: Java
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Djim Wade
*/


public class ESPGame {
	
	public static void main(String[] args) {
		
		// The 5 colors, all assigned to a constant variable that alligns to its name
		final String RED = "red";
		final String BLACK = "black";
		final String GREEN = "green";
		final String BLUE = "blue";
		final String YELLOW = "yellow";
		
		// Declaring necessary variables and objects
		String guess;
		String correct;
		Random random = new Random();
		int number;
		int correctGuesses = 0;
		boolean invalid = true;
		Scanner input = new Scanner(System.in);
		
		// Using the scanner object to ask the user to input their information and store it
		System.out.println("Enter Your Name: ");
		String name = input.nextLine();
		System.out.println("Enter Your MC#: ");
		String mcNumber = input.nextLine();
		System.out.println("Describe yourself: ");
		String description = input.nextLine();
		System.out.println("Enter the due date: ");
		String dueDate = input.nextLine();
		System.out.println("CMSC Assignment 1: Test your ESP Skills!");
		
		
		// A for loop that runs 11 time for the 11 rounds		
		for(int i=1; i<=11; i++) {
			
			System.out.println("\nRound " + i);
			number = random.nextInt(5);
			
			// An if else statement that converts the random number into its corresponding color
			if(number == 0) {
				correct = RED;
			}else if (number == 1) {
				correct = BLACK;
			}
			else if (number == 2) {
				correct = GREEN;
			}
			else if (number == 3) {
				correct = BLUE;
			}
			else {
				correct = YELLOW;
			}
			System.out.println("I am thinking of a color?");
			System.out.println("Is it red, black, green, blue, or yellow?");
			System.out.print("Guess a color(lowercase only): ");
			guess = input.nextLine();
			
			// Makes sure that guess is valid, and if not repeats question and asks for different input
			while(!(guess.equals("red")|| guess.equals("black")||guess.equals("green")||guess.equals("blue")||guess.equals("yellow"))) {
				System.out.println("You entered an invalid color. Is it red, black, green, blue, or yellow?");
				System.out.print("Guess a color(lowercase only): ");
				guess = input.nextLine();
			}
			
			// Checks if guess is correct
			if (guess.equals(correct)){
				System.out.println("Correct! I was thinking of " + correct);
				correctGuesses++;
			}else {
				System.out.println("Incorrect! I was thinking of " + correct);
			}
		}
		
		// Displays user information and amount of correct guesses
		System.out.println("\nYou guessed " + correctGuesses + " out of " + " 11 colors correctly");
		System.out.println("User Name: "+ name);
		System.out.println("User MC#: "+ mcNumber);
		System.out.println("User Description: "+ description);
		System.out.println("Due Date: "+ dueDate);
		

	}

}
