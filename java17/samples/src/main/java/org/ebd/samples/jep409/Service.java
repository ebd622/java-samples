package org.ebd.samples.jep409;

/**
 * <p>Sealed Iterface</p>
 */
public sealed interface Service permits Car, Truck {

    int getMaxServiceIntervalInMonths();

    default int getMaxDistanceBetweenServicesInKilometers() {
        return 100000;
    }

}
