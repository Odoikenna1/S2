package reflectionPerson;

public enum TypeOfProblem {
    FINANCIAL,
    EDUCATION,
    BUSINESS,
    TECHNICAL,
    SPIRITUAL;

    public String toString(){
        return String.format("""
                %s
                """, (Object) TypeOfProblem.values());
    }

}
