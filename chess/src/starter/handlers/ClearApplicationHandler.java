package handlers;

import com.google.gson.Gson;
import services.ClearApplicationRequest;
import services.ClearApplicationResponse;
import services.ClearApplicationService;

/**
 * ClearApplicationHandler - handles the json translation for the clear application service
 */
public class ClearApplicationHandler {
    ClearApplicationHandler() {
        ClearApplicationRequest clearRequest = new ClearApplicationRequest();
        ClearApplicationService service = new ClearApplicationService();
        ClearApplicationResponse result = service.clearApplication(clearRequest);
    }

    public String returnResult(ClearApplicationResponse result) {
        var serializer = new Gson();
        return serializer.toJson(result);
    }
}
