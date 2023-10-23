package services;

/**
 * JoinGameRequest - stores request information for JoinGameService
 */

public class JoinGameRequest {
    /**
     * playerColor - team color player intends to join (must be "BLACK" or "WHITE")
     */
    String playerColor;
    /**
     * gameID - gameID of the game the player intends to join
     */
    int gameID;

    /**
     * Constructor - sets the request information
     * @param playerColor team color player intends to join (must be "BLACK" or "WHITE")
     * @param gameID gameID of the game the player intends to join
     */
    JoinGameRequest(String playerColor, int gameID) {
        this.playerColor = playerColor;
        this.gameID = gameID;
    }
}
