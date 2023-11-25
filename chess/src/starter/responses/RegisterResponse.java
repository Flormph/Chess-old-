package responses;

import models.AuthToken;

/**
 * RegisterResponse - stores responses for RegisterService
 */

public class RegisterResponse extends Response{
    /**
     * userName - name for the new user
     */
    public String userName;
    /**
     * authToken - AuthToken provided for the session
     */
    public AuthToken authToken;

    /**
     * Constructor - success case sets username and token
     * @param userName name of new user
     * @param token session token for the user
     */
    public RegisterResponse(String userName, AuthToken token) {
        this.userName = userName;
        this.authToken = token;
    }

    /**
     * Constructor - fail case, sets success to "false"
     * @param errorMessage describes the error
     */
    public RegisterResponse(String errorMessage) {
        super(errorMessage);
    }
}
