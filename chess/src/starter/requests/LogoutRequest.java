package requests;

import models.AuthToken;

/**
 * LogoutRequest - stores request information for LogoutService
 */

public class LogoutRequest extends Request{
    public AuthToken token;
    LogoutRequest(AuthToken token) {
        this.token = token;
    }
}
