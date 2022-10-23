package org.ebd.samples.jep409;

public class Example {
    public static void main( String[] args ){

        // Instanciate a sealed class
        Service truck = new Truck(5000, "G-1000-PN");

        // Instanciate a non-sealed class
        Service car = new Car(1500, "3-TRT-88");
        System.out.println( truck.getMaxServiceIntervalInMonths() );
    }
}
