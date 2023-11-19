package database;

import chess.ChessGameImp;
import models.AuthToken;
import models.Game;
import models.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

/**
 * Database - a temporary class to function in place of a remote server for phase 3 of the chess project. It stores the games, users, and other information.
 */
public class Database {
    HashMap<String, Game> games;
    public static HashMap<Integer, String> gameIDs;
    public static HashMap<String, User> users;
    public static HashSet<AuthToken> tokens;
    public static Database database;

    public static Database getInstance() {
        if(database == null) {
            database = new Database();
        }
        return database;
    }

    public boolean clearApplication() {
        deleteAllGames();
        deleteAllAuthTokens();
        deleteAllUsers();
        return games.isEmpty() && users.isEmpty() && tokens.isEmpty();
    }

    public boolean addGame(String gameName, Game game) {
        if(games.containsKey(gameName)) {
            //todo add logic for add game
            return false;
        }
        games.put(gameName, game);
        gameIDs.put(game.getGameID(), gameName);
        return true;
    }

    public boolean deleteGame(String gameName) {
        if(games.containsKey(gameName)) {
            games.remove(gameName);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteAllGames() {
        if(games.isEmpty()) {
            return false;
        }
        else {
            games.clear();
            return true;
        }
    }

    public boolean addUser(User user) {
        if(users.containsKey(user.getUsername())) {
            return false;
        }
        else {
            users.put(user.getUsername(), user);
            return true;
        }
    }

    public boolean deleteUser(String userName) {
        if(users.containsKey(userName)) {
            users.remove(userName);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteAllUsers() {
        if(users.isEmpty()) {
            return false;
        }
        else {
            users.clear();
            return true;
        }
    }

    public boolean addAuthToken(AuthToken token) {
        if(tokens.contains(token)) {
            return false;
        }
        else {
            tokens.add(token);
            return true;
        }
    }

    public boolean deleteAuthToken(AuthToken token) {
        if(tokens.contains(token)) {
            tokens.remove(token);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteAllAuthTokens() {
        if(tokens.isEmpty()) {
            return false;
        }
        else {
            tokens.clear();
            return true;
        }
    }

    public boolean containsGame(String gameName) {
        return games.containsKey(gameName);
    }

    public int getGameID() {
        UUID id = UUID.randomUUID();
        String str = "" + id;
        int myID = str.hashCode();
        String filterStr = "" + myID;
        str = filterStr.replaceAll("-", "");
        return Integer.parseInt(str);
    }

    public Game gameFromID(int id) {
        return games.get(gameIDs.get(id));
    }

    public String getNameFromID(int id) {
        return gameIDs.get(id);
    }

    public boolean gamesIsEmpty() {
        return games.isEmpty();
    }

    public boolean usersContains(String username) {
        return users.containsKey(username);
    }

    public HashMap<String, Game> getGames() {
        return games;
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public void generateToken(String username) {
        users.get(username).generateToken();
    }

    public boolean hasToken(AuthToken token) {
        return tokens.contains(token);
    }

    public void nullifyToken(String username) {
        if(users.containsKey(username)) {
            users.get(username).nullifyToken();
        }
    }

    public boolean isEmpty(){
        return games.isEmpty() && users.isEmpty() && tokens.isEmpty();
    }

}
