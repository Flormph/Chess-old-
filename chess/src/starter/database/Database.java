package database;

import chess.ChessGameImp;
import models.AuthToken;
import models.User;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Database - a temporary class to function in place of a remote server for phase 3 of the chess project. It stores the games, users, and other information.
 */
public class Database {
    HashMap<String, ChessGameImp> games;
    HashMap<String, User> users;
    HashSet<AuthToken> tokens;

    public boolean clearApplication() {
        deleteAllGames();
        deleteAllAuthTokens();
        deleteAllUsers();
        return games.isEmpty() && users.isEmpty() && tokens.isEmpty();
    }

    public boolean addGame(String gameName, ChessGameImp game) {
        if(games.containsKey(gameName)) {
            //todo add logic for add game
            return false;
        }
        games.put(gameName, game);
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

    public boolean isEmpty(){
        return games.isEmpty() && users.isEmpty() && tokens.isEmpty();
    }

}
