package dataAccess;

import models.User;

import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * user data access object
 */
public class UserDAO {
    public void setName(String name) {
        return;
    }
    public void setPassword(String password) {
        return;
    }
    public void setEmail(String email) {
        return;
    }

    /**
     * getUser - returns user with provided username
     * @param username username of user object to retrieve
     * @return user object with parameter username
     * @throws DataAccessException if username isn't found
     */
    public User getUser(String username) throws DataAccessException {
        return new User();
    }

    /**
     * delete - deletes user with given name from database
     * @param username user to delete
     * @throws DataAccessException thrown if username isn't found
     */
    public void delete(String username) throws DataAccessException {
        return;
    }

    /**
     * deleteAll - deletes all users from the database
     */
    public void deleteAll() {
        return;
    }

    /**
     * listAll - returns a list of all users
     * @return list of all users
     * @throws DataAccessException thrown if there are no users
     */
    public ArrayList<User> listAll() throws DataAccessException{
        return null;
    }
}
