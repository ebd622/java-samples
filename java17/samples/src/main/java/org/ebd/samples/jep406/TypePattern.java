package org.ebd.samples.jep406;

public class TypePattern {
    public static void main(String[] args) {
        //System.out.println(String.format("Int -> Double: %f", getDoubleUsingIf(5)));
        //System.out.println(String.format("Int -> Double: %f", getDoubleUsingIf(5.0)));

        System.out.println("Int -> Double: " + getDoubleUsingIf(5));
        System.out.println("Float -> Double: " + getDoubleUsingIf(5.0f));

    }

    // Option 1
    static double getDoubleUsingIf(Object o) {
        double result;
        if (o instanceof Integer) {
            result = ((Integer) o).doubleValue();
        } else if (o instanceof Float) {
            result = ((Float) o).doubleValue();
        } else if (o instanceof String) {
            result = Double.parseDouble(((String) o));
        } else {
            result = 0d;
        }
        return result;
    }
}
