package problem2;

import input_reader.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        String input = InputReader.read("src/main/java/problem2/input.txt");
        int totalWrappingPaper = getTotalRibbonLength(input);
        System.out.println(totalWrappingPaper);
    }

    private static int getTotalWrappingPaperArea(String input) {
        String[] dimensions = input.split("\n");
        int totalWrappingPaperArea = 0;

        for (int i = 0; i < dimensions.length; i++) {
            totalWrappingPaperArea += new Box(dimensions[i]).getWrappingPaperArea();
        }

        return totalWrappingPaperArea;
    }

    private static int getTotalRibbonLength(String input) {
        String[] dimensions = input.split("\n");
        int totalRibbonLenth = 0;
        for (int i = 0; i < dimensions.length; i++) {
            totalRibbonLenth += new Box(dimensions[i]).getTotalRibbonLength();
        }

        return totalRibbonLenth;
    }


}
