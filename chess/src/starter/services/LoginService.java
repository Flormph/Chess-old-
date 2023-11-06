package services;

import database.Database;

import java.util.Objects;

/**
 * LoginService - Logs in an existing user (returns a new authToken).
 */
public class LoginService {
    /**
     * login - attempts to login an existing user with information from request and returns a success or fail case
     * @param request user information
     * @return response to login attempt
     */
    public LoginResponse login(LoginRequest request, Database database) {
        if(!database.usersContains(request.username)) {
            return new LoginResponse("Error: user not found");
        }
        if(Objects.equals(database.getUser(request.username).getPassword(), request.password)) {
            database.generateToken(request.username);
            database.addAuthToken(database.getUser(request.username).getToken());
            return new LoginResponse(database.getUser(request.username).getUsername(),database.getUser(request.username).getToken());
        }
        return null;
    }
}
