import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeoPoliticalZonesTest {

    @Test
    public void testFindGeoPoliticalZone() {
        assertEquals(GeoPoliticalZones.SOUTH_WEST, GeoPoliticalZones.findGeoPoliticalZone("Lagos"));
        assertEquals(GeoPoliticalZones.SOUTH_SOUTH, GeoPoliticalZones.findGeoPoliticalZone("Delta"));
        assertEquals(GeoPoliticalZones.NORTH_CENTRAL, GeoPoliticalZones.findGeoPoliticalZone("Benue"));
        assertThrows(IllegalArgumentException.class, () -> GeoPoliticalZones.findGeoPoliticalZone("Unknown"));
    }

    @Test
    public void testToString() {
        assertEquals("NORTH_CENTRAL", GeoPoliticalZones.NORTH_CENTRAL.toString());
        assertEquals("SOUTH_EAST", GeoPoliticalZones.SOUTH_EAST.toString());
    }

    @Test
    public void testGetStates() {
        assertArrayEquals(new String[]{"Benue", "FCT", "Kogi", "Kwara", "Nasarawa", "Niger", "Plateau"}, GeoPoliticalZones.NORTH_CENTRAL.getStates());
        assertArrayEquals(new String[]{"Ekiti", "Lagos", "Osun", "Ondo", "Ogun", "Oyo"}, GeoPoliticalZones.SOUTH_WEST.getStates());
    }
}
