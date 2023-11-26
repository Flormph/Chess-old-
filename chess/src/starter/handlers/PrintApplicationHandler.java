package handlers;

import dataAccess.DataAccessException;
import requests.PrintApplicationRequest;
import responses.PrintApplicationResponse;
import services.PrintApplicationService;
import spark.Request;
import spark.Response;

public class PrintApplicationHandler extends Handler{
    public String Handler(Request Srequest, Response Sresponse) {
        PrintApplicationRequest request = serializer.fromJson(Srequest.body(), PrintApplicationRequest.class);
        try {
            PrintApplicationService service = new PrintApplicationService();
            service.printApplication(request);
        } catch(DataAccessException e) {
            //TODO A FLIP OR NOT TODO A FLIP (MAKE RESPONSE OBJECT FOR FAILURE
            PrintApplicationResponse response = new PrintApplicationResponse(e.getMessage());
            Sresponse.body(serializer.toJson(response));
            Sresponse.status(e.getCode());
            return Sresponse.body();
        }
        PrintApplicationResponse response = new PrintApplicationResponse();
        Sresponse.body(serializer.toJson(response));
        Sresponse.status(200);
        return Sresponse.body();
    }
}
