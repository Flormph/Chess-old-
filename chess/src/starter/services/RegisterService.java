package services;

import database.Database;
import models.User;

/**
 * RegisterService - Register a new user.
 */
public class RegisterService {
    /**
     * register - attempts to register a user with the given request and returns a success or failcase
     * @param request provided username, password, and email to create a user from
     * @return returns success response or a fail response
     */
    public RegisterResponse register(RegisterRequest request, Database database) {
        if(database.usersContains(request.username)) {
            return new RegisterResponse("Error: username already in use");
        }
        else {
            User newUser = new User(request.username, request.password, request.email);
            database.addUser(newUser);
            return new RegisterResponse(newUser.getUsername(), newUser.getToken());
        }
    }
}

