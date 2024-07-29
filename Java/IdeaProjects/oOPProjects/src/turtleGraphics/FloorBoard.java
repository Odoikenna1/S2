package turtleGraphics;

public class FloorBoard {
    private int[][] floor = new int[20][20];

    public FloorBoard(int row, int column){
        floor = new int[row][column];
    }
    public int[][] getFloor(){
        return floor;
    }
}
