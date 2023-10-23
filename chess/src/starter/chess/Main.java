package chess;

import java.io.IOException;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        ChessBoardImp board = new ChessBoardImp();
        ChessGameImp game = new ChessGameImp();


        ChessPosition position = new ChessPositionImp(5, 2);
        ChessPiece bishop = new ChessPieceImp(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP);
        board.addPiece(position, bishop);

        //allied pieces
        ChessPosition[] allyPiecePositions = {new ChessPositionImp(4, 1)};
        board.addPiece(allyPiecePositions[0],
                new ChessPieceImp(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK));


        //enemy pieces
        ChessPosition[] enemyPiecePositions = {new ChessPositionImp(2, 5), new ChessPositionImp(7, 4)};
        board.addPiece(enemyPiecePositions[0],
                new ChessPieceImp(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN));
        board.addPiece(enemyPiecePositions[1],
                new ChessPieceImp(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN));
        System.out.print(board.toString());
        game.setBoard(board);

        HashSet<ChessMove> validMoves = (HashSet<ChessMove>) game.validMoves(position);
        for (ChessMove i : validMoves) {
            ChessMoveImp curr = (ChessMoveImp) i;
            System.out.print(curr.toString());
        }
    }
}
