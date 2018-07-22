/*
	Author: Joshua J. Abraham
	Description: Counts the number of palindromes contained in a given string, including substrings of said string.
				e.g. "aaa" has 6 substrings: a, a, a, aa, aa, aaa - all of which are palindromes.
				"abbc" has x substrings: a, b, b, c, ab, bb, bc, abb, bbc, abbc - only 5 of which are palindromes.
				etc.
	Date: July 2018.
*/

public class PalindromeCounter{
	/*
	// Straight-forward version:
	static int countPalindromes(String s){
		int s_length = s.length();
		int count = s_length;

		for(int i = 0; i < s_length - 1; i++){
			for(int j = i + 2; j <= s_length; j++){
				System.out.println(s.substring(i, j));
				System.out.println(isPalindrome(s.substring(i, j)));
				if (isPalindrome(s.substring(i, j))){
					count++;
				}
			}
		}
		return count;
	}
	
	// Presumably ptimised version:
	static int countPalindromes(String s){
		int s_length = s.length();
		int count = s_length;

		// Checking even length palis:
		System.out.println("Evens:");
		for(int i = 0; i < s_length - 1; i++){
			System.out.println(s.substring(i, i + 2));
			if(isPalindrome(s.substring(i, i + 2))){
				count++;
				System.out.println("START:");
				for(int m = i - 1, n = i + 3; m >= 0 && n <= s_length; m--, n++){
					System.out.println(s.substring(m, n));
					if(isPalindrome(s.substring(m, n))){ count++; }
				}
				System.out.println("END.");
			}
		}
		// Checking odd length palis:
		System.out.println("Oddies:");
		for(int i = 0; i < s_length - 2; i++){
			System.out.println(s.substring(i, i + 3));
			if(isPalindrome(s.substring(i, i + 3))){
				count++;
				System.out.println("START:");
				for(int m = i - 1, n = i + 4; m >= 0 && n <= s_length; m--, n++){
					System.out.println(s.substring(m, n));
					if(isPalindrome(s.substring(m, n))){ count++; }
				}
				System.out.println("END.");
			}
		}

		return count;
	}*/

	// Returna total number of palindrome substring of
    // length greater then equal to 2
    static int countPalindromes(char str[], int n)
    {
        // creat empty 2-D matrix that counts all palindrome
        // substring. dp[i][j] stores counts of palindromic
        // substrings in st[i..j]
        int dp[][] = new int[n][n];
      
        // P[i][j] = true if substring str[i..j] is palindrome,
        // else false
        boolean P[][] = new boolean[n][n];
      
        // palindrome of single lenght
        for (int i= 0; i< n; i++)
            P[i][i] = true;
      
        // palindrome of length 2
        for (int i=0; i<n-1; i++)
        {
            if (str[i] == str[i+1])
            {
                P[i][i+1] = true;
                dp[i][i+1] = 1 ;
            }
        }
      
        // Palindromes of length more then 2. This loop is similar
        // to Matrix Chain Multiplication. We start with a gap of
        // length 2 and fill DP table in a way that gap between
        // starting and ending indexes increases one by one by
        // outer loop.
        for (int gap=2 ; gap<n; gap++)
        {
            // Pick starting point for current gap
            for (int i=0; i<n-gap; i++)
            {
                // Set ending point
                int j = gap + i;
      
                // If current string is palindrome
                if (str[i] == str[j] && P[i+1][j-1] )
                    P[i][j] = true;
      
                // Add current palindrome substring ( + 1)
                // and rest palinrome substring (dp[i][j-1] + dp[i+1][j])
                // remove common palinrome substrings (- dp[i+1][j-1])
                if (P[i][j] == true)
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1 - dp[i+1][j-1];
                else
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
            }
        }
      
        // return total palindromic substrings
        return dp[0][n-1];
    }

	static boolean isPalindrome(String s){
		for(int i = 0, j = s.length() - 1; i < j; i++, j--){ 
			if(s.charAt(i) != s.charAt(j)){ 
				return false;
			}
		}
		return true;
	}

	public static void main (String[] args){
		final long startTime = System.nanoTime();
		for(int i = 0; i < args.length; i++){
			System.out.println("The amount of palindromes in '" + args[i] + "' is: " + countPalindromes(args[i].toCharArray, args[i].length()));
		}
		final long endTime = System.nanoTime();
		System.out.println("Total execution time: " + (endTime - startTime) );
	}
}