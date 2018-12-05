/*
 * Description: Finds the only single element in an array full of doubles and one single. Does it in O(1) time with no extra memory.
 * E.g. [1, 5, 3, 7, 8, 9, 9, 5, 3, 1, 7] ..computing.. The single element is: 8
*/

import java.util.concurrent.ThreadLocalRandom;

public class OnlySingle {
	public static int[] makeArray() {
		int arr_size = 7;	// Must be an odd number to allow for only one single and all others double
		int[] arr = new int [arr_size];

		// Producing a random number and index for the single element
		int snum = ThreadLocalRandom.current().nextInt(1, (arr_size / 2 + 1) + 1);	// The random single element
		arr[ThreadLocalRandom.current().nextInt(0, (arr_size - 2) + 1)] = snum;	// Insert at random index
		System.out.printf("The array size is: %d%n", arr.length);
		System.out.printf("The random single is: %d%n", snum);
		
		// Populating the rest of the array with doubles:
		int count = 1;
		int index;
		for(int i = 0; i <= (arr_size / 2 - 1); i++) {		
			if (count == snum) { 
				count++;
			}
			// insert two of the same elements (i.e. count) at random and available indexes.
			index = ThreadLocalRandom.current().nextInt(0, (arr_size - 2) + 1);
			while(arr[index] != 0) {
				index ++;
				if(index >= arr_size) {
					index = 0;
				}
			}
			arr[index] = count;

			index = ThreadLocalRandom.current().nextInt(0, (arr_size - 2) + 1);
			while(arr[index] != 0) {
				index ++;
				if(index >= arr_size) {
					index = 0;
				}
			}
			arr[index] = count;

			count ++;
		}

		return arr;
	}

	/*
	 * Find the single element usign XOR.
	 * Since A XOR B XOR A = B, if we XOR every element in the array, we will be left with the single element
	 * Thus, works in O(1) time, with no extra memory.
	*/
	public static int findSinglesIndex(int[] arr) {
		// Find the index of the non-duplicate number
		int snum = arr[0];

		for(int i = 1; i < arr.length; i++) {
			snum = snum ^ arr[i];
			System.out.println(snum);
		}
		return snum;
	}

	public static void main(String[] args) {
		int[] arr = makeArray();

		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%d: ", i);
			System.out.println(arr[i]);
		}

		System.out.printf("Found the single number to be: %d%n", findSinglesIndex(arr));
	}
}