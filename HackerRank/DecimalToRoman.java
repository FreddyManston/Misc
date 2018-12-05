/*
** Description: Converts decimal values to roman numerals
** Version: 1.0 
** Author: Joshua J. Abraham
** Date: December 2018
** Note: Only utilises the roman numerals up to 1000.
** For testing with bash, run 'javac DecimalToRoman.java && for i in {1..100}; do java DecimalToRoman $i | xargs echo $i -; done'
*/

import java.util.TreeMap;

public class DecimalToRoman {

	public final static TreeMap<Integer, String> NUMERALS = new TreeMap<Integer, String>();
	static {
		NUMERALS.put(1000, "M");
		NUMERALS.put(900, "CM");
		NUMERALS.put(500, "D");
		NUMERALS.put(400, "CD");
		NUMERALS.put(100, "C");
		NUMERALS.put(90, "XC");
		NUMERALS.put(50, "L");
		NUMERALS.put(40, "XL");
		NUMERALS.put(10, "X");
		NUMERALS.put(9, "IX");
		NUMERALS.put(5, "V");
		NUMERALS.put(4, "IV");
		NUMERALS.put(1, "I");
	}
	
	public static void main (String[] args) {
		int num = Integer.parseInt(args[0]);
		System.out.println(toRoman(num)); 
	}

	public final static String toRoman(int num) {
		int highest = NUMERALS.floorKey(num);
		if(num == highest) {
			return NUMERALS.get(num);
		}
		return NUMERALS.get(highest) + toRoman(num - highest);
	}
}
