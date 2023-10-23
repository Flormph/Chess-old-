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
        return null;
    }
    public String getPassword() {
        return null;
    }
    public String getEmail() {
        return null;
    }
}
