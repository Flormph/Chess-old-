package services;

import models.AuthToken;

/**
 * LogoutRequest - stores request information for LogoutService
 */

public class LogoutRequest {
    public AuthToken token;
    LogoutRequest(AuthToken token) {
        this.token = token;
    }
}
