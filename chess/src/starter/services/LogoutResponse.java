package services;

/**
 * LogoutResponse - Stores Responses for LogoutService
 */
public class LogoutResponse extends Response{
    public LogoutResponse() {super();}
    /**
     * Constructor - fail case, sets success to "false"
     * @param errorMessage describes the error
     */
    public LogoutResponse(String errorMessage) {
        super(errorMessage);
    }
}
