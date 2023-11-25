package responses;

/**
 * Response - Parent class for all responses
 */
public class Response {
    /**
     * default constructor for parent class;
     */
    Response() {
        successful = true;
    }

    /**
     * Constructor for parent class (sets success to fail)
     * @param errorMessage message for the failure
     */
    Response(String errorMessage) {
        successful = false;
        message = errorMessage;
    }
    boolean successful;
    String message;
}
