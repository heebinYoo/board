package bean;

public class Coord {
    private int row;
    private int col;

    public Coord(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
