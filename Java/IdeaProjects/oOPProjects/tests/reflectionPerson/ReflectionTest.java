package reflectionPerson;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionTest {
    @Test
    void test_PersonCanAddToProblems(){
        Person mfon = new Person();
        mfon.add("Loan", TypeOfProblem.FINANCIAL);
        int numberOfProblems = mfon.countProblems();
        assertEquals(numberOfProblems, 1);
    }
    @Test
    void test_ThatWhenANewProblemIsAdded_ProblemCountIncreasesTo2(){
        Person mfon = new Person();
        mfon.add("Loan", TypeOfProblem.FINANCIAL);
        mfon.add("Village_people", TypeOfProblem.SPIRITUAL);
        int numberOfProblems = mfon.countProblems();
        assertEquals(numberOfProblems, 2);
    }
    @Test
    void test_ThatWhenANewProblemIsAdded_ProblemCountIncreasesTo3(){
        Person mfon = new Person();
        mfon.add("Loan", TypeOfProblem.FINANCIAL);
        mfon.add("Village_people", TypeOfProblem.SPIRITUAL);
        mfon.add("Insufficient_funds", TypeOfProblem.BUSINESS);
        int numberOfProblems = mfon.countProblems();
        assertEquals(numberOfProblems, 3);
    }
    @Test
    void test_ThatWhenAProblemIsSolved_ProblemCountWillReduceByOne(){
        Person mfon = new Person();
        mfon.add("Loan", TypeOfProblem.FINANCIAL);
        mfon.add("Village_people", TypeOfProblem.SPIRITUAL);
        mfon.add("Insufficient_funds", TypeOfProblem.BUSINESS);
        int numberOfProblems = mfon.countProblems();
        assertEquals(numberOfProblems, 3);
        mfon.solveProblem("Insufficient_funds");
        numberOfProblems = mfon.countProblems();
        System.out.println(mfon.getProblems());
        assertEquals(numberOfProblems, 2);
    }
}