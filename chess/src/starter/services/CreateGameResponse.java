package services;

/**
 * CreateGameResponse - extends Response; stores response cases for CreateGameService
 */
public class CreateGameResponse extends Response{
    /**
     * Constructor - success case constructor; sets gameID variable
     * @param gameID ID of newly created game
     */
    public CreateGameResponse(int gameID) {
        this.gameID = gameID;
    }

    /**
     * Constructor - fail case, sets success to "false"
     * @param errorMessage message describing the error
     */
    public CreateGameResponse(String errorMessage) {
        super(errorMessage);
    }

    /**
     * gameID - ID for the created game
     */
    int gameID;
}
