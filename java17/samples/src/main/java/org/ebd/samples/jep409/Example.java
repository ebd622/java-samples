package org.ebd.samples.jep409;

import javax.sound.midi.Track;

public class Example {
    public static void main( String[] args ){

        // Instanciate a sealed class
        Service truck = new Truck(5000, "G-1000-PN");
        System.out.println("--- Instanciate a sealed class");
        System.out.println( "Track, MaxServiceIntervalInMonths: " + truck.getMaxServiceIntervalInMonths() );

        // Instanciate a non-sealed class (which estends a sealed class and implements a sealed interface)
        Service car = new Car(1500, "3-TRT-88");
        System.out.println( "Car, MaxServiceIntervalInMonths: " + car.getMaxServiceIntervalInMonths() );

        Service companyCar = new CompanyCar(1300, "G-319-PB");
        System.out.println( "companyCar, MaxServiceIntervalInMonths: " + companyCar.getMaxServiceIntervalInMonths() );
    }

}
/**
 * CompanyCar can extend non-sealed {@link Car} but not {@link Track}
 */
class CompanyCar extends Car {
    private final String merk = "Nissan";

    public CompanyCar(int numberOfSeats, String registrationNumber){
        super(numberOfSeats,registrationNumber);
    }
    public String getMerk(){
        return merk;
    }
}
