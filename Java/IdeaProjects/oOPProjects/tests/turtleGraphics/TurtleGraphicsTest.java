//package turtleGraphics;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static turtleGraphics.Direction.*;
//
//class TurtleGraphicsTest {
//
//    private TurtleGraphics sam;
//
//    @BeforeEach
//    void setUp() {
//        sam = new TurtleGraphics();
//    }
//
//    @Test
//    void test_turtlePenIsUp(){
//        assertTrue(sam.penIsUp());
//    }
//    @Test
//    void test_turtlePenCanBePutDown(){
//        sam.putPenDown();
//        assertFalse(sam.penIsUp());
//    }
//    @Test
//    void test_turtlePenCanBePutUp(){
//        sam.putPenDown();
//        sam.putPenUp();
//        assertTrue(sam.penIsUp());
//    }
//    @Test
//    void test_turtleCanTurnRightFromEastToSouth(){
//        assertSame(EAST, sam.getCurrentDirection());
//        sam.turnRight();
//        assertSame(SOUTH, sam.getCurrentDirection());
//    }
//    @Test
//    void test_turtleCanTurnRightFromSouthToWest(){
//        assertSame(EAST, sam.getCurrentDirection());
//        sam.turnRight();
//        assertSame(SOUTH, sam.getCurrentDirection());
//        sam.turnRight();
//        assertSame(WEST, sam.getCurrentDirection());
//    }
//    @Test
//    void test_turtleCanTurnRightFromWestToNorth(){
//        assertSame(EAST, sam.getCurrentDirection());
//        sam.turnRight();
//        assertSame(SOUTH, sam.getCurrentDirection());
//        sam.turnRight();
//        assertSame(WEST, sam.getCurrentDirection());
//        sam.turnRight();
//        assertSame(NORTH, sam.getCurrentDirection());
//    }
//    @Test
//    void test_turtleCanTurnRightFromNorthToEast(){
//        assertSame(EAST, sam.getCurrentDirection());
//        sam.turnRight();
//        assertSame(SOUTH, sam.getCurrentDirection());
//        sam.turnRight();
//        assertSame(WEST, sam.getCurrentDirection());
//        sam.turnRight();
//        assertSame(NORTH, sam.getCurrentDirection());
//        sam.turnRight();
//        assertSame(EAST, sam.getCurrentDirection());
//    }
//    @Test
//    void test_turtleCanTurnLeftFromEastToNorth(){
//        assertSame(EAST, sam.getCurrentDirection());
//        sam.turnLeft();
//        assertSame(NORTH, sam.getCurrentDirection());
//    }
//    @Test
//    void test_turtleCanTurnLeftFromNorthToWest(){
//        assertSame(EAST, sam.getCurrentDirection());
//        sam.turnLeft();
//        assertSame(NORTH, sam.getCurrentDirection());
//        sam.turnLeft();
//        assertSame(WEST, sam.getCurrentDirection());
//    }
//    @Test
//    void test_turtleCanTurnLeftFromWestToSouth(){
//        assertSame(EAST, sam.getCurrentDirection());
//        sam.turnLeft();
//        assertSame(NORTH, sam.getCurrentDirection());
//        sam.turnLeft();
//        assertSame(WEST, sam.getCurrentDirection());
//        sam.turnLeft();
//        assertSame(SOUTH, sam.getCurrentDirection());
//    }
//    @Test
//    void test_turtleCanTurnLeftFromSouthToEast(){
//        assertSame(EAST, sam.getCurrentDirection());
//        sam.turnLeft();
//        assertSame(NORTH, sam.getCurrentDirection());
//        sam.turnLeft();
//        assertSame(WEST, sam.getCurrentDirection());
//        sam.turnLeft();
//        assertSame(SOUTH, sam.getCurrentDirection());
//        sam.turnLeft();
//        assertSame(EAST, sam.getCurrentDirection());
//    }
//}