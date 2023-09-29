package problem7;

import problem6.Point;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Instruction {

    BinaryOperator<Integer> operation;
    String sinal1;
    String sinal2;
    public String target;

    public Instruction(String sinal1, String operation, String sinal2, String target) {
        this.sinal1 = sinal1;
        this.sinal2 = sinal2;
        this.target = target;
        switch (operation) {
            case "AND"    -> this.operation = (a, b) -> a & b;
            case "OR"     -> this.operation = (a, b) -> a | b;
            case "LSHIFT" -> this.operation = (a, b) -> a << b;
            case "RSHIFT" -> this.operation = (a, b) -> a >> b;
        }
    }

    public Instruction(String operation, String sinal2, String target) {
        this.sinal2 = sinal2;
        this.target = target;
        this.operation = (a, x) -> ~a;
    }

    public Instruction(String sinal2, String target) {
        this.sinal2 = sinal2;
        this.target = target;
        this.operation = (a, x) -> a;
    }

    public Instruction (String rawInstruction) {
        String[] tokens = rawInstruction.split(" ");
        switch (tokens.length) {
            case 5 -> new Instruction(tokens[0], tokens[1], tokens[2], tokens[4]);
            case 4 -> new Instruction(tokens[0], tokens[1], tokens[3]);
            case 3 -> new Instruction(tokens[0], tokens[2]);
        }
    }
}
