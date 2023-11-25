package server;

import database.Database;
import handlers.ClearApplicationHandler;

/**
 * Server - handles the communication and handlers between client and database
 */

public class Server {
    Database database;
    public Server() {
        database = new Database();
    }
    public boolean isEmpty() {
        return true; //TODO finish isEmpty class
    }
}
