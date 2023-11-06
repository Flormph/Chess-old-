package services;

import database.Database;

/**
 * LogoutService - Logs out the user represented by the authToken.
 */
public class LogoutService {
    /**
     * logout - attempts Logs out the user represented by the request and returns a response
     * @param request user information to logout
     * @return success or fail response for the attempt
     */
    public LogoutResponse logout(LogoutRequest request, Database database) {
        if(!database.hasToken(request.token)) {
           return new LogoutResponse("Error: could not logout user, incorrect authToken");
        }
        else {
            if(!database.usersContains(request.token.getUsername())) {
                return new LogoutResponse("Error: token found but user not found");
            }
            database.nullifyToken(request.token.getUsername());
            database.deleteAuthToken(request.token);
            return new LogoutResponse();
        }
    }
}
