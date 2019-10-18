package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private static final int ZERO = -273;
    private double[] temperatures;


    public TemperatureSeriesAnalysis() {
        this.temperatures = new double[]{};
    }

    public TemperatureSeriesAnalysis(double[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            throw new IllegalArgumentException("Array is empty.");
        }
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] < ZERO) {
                throw new InputMismatchException();
            }
        }
        this.temperatures = Arrays.copyOf(temperatures, temperatures.length);
    }

    /**
     * Return average temperature. Generate IllegalArgumentException
     * if the row is empty.
     *
     * @return average value of temperature.
     */
    public double average() {
        double sum = 0;
        for (double t : temperatures) {
            sum += t;
        }
        double average = sum / temperatures.length;
        return average;
    }


    /**
     * Return standart deviation. Generate IllegalArgumentException
     * if the row is empty.
     *
     * @return standard deviation.
     */
    public double deviation() {
        int dev = 0;
        final double AVG = this.average();
        for (double t : temperatures) {
            dev += (t - AVG) * (t - AVG);
        }
        return Math.sqrt(dev / temperatures.length);
    }

    /**
     * Return minimum temperature. Generate IllegalArgumentException
     * if the row is empty.
     *
     * @return minimum value of temperature.
     */
    public double min() {
        double min = Double.MAX_VALUE;
        for (double t : temperatures) {
            if (t < min) {
                min = t;
            }
        }
        return min;
    }

    /**
     * Return maximum temperature. Generate IllegalArgumentException
     * if the row is empty.
     *
     * @return max value of temperature.
     */
    public double max() {
        double max = Double.MIN_VALUE;
        for (double t : temperatures) {
            if (t > max) {
                max = t;
            }
        }
        return max;
    }

    /**
     * Return closest to 0 temperature. Generate IllegalArgumentException
     * if the row is empty.
     *
     * @return the value closest to 0.
     */
    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    /**
     * Return temperature closest to the value.
     * Generate IllegalArgumentException if the row is empty.
     *
     * @return temperature closest to value.
     */
    public double findTempClosestToValue(double tempValue) {
        double del = Double.MAX_VALUE;
        double ct = 0;
        for (double t : temperatures) {
            double d = Math.abs(t - tempValue);
            if (d < del) {
                del = d;
                ct = t;
            }
        }
        return ct;
    }

    /**
     * Return array with temperatures less than value.
     * Generate IllegalArgumentException if the row is empty.
     *
     * @return an array with numbers less than value.
     */
    public double[] findTempsLessThen(double tempValue) {
        double[] buff = Arrays.copyOf(temperatures, temperatures.length);
        Arrays.sort(buff);
        int maxIdx = 0;
        while (maxIdx < buff.length && buff[maxIdx] < tempValue) {
            maxIdx++;
        }
        return Arrays.copyOf(buff, maxIdx);
    }

    /**
     * Return array with temperatures greater or equal to the value.
     * Generate IllegalArgumentException if the row is empty.
     *
     * @return an array with numbers greater or equal to the value.
     */
    public double[] findTempsGreaterThen(double tempValue) {
        double[] buff = Arrays.copyOf(temperatures, temperatures.length);
        Arrays.sort(buff);
        int minIdx = buff.length;
        while (minIdx > 0 && buff[minIdx - 1] >= tempValue) {
            minIdx--;
        }
        return Arrays.copyOfRange(buff, minIdx, buff.length);
    }

    /**
     * Return an example of TempSummaryStatistics Class which has info about
     * - double avgTemp;
     * - double devTemp;
     * - double minTemp;
     * - double maxTemp;
     * Generate IllegalArgumentException if the row is empty.
     *
     * @return an array with numbers less than value.
     */
    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }


    public int addTemps(double... temps) {
        int newLen = temperatures.length + temps.length;
        double[] newarr = new double[newLen];
        System.arraycopy(temperatures, 0, newarr, 0, temperatures.length);
        System.arraycopy(temps, 0, newarr, temperatures.length, temps.length);
        temperatures = newarr;
        return temperatures.length;
    }

}
