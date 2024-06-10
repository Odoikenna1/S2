public class AllFunctions {


    public int findSumOfTwoNumbers(int num1, int num2)
    {
        return  num1 + num2;
    }
    public int convertMinutesToSeconds(int minutes){
        final int SECONDS = 60;
        return minutes * SECONDS;
    }
    public int findNextInt(int num)
    {
        return num+1;
    }
    public boolean isNumberEqual(int num1, int num2)
    {
        return num1 == num2;
    }

    public int getVoteCount(int upVote, int downVotes)
    {
        return upVote - downVotes;
    }
}
