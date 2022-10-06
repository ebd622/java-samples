package org.ebd.samples.jep406;

public class PatternMatching {
    public static void main() {
        Object o = 5;
        if (o instanceof String s) {
            System.out.printf("Object is a string %s", s);
        } else if(o instanceof Number n) {
            System.out.printf("Object is a number %n", n);
        }
    }
}
