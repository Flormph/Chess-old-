package services;

/**
 * LoginRequest - stores request information for LoginService
 */
public class LoginRequest {
    /**
     * username = login user's username
     */
    String username;
    /**
     * password = login user's password
     */
    String password;

    /**
     * Constructor - sets username and password
     * @param username user's username
     * @param password user's password
     */
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
