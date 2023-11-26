package database;

import chess.ChessGameImp;
import models.AuthToken;
import models.Game;
import models.User;

import java.util.*;

/**
 * Database - a temporary class to function in place of a remote server for phase 3 of the chess project. It stores the games, users, and other information.
 */
public class Database {
    public static ArrayList<Game> games;
    public static ArrayList<User> users;
    public static Map<String, AuthToken> tokens;
    public static Database database;

    public static Database getInstance() {
        if(database == null) {
            database = new Database();
        }
        return database;
    }

    public Database() {
        if(games == null) {
            games = new ArrayList<Game>();
        }
        if(users == null) {
            users = new ArrayList<User>();
        }
        if(tokens == null) {
            tokens = new HashMap<String, AuthToken>();
        }
    }

    public boolean clearApplication() {
        deleteAllGames();
        deleteAllAuthTokens();
        deleteAllUsers();
        return games.isEmpty() && users.isEmpty() && tokens.isEmpty();
    }

    public boolean addGame(String gameName, Game game) {
        for(Game g: games) {
            if(Objects.equals(g.getGameName(), gameName)) {
                //todo add logic for add game
                return false;
            }
        }

        games.add(game);
        return true;
    }

    public boolean deleteGame(String gameName) {
        for(Game g: games) {
            if(Objects.equals(g.getGameName(), gameName)) {
                games.remove(g);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAllGames() {
        games.clear();
        return true;
    }

    public boolean addUser(User user) {
        for(User u: users) {
            if (Objects.equals(u.getUsername(), user.getUsername())) {
                return false;
            }
        }
        users.add(user);
        return true;
    }

    public boolean deleteUser(String userName) {
        for(User u: users) {
            if (Objects.equals(u.getUsername(), userName)) {
                users.remove(u);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAllUsers() {
        users.clear();
        return true;
    }

    public boolean addAuthToken(String userName, AuthToken token) {
        if(tokens.containsValue(token)) {
            return false;
        }
        else {
            tokens.put(userName, token);
            return true;
        }
    }

    public boolean deleteAuthToken(String userName, AuthToken token) {
        if(tokens.containsValue(token)) {
            tokens.remove(userName, token);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteAllAuthTokens() {
        tokens.clear();
        return true;
    }

    public boolean containsGame(String gameName) {
        for(Game g: games) {
            if(Objects.equals(g.getGameName(), gameName)) {
                return true;
            }
        }
        return false;
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
        for(Game g: games) {
            if(g.getGameID() == id) {
                return g;
            }
        }
        return null;
    }

    public String getNameFromID(int id) {
        for(Game g: games) {
            if(g.getGameID() == id) {
                return g.getGameName();
            }
        }
        return null;
    }

    public boolean gamesIsEmpty() {
        return games.isEmpty();
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public boolean usersContains(String username) {
        for(User u: users) {
            if(Objects.equals(u.getUsername(), username)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String username) {
        for(User u: users) {
            if(Objects.equals(u.getUsername(), username)) {
                return u;
            }
        }
        return null;
    }

    public void generateToken(String username) {
        this.getUser(username).generateToken();
    }

    public boolean tokensContains(AuthToken token) {
        for(AuthToken t: tokens.values()) {
            if(Objects.equals(t.getAuthToken(), token.getAuthToken())) return true;
        }
        return false;
    }

    public void nullifyToken(String username) {
        if (this.usersContains(username)) {
            tokens.remove(username);
        }
    }

    public boolean isEmpty(){
        return games.isEmpty() && users.isEmpty() && tokens.isEmpty();
    }
    public String printApplication() {
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Users:");
        sb.append('\n');
        for(User u: users) {
            sb.append(u.toString());
            sb.append('\n');
        }

        sb.append("Games:");
        sb.append('\n');
        for(Game g: games) {
            sb.append(g.toString());
            sb.append('\n');
        }

        sb.append("Tokens:");
        sb.append('\n');
        for(String t: tokens.keySet()) {
            sb.append('\t');
            sb.append("Username:");
            sb.append(t);
            sb.append('\n');
            sb.append('\t');
            sb.append("Token:");
            sb.append(tokens.get(t).toString());
            sb.append('\n');
        }

        return sb.toString();
    }
//todo add a to string method for debugging purposes
}
