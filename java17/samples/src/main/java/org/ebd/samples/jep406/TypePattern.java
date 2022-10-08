package org.ebd.samples.jep406;

public class TypePattern {
    public static void main(String[] args) {
        patternMach("5");
        patternMach(5);
    }

    private static void patternMach(Object o) {
        if (o instanceof String s) {
            System.out.println(String.format("Object is a string %s", s));
        } else if(o instanceof Number n) {
            System.out.println(String.format("Object is a string %d", n));
        }
    }

}
