package services;

import handlers.ClearApplicationHandler;

/**
 * ClearApplicationResponse - stores possible responses for ClearApplication
 */
public class ClearApplicationResponse extends Response{
    public ClearApplicationResponse() {super();}
    /**
     * Constructor - fail case, sets success to "false"
     * @param errorMessage describes the error
     */
    public ClearApplicationResponse(String errorMessage) {
        super(errorMessage);
    }

}
