package handlers;

import dataAccess.DataAccessException;
import requests.JoinGameRequest;
import responses.JoinGameResponse;
import services.JoinGameService;
import spark.Request;
import spark.Response;

public class JoinGameHandler extends Handler{
    public JoinGameHandler() {super();}
    public String Handler(Request Srequest, Response Sresponse) {
        JoinGameRequest request = serializer.fromJson(Srequest.body(), JoinGameRequest.class);
        JoinGameResponse response = null;
        try {
            JoinGameService service = new JoinGameService();
            response = service.joinGame(request);
        } catch (DataAccessException e) {
            //TODO A FLIP OR NOT TODO A FLIP (MAKE RESPONSE OBJECT FOR FAILURE
            response = new JoinGameResponse(e.getMessage());
            Sresponse.body(serializer.toJson(response));
            Sresponse.status(e.getCode());
            return Sresponse.body();
        }
        Sresponse.body(serializer.toJson(response));
        Sresponse.status(200);
        return Sresponse.body();
    }
}
