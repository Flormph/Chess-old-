package services;

/**
 * CreateGameRequest - stores request information for CreateGameService
 */
public class CreateGameRequest{
    /**
     * gameName - name of game to be created
     */
    String gameName;

    /**
     * Constructor - sets gameName
     * @param gameName name of game
     */
    CreateGameRequest(String gameName) {
        this.gameName = gameName;
    }
}
