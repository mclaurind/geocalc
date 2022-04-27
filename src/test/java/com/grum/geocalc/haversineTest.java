package com.grum.geocalc;

import lombok.val;
import lombok.var;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class haversineTest {
    @Test
    public void testHaversineAmericaToJapan() {
        //Fairfax, VA to Tokyo,Japan
        var latitude = Coordinate.fromDMS(38, 50, 46.4064);
        var longitude = Coordinate.fromDMS(77, 18, 22.9428);
        val fairfax = Point.at(latitude, longitude);

        latitude = Coordinate.fromDMS(35, 36, 10.1952);
        longitude = Coordinate.fromDMS(139, 50, 22.1208);
        val tokyo = Point.at(latitude, longitude);

        assertEquals(5426, (int) (EarthCalc.haversine.distance(fairfax, tokyo) / 1000)); //km
    }

    @Test
    public void testHaversineCanadaToSpain() {
        //Canada to Spain
        var latitude = Coordinate.fromDegrees(56.1304);
        var longitude = Coordinate.fromDegrees(106.3468);
        val canada = Point.at(latitude, longitude);

        latitude = Coordinate.fromDegrees(40.416775);
        longitude = Coordinate.fromDegrees(-3.70379);
        val spain = Point.at(latitude, longitude);

        assertEquals(7418, (int) (EarthCalc.haversine.distance(canada, spain) / 1000)); //km
    }

    @Test
    public void testHaversinePhilipinesToChina() {
        var latitude = Coordinate.fromGPS(14,38.400366);
        var longitude = Coordinate.fromGPS(120,59.741880);
        val philipines = Point.at(latitude, longitude);

        latitude = Coordinate.fromGPS(22,16.759668);
        longitude = Coordinate.fromGPS(114,9.768786);
        val hongKong = Point.at(latitude, longitude);

        assertEquals(1111, (int) (EarthCalc.haversine.distance(philipines, hongKong) / 1000)); //km
    }

    @Test
    public void testHaversineAmericaToFrance() {
        var latitude = Coordinate.fromDegrees(36.778259);
        var longitude = Coordinate.fromDegrees(-119.417931);
        val california = Point.at(latitude, longitude);

        latitude = Coordinate.fromDegrees(48.864716);
        longitude = Coordinate.fromDegrees(2.349014);
        val paris = Point.at(latitude, longitude);

        assertEquals(8876, (int) (EarthCalc.haversine.distance(california, paris) / 1000));;
    }

    @Test
    public void testHaversineZeroDistance() {
        var latitude = Coordinate.fromGPS(22,16.759668);
        var longitude = Coordinate.fromGPS(114,9.768786);
        val hongKong = Point.at(latitude, longitude);

        assertEquals(0, (int) (EarthCalc.haversine.distance(hongKong, hongKong) / 1000)); //km
    }

}