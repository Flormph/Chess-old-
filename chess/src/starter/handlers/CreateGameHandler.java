package handlers;

import com.google.gson.Gson;
import dataAccess.DataAccessException;
import database.Database;
import requests.CreateGameRequest;
import responses.CreateGameResponse;
import services.CreateGameService;
import spark.Request;
import spark.Response;

/**
 * ClearApplicationHandler - handles the json translation for the clear application service
 */
public class CreateGameHandler extends Handler{
    public String Handler(Request Srequest, Response Sresponse) {
        CreateGameRequest request = serializer.fromJson(Srequest.body(), CreateGameRequest.class);
        CreateGameResponse response = null;
        try {
            CreateGameService service = new CreateGameService();
            response = service.createGame(request);
        } catch(DataAccessException e) {
            //TODO A FLIP OR NOT TODO A FLIP (MAKE RESPONSE OBJECT FOR FAILURE
            response = new CreateGameResponse(e.getMessage());
            Sresponse.body(serializer.toJson(response));
            Sresponse.status(e.getCode());
            return Sresponse.body();
        }
        Sresponse.body(serializer.toJson(response));
        Sresponse.status(200);
        return Sresponse.body();
    }
}
