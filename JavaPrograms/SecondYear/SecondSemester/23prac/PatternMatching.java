// PatternMatching.java
// Joshua Abraham - 3475896
// Description: Compares pattern matching efficiency of the following methods: Brute Force and Rabin Karp.

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class PatternMatching {
	
	public static void main (String[] args) {
		//File file = new File("/export/home/notes/ds/lesmiserables.text");
		//File file = new File("/export/home/notes/ds/patterns.text");
		File book_file = new File("lesmiserables.text");
		File pat_file = new File("patterns.text");
		byte[] arr_text;
		String text;
		ArrayList<String> arr_pat = new ArrayList<String>();
		String[] pat, text_list;
		
		int bf_counter = 0, rk_counter = 0;
                		
	        try {
			// Setting up the data in the book and pattern files respectively:		
				
			FileInputStream book_scan = new FileInputStream(book_file);
			//Scanner book_scan = new Scanner(book_file);
			Scanner pat_scan = new Scanner(pat_file);
					
			arr_text = new byte[(int) book_file.length()];
			book_scan.read(arr_text);
			book_scan.close();
			text = new String(arr_text, "UTF-8");
	
			/*
			// Setting up the data in the book file
			while (book_scan.hasNextLine()) {
				String[] line = book_scan.nextLine().split(" ");
				for (int i = 0; i < line.length; i ++) {
					text.add(line [i]);	
				}
			}
			arr_text = text.toArray(new String[text.size()]);
			//for (int i = 0; i < text.size(); i ++) { System.out.println(arr_text [i]); }
			*/
			
			while (pat_scan.hasNext()) { 
				arr_pat.add(pat_scan.next()); 
			}
			pat = arr_pat.toArray(new String[arr_pat.size()]);

			// Doing Brute Force pattern matching method:
			text_list = text.split(" ");
			for (int i = 0; i < pat.length; i ++) {
				System.out.println("bf " + i);
				if (bruteForce(text_list, pat [i])) { bf_counter ++; }
			}
			

			// Doing Rabin Karp pattern matching method:
			/*for (int i = 0; i < pat.length; i ++) {
				System.out.println(pat [i] + ": " + rabinKarp(text, pat [i]));
				//System.out.println("rk " + i + ": " + pat [i]);
				if (rabinKarp(text, pat [i])) { rk_counter ++; }
			}*/
			
			System.out.println("Brute Force: " + bf_counter);
			//System.out.println("Rabin Karp: " + rk_counter);
		}		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Brute force method takes a string array instead of a string to help remove the case of looking for a match with a string that has a 
	//  space in it since, in this particular case, the patterns never have a space in them.
	public static boolean bruteForce (String[] text, String pat) {
		if (pat.length() == 0) { return false; }
		else {	
			boolean is_equal = false;

			//Sift through each word in the array 'text'
			for (int i = 0; i < text.length; i ++) {
			
				String word = text [i];
				//Sift through each letter in String 'word'
				for (int j = 0; j <= (word.length() - pat.length()); j ++) {
					if (word.charAt(j) == pat.charAt(0)) {
						is_equal = true;
						//If a match is found in the first letter, check if substring of word is the same as the pattern
						for (int k = 1; k < pat.length(); k ++) {
							if (word.charAt(j + k) != pat.charAt(k)) {
								is_equal = false;
								break;
							}
						}
						if (is_equal) { return is_equal; }
						else { continue; }
					}
				}
			}
			return is_equal;
		}	
	}

	public static boolean rabinKarp (String text, String pat) {
		if (pat.length() == 0 || text.length() == 0) { return false; }
		else {
			int pat_len = pat.length(), text_len = text.length(), base = 256;
			long pat_hash = 0, text_hash = 0, mod_val = BigInteger.probablePrime(31, new Random()).longValue(), base_pow = (long) Math.pow(base, pat_len - 1);

			// Calculating the hash value of the pattern:
			for (int i = 0; i < pat_len; i ++) { 
				pat_hash = (base * pat_hash + pat.charAt(i)) % mod_val; 
			}

			// Calculating the first hash value taken from the string:
			for (int i = 0; i < pat_len; i ++) { 
				text_hash = (base * text_hash + text.charAt(i)) % mod_val; 
			}

			// Sifting through the text, with rolling hash, looking for hash matches:
			for (int i = pat_len; i < text_len; i ++) {
				if (pat_hash == text_hash && (text.substring(i - pat_len, i).equals(pat))) { return true; }

				// Remove the leading character and add the trailing character: 
				text_hash = (text_hash + mod_val - base_pow * text.charAt(i - pat_len) % mod_val) % mod_val; 
				text_hash = (text_hash * base + text.charAt(i)) % mod_val;				
			}
			return false;
		}                              
	}
}
