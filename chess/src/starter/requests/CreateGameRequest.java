package requests;

import models.AuthToken;

/**
 * CreateGameRequest - stores request information for CreateGameService
 */
public class CreateGameRequest extends Request{
    /**
     * gameName - name of game to be created
     */
    public String gameName;
    public AuthToken token = null;

    /**
     * Constructor - sets gameName
     * @param gameName name of game
     */
    CreateGameRequest(String gameName) {
        this.gameName = gameName;
    }
    CreateGameRequest(String gameName, AuthToken token) {this.gameName = gameName; this.token = token;}
}
