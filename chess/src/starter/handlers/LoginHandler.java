package handlers;

import dataAccess.DataAccessException;
import requests.LoginRequest;
import responses.LoginResponse;
import services.LoginService;
import spark.Request;
import spark.Response;

public class LoginHandler extends Handler{
    public LoginHandler() {super();}

    public String Handler(Request Srequest, Response Sresponse) {
        LoginRequest request = serializer.fromJson(Srequest.body(), LoginRequest.class);
        LoginResponse response = null;
        try {
            LoginService service = new LoginService();
            response = service.login(request);
        } catch (DataAccessException e) {
            //TODO A FLIP OR NOT TODO A FLIP (MAKE RESPONSE OBJECT FOR FAILURE
            response = new LoginResponse(e.getMessage());
            Sresponse.body(serializer.toJson(response));
            Sresponse.status(e.getCode());
            return Sresponse.body();
        }
        Sresponse.body(serializer.toJson(response));
        Sresponse.status(200);
        return Sresponse.body();
    }

}
