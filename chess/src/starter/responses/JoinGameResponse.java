package responses;

/**
 * JoinGameResponse - extends response; stores response cases for JoinGameService
 */
public class JoinGameResponse extends Response{
    /**
     * Constructor - fail case, sets success to "false"
     * @param errorMessage describes the error
     */
    public JoinGameResponse(String errorMessage) {
        super(errorMessage);
    }
    public JoinGameResponse() {super();};
}
