package geospatialApplicationTests.geospatialApplicationTest;

import geospatialApplication.SimpleLocation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeospatialApllicationTestsTest {
    @Test
    void xc(){
        SimpleLocation x = new SimpleLocation(32.9, -117.2);
        SimpleLocation y = new SimpleLocation(-12.0,-77.1);
        assertEquals(0, x.distance(y));
    }
}