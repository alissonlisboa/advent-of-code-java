package problem6;

public class Grid {
    int[][] points;
    public Grid(int width, int height) {
        this.points = new int[width][height];
    }

    public void applyAll(Instruction[] instructions) {
        for (int i = 0; i < instructions.length; i++) {
            applyInstruction(instructions[i]);
        }
    }

    public void applyBrightnessAll(Instruction[] instructions) {
        for (int i = 0; i < instructions.length; i++) {
            applyBrightnessInstruction(instructions[i]);
        }
    }

    public void applyInstruction(Instruction instruction) {
        for (int x = instruction.from.x; x <= instruction.to.x; x++) {
            for (int y = instruction.from.y; y <= instruction.to.y; y++) {
                apply(instruction.action, x, y);
            }
        }
    }

    public void applyBrightnessInstruction(Instruction instruction) {
        for (int x = instruction.from.x; x <= instruction.to.x; x++) {
            for (int y = instruction.from.y; y <= instruction.to.y; y++) {
                applyBrightness(instruction.action, x, y);
            }
        }
    }

    public void applyBrightness(String action, int x, int y) {
        switch (action) {
            case "on": points[x][y] += 1; break;
            case "off": if (points[x][y] >= 1) points[x][y] -= 1; break;
            case "toggle": points[x][y] += 2; break;
        }
    }

    public void apply(String action, int x, int y) {
        int current = points[x][y];
        switch (action) {
            case "on": points[x][y] = 1; break;
            case "off": points[x][y] = 0; break;
            case "toggle":
                if (current == 1) points[x][y] = 0;
                else points[x][y] = 1;
                break;
        }
    }

    public int lightsLit() {
        int lightsLit = 0;
        for (int x = 0; x < points.length; x++) {
            for (int y = 0; y < points[x].length; y++) {
                lightsLit += points[x][y];
            }
        }
        return lightsLit;
    }

    public int totalBrightness() {
        int totalBrightness = 0;
        for (int x = 0; x < points.length; x++) {
            for (int y = 0; y < points[x].length; y++) {
                totalBrightness += points[x][y];
            }
        }
        return totalBrightness;
    }

    public void show() {
        for (int x = 0; x < points.length; x++) {
            for (int y = 0; y < points[x].length; y++) {
                System.out.print(points[x][y]);
                if (y < points[x].length - 1)
                    System.out.print(",");
            }
            System.out.println();
        }
    }
}
