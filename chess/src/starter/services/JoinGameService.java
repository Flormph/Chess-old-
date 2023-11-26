package services;

import dataAccess.DataAccessException;
import database.Database;
import models.Game;
import requests.JoinGameRequest;
import responses.JoinGameResponse;

import java.util.Objects;

/**
 * JoinGameService - Verifies that the specified game exists, and, if a color is specified, adds the caller as the requested color to the game. If no color is specified the user is joined as an observer. This request is idempotent.
 */
public class JoinGameService extends Service{
    /**
     * joinGame - attempts to join game with given request and returns response
     * @param request information for which game to join
     * @return success or fail case of attempt
     */
    public JoinGameResponse joinGame(JoinGameRequest request) throws DataAccessException {
        if(!database.tokensContains(request.token)) { //incorrect authtoken
            throw new DataAccessException("Error: unauthorized", 401);
        }
        if(!Objects.equals(request.playerColor, "WHITE") && !Objects.equals(request.playerColor, "BLACK")) {
            throw new DataAccessException("Error: bad request", 400);
        }
        if(!database.containsGame(database.getNameFromID(request.gameID))) {
            throw new DataAccessException("Error: game doesn't exist", 500);
        }
        Game game = database.gameFromID(request.gameID);
        if(Objects.equals(request.playerColor, "WHITE")) {
            if(!database.containsGame(game.getGameName())) {
                throw new DataAccessException("Error: game doesn't exist", 500);
            }
            else {
                if(Objects.equals(game.getWhiteUsername(), "NOWHITE")) {
                    game.setWhiteUsername(request.token.getUsername());
                    return new JoinGameResponse();
                }
                else {
                    throw new DataAccessException("Error: already taken", 403);
                }
            }
        }
        if(Objects.equals(request.playerColor, "BLACK")) {
            if(!database.containsGame(database.getNameFromID(request.gameID))) {
                throw new DataAccessException("Error: game doesn't exist", 500);
            }
            else {
                if(Objects.equals(game.getBlackUsername(), "NOBLACK")) {
                    game.setBlackUsername(request.token.getUsername());
                    return new JoinGameResponse();
                }
                else {
                    throw new DataAccessException("Error: already taken", 403);
                }
            }
        }
        return null;
    }
}
