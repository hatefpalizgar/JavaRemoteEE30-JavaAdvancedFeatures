package enums;

public enum Weight {
    GRAM(0.001, "Metric"),
    KILOGRAM(1, "Metric"),
    POUND(0.453592, "Imperial"),
    OUNCE(0.0283495, "Imperial");

    double valueInKilograms;
    String system;

    Weight(double valueInKilograms, String system) {
        this.valueInKilograms = valueInKilograms;
        this.system = system;
    }

}
