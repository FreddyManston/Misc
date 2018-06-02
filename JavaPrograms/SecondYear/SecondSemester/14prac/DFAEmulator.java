/*
Author: Joshua J. Abraham
Student Number: 3475896				
*/
import java.io.*;
import java.util.*;

public class DFAEmulator {
	public static void main (String[] args) {
		String line = "";
		String input = "";
		char chr = ' ';
		int curr = 0, finl = 0, num_state = 0;
		int[][] table = new int[5][256];;
		

		try {
			BufferedReader reader = new BufferedReader(new FileReader("dfadata.text"));
			line = reader.readLine();
			while (line != null) {
				/* If the line is a comment or a blank, then skip it */
				if (line.equals("") || line.charAt(0) == '#') { /*Do nothing*/ }

				/* If the line has a 'D', for allowed input cahracters, then store those characters in the input variable. */
				else if (line.contains("D")) {
					num_state = 0;
					input = "";
					boolean loop_break = false;
					for (int i = 0; i < line.length(); i ++) {
						chr = line.charAt(i);
						switch (chr) {
							case 'D': case ';': case ' ':
								break;
							case 'f':
								if (line.substring(i, line.length()).contains("final")) { loop_break = true; break;}
							default:
								input += chr;
						}
						if (loop_break) { break; }
					}
					table = new int[5][256];					
				}

				/* If the line contains state specifications, store those specifications in the table. */
				else if (line.contains("q")) {
					num_state ++;
					if (line.contains("*")) { finl = num_state; }

					int i = line.indexOf('q');
					int count = 1;
					while (i < line.length()) {
						if (line.substring(i + 1, line.length()).contains("q")) {
							i = line.indexOf('q', i + 1);
							table [num_state][(int)input.charAt(count - 1)] = Character.getNumericValue(line.charAt(i + 1));
							count ++;
						}
						else { break; }		
						i ++;
					}
				}

				/* If the line has input, read the input into the DFA and say whether it is accepted or rejected. */
				else { 
					System.out.println(line + "    ");
					curr = 1;
					for (int i = 0; i < line.length(); i ++) {
						chr = line.charAt(i);
						curr = table[curr][(int) chr];
					}
					if (curr == finl) { System.out.println("#accepts"); }
					//else { System.out.println(curr + " " + finl + " " + "rejects"); }
				}

				line = reader.readLine();
			} 
			reader.close();
		}
		catch (Exception e) { e.printStackTrace(); }
	}
}
