package problem6;

import input_reader.InputReader;

import java.security.NoSuchAlgorithmException;

public class Problem6 {


    public static void main(String[] args) {
        String input = InputReader.read("src/main/java/problem6/input.txt");
        Grid grid = new Grid(1000, 1000);
        Instruction[] instructions = getInstructions(input);
        grid.applyBrightnessAll(instructions);
        System.out.println(grid.totalBrightness());
    }

    public static Instruction[] getInstructions(String input) {
        String[] inputs = input.trim().split("\n");
        Instruction[] instructions = new Instruction[inputs.length];
        for (int i = 0; i < instructions.length; i++) {
            instructions[i] = new Instruction(inputs[i]);
        }
        return instructions;
    }




}