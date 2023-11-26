package models;

import chess.ChessGameImp;

/**
 * Game - holds information identifying the game and players. Also holds ChessGame implementation
 */
public class Game {
    /**
     * default constructor
     *
     */
    public Game() {
        gameID = 0;
        whiteUsername = "NoWhite";
        blackUsername = "NoBlack";
        gameName = "NoGameName";
        game = null;
    }

    /**
     * Constructor - constructs with a game name
     * @param gName game name
     * @param gameID game ID generated in service class
     */
    public Game(String gName, int gameID) {
        this.gameID = gameID; //TODO make this get generated or something. Not actually necessary for this phase of the project
        whiteUsername = null;
        blackUsername = null;
        gameName = gName;
        game = new chess.ChessGameImp();
    }

    public String getWhiteUsername() {
        return whiteUsername;
    }
    public String getBlackUsername() {
        return blackUsername;
    }
    public String getGameName() {
        return gameName;
    }
    public ChessGameImp getGame() {
        return game;
    }
    public void setWhiteUsername(String username) {
        this.whiteUsername = username;
    }
    public void setBlackUsername(String blackUsername) {
        this.blackUsername = blackUsername;
    }
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
    public void setGame() {
        return;
    }
    public int getGameID() {return gameID;}

    /**
     * gameID - int identifier for the game
     */
    private int gameID;
    /**
     * whiteUsername - string username of player controlling the white pieces
     */
    private String whiteUsername;
    /**
     * blackUsername - string username of player controlling the black pieces
     */
    private String blackUsername;
    /**
     * gameName - string identifier for the game
     */
    private String gameName;
    /**
     * game - ChessGame implementation
     */
    private ChessGameImp game;
    @Override
    public String toString() {
        return "Game name:" +
                gameName +
                '\n' +
                "Game ID:" +
                gameID +
                '\n' +
                "White User:" +
                whiteUsername +
                '\n' +
                "Black User:" +
                blackUsername +
                '\n' +
                "Current board:" +
                game.getBoard().toString() +
                '\n' +
                "------------" +
                '\n';
    }
}
