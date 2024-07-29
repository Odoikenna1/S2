package geoPoliticalZones;

public enum Zones {
    SOUTH_EAST("Anambra", "Abia", "Enugu", "Ebonyi", "Imo"),
    SOUTH_SOUTH("Akwa_Ibom", "Bayelsa", "Cross_River", "Delta", "Edo", "Rivers"),
    SOUTH_WEST("Ekiti","Lagos", "Osun", "Oyo", "Ondo", "Ogun"),
    NORTH_CENTRAL("Benue", "FCT", "Koggi","Kwara", "Nassawara", "Niger", "Plateau"),
    NORTH_WEST("Kaduna", "Kastina", "Kano", "Kebbi", "Sokoto", "Jigawa", "Zamfara"),
    NORTH_EAST("Adamawa", "Bauchi", "Gombe", "Taraba", "Yobe");

    private String[] state;
    Zones(String... state){
        this.state = state;
    }
    public String[] getStates(){
        return state;
    }
}
