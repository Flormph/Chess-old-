package chess;

import java.util.Objects;

public class ChessMoveImp implements ChessMove{
    ChessPositionImp start;
    ChessPositionImp end;
    ChessPiece.PieceType promoteTo = null;
    public ChessMoveImp(ChessPositionImp startPos, ChessPositionImp endPos) {
        start = startPos;
        end = endPos;
        promoteTo = null;
    }

    public ChessMoveImp(ChessPositionImp startPos, ChessPositionImp endPos, ChessPiece.PieceType promType) {
        start = startPos;
        end = endPos;
        promoteTo = promType;
    }

    @Override
    public String toString() {
        return start.toString() + '\n' + end.toString() + '\n' + promoteTo + "\n\n";
    }


    @Override
    public ChessPosition getStartPosition() {
        return start;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessMoveImp that = (ChessMoveImp) o;
        return Objects.equals(start, that.start) && Objects.equals(end, that.end) && promoteTo == that.promoteTo;
    }

    @Override
    public ChessPosition getEndPosition() {
        return end;
    }

    @Override
    public ChessPiece.PieceType getPromotionPiece() {
        return promoteTo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, promoteTo) * 7 * end.getRow();
    }
}
