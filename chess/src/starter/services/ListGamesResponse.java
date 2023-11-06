package services;

import chess.ChessGame;
import chess.ChessGameImp;
import models.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public ListGamesResponse(HashMap<String, Game> games) {

        for(Map.Entry<String, Game> g: games.entrySet()) {
            Game value = g.getValue();
            if(this.games == null) {
                this.games = new ArrayList<Game>();
            }
            this.games.add(value);
        }
    }

    /**
     * Constructor - fail case, sets success to "false"
     * @param errorMessage describes the error
     */
    public ListGamesResponse(String errorMessage) {
        super(errorMessage);
    }
}
