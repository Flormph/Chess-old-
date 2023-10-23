package services;

/**
 * JoinGameService - Verifies that the specified game exists, and, if a color is specified, adds the caller as the requested color to the game. If no color is specified the user is joined as an observer. This request is idempotent.
 */
public class JoinGameService {
    /**
     * joinGame - attempts to join game with given request and returns response
     * @param request information for which game to join
     * @return success or fail case of attempt
     */
    public JoinGameResponse joinGame(JoinGameRequest request) {
        return null;
    }
}
