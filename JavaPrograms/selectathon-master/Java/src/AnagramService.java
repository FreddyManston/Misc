import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class AnagramService {

    private static int[] PRIMES = new int[] {
    //  A  B  C  D  E   F   G   H   I   J   K   L   M
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
    //  N   O   P   Q   R   S   T   U   V   W   X   Y    Z
        43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
    };

    public List<AnagramCounter> compute(String dictionaryLocation) throws IOException {
        List<String> words = FileUtils.readLines(new File(dictionaryLocation));
        HashMap<String, List<String>> WORD_MAP = new HashMap<>();
        List<AnagramCounter> ANAG_COUNT = new ArrayList<AnagramCounter>();

        // ASSUMPTION:
        //  * Words of character length 1 have no anagrams.
        //  * Current max word length in '../resources/Dictionary.txt' is 15
        for (int i = 2; i <= 15; i++) {
            WORD_MAP.put(Integer.toString(i), new ArrayList<String>());
            ANAG_COUNT.add(new AnagramCounter(i - 2, 0));
        }

        for (String word : words) {
            String word_len = Integer.toString(word.length());
            String word_id = Long.toString(calcProduct(word));

            if (WORD_MAP.get(word_len).contains(word_id)){ ANAG_COUNT.get(word.length() - 2).setCount(ANAG_COUNT.get(word.length() - 2).getCount() + 1); }
            else { WORD_MAP.get(word_len).add(word_id); }
        }

        return ANAG_COUNT;
    }

    // Credit: ACV, https://stackoverflow.com/questions/12477339/finding-anagrams-for-a-given-word
    private static long calcProduct(String word) {
        long result = 1L;
        // ASSUMPTION:
        //  * All characters in the dictionary are upper case and thus case sensitivity is not an issue.
        for (char c : word.toCharArray()) {
            if (c < 65) { return -1; }
            int pos = c - 65;
            result *= PRIMES[pos];
        }
        return result;
    }
}