package org.ebd.samples.jep409;

import javax.sound.midi.Track;

public class Example {
    public static void main( String[] args ){

        // Instanciate a sealed class
        Service truck = new Truck(5000, "G-1000-PN");
        System.out.println( truck.getMaxServiceIntervalInMonths() );

        // Instanciate a non-sealed class (which estends a sealed class and implements a sealed interface)
        Service car = new Car(1500, "3-TRT-88");
        System.out.println( car.getMaxServiceIntervalInMonths() );
    }

    /**
     * Nissan can extend non-sealed {@link Car} but not {@link Track}
     */
    class Nissan extends Car {
        public Nissan(int numberOfSeats, String registrationNumber){
            super(numberOfSeats,registrationNumber);
        }
    }
}
