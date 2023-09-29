package problem3;

import input_reader.InputReader;
import java.util.HashMap;

public class Problem3 {

    static HashMap<String, Integer> visits = new HashMap<>();
    static int[] santaPosition = {0, 0};
    static int[] roboPosition = {0, 0};

    public static void main(String[] args) {
        String input = InputReader.read("src/main/java/problem3/input.txt");
        int housesVisited = santaAndRoboVisits(input);
        System.out.println(housesVisited);
    }

    public static int santaVisits(String input) {
        visits.put("0,0", 2);
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '>': santaPosition[0]++; break;
                case '<': santaPosition[0]--; break;
                case '^': santaPosition[1]++; break;
                case 'v': santaPosition[1]--; break;
            }
            String currentPosition = String.format("%d,%d", santaPosition[0], santaPosition[1]);
            int currentNumberOfVisits = visits.getOrDefault(currentPosition, 0);
            visits.put(currentPosition, currentNumberOfVisits + 1);
        }
        return visits.keySet().size();
    }

    public static int santaAndRoboVisits(String input) {
        visits.put("0,0", 2);
        for (int i = 0, j = 1; j < input.length(); i += 2, j += 2) {
            switch (input.charAt(i)) {
                case '>': santaPosition[0]++; break;
                case '<': santaPosition[0]--; break;
                case '^': santaPosition[1]++; break;
                case 'v': santaPosition[1]--; break;
            }
            switch (input.charAt(j)) {
                case '>': roboPosition[0]++; break;
                case '<': roboPosition[0]--; break;
                case '^': roboPosition[1]++; break;
                case 'v': roboPosition[1]--; break;
            }
            String currentSantaPosition = String.format("%d,%d", santaPosition[0], santaPosition[1]);
            String currentRoboPosition = String.format("%d,%d", roboPosition[0], roboPosition[1]);

            visits.put(currentSantaPosition, visits.getOrDefault(currentSantaPosition, 0) + 1);
            visits.put(currentRoboPosition, visits.getOrDefault(currentRoboPosition, 0) + 1);
        }
        return visits.keySet().size();
    }


}