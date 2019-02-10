package morsecodeapp;

import java.util.ArrayList;
import java.util.List;

public class MorseCode {

    /**
     * The Morse codes are not hard coded. This file generates 126 Morse codes
     * using recursion. 126 codes should be enough to convert a plain text file
     * a Morse Code.
     */
    private final List<String> fullMorseList = new ArrayList<>();
    char[] alphabet = new char[]{'.', '-'};

    public List<String> getFullMorseList() {
        List<String> temp = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            temp.clear();
            /**
             * clears the list to add the new combinations of the characters.
             */
            temp = possibleStrings(i, alphabet, "");
            for (String s : temp) {
                fullMorseList.add(s);
            }
        }
        return fullMorseList;
    }

    static List<String> comb = new ArrayList<>();

    public static List possibleStrings(int maxLength, char[] alphabet, String curr) {
        // If the current string has reached it's maximum length
        if (curr.length() == maxLength) {
            comb.add(curr);
            // Else add each letter from the alphabet to new strings
            // and process these new strings again
        } else {
            for (char c : alphabet) {
                String oldCurr = curr;
                curr += c;
                possibleStrings(maxLength, alphabet, curr);
                curr = oldCurr;
            }
        }
        return comb;
    }

}
