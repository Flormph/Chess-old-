package services;

import models.AuthToken;

/**
 * LoginResponse - stores Responses for LoginService
 */
public class LoginResponse extends Response{
    /**
     * userName - name for the user
     */
    String userName;
    /**
     * authToken - Authtoken provided for the session
     */
    AuthToken authToken;

    /**
     * Constructor - success case
     * @param userName user's username
     * @param token user's session token
     */
    public LoginResponse(String userName, AuthToken token) {
        this.userName = userName;
        this.authToken = token;
    }

    /**
     * Constructor - fail case, sets success to "false"
     * @param errorMessage describes the error
     */
    public LoginResponse(String errorMessage) {
        super(errorMessage);
    }
}
