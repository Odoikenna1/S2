package turtleGraphics;

public class Position {
    private int row;
    private int column;

    Position(int row, int column){
        this.row = row;
        this.column = column;
    }
    public boolean equals(Position newPos){
        return this.row == newPos.row && this.column == newPos.column;
    }
    public String toString(){
        return String.format("""
                {Position: this.row = %d, this.column = %d}
                """, this.row, this.column);
    }
    public void setRow(int numberOfSteps){
        this.row = numberOfSteps;
    }
    public void setColumn(int numberOfSteps){
        this.column = numberOfSteps;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
}
