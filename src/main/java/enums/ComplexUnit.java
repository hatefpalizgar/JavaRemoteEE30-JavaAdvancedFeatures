package enums;

public enum ComplexUnit {
    CENTIMETER(0.01),
    INCH(0.0254),
    FOOT(0.3048),
    METER(1);

    private double valueToMeter;

    ComplexUnit(double valueToMeter) {
        this.valueToMeter = valueToMeter;
    }

    double convertToMeters() {
        return valueToMeter;
    }

}
