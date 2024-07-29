package reflectionPerson;

import java.util.ArrayList;

public class Person {
    private Problem palava;
    ArrayList<Problem> problems = new ArrayList<>();
    private int problemCounter = 0;


    public void add(String name, TypeOfProblem type){
         Problem newPalava = createProblem(name, type);
         problems.add(newPalava);
    }
    public void solveProblem(String name){
        Problem palavaFound = findProblem(name);
        palavaFound.solveProblem();
        problems.remove(palavaFound);
    }
    public Problem findProblem(String name){
        for(Problem problem : problems){
            if(name.equalsIgnoreCase(problem.getName())){
                return problem;
            }
        }
        throw new IllegalArgumentException("Problem not found.");
    }
    public boolean checkProblemSolved(String name){
        Problem palavaFound = findProblem(name);
        return palavaFound.isSolved();
    }
    private void filterProblems(String name){
        if(checkProblemSolved(name)){
            removeProblem(name);
        }
    }
    public void removeProblem(String name){
        for(Problem problem : problems){
            if(name.equalsIgnoreCase(problem.getName())){
                Problem problemFound = findProblem(name);
                problems.remove(problemFound);
            }
        }
    }
    public String getProblems(){
        StringBuilder result = new StringBuilder();
        for(Problem palava : problems){
            if(!result.isEmpty()){
                result.append(", ");
            }
            result.append(palava.getName());
        }
        return result.toString();
    }
    public String toString(){
        return String.format("""
                Problem name: %s
                Problem type: %s
                """, palava.getName(), palava.toString());
    }
    public int countProblems(){
//        for(Problem problem : problems){
//                problemCounter++;
//        }
//        return problemCounter;
        return problems.size();
    }
    private Problem createProblem(String name, TypeOfProblem type){
        palava = new Problem(name, type);
        return palava;
    }

}
