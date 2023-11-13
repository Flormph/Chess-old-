package services;

import dataAccess.DataAccessException;
import database.Database;
import models.Game;

import java.util.Objects;

/**
 * JoinGameService - Verifies that the specified game exists, and, if a color is specified, adds the caller as the requested color to the game. If no color is specified the user is joined as an observer. This request is idempotent.
 */
public class JoinGameService {
    /**
     * joinGame - attempts to join game with given request and returns response
     * @param request information for which game to join
     * @return success or fail case of attempt
     */
    public JoinGameResponse joinGame(JoinGameRequest request, Database database) throws DataAccessException {
        if(database.gameIDs.containsKey(request.gameID)) {
            return new JoinGameResponse("Error: game doesn't exist");
        }
        Game game = database.gameFromID(request.gameID);
        if(Objects.equals(request.playerColor, "WHITE")) {
            if(!database.containsGame(game.getGameName())) {
                return new JoinGameResponse("Error: game doesn't exist");
            }
            else {
                if(Objects.equals(game.getWhiteUsername(), "NOWHITE")) {
                    game.setWhiteUsername(request.token.getUsername());
                    return new JoinGameResponse();
                }
                else {
                    return new JoinGameResponse("Error: already taken");
                }
            }
        }
        if(Objects.equals(request.playerColor, "BLACK")) {
            if(!database.containsGame(database.getNameFromID(request.gameID))) {
                return new JoinGameResponse("Error: game doesn't exist");
            }
            else {
                if(Objects.equals(game.getBlackUsername(), "NOBLACK")) {
                    game.setBlackUsername(request.token.getUsername());
                    return new JoinGameResponse();
                }
                else {
                    return new JoinGameResponse("Error: already taken");
                }
            }
        }
        return null;
    }
}
