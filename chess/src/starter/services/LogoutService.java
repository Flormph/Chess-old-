package services;

import dataAccess.DataAccessException;
import requests.LogoutRequest;
import responses.LogoutResponse;

/**
 * LogoutService - Logs out the user represented by the authToken.
 */
public class LogoutService extends Service{
    /**
     * logout - attempts Logs out the user represented by the request and returns a response
     *
     * @param request user information to logout
     * @return success or fail response for the attempt
     */
    public LogoutResponse logout(LogoutRequest request) throws DataAccessException {
        if(!database.tokensContains(request.token)) { //incorrect authtoken
           throw new DataAccessException("Error: unauthorized", 401);
        }
        else {
            if(!database.usersContains(request.token.getUsername())) { //user not logged in
                throw new DataAccessException("Error: user not found", 500);
            }
            else { //successful logout
                database.nullifyToken(request.token.getUsername());
                database.deleteAuthToken(request.token.getUsername(), request.token);
                return new LogoutResponse();
            }
        }
    }
}
