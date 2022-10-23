package org.ebd.samples.jep409;

public class Example {
    public static void main( String[] args ){

        // Instanciate a sealed class
        Service truck = new Truck(5000, "G-1000-PN");

        
        System.out.println( truck.getMaxServiceIntervalInMonths() );
    }
}
