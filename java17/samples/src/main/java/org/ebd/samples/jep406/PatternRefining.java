package org.ebd.samples.jep406;

public class PatternRefining {
    public static void main(String[] args) {
        testTriangle(new Shape());

    }


    static void testTriangle(Shape s) {
        switch (s) {
            case Triangle t && (t.calculateArea() > 100) ->
                    System.out.println("Large triangle");
            case Triangle t ->
                    System.out.println("Small triangle");
            default ->
                    System.out.println("Non-triangle");
        }
    }
    static class Shape {}
    static class Rectangle extends Shape {}
    static class Triangle  extends Shape { int calculateArea() { return 110; } }
}
