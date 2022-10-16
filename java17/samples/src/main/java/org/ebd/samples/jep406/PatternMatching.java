package org.ebd.samples.jep406;

public class PatternMatching {
    public static void main(String[] args) {
        patternMach("5");
        patternMach(5);

        //Pattern matching and null
        testPatternAndNull_1(null);
        testPatternAndNull_1("test1");
        testPatternAndNull_1(new Foo());

        testPatternAndNull_2(null);
        testPatternAndNull_2("test2");

    }

    private static void patternMach(Object o) {
        if (o instanceof String s) {
            System.out.println(String.format("Object is a string %s", s));
        } else if(o instanceof Number n) {
            System.out.println(String.format("Object is a string %d", n));
        }
    }

    static void testPatternAndNull_1(String s) {
        switch (s) {
            case null         -> System.out.println("Oops");
            case "Foo", "Bar" -> System.out.println("Great");
            default           -> System.out.println("Ok");
        }
    }

    static void testPatternAndNull_2(Object o) {
        switch (o) {
            case null, String s -> System.out.println("String: " + s);
            default             -> System.out.println("Object: " + o);
        }
    }

    static class Foo{}
}
