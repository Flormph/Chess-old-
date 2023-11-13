package services;

import models.AuthToken;

/**
 * JoinGameRequest - stores request information for JoinGameService
 */

public class JoinGameRequest {
    /**
     * playerColor - team color player intends to join (must be "BLACK" or "WHITE")
     */
    public String playerColor;
    /**
     * gameID - gameID of the game the player intends to join
     */
    public int gameID;
    public AuthToken token;

    /**
     * Constructor - sets the request information
     * @param playerColor team color player intends to join (must be "BLACK" or "WHITE")
     * @param gameID gameID of the game the player intends to join
     */
    JoinGameRequest(String playerColor, int gameID, AuthToken token) {
        this.playerColor = playerColor;
        this.gameID = gameID;
        this.token = token;
    }
}
