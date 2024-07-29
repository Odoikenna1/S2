package geoPoliticalZones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoZoneTest {

    @Test
    void test_ThatAppCanFindZoneOfStateInput(){
        Zones actualZone = Zones.SOUTH_EAST;
        Zones expectedZones = Nigeria.findZone("Imo");
        System.out.println(actualZone + " = " + actualZone);
        assertEquals(actualZone, expectedZones);
    }
}