package com.grum.geocalc;

import lombok.val;
import lombok.var;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
* Mutation Testing for Coordinate class and child classes, as well as Point.
 */
public class coordinatePointTest {

    @Test
    public void convertToSelf(){
    val degreeCoordinate = Coordinate.fromDegrees(101.45627);
    assertEquals(degreeCoordinate.toDegreeCoordinate().degrees(), degreeCoordinate.degrees());

    val DMSCoordinate = Coordinate.fromDMS(93,5,3.8976);
    assertEquals(DMSCoordinate.toDMSCoordinate().degrees(), DMSCoordinate.degrees());

    val DMSCoordinate2 = Coordinate.fromDMS(-80,17,20.9887);
    assertEquals(DMSCoordinate.toDMSCoordinate().degrees(), DMSCoordinate.degrees());

    val GPSCoordinate = Coordinate.fromGPS(38,59);
    assertEquals(GPSCoordinate.toGPSCoordinate().degrees(), GPSCoordinate.degrees());

    val radianCoordinate = Coordinate.fromRadians(Math.PI/6);
    assertEquals(radianCoordinate.toRadianCoordinate().degrees(), radianCoordinate.degrees());
    }

    @Test
    public void containsCoordinate(){
        //bounding area requires
        var topLeft = Point.at(Coordinate.fromDegrees(23), Coordinate.fromDegrees(180));
        var bottomRight = Point.at(Coordinate.fromDegrees(-16),Coordinate.fromDegrees(-100));
        var boundingArea = BoundingArea.at(topLeft, bottomRight);

        var point1 = Point.at(Coordinate.fromDegrees(10), Coordinate.fromDegrees(90));
        assertTrue(boundingArea.contains(point1));

        var point2 = Point.at(Coordinate.fromDegrees(20), Coordinate.fromDegrees(65));
        assertTrue(boundingArea.contains(point2));

        var point3 = Point.at(Coordinate.fromDegrees(34), Coordinate.fromDegrees(59));
        assertFalse(boundingArea.contains(point3));

        var point4 = Point.at(Coordinate.fromDegrees(50), Coordinate.fromDegrees(50));
        assertFalse(boundingArea.contains(point4));

        var point5 = Point.at(Coordinate.fromDegrees(1), Coordinate.fromDegrees(181));
        assertFalse(boundingArea.contains(point5));

        var point6 =  Point.at(Coordinate.fromDegrees(40), Coordinate.fromDegrees(45));
        assertFalse(boundingArea.contains(point6));

        var point7 =  Point.at(Coordinate.fromDegrees(88), Coordinate.fromDegrees(90));
        assertFalse(boundingArea.contains(point7));

        topLeft = Point.at(Coordinate.fromDegrees(10), Coordinate.fromDegrees(18));
        bottomRight = Point.at(Coordinate.fromDegrees(61),Coordinate.fromDegrees(-5));
        boundingArea = BoundingArea.at(topLeft, bottomRight);

        var point8 = Point.at(Coordinate.fromDegrees(5), Coordinate.fromDegrees(15));
        assertFalse(boundingArea.contains(point8));

        var point9 = Point.at(Coordinate.fromDegrees(-90), Coordinate.fromDegrees(-75));
        assertFalse(boundingArea.contains(point9));

        var point10 =  Point.at(Coordinate.fromDegrees(-88), Coordinate.fromDegrees(-65));
        assertFalse(boundingArea.contains(point10));

        var point11 =  Point.at(Coordinate.fromDegrees(-70), Coordinate.fromDegrees(-30));
        assertFalse(boundingArea.contains(point11));
    }
}