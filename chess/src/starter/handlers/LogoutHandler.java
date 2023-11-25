package handlers;

import dataAccess.DataAccessException;
import requests.LogoutRequest;
import responses.LogoutResponse;
import services.LogoutService;
import spark.Request;
import spark.Response;

public class LogoutHandler extends Handler{
    public LogoutHandler() {super();}

    public String Handler(Request Srequest, Response Sresponse) {
        LogoutRequest request = serializer.fromJson(Srequest.body(), LogoutRequest.class);
        LogoutResponse response = null;
        try {
            LogoutService service = new LogoutService();
            response = service.logout(request);
        } catch (DataAccessException e) {
            //TODO A FLIP OR NOT TODO A FLIP (MAKE RESPONSE OBJECT FOR FAILURE
            response = new LogoutResponse(e.getMessage());
            Sresponse.body(serializer.toJson(response));
            Sresponse.status(e.getCode());
            return Sresponse.body();
        }
        Sresponse.body(serializer.toJson(response));
        Sresponse.status(200);
        return Sresponse.body();
    }
}
