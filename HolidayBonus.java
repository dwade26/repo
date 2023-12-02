package application;
/*
 * Class: CMSC203 
 * Instructor: Gary Thai
 * Description:  This static class calculates the holiday bonus of the stores based on their sale amounts
 * relative to the other stores
 * Due: 12/1/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * Print your Name here: Djim Wade
 */
public class HolidayBonus {

		static final double BONUS_HIGHEST = 5000;
		static final double BONUS_LOWEST = 1000;
		static final double BONUS_ALL = 2000;
		
		/**
		 * Calculates the holiday bonus for each store
		 * @param data - the two dimensional array of store sale
		 * @return an array of the bonus for each store
		 */
		public static double[] calculateHolidayBonus(double[][] data) {
			double[] storeBonus = new double[data.length];
			for(int i =0; i<data.length;i++) {
				for(int j=0;j<data[i].length;j++) {
					if(TwoDimRaggedArrayUtility.getHighestInColumn(data,j) == data[i][j]) {
						storeBonus[i]+=BONUS_HIGHEST;
					}else if(TwoDimRaggedArrayUtility.getLowestInColumn(data,j) == data[i][j]) {
						storeBonus[i]+=BONUS_LOWEST;
					}else {
						storeBonus[i]+=BONUS_ALL;
					}
				}
			}
			return storeBonus;
		}
		
		/**
		 * Calculates the total holiday bonuses
		 * @param data - the two dimensional array of store sales
		 * @return the total of all holiday bonuses
		 */
		public static double calculateTotalHolidayBonus(double[][] data) {
			double totalStoreBonus = 0;
			for(int i =0; i<data.length;i++) {
				for(int j=0;j<data[i].length;j++) {
					if(TwoDimRaggedArrayUtility.getHighestInColumn(data,j) == data[i][j]) {
						totalStoreBonus+=BONUS_HIGHEST;
					}else if(TwoDimRaggedArrayUtility.getLowestInColumn(data,j) == data[i][j]) {
						totalStoreBonus+=BONUS_LOWEST;
					}else {
						totalStoreBonus+=BONUS_ALL;
					}	
				}
			}
			return totalStoreBonus;
		}
}
