package services;

import database.Database;
import models.Game;

import java.util.UUID;

/**
 * CreateGameService - Creates a new game.
 */
public class CreateGameService {
    /**
     * createGame - attempts to create a game from given request
     * @param request information for created game
     * @return success or fail response from game creation attempt
     */
    public CreateGameResponse createGame(CreateGameRequest request, Database database) {
        if(!database.containsGame(request.gameName)) {
            int gameID = database.getGameID();
            database.addGame(request.gameName, new Game(request.gameName, gameID));
            return new CreateGameResponse(gameID);
        }
        return null;
    }

}
