package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Box {
    private int length;
    private int width;
    private int height;
    Box(String dimensions) {
        String[] splitedDimensions = dimensions.trim().split("x");
        this.length = Integer.parseInt(splitedDimensions[0]);
        this.width = Integer.parseInt(splitedDimensions[1]);
        this.height = Integer.parseInt(splitedDimensions[2]);
    }

    public int getArea() {
        return 2 * (length * width +  width * height + height * length);
    }

    public int getLeastArea() {
        int area1 = length * width;
        int area2 = width * height;
        int area3 = height * length;
        return Math.min(Math.min(area1, area2), area3);
    }

    public int getWrappingPaperArea() {
        return getArea() + getLeastArea();
    }

    public int getWrappingRibbonLength() {
        Integer[] dimensionArray = {length, width, height};
        List<Integer> dimensions = new ArrayList<>();

        for (int i = 0; i< dimensionArray.length; i++) {
            dimensions.add(dimensionArray[i]);
        }

        Collections.sort(dimensions);

        return 2 * (dimensions.get(0) + dimensions.get(1));
    }

    public int getBowRibbonLength() {
        return length * width * height;
    }

    public int getTotalRibbonLength() {
        return getWrappingRibbonLength() + getBowRibbonLength();
    }
}
