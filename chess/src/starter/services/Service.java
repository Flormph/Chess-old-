package services;

import database.Database;

public class Service {
    Database database = null;
    protected Service() {
        database = Database.getInstance();
    }
}
