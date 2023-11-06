package services;

import database.Database;
import models.Game;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ListGamesService - Gives a list of all games.
 */
public class ListGamesService {
    /**
     * listGames - attempts to list games, returns a fail case or success case
     * @param request authorization to be checked before returning list
     * @return success or fail case of attempt
     */
    public ListGamesResponse listGames(ListGamesRequest request, Database database) {
        if(database.gamesIsEmpty()) {
            return new ListGamesResponse("Error: games list is empty");
        }
        else {
            Collection<Game> values = database.getGames().values();
            return new ListGamesResponse(new ArrayList<Game>(values));
        }
    }
}
