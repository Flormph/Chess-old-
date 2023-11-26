package services;

import dataAccess.DataAccessException;
import database.Database;
import models.User;
import requests.RegisterRequest;
import responses.RegisterResponse;

/**
 * RegisterService - Register a new user.
 */
public class RegisterService extends Service{
    /**
     * register - attempts to register a user with the given request and returns a success or failcase
     * @param request provided username, password, and email to create a user from
     * @return returns success response or a fail response
     */
    public RegisterResponse register(RegisterRequest request) throws DataAccessException {
        if(request.username == null || request.username.isEmpty() || request.email == null || request.email.isEmpty() || request.password == null || request.password.isEmpty()) {
            throw new DataAccessException("Error: bad request", 400);
        }
        else if(database.users.isEmpty() || database.usersContains(request.username)) {
            throw new DataAccessException("Error: already taken", 403);
        }
        else {
            User newUser = new User(request.username, request.password, request.email);
            database.addUser(newUser);
            return new RegisterResponse(newUser.getUsername(), newUser.getToken());
        }
    }
}

