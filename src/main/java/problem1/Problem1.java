package problem1;

import input_reader.InputReader;

public class Problem1 {
    public static void main(String[] args) {
        String input = InputReader.read("src/main/java/problem1/input.txt");

        int finalFloor = getFinalFloor(input);
        System.out.println("Final Floor: " + finalFloor);

        int firstBasement = getPositionOfFirstBasement(input);
        System.out.println("Firt Basement: " + firstBasement);
    }

    private static int getFinalFloor(String input) {
        int floor = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') floor++;
            else if (input.charAt(i) == ')') floor--;
        }
        return floor;
    }

    private static int getPositionOfFirstBasement(String input) {
        int floor = 0;
        int firstBasement = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') floor++;
            else if (input.charAt(i) == ')') floor--;
            if (floor < 0) {
                firstBasement = i + 1;
                return firstBasement;
            }
        }
        return firstBasement;
    }
}
