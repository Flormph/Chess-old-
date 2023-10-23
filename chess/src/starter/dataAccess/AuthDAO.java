package dataAccess;

import models.AuthToken;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Map;


/**
 * AuthDAO - Data Access Object for AuthToken class
 */
public class AuthDAO {
    /**
     * Stores a map of authToken keys and objects.
     */
    Map<String, AuthToken> authTokens;

    /**
     * generateToken - generates an authToken token
     * @return generated token string
     */
    public String generateToken() {
        return "<generated_token>";
    }

    public void setUsername(String authTokenIdentifier, String newUserName) {
        return;
    }

    public String getUsername(String authTokenIdentifier) {
        return "<returned_username>";
    }

    public String getToken(String authTokenIdentifier) {
        return "<returned_token>";
    }
    /**
     * delete - deletes a single authToken
     * @param userName tied to the token to be deleted
     * @throws DataAccessException - throws an exception if the authToken is not found.
     */
    public void delete(String userName) throws DataAccessException {
        return;
    }
    /**
     * deleteAll - deletes all authTokens in the database
     */
    public void deleteAll() {
        return;
    }
    /**
     * createAuthToken - creates a new authToken in the database
     * @param userName  userName for the created authToken
     * @param token     token identifier for the created authToken
     * @throws DataAccessException thrown if token is already present
     */
    public AuthToken createAuthToken(String userName, String token) throws DataAccessException {
        return null;
    }

    /**
     * findAuthToken - Checks if authtoken is in database
     * @param token token to look for
     * @return token found
     * @throws DataAccessException thrown if token isn't in database
     */
    public AuthToken findAuthToken(AuthToken token) throws DataAccessException {
        return null;
    }

    /**
     * listAll - returns a list of all AuthTokens
     * @return list of AuthTokens
     * @throws DataAccessException thrown if there are no authTokens
     */
    public ArrayList<AuthToken> listAll() throws DataAccessException{
        return null;
    }
}
