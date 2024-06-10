package geospatialApplication;

public class SimpleLocation {

    public double latitude;
    public double longitude;

    public SimpleLocation(double latitude, double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getDistance(double latitude, double longitude, double otherLatitude, double otherLongitude) {
        return;
    }
    public double distance(SimpleLocation otherLocation)
    {
        return getDistance(this.latitude, this.longitude, otherLocation.latitude, otherLocation.longitude);
    }
}
