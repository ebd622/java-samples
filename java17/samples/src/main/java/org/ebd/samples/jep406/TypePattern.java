package org.ebd.samples.jep406;

public class TypePattern {
    public static void main(String[] args) {

        System.out.println("--- Use if-else");
        System.out.println(formatter(5));
        System.out.println(formatter(5d));
        System.out.println(formatter(5l));
        System.out.println(formatter("5"));

        System.out.println("--- Use switch");
        System.out.println(formatterPatternSwitch(5));
        System.out.println(formatterPatternSwitch(5d));
        System.out.println(formatterPatternSwitch(5l));
        System.out.println(formatterPatternSwitch("5"));
    }

    // Option 1: using if-else
    static String formatter(Object o) {
        String formatted = "unknown";
        if (o instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (o instanceof Long l) {
            formatted = String.format("long %d", l);
        } else if (o instanceof Double d) {
            formatted = String.format("double %f", d);
        } else if (o instanceof String s) {
            formatted = String.format("String %s", s);
        }
        return formatted;
    }

    // Option 2: using switch
    static String formatterPatternSwitch(Object o) {
        return switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l    -> String.format("long %d", l);
            case Double d  -> String.format("double %f", d);
            case String s  -> String.format("String %s", s);
            default        -> o.toString();
        };
    }
}
