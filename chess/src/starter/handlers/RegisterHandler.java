package handlers;

import com.google.gson.Gson;
import dataAccess.DataAccessException;
import requests.RegisterRequest;
import responses.RegisterResponse;
import services.*;
import spark.Request;
import spark.Response;

public class RegisterHandler extends Handler {
    public RegisterHandler() {super();}
    public String Handler(Request Srequest, Response Sresponse) {
        RegisterRequest request = serializer.fromJson(Srequest.body(), RegisterRequest.class);
        RegisterResponse response = null;
        try {
            RegisterService service = new RegisterService();
            response = service.register(request);
        } catch (DataAccessException e) {
            //TODO A FLIP OR NOT TODO A FLIP (MAKE RESPONSE OBJECT FOR FAILURE
            response = new RegisterResponse(e.getMessage());
            Sresponse.body(serializer.toJson(response));
            Sresponse.status(e.getCode());
            return Sresponse.body();
        }
        Sresponse.body(serializer.toJson(response));
        Sresponse.status(200);
        return Sresponse.body();
    }
}
