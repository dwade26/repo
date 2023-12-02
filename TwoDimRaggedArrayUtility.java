package application;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description:  This utility works with 2 dimensional ragged arrays with a maximum of 
 * 10 rows and 10 columns. It works with negative and positive numbers
 * Due: 12/1/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * Print your Name here: Djim Wade
 */
public class TwoDimRaggedArrayUtility {
	
	/**
	 * Reads from a file and returns a ragged array of doubles
	 * @param file - the file to read from
	 * @return a two dimensional ragged (depending on data) array of doubles if the file is not empty, 
	 * returns a null if file is empty
	 */
	public static double [][] readFile(File file) throws FileNotFoundException {
		if(file == null)
			return null;
		String [] stringList = new String[10];
		FileReader fileReader = new FileReader(file);
		Scanner reader = new Scanner(fileReader);
		int row = 0;
		while(reader.hasNext()) {
			stringList[row] = reader.nextLine();
			row++;
		}
		String [][] raggedString = new String [row][];
		for(int i = 0; i<row;i++) {
			raggedString[i] = stringList[i].split(" ");
		}
	    double [][] raggedDouble = new double [row][];
	    for(int i = 0; i<raggedString.length;i++) {
	    	raggedDouble[i] = new double[raggedString[i].length];
			for(int j =0;j<raggedString[i].length;j++) {
				raggedDouble[i][j]= Double.parseDouble(raggedString[i][j]);
			}
		}
	    return raggedDouble;
	}
	
	/**
	 * Writes the ragged array of doubles into the file. 
	 * @param data - two dimensional ragged array of doubles
	 * @param outputFile - the file to write to
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		FileWriter output;
		try {
			output = new FileWriter(outputFile);
			for(int i = 0; i<data.length;i++) {
				if(i!=0) {
					output.write("\n");
				}
				for(int j =0;j<data[i].length;j++) {	
					if(j+1==data[i].length) {
						output.write(String.valueOf(data[i][j]));
					}else {
						output.write(String.valueOf(data[i][j] + " "));
					}	
				}
			}
			output.close();
		} catch (IOException e) {
			
			System.out.print("There was an IO exception");
		}
		
	}
	
	/**
	 * Returns the sum of the elements in the two dimensional array
	 * @param data - the two dimensional array
	 * @return the sum of all the elements in the two dimensional array
	 */
	public static double getTotal(double[][] data) {
		double sum = 0;
		for(int i = 0; i<data.length;i++) {
			for(int j =0;j<data[i].length;j++) {	
				sum+=data[i][j];
			}
		}
		return sum;
	}
	
	/**
	 * Returns the average of the elements in the two dimensional array
	 * @param data - the two dimensional array
	 * @return the average of all the elements in the two dimensional array
	 */
	public static double getAverage(double[][] data) {
		double sum = 0;
		double count = 0;
		for(int i = 0; i<data.length;i++) {
			for(int j =0;j<data[i].length;j++) {	
				sum+=data[i][j];
				count++;
			}
		}
		return sum/count;
	}
	
	/**
	 * Returns the sum of the elements in thegiven row of the two dimensional array
	 * @param data - the two dimensional array
	 * @param row - the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double sum = 0;
		for(int i =0;i<data[row].length;i++) {	
			sum+=data[row][i];
		}
		return sum;
	}
	
	/**
	 * Returns the sum of the elements in the given column of the two dimensional array
	 * @param data - the two dimensional array
	 * @param col - the column index to take the total of (0 refers to the first row)
	 * @return the total of the column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double sum = 0;
		for(int i =0;i<data.length;i++) {	
			if(data[i].length>col)
				sum+=data[i][col];
		}
		return sum;
	}
	
	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * @param data - the two dimensional array
	 * @param row - the row index to take the total of (0 refers to the first row)
	 * @return the largest element of the row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = data[row][0];
		for(int i =1;i<data[row].length;i++) {
			if(data[row][i]>highest)
				highest=data[row][i];
		}
		return highest;
	}
	
	/**
	 * Returns index of the largest element of the selected row in the two dimensional array
	 * @param data - the two dimensional array
	 * @param row - the row index to take the total of (0 refers to the first row)
	 * @return the index of largest element of the row
	 */
	public static double getHighestInRowIndex(double[][] data, int row) {
		double highest = data[row][0];
		int index = 0;
		for(int i =1;i<data[row].length;i++) {
			if(data[row][i]>highest) {
				highest=data[row][i];
				index=i;
			}
		}
		return index;
	}
	
