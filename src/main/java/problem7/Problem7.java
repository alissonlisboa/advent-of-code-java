package problem7;

import input_reader.InputReader;
import problem6.Instruction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Problem7 {

    private static Map<String, Function> storage = new HashMap<>();


    public static void main(String[] args) {
        String input = InputReader.read("src/main/java/problem7/input.txt");
        String[] rawInstructions = input.split("\n");
        Instruction[] instructions = new Instruction[rawInstructions.length];

        for (int i = 0; i < instructions.length; i++) {
            instructions[i] = new Instruction(rawInstructions[i]);
        }

        for (int i = 0; i < instructions.length; i++) {
            System.out.println(instructions[i].target);
        }

        // c -> a
        //   44430 -> b
        //     430 -> c
//        Function<String, Function<String, String>> function1 = (letter) -> storage.get(letter);
//        storage.put("a", function1);
//
//        Function<String, Supplier<Integer>> function2 = (letter) -> () -> 430;
//        storage.put("c", function2);
//
//        Function c = storage.get("c");
//        System.out.println(c);



    }






}