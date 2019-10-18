package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private final double average, deviation, min, max;

    public TempSummaryStatistics(double average, double deviation, double min, double max) {
        this.average = average;
        this.deviation = deviation;
        this.min = min;
        this.max = max;
    }

    public double getAverage() {
        return average;
    }

    public double getDeviation() {
        return deviation;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TempSummaryStatistics) {
            TempSummaryStatistics other = (TempSummaryStatistics) obj;
            return this.average == other.average && this.deviation == other.deviation && this.min == other.min && this.max == other.max;
        }
        return false
                ;
    }

        public String toString() {
        return "TempSummaryStatistics: "
                + "Average temperature = " + average + ", Deviation temperature = " + deviation
                + ", Minimal temperature = " + min + ", Maximum temperature = " + max + '}';
    }

}
