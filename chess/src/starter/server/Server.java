package server;

import database.Database;
import handlers.ClearApplicationHandler;
import services.ClearApplicationResponse;
import services.ClearApplicationRequest;
import services.ClearApplicationService;

/**
 * Server - handles the communication and handlers between client and database
 */

public class Server {
    Database database;
    public Server() {
        database = new Database();
    }

    public String clear(String requestJson) {
        ClearApplicationHandler handler = new ClearApplicationHandler();
        return handler.sendRequest(requestJson, database);
    }

    public boolean isEmpty() {
        return true; //TODO finish isEmpty class
    }
}
