package server;

import database.Database;

/**
 * Server - handles the communication and handlers between client and database
 */

public class Server {
    Database database;
    public Server() {
        database = new Database();
    }

    public boolean clear() {
        return database.clearApplication();
    }

    public boolean isEmpty() {
        return true; //TODO finish isEmpty class
    }
}
