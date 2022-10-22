package org.ebd.samples.jep406;

public class PatternRefining {
    public static void main(String[] args) {

    }

    class Shape {}
    class Rectangle extends Shape {}
    class Triangle  extends Shape { int calculateArea() { return 110; } }
}
