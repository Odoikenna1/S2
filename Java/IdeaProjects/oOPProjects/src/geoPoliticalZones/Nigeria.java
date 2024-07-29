package geoPoliticalZones;

public class Nigeria {
    //private static Zones zone;


    public static Zones findZone(String state){
        for (Zones zone : Zones.values()) {
            for(String x : zone.getStates()) {
                if (x.equalsIgnoreCase(state)) {
                    return zone;
                }
            }
        }
        throw new IllegalArgumentException("Zone not found.");
    }
}
