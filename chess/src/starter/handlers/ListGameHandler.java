package handlers;

import dataAccess.DataAccessException;
import requests.ListGamesRequest;
import responses.ListGamesResponse;
import services.ListGamesService;
import spark.Request;
import spark.Response;

public class ListGameHandler extends Handler{
    public ListGameHandler() {super();}

    public String Handler(Request Srequest, Response Sresponse) {
        ListGamesRequest request = serializer.fromJson(Srequest.body(), ListGamesRequest.class);
        ListGamesResponse response = null;
        try {
            ListGamesService service = new ListGamesService();
            response = service.listGames(request);
        } catch (DataAccessException e) {
            //TODO A FLIP OR NOT TODO A FLIP (MAKE RESPONSE OBJECT FOR FAILURE
            response = new ListGamesResponse(e.getMessage());
            Sresponse.body(serializer.toJson(response));
            Sresponse.status(e.getCode());
            return Sresponse.body();
        }
        Sresponse.body(serializer.toJson(response));
        Sresponse.status(200);
        return Sresponse.body();
    }
}
