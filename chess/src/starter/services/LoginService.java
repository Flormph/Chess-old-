package services;

import database.Database;
import requests.LoginRequest;
import responses.LoginResponse;
import dataAccess.DataAccessException;

import java.util.Objects;

/**
 * LoginService - Logs in an existing user (returns a new authToken).
 */
public class LoginService extends Service{
    /**
     * login - attempts to login an existing user with information from request and returns a success or fail case
     * @param request user information
     * @return response to login attempt
     */
    public LoginResponse login(LoginRequest request) throws DataAccessException{ //username not in database
        if(!database.usersContains(request.username)) {
            throw new DataAccessException("Error: user not found", 500);
        }
        else if(!Objects.equals(database.getUser(request.username).getPassword(), request.password)) { //incorrect password
            throw new DataAccessException("Error: unauthorized", 401);
        }
        if(Objects.equals(database.getUser(request.username).getPassword(), request.password)) { //successful login
            database.generateToken(request.username);
            database.addAuthToken(request.username, database.getUser(request.username).getToken());
            return new LoginResponse(database.getUser(request.username).getUsername(),database.getUser(request.username).getToken());
        }
        return null;
    }
}
