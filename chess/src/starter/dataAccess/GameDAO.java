package dataAccess;

import chess.ChessGameImp;
import models.Game;

import java.util.ArrayList;

/**
 * GameDAO - Data Access Object for the game
 */
public class GameDAO {
    /**
     * createGame - creates a new Game in the database
     * @param gameID int identifier for the game
     * @param whiteUsername String username for white player
     * @param blackUsername String username for black player
     * @param gameName String identifier for the game
     * @param game ChessGameImp ChessGame Implementation
     */
    public void createGame(int gameID, String whiteUsername, String blackUsername, String gameName, ChessGameImp game){
        return;
    }
    /**
     * delete - deletes a single game
     * @param gameID deletes game with the given gameID
     * @throws DataAccessException if gameID is not in database
     */
    public void delete(int gameID) throws DataAccessException {
        return;
    }
    /**
     * deleteAll - deletes all games from the database
     */
    public void deleteAll() {
        return;
    }
    /**
     * getGame - returns ChessGameImp
     * @param gameID int game identifier
     * @return returns Game model
     * @throws DataAccessException if gameID is not found in database
     */
    public Game getGame(int gameID) throws DataAccessException {
        return new Game();
    }
    /**
     * setWhite - sets White username
     * @param gameID id of game to update
     * @param whiteName name to be assigned
     * @throws DataAccessException if gameID is not in database
     */
    public void setWhite(int gameID, String whiteName) throws DataAccessException{
        return;
    }
    /**
     * setBlack - sets White username
     * @param gameID id of game to update
     * @param blackName name to be assigned
     * @throws DataAccessException if gameID is not in database
     */
    public void setBlack(int gameID, String blackName) throws DataAccessException{
        return;
    }
    /**
     * setGameName - sets game name
     * @param gameID id of game to update
     * @param gameName name to be assigned
     * @throws DataAccessException if gameID is not in database
     */
    public void setGameName(int gameID, String gameName) throws DataAccessException{
        return;
    }
    /**
     * setGameID - sets game ID
     * @param gameID id of game to update
     * @param newGameID id to be assigned
     * @throws DataAccessException if gameID isn't in database
     */
    public void setGameID(int gameID, int newGameID) throws DataAccessException{
        return;
    }

    /**
     * setGame - updates the chess game implementation
     * @param gameID id of game to update
     * @param game game implementation to update with
     */
    public void setGame(int gameID, Game game) {
        return;
    }

    /**
     * getAllGames - returns a list of all games
     * @return list of games
     */
    public ArrayList<Game> getAllGames() {
        return null;
    }
}
