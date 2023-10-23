package chess;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class ChessGameImp implements ChessGame{

    TeamColor currTeam = TeamColor.WHITE;
    ChessBoardImp board = new ChessBoardImp();
    HashSet<ChessPosition> whitePieces = new HashSet<ChessPosition>();
    HashSet<ChessPosition> blackPieces = new HashSet<ChessPosition>();
    HashSet<ChessPosition> dummyWhitePieces = new HashSet<ChessPosition>();
    HashSet<ChessPosition> dummyBlackPieces = new HashSet<ChessPosition>();
    @Override
    public TeamColor getTeamTurn() {
        return currTeam;
    }

    @Override
    public void setTeamTurn(TeamColor team) {
        currTeam = team;
    }

    @Override
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        ChessPiece currPiece = board.getPiece(startPosition);
        HashSet<ChessMove> validMoves = new HashSet<ChessMove>();
        if(currPiece == null) {
            return null;
        }
        currTeam = currPiece.getTeamColor(); //FIXME FOR TESTING
        //if(currPiece.getTeamColor() != currTeam) {
        //    return null;
        //}
        HashSet<ChessMove> pieceMoves = new HashSet<ChessMove>(board.getPiece(startPosition).pieceMoves(board, startPosition));
        for(ChessMove p : pieceMoves) {
            if(validate(p)) {
                validMoves.add(p);
            }
        }
        return validMoves;
    }

    private boolean validate(ChessMove p) {
        ChessBoardImp tempBoard = new ChessBoardImp(board);
        tempBoard.setPiece(p.getEndPosition(), (ChessPieceImp)tempBoard.getPiece(p.getStartPosition()));
        tempBoard.setPiece(p.getStartPosition(), null);
        if(currTeam == TeamColor.WHITE) {
            if(isInCheck(TeamColor.WHITE, tempBoard)) {return false;}
        }
        if(currTeam == TeamColor.BLACK) {
            if(isInCheck(TeamColor.BLACK, tempBoard)) {return false;}
        }

        return true;
    }


    @Override
    public void makeMove(ChessMove move) throws InvalidMoveException {
        if(board.getPiece(move.getStartPosition()) == null) {
            throw new InvalidMoveException();
        }
        if(board.getPiece(move.getStartPosition()).getTeamColor() != currTeam) {
            throw new InvalidMoveException();
        }
        Collection<ChessMove> myMoves = validMoves(move.getStartPosition());
        if(myMoves != null) {
            if (myMoves.contains(move)) {
                if(move.getPromotionPiece() != null) {
                    board.setPiece(move.getEndPosition(), new ChessPieceImp(board.getPiece(move.getStartPosition()).getTeamColor(), move.getPromotionPiece()));
                }
                else {
                    board.setPiece(move.getEndPosition(), (ChessPieceImp) board.getPiece(move.getStartPosition()));
                }
                board.setPiece(move.getStartPosition(), null);
            }
            else {
                throw new InvalidMoveException("YOUR TRIED BUT YOU LIED YOUR PIECE IS WRONG (invalid move)");
            }
        }
        else {
            throw new InvalidMoveException("YOUR TRIED BUT YOU LIED YOUR PIECE IS WRONG (invalid move)");
        }
        changeTeam();
        return;
    }

    public void changeTeam() {
        if(currTeam == TeamColor.WHITE) {
            currTeam = TeamColor.BLACK;
        }
        else {
            currTeam = TeamColor.WHITE;
        }
    }

    @Override
    public boolean isInCheck(TeamColor teamColor) {
        checkBoardPieces();
        ChessPosition whiteKingPos = board.findWhiteKing();
        ChessPosition blackKingPos = board.findBlackKing();
        if(teamColor == TeamColor.WHITE) {
            for(ChessPosition pos : blackPieces) {
                for(ChessMove mov : board.getPiece(pos).pieceMoves(board,pos)){
                    ChessPosition currMove = mov.getEndPosition();
                    if(Objects.equals(currMove, (ChessPosition)whiteKingPos)) {
                        return true;
                    }
                }
            }
        }
        if(teamColor == TeamColor.BLACK) {
            for(ChessPosition pos : whitePieces) {
                for(ChessMove mov : board.getPiece(pos).pieceMoves(board,pos)){
                    ChessPosition currMove = mov.getEndPosition();
                    if(Objects.equals(currMove, (ChessPosition)blackKingPos)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isInCheck(TeamColor teamColor, ChessBoardImp board) {
        checkBoardPieces(board);
        ChessPosition whiteKingPos = board.findWhiteKing();
        ChessPosition blackKingPos = board.findBlackKing();
        if(teamColor == TeamColor.WHITE) {
            for(ChessPosition pos : dummyBlackPieces) {
                for(ChessMove mov : board.getPiece(pos).pieceMoves(board,pos)){
                    ChessPosition currMove = mov.getEndPosition();
                    if(Objects.equals(currMove, (ChessPosition)whiteKingPos)) {
                        return true;
                    }
                }
            }
        }
        if(teamColor == TeamColor.BLACK) {
            for(ChessPosition pos : dummyWhitePieces) {
                for(ChessMove mov : board.getPiece(pos).pieceMoves(board,pos)){
                    ChessPosition currMove = mov.getEndPosition();
                    if(Objects.equals(currMove, (ChessPosition)blackKingPos)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean isInCheckmate(TeamColor teamColor) {
        if(!isInCheck(teamColor)) {
           return false;
        }
        if(teamColor == TeamColor.WHITE) {
            for(ChessPosition cp : whitePieces) {
                Collection<ChessMove> myMoves = validMoves(cp);
                if(myMoves != null) {
                    if(!validMoves(cp).isEmpty()) {
                        return false;
                    }
                }
            }
        }
        if(teamColor == TeamColor.BLACK) {
            for(ChessPosition cp : blackPieces) {
                Collection<ChessMove> myMoves = validMoves(cp);
                if(myMoves != null) {
                    if(!validMoves(cp).isEmpty()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean isInStalemate(TeamColor teamColor) {
        if(isInCheck(teamColor)) {
            return false;
        }
        if(teamColor == TeamColor.WHITE) {
            for(ChessPosition cp : whitePieces) {
                Collection<ChessMove> myMoves = validMoves(cp);
                if(myMoves != null) {
                    if(!validMoves(cp).isEmpty()) {
                        return false;
                    }
                }
            }
        }
        if(teamColor == TeamColor.BLACK) {
            for(ChessPosition cp : blackPieces) {
                Collection<ChessMove> myMoves = validMoves(cp);
                if(myMoves != null) {
                    if(!validMoves(cp).isEmpty()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void setBoard(ChessBoard board) {
        this.board = (ChessBoardImp) board;
        checkBoardPieces();
    }

    public void resetBoard(ChessBoard board) {
        board.resetBoard();
        checkBoardPieces();
    }

    private void checkBoardPieces() {
        blackPieces.clear();
        whitePieces.clear();
        for(int i = 1; i < 9; ++i) {
            for(int j = 1; j < 9; ++j) {
                ChessPosition currPos = new ChessPositionImp(i,j);
                if(board.getPiece(currPos) != null) {
                    if(board.getPiece(currPos).getTeamColor() == TeamColor.WHITE) {
                        whitePieces.add(currPos);
                    }
                    if(board.getPiece(currPos).getTeamColor() == TeamColor.BLACK) {
                        blackPieces.add(currPos);
                    }
                }
            }
        }
    }
    private void checkBoardPieces(ChessBoard board) {
        dummyBlackPieces.clear();
        dummyWhitePieces.clear();
        for(int i = 1; i < 9; ++i) {
            for(int j = 1; j < 9; ++j) {
                ChessPosition currPos = new ChessPositionImp(i,j);
                if(board.getPiece(currPos) != null) {
                    if(board.getPiece(currPos).getTeamColor() == TeamColor.WHITE) {
                        dummyWhitePieces.add(currPos);
                    }
                    if(board.getPiece(currPos).getTeamColor() == TeamColor.BLACK) {
                        dummyBlackPieces.add(currPos);
                    }
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessGameImp that = (ChessGameImp) o;
        return currTeam == that.currTeam && Objects.equals(board, that.board) && Objects.equals(whitePieces, that.whitePieces) && Objects.equals(blackPieces, that.blackPieces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currTeam, board, whitePieces, blackPieces);
    }

    @Override
    public ChessBoard getBoard() {
        return (ChessBoard) board;
    }
}
