package handlers;

import com.google.gson.Gson;
import database.Database;
import services.ClearApplicationRequest;
import services.ClearApplicationResponse;
import services.ClearApplicationService;

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

    public String sendRequest(String Json, Database database) {
        var serializer = new Gson();
        ClearApplicationService service = new ClearApplicationService();
        return returnResult(service.clearApplication(serializer.fromJson(Json, ClearApplicationRequest.class), database));
    }

    public String returnResult(ClearApplicationResponse result) {
        var serializer = new Gson();
        return serializer.toJson(result);
    }
}
