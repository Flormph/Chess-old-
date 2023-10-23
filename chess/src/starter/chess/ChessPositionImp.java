package chess;

import java.util.Objects;

public class ChessPositionImp implements ChessPosition{
    int row = -1; // negative to throw an error if the location is not set
    int column = -1;
    public ChessPositionImp(int setRow, int setColumn) {
        row = setRow;
        column = setColumn;
    }
    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getColumn() {
        return column;
    }

    public ChessPositionImp edit(int newRow, int newColumn) {
        return new ChessPositionImp(row + newRow, column + newColumn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPositionImp that = (ChessPositionImp) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "(" + getRow() + "," + getColumn() + ")";
    }

    public boolean isInBounds() {
        return 0 < row && row < 9 && 0 < column && column < 9;
    }
}
