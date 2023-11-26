package services;

import dataAccess.DataAccessException;
import models.Game;
import requests.ListGamesRequest;
import responses.ListGamesResponse;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ListGamesService - Gives a list of all games.
 */
public class ListGamesService extends Service{
    /**
     * listGames - attempts to list games, returns a fail case or success case
     *
     * @param request authorization to be checked before returning list
     * @return success or fail case of attempt
     */
    public ListGamesResponse listGames(ListGamesRequest request) throws DataAccessException {
        if(!database.tokensContains(request.token)) { //incorrect authtoken
            throw new DataAccessException("Error: unauthorized", 401);
        }
        if(database.gamesIsEmpty()) {
            throw new DataAccessException("Error: games list is empty", 500);
        }
        else {
            Collection<Game> values = database.getGames();
            return new ListGamesResponse(new ArrayList<Game>(values));
        }
    }
}
