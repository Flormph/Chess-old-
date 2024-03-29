package services;

import models.Game;

import java.util.ArrayList;

/**
 * ListGamesResponse - stores responses for ListGamesService
 */

public class ListGamesResponse extends Response {
    /**
     * games - ArrayList of current games
     */
    public ArrayList<Game> games;

    /**
     * Constructor - Success case which updates the game list
     * @param games list of games
     */
    public ListGamesResponse(ArrayList<Game> games) {
        this.games = games;
    }

    /**
     * Constructor - fail case, sets success to "false"
     * @param errorMessage describes the error
     */
    public ListGamesResponse(String errorMessage) {
        super(errorMessage);
    }
}
