package problem5;

import input_reader.InputReader;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Problem5 {


    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = InputReader.read("src/main/java/problem5/input.txt");
        int numberOfNiceStrings = getNumberOfNiceStringsRule2(input);
        System.out.println(numberOfNiceStrings);
    }

    public static boolean hasMoreThan3Vowels(String string) {
        int numberOfvowels = 0;
        for (int i = 0; i < string.length(); i++) {
            switch (string.charAt(i)) {
                case 'a': numberOfvowels++; break;
                case 'e': numberOfvowels++; break;
                case 'i': numberOfvowels++; break;
                case 'o': numberOfvowels++; break;
                case 'u': numberOfvowels++; break;
            }
        }
        return numberOfvowels >= 3;
    }

    public static boolean hasDoubleLetter(String string) {
        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) == string.charAt(i+1)) return true;
        }
        return false;
    }

    public static boolean hasForbbidenPairs(String string) {
        for (int i = 0; i < string.length() - 1; i++) {
            String pair = ""+ string.charAt(i) + string.charAt(i+1);
            switch (pair) {
                case "ab": return true;
                case "cd": return true;
                case "pq": return true;
                case "xy": return true;
            }
        }
        return false;
    }

    public static boolean hasRepetitionPairs(String string) {
        if (string.length() <= 1) return false;
        String pair = string.substring(0, 2);
        String rest = string.substring(2);
        if (rest.contains(pair)) return true;
        return hasRepetitionPairs(string.substring(1));
    }

    public static boolean hasRepetitionWhitOneLetterBetween(String string) {
        for (int i = 0; i < string.length() - 2; i++) {
            if (string.charAt(i) == string.charAt(i+2)) return true;
        }
        return false;
    }

    public static int getNumberOfNiceStringsRule1(String input) {
        String[] strings = input.split("\n");
        int numberOfNiceStrings = 0;
        for (String string: strings) {
            if (hasMoreThan3Vowels(string)
                    && hasDoubleLetter(string)
                    && !hasForbbidenPairs(string)) {
                numberOfNiceStrings++;
            }
        }
        return numberOfNiceStrings;
    }

    public static int getNumberOfNiceStringsRule2(String input) {
        String[] strings = input.split("\n");
        int numberOfNiceStrings = 0;
        for (String string: strings) {
            if (hasRepetitionPairs(string) && hasRepetitionWhitOneLetterBetween(string)) {
                numberOfNiceStrings++;
            }
        }
        return numberOfNiceStrings;
    }
}