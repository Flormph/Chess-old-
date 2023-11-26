package responses;

public class PrintApplicationResponse extends Response {
    String application = null;
    public PrintApplicationResponse() {super();}
    /**
     * Constructor - fail case, sets success to "false"
     * @param errorMessage describes the error
     */
    public PrintApplicationResponse(String errorMessage) {
        super(errorMessage);
    }
    public PrintApplicationResponse(int dummy, String application) {
        this.application = application;
    }

}
