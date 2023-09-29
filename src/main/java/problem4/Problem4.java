package problem4;

import input_reader.InputReader;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Problem4 {


    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = InputReader.read("src/main/java/problem4/input.txt");
        long santaNumber = getSantaNumber(input, 6);
        System.out.println(santaNumber);
    }

    public static String getHash(String input) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(input.getBytes(), 0, input.length());
        String hash = new BigInteger(1,md5.digest()).toString(16);
        return String.format("%1$" + 32 + "s", hash).replace(' ', '0');
    }

    public static long getSantaNumber(String input, int zeros) throws NoSuchAlgorithmException {
        long number = 0;
        String hash = getHash(input + number);
        while (getLeftZeros(hash) < zeros) {
            number++;
            hash = getHash(input + number);
        }
        return number;
    }

    public static int getLeftZeros(String input) {
        int position = 0;
        while (input.charAt(position) == '0') {
            position++;
        }
        return position;
    }
}