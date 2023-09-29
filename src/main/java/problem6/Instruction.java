package problem6;

public class Instruction {
    String action;
    Point from;
    Point to;

    public Instruction(String rawInstruction) {
        String[] parts = rawInstruction.split(" ");
        String[] to = parts[parts.length - 1].split(",");
        String[] from = parts[parts.length - 3].split(",");
        this.to = new Point(Integer.parseInt(to[0]), Integer.parseInt(to[1]));
        this.from = new Point(Integer.parseInt(from[0]), Integer.parseInt(from[1]));
        this.action = parts[parts.length - 4];
    }
}
