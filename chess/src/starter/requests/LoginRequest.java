package requests;

/**
 * LoginRequest - stores request information for LoginService
 */
public class LoginRequest extends Request{
    /**
     * username = login user's username
     */
    public String username;
    /**
     * password = login user's password
     */
    public String password;

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
