package cars;

import java.util.Random;

public class Stats {
    private double speed;
    private double maniability;
    private double resistance;

    // Range between which the attributes above must fit
    private static final double RANGE_MIN = 1;
    private static final double RANGE_MAX = 5;

    /**
     * Standard constructor. The given value will automatically be cut to fit range
     * @param speed speed factor
     * @param maniability maniability factor
     * @param resistance resistance factor
     */
    public Stats(double speed, double maniability, double resistance) {
        this.speed = applyRange(speed);
        this.maniability = applyRange(maniability);
        this.resistance = applyRange(resistance);
    }

    /**
     * Null constructor: all attributes set to RANGE_MIN
     */
    public Stats() {
        speed = RANGE_MIN;
        maniability = RANGE_MIN;
        resistance = RANGE_MIN;
    }

    public static double getRangeMin() {
        return RANGE_MIN;
    }

    public static double getRangeMax() {
        return RANGE_MAX;
    }

    public double getSpeed() {
        return speed;
    }
    
    public double getManiability() {
        return maniability;
    }
    
    public double getResistance() {
        return resistance;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setManiability(double maniability) {
        this.maniability = maniability;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    /**
     * Sets the attributes randomly in range [RANGE_MIN;RANGE_MAX]
     * @return reference to self
     */
    public Stats randomize() {
        Random random = new Random();
        speed = applyRange(random.nextDouble() * (RANGE_MAX - 1) + 1);
        maniability = applyRange(random.nextDouble() * (RANGE_MAX - 1) + 1);
        resistance = applyRange(random.nextDouble() * (RANGE_MAX - 1) + 1);

        return this;
    }

    /**
     * Converts stat value [RANGE_MIN;RANGE_MAX] to proportional factor [RANGE_MIN/RANGE_MAX;1]
     * @param value te stat to be converted
     * @return factor value [RANGE_MIN/RANGE_MAX;1]
     */
    public static double toPercent(double value) {
        return value / RANGE_MAX;
    }

    /**
     * Ensures that the value is between class ranges
     * @param value the numeric value to be checked
     * @return the given value, cut to range [RANGE_MIN;RANGE_MAX]
     */
    private double applyRange(double value) {
        return value >= RANGE_MIN ? Math.min(value, RANGE_MAX) : RANGE_MIN;
    }

    @Override
    public String toString() {
        return "S: " + speed + ", M: " + maniability + ", R: " + resistance;
    }
}
