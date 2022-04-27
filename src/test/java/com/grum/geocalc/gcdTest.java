package com.grum.geocalc;

import lombok.var;
import lombok.val;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class gcdTest {
    /*
     * Input domain modeling with base choice coverage.
     * Characteristics
     * A: Nonzero Distance
     * B: Midpoint can be calculated
     * C: Latitude is negative
     * D: Longitude is negative
     * E: Valid point
     */
    @Test
    public void baseCase() {
        //Distance between Argentina and Sterling, VA
        var latitude = Coordinate.fromDegrees(-34.77327784693898);
        var longitude = Coordinate.fromDegrees(-66.32686954937233);
        val argentina = Point.at(latitude, longitude);

        latitude = Coordinate.fromDegrees(39.006699);
        longitude = Coordinate.fromDegrees(-77.429131);
        val sterling = Point.at(latitude, longitude);

        assertEquals(8264555.623125837, EarthCalc.gcd.distance(argentina, sterling), 10E-3);

        //midpoint of distance
        assertEquals(EarthCalc.gcd.midPoint(argentina, sterling), Point.at(Coordinate.fromDegrees(2.1266672937629623), Coordinate.fromDegrees(-71.72352561500567)));
    }

    @Test
    public void zeroDistance() {
        var latitude = Coordinate.fromDegrees(39.006699);
        var longitude = Coordinate.fromDegrees(-77.429131);

        val sterling = Point.at(latitude, longitude);
        assertEquals(0, EarthCalc.gcd.distance(sterling, sterling));
    }

    //calculating distance and  midpoint with positive latitude and negative longitude
    @Test
    public void positiveLatitude() {
        var latitude = Coordinate.fromDegrees(36.778259);
        var longitude = Coordinate.fromDegrees(-119.417931);
        val california = Point.at(latitude, longitude);

        latitude = Coordinate.fromDegrees(48.864716);
        longitude = Coordinate.fromDegrees(2.349014);
        val paris = Point.at(latitude, longitude);
        assertEquals(8876430.158762937, EarthCalc.gcd.distance(california, paris));

        assertEquals(EarthCalc.gcd.midPoint(california, paris), Point.at(Coordinate.fromDegrees(61.93546925740355), Coordinate.fromDegrees(-68.52436395325923)));

    }

    @Test
    public void positiveLongitude() {
        var latitude = Coordinate.fromDegrees(-33.865143);
        var longitude = Coordinate.fromDegrees(151.209900);
        val australia = Point.at(latitude, longitude);

        latitude = Coordinate.fromDegrees(48.864716);
        longitude = Coordinate.fromDegrees(2.349014);

        val paris = Point.at(latitude, longitude);
        assertEquals(1.692222216741114E7, EarthCalc.gcd.distance(australia, paris));

        assertEquals(EarthCalc.gcd.midPoint(australia, paris), Point.at(Coordinate.fromDegrees(24.363492377660428), Coordinate.fromDegrees(99.368477166143)));
    }
    /*
     * Tests added for mutation testing
     */
    @Test
    public void gcdBearing(){
        var latitude = Coordinate.fromDegrees(48.864716);
        var longitude = Coordinate.fromDegrees(2.349014);
        val paris = Point.at(latitude, longitude);

        latitude = Coordinate.fromDegrees(-34.77327784693898);
        longitude = Coordinate.fromDegrees(-66.32686954937233);
        val argentina = Point.at(latitude, longitude);
        assertEquals(231.89173387040188, EarthCalc.gcd.bearing(paris,argentina));
    }

    @Test
    public void gcdPointDestination() {
        var latitude = Coordinate.fromDegrees(-33.865143);
        var longitude = Coordinate.fromDegrees(151.209900);
        val australia = Point.at(latitude, longitude);

        latitude = Coordinate.fromDegrees(-33.85758360826014);
        longitude = Coordinate.fromDegrees(151.215811473025);
        val destination = Point.at(latitude, longitude);

        assertEquals(destination, EarthCalc.gcd.pointAt(australia, 33, 1000));
    }
}