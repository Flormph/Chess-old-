package services;

import dataAccess.DataAccessException;
import database.Database;

/**
 * ClearApplicationService - Clears the database. Removes all users, games, and authTokens.
 */
public class ClearApplicationService {
    /**
     * clearApplication - attempts to clear database with given request and returns a clearApplication response
     * @param request - A ClearApplicationRequest object containing information for the request.
     * @return ClearApplicationResponse return of either success or failure
     */
    public ClearApplicationResponse clearApplication(ClearApplicationRequest request) throws DataAccessException {
        Database database = Database.getInstance();
        if(!database.isEmpty()) {
            database.clearApplication();
            return new ClearApplicationResponse();
        }
        else {
            return new ClearApplicationResponse("Error: database already empty");
        }
    }
}
