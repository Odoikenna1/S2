package turtleGraphics;

public enum Direction {
    EAST("NORTH","SOUTH"), SOUTH("EAST", "WEST"),
    WEST("SOUTH", "NORTH"), NORTH("WEST", "EAST");

    Direction(String left, String right){
        this.left = left;
        this.right = right;
    }
    private String left;
    private String right;

   public Direction turnRight(){
       return Direction.valueOf(right);
   }
   public Direction turnLeft(){
       return Direction.valueOf(left);
   }
}
