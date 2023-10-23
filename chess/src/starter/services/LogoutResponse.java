package services;

/**
 * LogoutResponse - Stores Responses for LogoutService
 */
public class LogoutResponse extends Response{
    /**
     * Constructor - fail case, sets success to "false"
     * @param errorMessage describes the error
     */
    public LogoutResponse(String errorMessage) {
        super(errorMessage);
    }
}
