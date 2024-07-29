public enum GeoPoliticalZones {

    NORTH_CENTRAL("Benue", "FCT", "Kogi", "Kwara", "Nasarawa", "Niger", "Plateau"),
    NORTH_EAST("Adamawa", "Bauchi", "Borno", "Gombe", "Taraba", "Yobe"),
    NORTH_WEST("Kaduna", "Kastina", "Kano", "Kebbi", "Sokoto", "Jigawa", "Zamfara"),
    SOUTH_EAST("Abia", "Anambra", "Ebonyi", "Enugu", "Imo"),
    SOUTH_SOUTH("Akwa_Ibom", "Bayelsa", "Cross_River", "Delta", "Edo", "Rivers"),
    SOUTH_WEST("Ekiti", "Lagos", "Osun", "Ondo", "Ogun", "Oyo");

    private  String[] states;

    GeoPoliticalZones(String... states){
        this.states = states;
    }
    public String[] getStates(){return states;}

    public  GeoPoliticalZones findGeoPoliticalZone(String state){
        for(var zone : GeoPoliticalZones.values()){
            for(String values : states){
                if(values.equalsIgnoreCase(state)){
                    return zone;
                }
            }
        }
        throw new IllegalArgumentException("State and zone not found.");
    }
    @Override
    public String toString(){
        return this.name();
    }
}
