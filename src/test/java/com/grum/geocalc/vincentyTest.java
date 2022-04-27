package com.grum.geocalc;

import lombok.val;
import lombok.var;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class vincentyTest {

    @Test
    public void vincentyAmericaToJapan() {
        //Fairfax, VA to Tokyo,Japan
        var latitude = Coordinate.fromDMS(38, 50, 46.4064);
        var longitude = Coordinate.fromDMS(77, 18, 22.9428);
        val fairfax = Point.at(latitude, longitude);

        latitude = Coordinate.fromDMS(35, 36, 10.1952);
        longitude = Coordinate.fromDMS(139, 50, 22.1208);
        val tokyo = Point.at(latitude, longitude);

        assertEquals(5451, (int) (EarthCalc.vincenty.distance(fairfax, tokyo) / 1000)); //km
    }

    @Test
    public void vincentyCanadaToSpain() {
        //Canada to Spain
        var latitude = Coordinate.fromDegrees(56.1304);
        var longitude = Coordinate.fromDegrees(106.3468);
        val canada = Point.at(latitude, longitude);

        latitude = Coordinate.fromDegrees(40.416775);
        longitude = Coordinate.fromDegrees(-3.70379);
        val spain = Point.at(latitude, longitude);

        assertEquals(7455, (int) (EarthCalc.vincenty.distance(canada, spain) / 1000)); //km
    }

    @Test
    public void vincentyPhilipinesToChina() {
        var latitude = Coordinate.fromGPS(14, 38.400366);
        var longitude = Coordinate.fromGPS(120, 59.741880);
        val philipines = Point.at(latitude, longitude);

        latitude = Coordinate.fromGPS(22, 16.759668);
        longitude = Coordinate.fromGPS(114, 9.768786);
        val hongKong = Point.at(latitude, longitude);

        assertEquals(1111, (int) (EarthCalc.vincenty.distance(philipines, hongKong) / 1000)); //km
    }

    @Test
    public void vincentyAmericaToFrance() {
        var latitude = Coordinate.fromDegrees(36.778259);
        var longitude = Coordinate.fromDegrees(-119.417931);
        val california = Point.at(latitude, longitude);

        latitude = Coordinate.fromDegrees(48.864716);
        longitude = Coordinate.fromDegrees(2.349014);
        val paris = Point.at(latitude, longitude);

        assertEquals(8918597.509450343, EarthCalc.vincenty.distance(california, paris));
    }

    @Test
    public void vincentyVirginia() {
        var latitude = Coordinate.fromDegrees(39.006699);
        var longitude = Coordinate.fromDegrees(-77.429131);
        val sterling = Point.at(latitude, longitude);

        latitude = Coordinate.fromDegrees(39.043757);
        longitude = Coordinate.fromDegrees(-77.487442);
        val ashburn = Point.at(latitude, longitude);

        assertEquals(6513.252905371315, EarthCalc.vincenty.distance(ashburn, sterling));
    }

    @Test
    public void vincentyZeroDistance() {
        var latitude = Coordinate.fromDegrees(36.778259);
        var longitude = Coordinate.fromDegrees(-119.417931);
        val california = Point.at(latitude, longitude);

        assertEquals(0, EarthCalc.vincenty.distance(california, california));
    }

    @Test
    public void vincentyBearing() {
        var latitude = Coordinate.fromDegrees(36.778259);
        var longitude = Coordinate.fromDegrees(-119.417931);
        val california = Point.at(latitude, longitude);

        latitude = Coordinate.fromDegrees(40.416775);
        longitude = Coordinate.fromDegrees(-3.70379);
        val spain = Point.at(latitude, longitude);

        assertEquals(43.709708112499776, EarthCalc.vincenty.bearing(california, spain));
    }

    @Test
    public void vincentyFinalBearing() {
        var latitude = Coordinate.fromDegrees(36.778259);
        var longitude = Coordinate.fromDegrees(-119.417931);
        val california = Point.at(latitude, longitude);

        latitude = Coordinate.fromDegrees(40.416775);
        longitude = Coordinate.fromDegrees(-3.70379);
        val spain = Point.at(latitude, longitude);

        assertEquals(133.38084585753566, EarthCalc.vincenty.finalBearing(california, spain));
    }
}