package org.ebd.samples.jep406;

public class PatternRefining {
    public static void main(String[] args) {
        testTriangle(new Triangle(5));
        testTriangle(new Triangle(6));
        testTriangle(new Rectangle());

    }


    static void testTriangle(Shape s) {
        switch (s) {
            case Triangle t && (t.calculateArea() > 10) ->
                    System.out.println("Large triangle");
            case Triangle t ->
                    System.out.println("Small triangle");
            default ->
                    System.out.println("Non-triangle");
        }
    }
    static class Shape {}
    static class Rectangle extends Shape {}
    static class Triangle  extends Shape {
        private final int v;
        public Triangle(int v){this.v = v;}
        int calculateArea() { return v*2; } }
}
