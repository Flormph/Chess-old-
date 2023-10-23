package chess;

import java.util.Arrays;

public class ChessBoardImp implements ChessBoard{
    public ChessBoardImp() {}
    public ChessBoardImp(ChessBoardImp newBoard) {
        setBoard(newBoard);
    }
    ChessPieceImp[][] board = new ChessPieceImp[8][8]; //new board

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for(int i = 8; i > 0; --i) {
            for(int j = 1; j < 9; ++j) {
                ChessPositionImp currPos = new ChessPositionImp(i,j);
                ChessPieceImp currPiece = (ChessPieceImp) getPiece(currPos);
                out.append('|');
                if(currPiece != null) {
                    out.append(getPiece(currPos).toString());
                }
                else {
                    out.append(" ");
                }
                if(j == 8) {out.append('|');}
            }
            out.append('\n');
        }
        return out.toString();
    }

    public void setBoard(ChessBoardImp newBoard) {
        for(int i = 0; i < 8; ++i) {
            for(int j = 0; j < 8; ++j) {
                if(newBoard.getPiece(new ChessPositionImp(i + 1,j + 1)) != null) {
                    ChessPieceImp newPiece = new ChessPieceImp((ChessPieceImp) newBoard.getPiece(new ChessPositionImp(i + 1, j + 1)));
                    board[i][j] = newPiece;
                }
            }
        }
    }
    @Override
    public void addPiece(ChessPosition position, ChessPiece piece) { //takes an already instantiated piece and places it on the board
        if(getPiece(position) == null) { //checks if the location is empty (if not it will return null
            board[position.getRow() - 1][position.getColumn() - 1]  = (ChessPieceImp) piece;
        }
        else {
            return; // maybe throw an exception later
        }
    }
    public ChessPieceImp[][] getBoard() {
        return board;
    }
    @Override
    public ChessPiece getPiece(ChessPosition position) { //returns the piece at given position
        ChessPositionImp currPos = (ChessPositionImp) position;
        if(currPos.isInBounds()) {
            return board[position.getRow() - 1][position.getColumn() - 1];
        }
        else {
            return null;
        }
    }

    public ChessPosition findWhiteKing() {
        for(int i = 1; i < 9; ++i) {
            for(int j = 1; j < 9; ++j) {
                ChessPositionImp currPos = new ChessPositionImp(i,j);
                if(getPiece(currPos) != null) {
                    if (getPiece(currPos).getPieceType() == ChessPiece.PieceType.KING && getPiece(currPos).getTeamColor() == ChessGame.TeamColor.WHITE) {
                        return currPos;
                    }
                }
            }
        }
        return null;
    }
    public ChessPosition findBlackKing() {
        for(int i = 1; i < 9; ++i) {
            for(int j = 1; j < 9; ++j) {
                ChessPositionImp currPos = new ChessPositionImp(i,j);
                if(getPiece(currPos) != null) {
                    if (getPiece(currPos).getPieceType() == ChessPiece.PieceType.KING && getPiece(currPos).getTeamColor() == ChessGame.TeamColor.BLACK) {
                        return currPos;
                    }
                }
            }
        }
        return null;
    }
    public void setPiece(ChessPosition pos, ChessPieceImp piece) {
        board[pos.getRow() - 1][pos.getColumn() - 1] = piece;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessBoardImp that = (ChessBoardImp) o;
        return Arrays.equals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }

    @Override
    public void resetBoard() {
        board = new ChessPieceImp[8][8]; // Clears board by newing up a new one (eat your heart out c++)

        //This portion instantiates the piece types for easier coding later on (it actually adds lines but it makes the code more readable
        ChessPieceImp whiteRook = new ChessPieceImp(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK);
        ChessPieceImp blackRook = new ChessPieceImp(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK);
        ChessPieceImp whiteKnight = new ChessPieceImp(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT);
        ChessPieceImp blackKnight = new ChessPieceImp(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT);
        ChessPieceImp whiteBishop = new ChessPieceImp(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP);
        ChessPieceImp blackBishop = new ChessPieceImp(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
        ChessPieceImp whiteQueen = new ChessPieceImp(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN);
        ChessPieceImp blackQueen = new ChessPieceImp(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN);
        ChessPieceImp whiteKing = new ChessPieceImp(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING);
        ChessPieceImp blackKing = new ChessPieceImp(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING);
        ChessPieceImp whitePawn = new ChessPieceImp(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
        ChessPieceImp blackPawn = new ChessPieceImp(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);

        for(int i = 0; i < 2; ++i) { //Places the horizontally-symmetric pieces
            addPiece(new ChessPositionImp(1, 7 * i + 1), whiteRook);
            addPiece(new ChessPositionImp(8, 7 * i + 1), blackRook);
            addPiece(new ChessPositionImp(1, 5 * i + 2), whiteKnight);
            addPiece(new ChessPositionImp(8, 5 * i + 2), blackKnight);
            addPiece(new ChessPositionImp(1, 3 * i + 3), whiteBishop);
            addPiece(new ChessPositionImp(8, 3 * i + 3), blackBishop);
        }

        //Places non-horizontally-symmetric pieces
        addPiece(new ChessPositionImp(1, 4), whiteQueen);
        addPiece(new ChessPositionImp(8, 4), blackQueen);
        addPiece(new ChessPositionImp(1, 5), whiteKing);
        addPiece(new ChessPositionImp(8, 5), blackKing);

        //Places pawn rows
        Arrays.fill(board[1], whitePawn);
        Arrays.fill(board[6], blackPawn);

        return;
    }
}
