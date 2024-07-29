package relectionTask1;

public enum Type {
    LIVING_THING("Plant", "Animal"), NON_LIVING_THING((String) null);

    private String[] typeOfLivingThing;
    Type(String... type){
        typeOfLivingThing = type;
    }
}