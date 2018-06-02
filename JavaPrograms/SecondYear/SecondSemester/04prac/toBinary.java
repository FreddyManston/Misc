//Author: Joshua J. Abraham
//Descritpion: Converts decimal floating point numbers to binary in IEEE754 notation. Assumes 32-bit floats and 64-bit doubles
//Date: 16 November 2015

import java.util.*;
import java.io.*;

public class toBinary {
	public static void main (String[] args) {
		Scanner USERS_INPUT = new Scanner(System.in);
		boolean WRONG_INPUT = true;
		String USERS_CHOICE = "";

		while (WRONG_INPUT) {
			System.out.print("32-bit float or 64-bit double? Type either 'f' or 'd': ");
			USERS_CHOICE = USERS_INPUT.next();

			if (USERS_CHOICE.equalsIgnoreCase("f") || USERS_CHOICE.equalsIgnoreCase("d")) { WRONG_INPUT = false; }
			else { System.out.println("You seem to not understand."); }
		}
		

		// User chose float. Entails 32-bit decimal
		if (USERS_CHOICE.equalsIgnoreCase("f")) {
			System.out.print("Type in your floating point decimal: ");
			float DECIMAL_FLOAT = USERS_INPUT.nextFloat();
			String STRING_FLOAT = String.valueOf(DECIMAL_FLOAT);
			String[] STRING_FLOAT_ARRAY = STRING_FLOAT.split("\\.");	// splits the float into it's whole part and it's fracional part
			String STRING_FLOAT_WHOLE = STRING_FLOAT_ARRAY [0];
			String STRING_FLOAT_FRACTION = STRING_FLOAT_ARRAY [1];
			//System.out.println(STRING_FLOAT_WHOLE + "     " + STRING_FLOAT_FRACTION);
			String BINARY_FLOAT_WHOLE = reverseString(convertToBinary(Integer.parseInt(STRING_FLOAT_WHOLE)));
			String BINARY_FLOAT_FRACTION = convertToBinary(Integer.parseInt(STRING_FLOAT_FRACTION));
			//System.out.println(BINARY_FLOAT_WHOLE + "     " + BINARY_FLOAT_FRACTION);
			printIEEEBinary(32, BINARY_FLOAT_WHOLE, BINARY_FLOAT_FRACTION, STRING_FLOAT);
		}
		// User chose double. Entails 64-bit decimal
		else if (USERS_CHOICE.equalsIgnoreCase("d")) {
			System.out.print("Type in your decimal of type double: ");
			double DECIMAL_DOUBLE = USERS_INPUT.nextDouble();
			String STRING_DOUBLE = String.valueOf(DECIMAL_DOUBLE);
			String[] STRING_DOUBLE_ARRAY = STRING_DOUBLE.split("\\.");	// splits the double into it's whole part and it's fracional part
			String STRING_DOUBLE_WHOLE = STRING_DOUBLE_ARRAY [0];
			String STRING_DOUBLE_FRACTION = STRING_DOUBLE_ARRAY [1];
			String BINARY_DOUBLE_WHOLE = reverseString(convertToBinary(Integer.parseInt(STRING_DOUBLE_WHOLE)));
			String BINARY_DOUBLE_FRACTION = convertToBinary(Integer.parseInt(STRING_DOUBLE_FRACTION));
			printIEEEBinary(64, BINARY_DOUBLE_WHOLE, BINARY_DOUBLE_FRACTION, STRING_DOUBLE);
		}
		else { System.out.println("Error in main class, USERS_CHOICE conditionals."); }
	
	}

	// Converts a positive decimal integer to a back-to-front binary string (i.e. in the reverse order)
	public static String convertToBinary(int DECIMAL_NUMBER) {
		String BINARY_NUMBER = "";
		while (DECIMAL_NUMBER != 0) {
			if (DECIMAL_NUMBER % 2 == 0) { BINARY_NUMBER += "0"; }
			else { BINARY_NUMBER += "1"; }
			DECIMAL_NUMBER = DECIMAL_NUMBER / 2;
		}
		return BINARY_NUMBER;
	}

	// Reverses the order of a string type variable
	public static String reverseString(String STRING_VARIABLE) {
		String REVERSED_STRING = "";
		for (int i = STRING_VARIABLE.length(); i > 0; i --) { REVERSED_STRING += STRING_VARIABLE.charAt(i - 1); }
		return REVERSED_STRING;
	}

	// Prints the positive and negative IEEE754 form of the binary given the binary whole part and the binary fraction
	public static void printIEEEBinary(int TYPE, String WHOLE_PART, String FRACTION_PART, String DECIMAL_NUMBER) {
		int DECIMAL_POINT_SHIFT = 0;
		String EXPONENT = "";
		String MANTISSA = "";

		// Determining scientific notation
		if (WHOLE_PART.equals("0")) { DECIMAL_POINT_SHIFT = -1 * (FRACTION_PART.indexOf("1") + 1); }
		else { DECIMAL_POINT_SHIFT = WHOLE_PART.length() - 1; }
		// Determining the mantissa of the IEEE binary
		if (WHOLE_PART.equals("0")) { MANTISSA = FRACTION_PART.substring(FRACTION_PART.indexOf("1"), FRACTION_PART.length() - 1); }
		else { MANTISSA = WHOLE_PART.substring(1, DECIMAL_POINT_SHIFT + 1) + FRACTION_PART; }
		// Calculating the exponent of the IEEE binary
		if (TYPE == 32) { EXPONENT = reverseString(convertToBinary(127 + DECIMAL_POINT_SHIFT)); }
		else { EXPONENT = reverseString(convertToBinary(1023 + DECIMAL_POINT_SHIFT)); }

		// Printing the IEEE binary
		if (TYPE == 32) {
			if (EXPONENT.length() < 8) { while (EXPONENT.length() != 8) { EXPONENT += "0"; } }
			if (MANTISSA.length() < 23) { while (MANTISSA.length() != 23) { MANTISSA += "0"; } }
		}
		else {
			if (EXPONENT.length() < 11) { while (EXPONENT.length() != 11) { EXPONENT += "0"; } }
			if (MANTISSA.length() < 52) { while (MANTISSA.length() != 52) { MANTISSA += "0"; } }
		}
		System.out.println(" "+DECIMAL_NUMBER + " (base 10) = 0 " + EXPONENT + " " + MANTISSA + " (IEEE754 base 2)");
		System.out.println("-"+DECIMAL_NUMBER + " (base 10) = 1 " + EXPONENT + " " + MANTISSA + " (IEEE754 base 2)");
	}
}