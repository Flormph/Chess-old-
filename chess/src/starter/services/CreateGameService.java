package services;

import dataAccess.DataAccessException;
import database.Database;
import models.Game;
import requests.CreateGameRequest;
import responses.CreateGameResponse;

/**
 * CreateGameService - Creates a new game.
 */
public class CreateGameService extends Service{
    /**
     * createGame - attempts to create a game from given request
     * @param request information for created game
     * @return success or fail response from game creation attempt
     */
    public CreateGameResponse createGame(CreateGameRequest request) throws DataAccessException {
        if(!database.hasToken(request.token)) { //incorrect authtoken
            throw new DataAccessException("Error: unauthorized", 401);
        }
        if(request.gameName == null || request.gameName.isEmpty()){
            throw new DataAccessException("Error: bad request", 400);
        }
        if(database.containsGame(request.gameName)) {
            throw new DataAccessException("Error: already taken", 500);
        }
        else {
            int gameID = database.getGameID();
            database.addGame(request.gameName, new Game(request.gameName, gameID));
            return new CreateGameResponse(gameID);
        }
    }
}
