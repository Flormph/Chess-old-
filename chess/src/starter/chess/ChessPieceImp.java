package chess;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Vector;

public class ChessPieceImp implements ChessPiece{
    private ChessGame.TeamColor teamColor = null;
    private ChessPieceImp.PieceType pieceType = null;
    public ChessPieceImp(ChessGameImp.TeamColor color, ChessPieceImp.PieceType type) {
        teamColor = color;
        pieceType = type;
    }
    public ChessPieceImp(ChessPieceImp newPiece) {
        teamColor = newPiece.getTeamColor();
        pieceType = newPiece.getPieceType();
    }

    @Override
    public ChessGame.TeamColor getTeamColor() {
        return teamColor;
    }

    @Override
    public PieceType getPieceType() {
        return pieceType;
    }

    private boolean teamCheck(ChessGameImp.TeamColor color1, ChessGameImp.TeamColor color2) {
        return color1 == color2;
    }

    private HashSet<ChessMove> kingMoves(ChessBoard board, ChessPosition myPosition) {
        ChessPositionImp currPos = (ChessPositionImp) myPosition;
        HashSet<ChessMove> pieceMoves = new HashSet<ChessMove>();
        for (int i = -1; i < 2; ++i) {
            for (int j = -1; j < 2; ++j) {
                if (i != 0 || j != 0) {
                    if(currPos.edit(i, j).isInBounds()) {
                        if (board.getPiece(currPos.edit(i, j)) == null) {
                            ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                            pieceMoves.add(newMove);
                        }
                        if (board.getPiece(currPos.edit(i, j)) != null) {
                            if (!teamCheck(teamColor, board.getPiece(currPos.edit(i, j)).getTeamColor())) {
                                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                                pieceMoves.add(newMove);
                            }
                        }
                    }
                }
            }
        }
        return pieceMoves;
    }
    private HashSet<ChessMove> knightMoves(ChessBoard board, ChessPosition myPosition) {
        ChessPositionImp currPos = (ChessPositionImp) myPosition;
        HashSet<ChessMove> pieceMoves = new HashSet<ChessMove>();
        if(currPos.getRow() + 1 < 9 && currPos.getColumn() - 2 > 0) { // up left left attack
            int i = 1;
            int j = -2;
            if(board.getPiece(currPos.edit(i, j)) == null) {
                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                pieceMoves.add(newMove);
            }
            else {
                if (!teamCheck(teamColor, board.getPiece(currPos.edit(i, j)).getTeamColor())) {
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                    pieceMoves.add(newMove);
                }
            }
        }
        if(currPos.getRow() + 2 < 9 && currPos.getColumn() - 1 > 0) { // up up left attack
            int i = 2;
            int j = -1;
            if(board.getPiece(currPos.edit(i, j)) == null) {
                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                pieceMoves.add(newMove);
            }
            else {
                if (!teamCheck(teamColor, board.getPiece(currPos.edit(i, j)).getTeamColor())) {
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                    pieceMoves.add(newMove);
                }
            }
        }
        if(currPos.getRow() + 2 < 9 && currPos.getColumn() + 1 < 9) { // up up right attack
            int i = 2;
            int j = 1;
            if(board.getPiece(currPos.edit(i, j)) == null) {
                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                pieceMoves.add(newMove);
            }
            else {
                if (!teamCheck(teamColor, board.getPiece(currPos.edit(i, j)).getTeamColor())) {
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                    pieceMoves.add(newMove);
                }
            }
        }
        if(currPos.getRow() + 1 < 9 && currPos.getColumn() + 2 < 9) { // up right right attack
            int i = 1;
            int j = 2;
            if(board.getPiece(currPos.edit(i, j)) == null) {
                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                pieceMoves.add(newMove);
            }
            else {
                if (!teamCheck(teamColor, board.getPiece(currPos.edit(i, j)).getTeamColor())) {
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                    pieceMoves.add(newMove);
                }
            }
        }
        if(currPos.getRow() - 1 > 0 && currPos.getColumn() + 2 < 9) { // down right right attack
            int i = -1;
            int j = 2;
            if(board.getPiece(currPos.edit(i, j)) == null) {
                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                pieceMoves.add(newMove);
            }
            else {
                if (!teamCheck(teamColor, board.getPiece(currPos.edit(i, j)).getTeamColor())) {
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                    pieceMoves.add(newMove);
                }
            }
        }
        if(currPos.getRow() - 2 > 0 && currPos.getColumn() + 1 < 9) { // down down right attack
            int i = -2;
            int j = 1;
            if(board.getPiece(currPos.edit(i, j)) == null) {
                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                pieceMoves.add(newMove);
            }
            else {
                if (!teamCheck(teamColor, board.getPiece(currPos.edit(i, j)).getTeamColor())) {
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                    pieceMoves.add(newMove);
                }
            }
        }
        if(currPos.getRow() - 2 > 0 && currPos.getColumn() - 1 > 0) { // down down left attack
            int i = -2;
            int j = -1;
            if(board.getPiece(currPos.edit(i, j)) == null) {
                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                pieceMoves.add(newMove);
            }
            else {
                if (!teamCheck(teamColor, board.getPiece(currPos.edit(i, j)).getTeamColor())) {
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                    pieceMoves.add(newMove);
                }
            }
        }
        if(currPos.getRow() - 1 > 0 && currPos.getColumn() - 2 > 0) { // down left left attack
            int i = -1;
            int j = -2;
            if(board.getPiece(currPos.edit(i, j)) == null) {
                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                pieceMoves.add(newMove);
            }
            else {
                if (!teamCheck(teamColor, board.getPiece(currPos.edit(i, j)).getTeamColor())) {
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, j));
                    pieceMoves.add(newMove);
                }
            }
        }
        return pieceMoves;
    }

    private HashSet<ChessMove> pawnMoves(ChessBoard board, ChessPosition myPosition) {
        ChessPositionImp currPos = (ChessPositionImp) myPosition;
        HashSet<ChessMove> pieceMoves = new HashSet<ChessMove>();
        if(teamColor == ChessGame.TeamColor.WHITE) {//white moves
            if(currPos.getRow() == 2) {
                for (int i = 1; i < 3; ++i) { //Hop movement
                    if (board.getPiece(currPos.edit(i, 0)) == null) {
                            ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, 0));
                            pieceMoves.add(newMove);
                    }
                    else break;
                }
            }
            if(currPos.getRow() != 8) { //normal forward movement
                if(board.getPiece(currPos.edit(1,0)) == null) {
                    if(currPos.getRow() == 7) { //promotion logic
                        ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, 0), PieceType.ROOK);
                        pieceMoves.add(newMove);
                        ChessMove newMove2 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, 0), PieceType.KNIGHT);
                        pieceMoves.add(newMove2);
                        ChessMove newMove3 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, 0), PieceType.BISHOP);
                        pieceMoves.add(newMove3);
                        ChessMove newMove4 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, 0), PieceType.QUEEN);
                        pieceMoves.add(newMove4);
                    }
                    else { //without promotion
                        ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, 0));
                        pieceMoves.add(newMove);
                    }
                }
                if(0 < currPos.getColumn() - 1) { //left diagonal attack logic
                    if(board.getPiece(currPos.edit(1,-1)) != null) {
                        if(!teamCheck(teamColor,board.getPiece(currPos.edit(1,-1)).getTeamColor())) {
                            if (currPos.getRow() == 7) { //promotion logic
                                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, -1), PieceType.ROOK);
                                pieceMoves.add(newMove);
                                ChessMove newMove2 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, -1), PieceType.KNIGHT);
                                pieceMoves.add(newMove2);
                                ChessMove newMove3 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, -1), PieceType.BISHOP);
                                pieceMoves.add(newMove3);
                                ChessMove newMove4 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, -1), PieceType.QUEEN);
                                pieceMoves.add(newMove4);
                            } else { //without promotion
                                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, -1));
                                pieceMoves.add(newMove);
                            }
                        }
                    }
                }
                if(currPos.getColumn() + 1 < 9) { //right diagonal attack logic
                    if(board.getPiece(currPos.edit(1,1)) != null) {
                        if(!teamCheck(teamColor,board.getPiece(currPos.edit(1,1)).getTeamColor())) {
                            if (currPos.getRow() == 7) { //promotion logic
                                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, 1), PieceType.ROOK);
                                pieceMoves.add(newMove);
                                ChessMove newMove2 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, 1), PieceType.KNIGHT);
                                pieceMoves.add(newMove2);
                                ChessMove newMove3 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, 1), PieceType.BISHOP);
                                pieceMoves.add(newMove3);
                                ChessMove newMove4 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, 1), PieceType.QUEEN);
                                pieceMoves.add(newMove4);
                            } else { //without promotion
                                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(1, 1));
                                pieceMoves.add(newMove);
                            }
                        }
                    }
                }
            }
        }

        if(teamColor == ChessGame.TeamColor.BLACK) { //black moves (white but negative column movement
            if(currPos.getRow() == 7) {
                for (int i = 1; i < 3; ++i) { //Hop movement
                    if (board.getPiece(currPos.edit(-i, 0)) == null) {
                        ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-i, 0));
                        pieceMoves.add(newMove);
                    }
                    else {
                        break;
                    }
                }
            }
            if(currPos.getRow() != 1) { //normal forward movement
                if(board.getPiece(currPos.edit(-1,0)) == null) {
                    if (currPos.getRow() == 2) { //promotion logic
                            ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, 0), PieceType.ROOK);
                            pieceMoves.add(newMove);
                            ChessMove newMove2 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, 0), PieceType.KNIGHT);
                            pieceMoves.add(newMove2);
                            ChessMove newMove3 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, 0), PieceType.BISHOP);
                            pieceMoves.add(newMove3);
                            ChessMove newMove4 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, 0), PieceType.QUEEN);
                            pieceMoves.add(newMove4);
                    }
                    else { //without promotion
                            ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, 0));
                            pieceMoves.add(newMove);
                    }
                }
                if(0 < currPos.getColumn() - 1) { //left diagonal attack logic
                    if(board.getPiece(currPos.edit(-1,-1)) != null) {
                        if(!teamCheck(teamColor, board.getPiece(currPos.edit(-1,-1)).getTeamColor())) {
                            if(currPos.getRow() == 2) { //promotion logic
                                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, -1), PieceType.ROOK);
                                pieceMoves.add(newMove);
                                ChessMove newMove2 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, -1), PieceType.KNIGHT);
                                pieceMoves.add(newMove2);
                                ChessMove newMove3 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, -1), PieceType.BISHOP);
                                pieceMoves.add(newMove3);
                                ChessMove newMove4 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, -1), PieceType.QUEEN);
                                pieceMoves.add(newMove4);
                            }
                            else { //without promotion
                                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, -1));
                                pieceMoves.add(newMove);
                            }
                        }
                    }
                }
                if(currPos.getColumn() + 1 < 9) { //right diagonal attack logic
                    if(board.getPiece(currPos.edit(-1,1)) != null) {
                        if (!teamCheck(teamColor, board.getPiece(currPos.edit(-1, 1)).getTeamColor())) {
                            if (currPos.getRow() == 2) { //promotion logic
                                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, 1), PieceType.ROOK);
                                pieceMoves.add(newMove);
                                ChessMove newMove2 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, 1), PieceType.KNIGHT);
                                pieceMoves.add(newMove2);
                                ChessMove newMove3 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, 1), PieceType.BISHOP);
                                pieceMoves.add(newMove3);
                                ChessMove newMove4 = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, 1), PieceType.QUEEN);
                                pieceMoves.add(newMove4);
                            } else {
                                ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-1, 1));
                                pieceMoves.add(newMove);
                            }
                        }
                    }
                }
            }
        }
        return pieceMoves;
    }
    private HashSet<ChessMove> bishopMoves(ChessBoard board, ChessPosition myPosition) {
        ChessPositionImp currPos = (ChessPositionImp) myPosition;
        HashSet<ChessMove> pieceMoves = new HashSet<ChessMove>();
        loop : for (int i = 1; i < 8; ++i) { //casts an up-left ray for moves
            if(9 > (currPos.getRow() + i) && (currPos.getColumn() - i) > 0) {//checks if move is in bounds
                if (board.getPiece(currPos.edit(i, -i)) == null) {//checks if the space is empty and if so adds it to avaliable moves
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, -i));
                    pieceMoves.add(newMove);
                }
                else { //if place is full, adds to avaliable moves and breaks the loop
                    if(board.getPiece(currPos.edit(i, -i)) == null) {
                        ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, -i));
                        pieceMoves.add(newMove);
                    }
                    if(board.getPiece(currPos.edit(i, -i)) != null) {
                        if(!teamCheck(teamColor, board.getPiece(currPos.edit(i,-i)).getTeamColor())) {
                            ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, -i));
                            pieceMoves.add(newMove);
                        }
                    }
                    break loop;
                }
            }
            else {

                break loop;
            }
        }

        loop : for (int i = 1; i < 8; ++i) { //casts an up-right ray for moves
            if(currPos.getRow() + i < 9 && currPos.getColumn() + i < 9) {//checks if move is in bounds
                if (board.getPiece(currPos.edit(i, i)) == null) {//checks if the space is empty and if so adds it to avaliable moves
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, i));
                    pieceMoves.add(newMove);
                }
                else { //if place is full, adds to avaliable moves and breaks the loop
                    if(board.getPiece(currPos.edit(i, i)) == null) {
                        ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, i));
                        pieceMoves.add(newMove);
                    }
                    if(board.getPiece(currPos.edit(i, i)) != null) {
                        if(!teamCheck(teamColor, board.getPiece(currPos.edit(i,i)).getTeamColor())) {
                            ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, i));
                            pieceMoves.add(newMove);
                        }
                    }
                    break loop;
                }
            }
            else {

                break loop;
            }
        }

        loop : for (int i = 1; i < 8; ++i) { //casts a down-right ray for moves
            if(currPos.getRow() - i > 0 && 9 > currPos.getColumn() + i) {//checks if move is in bounds
                if (board.getPiece(currPos.edit(-i, i)) == null) {//checks if the space is empty and if so adds it to avaliable moves
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-i, i));
                    pieceMoves.add(newMove);
                }
                else { //if place is full, adds to avaliable moves and breaks the loop
                    if(board.getPiece(currPos.edit(-i, i)) == null) {
                        ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-i, i));
                        pieceMoves.add(newMove);
                    }
                    if(board.getPiece(currPos.edit(-i, i)) != null) {
                        if(!teamCheck(teamColor, board.getPiece(currPos.edit(-i,i)).getTeamColor())) {
                            ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-i, i));
                            pieceMoves.add(newMove);
                        }
                    }
                    break loop;
                }
            }
            else {

                break loop;
            }
        }

        loop : for (int i = 1; i < 8; ++i) { //casts a down-left ray for moves
            if(0 < currPos.getRow() - i && 0 < currPos.getColumn() - i) {//checks if move is in bounds
                if (board.getPiece(currPos.edit(-i, -i)) == null) {//checks if the space is empty and if so adds it to avaliable moves
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-i, -i));
                    pieceMoves.add(newMove);
                }
                else { //if place is full, adds to avaliable moves and breaks the loop
                    if(board.getPiece(currPos.edit(-i, -i)) == null) {
                        ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-i, -i));
                        pieceMoves.add(newMove);
                    }
                    if(board.getPiece(currPos.edit(-i, -i)) != null) {
                        if(!teamCheck(teamColor, board.getPiece(currPos.edit(-i,-i)).getTeamColor())) {
                            ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-i, -i));
                            pieceMoves.add(newMove);
                        }
                    }
                    break loop;
                }
            }
            else {

                break loop;
            }
        }
        return pieceMoves;
    }

    private HashSet<ChessMove> rookMoves(ChessBoard board, ChessPosition myPosition) {
        ChessPositionImp currPos = (ChessPositionImp) myPosition;
        HashSet<ChessMove> pieceMoves = new HashSet<ChessMove>();
        loop:
        for (int i = 1; i < 8; ++i) { //casts a left ray for moves
            if (0 < (currPos.getColumn() - i)) {//checks if move is in bounds
                if (board.getPiece(currPos.edit(0, -i)) == null) {//checks if the space is empty and if so adds it to avaliable moves
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(0, -i));
                    pieceMoves.add(newMove);
                } else { //if place is full, adds to avaliable moves and breaks the loop
                    if (board.getPiece(currPos.edit(0, -i)) == null) {
                        ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(0, -i));
                        pieceMoves.add(newMove);
                    }
                    if (board.getPiece(currPos.edit(0, -i)) != null) {
                        if (!teamCheck(teamColor, board.getPiece(currPos.edit(0, -i)).getTeamColor())) {
                            ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(0, -i));
                            pieceMoves.add(newMove);
                        }
                    }
                    break loop;
                }
            } else {

                break loop;
            }
        }
        loop:
        for (int i = 1; i < 8; ++i) { //casts an up ray for moves
            if (currPos.getRow() + i < 9) {//checks if move is in bounds
                if (board.getPiece(currPos.edit(i, 0)) == null) {//checks if the space is empty and if so adds it to avaliable moves
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, 0));
                    pieceMoves.add(newMove);
                } else { //if place is full, adds to avaliable moves and breaks the loop
                    if (board.getPiece(currPos.edit(i, 0)) == null) {
                        ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, 0));
                        pieceMoves.add(newMove);
                    }
                    if (board.getPiece(currPos.edit(i, 0)) != null) {
                        if (!teamCheck(teamColor, board.getPiece(currPos.edit(i, 0)).getTeamColor())) {
                            ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(i, 0));
                            pieceMoves.add(newMove);
                        }
                    }
                    break loop;
                }
            } else {

                break loop;
            }
        }
        loop:
        for (int i = 1; i < 8; ++i) { //casts a right ray for moves
            if (currPos.getColumn() + i < 9) {//checks if move is in bounds
                if (board.getPiece(currPos.edit(0, i)) == null) {//checks if the space is empty and if so adds it to avaliable moves
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(0, i));
                    pieceMoves.add(newMove);
                } else { //if place is full, adds to avaliable moves and breaks the loop
                    if (board.getPiece(currPos.edit(0, i)) == null) {
                        ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(0, i));
                        pieceMoves.add(newMove);
                    }
                    if (board.getPiece(currPos.edit(0, i)) != null) {
                        if (!teamCheck(teamColor, board.getPiece(currPos.edit(0, i)).getTeamColor())) {
                            ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(0, i));
                            pieceMoves.add(newMove);
                        }
                    }
                    break loop;
                }
            } else {

                break loop;
            }
        }
        loop : for (int i = 1; i < 8; ++i) { //casts a down ray for moves
            if(0 < currPos.getRow() - i) {//checks if move is in bounds
                if (board.getPiece(currPos.edit(-i, 0)) == null) {//checks if the space is empty and if so adds it to avaliable moves
                    ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-i, 0));
                    pieceMoves.add(newMove);
                }
                else { //if place is full, adds to avaliable moves and breaks the loop
                    if(board.getPiece(currPos.edit(-i, 0)) == null) {
                        ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-i, 0));
                        pieceMoves.add(newMove);
                    }
                    if(board.getPiece(currPos.edit(-i, 0)) != null) {
                        if(!teamCheck(teamColor, board.getPiece(currPos.edit(-i,0)).getTeamColor())) {
                            ChessMove newMove = (ChessMove) new ChessMoveImp(currPos, currPos.edit(-i, 0));
                            pieceMoves.add(newMove);
                        }
                    }
                    break loop;
                }
            }
            else {

                break loop;
            }
        }
        return pieceMoves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPieceImp that = (ChessPieceImp) o;
        return teamColor == that.teamColor && pieceType == that.pieceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamColor, pieceType);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        ChessPositionImp currPos = (ChessPositionImp) myPosition;
        HashSet<ChessMove> pieceMoves = new HashSet<ChessMove>();
        switch (pieceType) {
            case KING:
                pieceMoves.addAll(kingMoves(board, myPosition));
                break;

            case QUEEN:
                pieceMoves.addAll(rookMoves(board, myPosition));
                pieceMoves.addAll(bishopMoves(board, myPosition));
                break;

            case BISHOP: //uses the queens diagonal move code
                pieceMoves.addAll(bishopMoves(board, myPosition));
                break;

            case KNIGHT:
                pieceMoves.addAll(knightMoves(board, myPosition));
                break;

            case ROOK: //uses queen hori-verti code
                pieceMoves.addAll(rookMoves(board, myPosition));
                break;

            case PAWN:
                pieceMoves.addAll(pawnMoves(board, myPosition));
                break;

            default:
                break;
        };
        return pieceMoves;
    }

    public String toString() {
        if(teamColor == ChessGame.TeamColor.BLACK) {
            return switch (pieceType) {
                case KING -> "k";
                case QUEEN -> "q";
                case BISHOP -> "b";
                case KNIGHT -> "n";
                case ROOK -> "r";
                case PAWN -> "p";
                default -> " ";
            };
        }
        else if(teamColor == ChessGame.TeamColor.WHITE) {
            return switch (pieceType) {
                case KING -> "K";
                case QUEEN -> "Q";
                case BISHOP -> "B";
                case KNIGHT -> "N";
                case ROOK -> "R";
                case PAWN -> "P";
                default -> " ";
            };
        }
        else {
            return "";
        }
    }
}
