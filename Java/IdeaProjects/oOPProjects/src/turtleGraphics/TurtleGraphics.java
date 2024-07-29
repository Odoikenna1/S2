package turtleGraphics;

import static turtleGraphics.Direction.*;

public class TurtleGraphics {
    private boolean isPenUp = true;
    private Direction currentDirection = EAST;
    private Position position = new Position(0,0);

    public boolean isPenUp() {
        return isPenUp;
    }
    public void putPenDown() {isPenUp = false;}
    public void putPenUp() {
        isPenUp = true;
    }
    public void turnRight() {
        currentDirection = currentDirection.turnRight();
    }
    public void turnLeft() {
        currentDirection = currentDirection.turnLeft();
    }
    public Direction getCurrentDirection() {
        return currentDirection;
    }
//    public void move(int numberOfSteps, FloorBoard floorBoard){
//        if (!isPenUp){
//            writeOn(floorBoard, numberOfSteps);
//        }
//    }
//    private void writeOn(FloorBoard floorBoard, int numberOfSteps) {
//        if (currentDirection.equals(NORTH)) {
//            moveNorth(numberOfSteps, floorBoard);
//        }
//    }
//    private void moveNorth(int numberOfSteps, FloorBoard floorBoard) {
//        int currentRow = position.getRow();
//        int currentColumn = position.getColumn();
//        int[][] floor = floorBoard.getFloor();
//
//        for (int row = 0; row < numberOfSteps; row++) {
//            floor[currentRow - row][currentColumn] = 1;
//        }
//    }
}