	/**
	 * Returns the smallest element of the selected row in the two dimensional array
	 * @param data - the two dimensional array
	 * @param row - the row index to take the total of (0 refers to the first row)
	 * @return the smallest element of the row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = data[row][0];;
		for(int i =1;i<data[row].length;i++) {
			if(data[row][i]<lowest)
				lowest=data[row][i];
		}
		return lowest;
	}
	
	/**
	 * Returns index of the smallest element of the selected row in the two dimensional array
	 * @param data - the two dimensional array
	 * @param row - the row index to take the total of (0 refers to the first row)
	 * @return the index of the smallest element of the row
	 */
	public static double getLowestInRowIndex(double[][] data, int row) {
		double lowest = data[row][0];;
		int index = 0;
		for(int i =1;i<data[row].length;i++) {
			if(data[row][i]<lowest) {
				lowest=data[row][i];
				index=i;
			}
		}
		return index;
	}
	
	/**
	 * Returns the largest element of the selected column in the two dimensional array
	 * @param data - the two dimensional array
	 * @param col - the column index to take the total of (0 refers to the first row)
	 * @return the largest element of the column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest;
		if(data[0].length>col) {
			highest = data[0][col];
		}else {
			highest =2.2250738585072014E-308;
		}
		for(int i =1;i<data.length;i++) {
			if(data[i].length>col) {
				if(data[i][col]>highest)
					highest=data[i][col];
			}
		}
		return highest;
	}
	
	/**
	 * Returns index of the largest element of the selected column in the two dimensional array
	 * @param data - the two dimensional array
	 * @param col - the column index to take the total of (0 refers to the first row)
	 * @return the index of the largest element of the column
	 */
	public static double getHighestInColumnIndex(double[][] data, int col) {
		double highest;
		if(data[0].length>col) {
			highest = data[0][col];
		}else {
			highest =2.2250738585072014E-308;
		}
		int index = 0;
		for(int i =1;i<data.length;i++) {
			if(data[i].length>col) {
				if(data[i][col]>highest) {
					highest=data[i][col];
				    index = i;
				}
			}
		}
		return index;
	}
	
	/**
	 * Returns the smallest element of the selected column in the two dimensional array
	 * @param data - the two dimensional array
	 * @param col - the column index to take the total of (0 refers to the first row)
	 * @return the smallest element of the column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest;
		if(data[0].length>col) {
			lowest = data[0][col];
		}else {
			lowest =1.79769313486231570e+308d;
		}
		for(int i =1;i<data.length;i++) {
			if(data[i].length>col) {
				if(data[i][col]<lowest)
					lowest=data[i][col];
			}
		}
		return lowest;
	}
	
	/**
	 * Returns index of the smallest element of the selected column in the two dimensional array
	 * @param data - the two dimensional array
	 * @param col - the column index to take the total of (0 refers to the first row)
	 * @return the index of the smallest element of the column
	 */
	public static double getLowestInColumnIndex(double[][] data, int col) {
		double lowest;
		if(data[0].length>col) {
			lowest = data[0][col];
		}else {
			lowest =1.79769313486231570e+308d;
		}
		int index = 0;
		for(int i =1;i<data.length;i++) {
			if(data[i].length>col) {
				if(data[i][col]<lowest) {
					lowest=data[i][col];
					index = i;
				}
			}
		}
		return index;
	}
	
	/**
	 * Returns the largest element in the two dimensional array
	 * @param data - the two dimensional array getting the sum of
	 * @return the largest element in the two dimensional array
	 */
	public static double getHighestInArray(double[][] data) {
		double highest = data[0][0];
		for(int i = 0; i<data.length;i++) {
			for(int j =0;j<data[i].length;j++) {	
				if(data[i][j]>highest)
					highest=data[i][j];
			}
		}
		return highest;
	}
	
	/**
	 * Returns the smallest element in the two dimensional array
	 * @param data - the two dimensional array
	 * @return the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0];
		for(int i = 0; i<data.length;i++) {
			for(int j =0;j<data[i].length;j++) {	
				if(data[i][j]<lowest)
					lowest=data[i][j];
			}
		}
		return lowest;
	}
	
}
