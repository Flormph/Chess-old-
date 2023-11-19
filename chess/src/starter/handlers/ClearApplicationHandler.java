package handlers;

import com.google.gson.Gson;
import dataAccess.DataAccessException;
import database.Database;
import services.ClearApplicationRequest;
import services.ClearApplicationResponse;
import services.ClearApplicationService;
import spark.Request;
import spark.Response;
import spark.Spark;

/**
 * ClearApplicationHandler - handles the json translation for the clear application service
 */
public class ClearApplicationHandler extends Handler{
    String Json;
    public ClearApplicationHandler() {
        super(null);
    }
    public ClearApplicationHandler(String Json) {
        super(Json);
    }

    public String Handler(Request Srequest, Response Sresponse) {
        Gson serializer = new Gson();
        ClearApplicationRequest request = serializer.fromJson(Srequest.body(), ClearApplicationRequest.class);
        try {
            ClearApplicationService service = new ClearApplicationService();
            service.clearApplication(request);
        } catch(DataAccessException e) {
            //TODO A FLIP OR NOT TODO A FLIP (MAKE RESPONSE OBJECT FOR FAILURE
            ClearApplicationResponse response = new ClearApplicationResponse("Error: description");
            Sresponse.body(serializer.toJson(response));
            Sresponse.status(500);
            return Sresponse.body();
        }
        ClearApplicationResponse response = new ClearApplicationResponse();
        Sresponse.body(serializer.toJson(response));
        Sresponse.status(200);
        return Sresponse.body();
    }

}
