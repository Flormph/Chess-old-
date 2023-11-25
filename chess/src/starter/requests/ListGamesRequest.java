package requests;

import models.AuthToken;

/**
 * ListGamesRequest - stores request information for ListGamesService
 */

public class ListGamesRequest extends Request{
    public AuthToken token = null;
    ListGamesRequest() {
        token = null;
    }
    ListGamesRequest(AuthToken token) {
        this.token = token;
    }
}
