import java.util.*;
import java.io.*;

/// <author> Joshua J. Abraham </author>
/// <date> June 2018 </date>
///
/// <summary>
/// INSTRUCTIONS:
/// Write the logic within the Anagram Service class to determine how many anagrams exist in a given list of words.
/// The definition of an anagram can be found here: https://www.google.co.za/?#q=definition+of+anagram
///
/// The output should list how many anagrams exist for a given character count.
/// E.g. Words with the character length of 4 had 5000 anagrams
///
/// Feel free to change the structure of the solution if you feel it helps optimise execution speed, memory usage etc.
/// Feel free to ask other colleagues and / or use google when crafting your solution.
/// Document assumptions (if any) as comments in code.
///
/// Your code should:
///     a) make use of the included file Dictionary.txt,
///     b) write your results to the console in the form "Words with the character length of x had y anagrams"
///     c) include the total time in milliseconds somewhere in your console output
///     d) not write to the console on processing each word
///
/// Should BSG proceed with a follow-up interview, you will be required to walk through your code as part of the face to face interview process.
///
/// Press return the completed solution with 48 hours to BSG, using the same email address that you received the zipped package.
/// Please re-zip your solution excluding all unnecessary files (e.g. *.user, *.suo, bin folder, obj folder)
/// </summary>
///
/// <solution_description>
/// This problem has a 2-part solution. First, individual words have to be checked against other individual words,
/// in order to see if they're anagrams of eacother. Second, the amount of different anagrams for each character length has to be counted.
///
/// First part - Identifying anagrams:
///		Each character is associated with a unique prime number (from PRIMES[]), based on the character's ASCII value and the
///		index of the prime number. Thus, each anagram can have a unique id based on the characters it contains. This is done
///		by multiplying together the associated primes of the characters in the anagram.
///		E.g. SADDER = 67 * 2 * 7 * 7 * 11 * 61 = 4 405 786 (i.e. anagram id) = 7 * 61 * 11 * 2 * 7 * 67 = DREADS
///		This method is computationally less needy than sorting words by character and then comparing sorted words.
///
/// Second part - Getting amount of anagrams for each character length:
///		WORD_MAP stores the unique anagram ids of words, i.e. when first encountered.
///		If a word's anagram id is found and it is already present in WORD_MAP, the counter representing
///		the word's length is incremented by one.
///
///	At the end, you'll be left with a map of unique anagram ids and a list of counters for each character length,
/// representing the amount of anagrams.
/// </solution_description>
///
/// <note>
///	Instructions say that there are 5000 anagrams for words with the character length of 4,
///	however, the total number of words of character length of 4 in Dictionary.txt is only 4030, 
///	so this cannot be true.
/// </note>

public class AnagramSolver {
	private static int[] PRIMES = new int[] {
	//	A  B  C  D  E   F   G   H   I   J   K   L   M
		2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
	//	N   O   P   Q   R   S   T   U   V   W   X   Y    Z
		43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
	};

	public static void main (String args[]) {
		String DICTIONARY_LOCAL = "../resources/Dictionary.txt";
		HashMap<String, List<String>> WORD_MAP = new HashMap<>();
		int[] ANAG_COUNT = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

		long beforeFreeMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		long startTime = System.currentTimeMillis();

		// ASSUMPTION:
		//	* Words of character length 1 have no anagrams.
		//	* Current max word length in '../resources/Dictionary.txt' is 15
		for (int i = 2; i <= 15; i++) { WORD_MAP.put(Integer.toString(i), new ArrayList<String>()); }

		// ANAGRAM SERVICE:
		try (BufferedReader br = new BufferedReader (new FileReader (DICTIONARY_LOCAL))) {
			for (String word; (word = br.readLine()) != null; ) {
				//System.out.println(word);
				String word_len = Integer.toString(word.length());
				String word_id = Long.toString(calcProduct(word));

				if (WORD_MAP.get(word_len).contains(word_id)){ ANAG_COUNT[word.length() - 2] ++; }
				else { WORD_MAP.get(word_len).add(word_id); }
			}

			long endTime = System.currentTimeMillis();
			long afterFreeMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

			System.out.println();
			System.out.println("Anagram Results:");
			System.out.println();
			for (int i = 2; i <= 15; i++) { System.out.println("Words with the character length of " +i + " had " + ANAG_COUNT[i - 2] + " anagrams."); }
			System.out.println();
			System.out.println("completed in " + (endTime - startTime) + "ms");
			System.out.println("used " + ((afterFreeMem - beforeFreeMem) / (1024*1024.0)) + "MB");
			System.out.println();
		}

		catch (Exception e) { System.out.print("The following exception occurred: " + e); }
	}

	// Credit: ACV, https://stackoverflow.com/questions/12477339/finding-anagrams-for-a-given-word
	private static long calcProduct(String word) {
		long result = 1L;
		// ASSUMPTION:
		//	* All characters in the dictionary are upper case and thus case sensitivity is not an issue.
		for (char c : word.toCharArray()) {
			if (c < 65) { return -1; }
			int pos = c - 65;
			result *= PRIMES[pos];
		}
		return result;
	}
}