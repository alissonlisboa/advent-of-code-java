package input_reader;

import java.io.File;
import java.util.Scanner;

public class InputReader {
    public static String read(String path) {
        String input = "";
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNext()) input += scanner.nextLine() + "\n";
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input.trim();
    }
}
