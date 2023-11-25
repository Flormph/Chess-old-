package requests;

/**
 * RegisterRequest - stores request information for RegisterService
 */
public class RegisterRequest extends Request{
    /**
     * username - name to be assigned to new user
     */
    public String username;
    /**
     * password - password to be assigned to new user
     */
    public String password;
    /**
     * email - email to be assigned to new user
     */
    public String email;

    /**
     * Constructor - sets username, password, and email.
     * @param username username for new user
     * @param password password for new user
     * @param email email for new user
     */
    RegisterRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
