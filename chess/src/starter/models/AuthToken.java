package models;

import java.util.UUID;

/**
 * Authtoken - temporary session information for a user
 */
public class AuthToken {
    /**
     * authToken - session token identifying the user
     */
    private String authToken;
    /**
     * username - user identified by the authToken
     */
    private String username;

    /**
     * Constructor - sets username and generates authToken
     * @param username user's username
     */

    public AuthToken(String username) {
        this.username = username;
        this.authToken = UUID.randomUUID().toString();
    }
    public String getUsername() {
        return username;
    }
}

