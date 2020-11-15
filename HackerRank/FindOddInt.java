/*
** Description: Given an int array consisting of distinct values that occur an even 
**		number of times and one value that occurs an odd number of times, finds the latter.
** 		E.g. [2,3,2,5,4,3,6,4,5,6,6,1,1,1,1] ... outputs 6
		Link: https://www.hackerrank.com/contests/crescent-practice-3rd-years/challenges/find-the-unique-one
** Version: 1.0 
** Author: Joshua J. Abraham
** Date: December 2018
** Note: 
*/
import java.util.HashMap;

public class FindOddInt {

	public static void main(String[] args) {
		int[] arr = new int[args.length];
		for(int i=0; i < args.length; i++) {
			arr[i] = Integer.parseInt(args[i]);
		}

		System.out.printf("Quickly found odd integer to be: %d\n", findOddQuick(arr));
		System.out.printf("Standard find odd integer gave : %d\n", findOddStandard(arr));
	}
	
	private static int findOddQuick(int[] arr) {
		int sum = 0;
		for(int i=0; i < arr.length; i++) {
			sum ^= arr[i];	// making use of XOR
		}
		return(sum);
	}

	private static int findOddStandard(int[] arr) {
		HashMap<Integer, Integer> checker = new HashMap<Integer, Integer>();
		
		try {
		for(int i=0; i < arr.length; i++) {
			if(checker.containsKey(arr[i])) {
				checker.remove(arr[i]);
			}
			else {
				checker.put(arr[i], 1);
			}
		}
		// Create a new Error to throw when checker.keySet().length > 1, i.e. when there are more than 1 odd occurring integers
		return((Integer)checker.keySet().toArray()[0]);
		}
		catch(Exception e) {
			System.out.println("Error: " + e);
			return 0;
		}
	}
}
