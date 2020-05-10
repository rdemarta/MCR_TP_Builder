package cars;

import java.awt.*;

public class Spoiler extends CarPart {

    private static String SPOILER_PATH = "resources/cars/spoilers/";

    public Spoiler(String name, String image, double acceleration, double weight, double adherence, double maniability, double resistance, Point relCoord) {
        super(name, SPOILER_PATH + image, acceleration, weight, adherence, maniability, resistance, relCoord);
    }

    @Override
    public String getCategory() {
        return "Spoiler";
    }

}
