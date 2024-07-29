package reflectionPerson;

public class Problem {

    private boolean isSolved;
    private String name;
    private TypeOfProblem type;

    Problem(String name, TypeOfProblem type){
        this.name = name;
        this.type = type;
    }
    public boolean isSolved(){
        return isSolved;
    }
    public void solveProblem(){
        this.isSolved = true;
    }
    public String getName(){
        return this.name;
    }

}
