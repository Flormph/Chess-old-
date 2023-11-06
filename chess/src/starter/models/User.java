package models;

/**
 * User - each player's information is stored in this class
 */
public class User {

    /**
     * Constructor - default constructor sets null values;
     */
    public User() {
        username = null;
        password = null;
        email = null;
        AuthToken token = null;
    }

    /**
     * Constructor - sets name, password, and email
     * @param name user name
     * @param password user password
     * @param email user email
     */
    public User(String name, String password, String email) {
        username = name;
        this.password = password;
        this.email = email;
        AuthToken token = new AuthToken(username);
    }
    /**
     * username - name of the user
     */
    private String username;
    /**
     * password - user password for login
     */
    private String password; //user password necessary to login
    /**
     * email - user contace email
     */
    private String email; //user email
    private AuthToken token;
    public void setUsername() {
        return;
    }
    public void setPassword() {
        return;
    }
    public void setEmail() {
        return;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public AuthToken getToken() {return token;};
    public void generateToken() {token = new AuthToken(username);}
    public void nullifyToken() {token = null;}
}
