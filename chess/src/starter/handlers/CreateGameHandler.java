package handlers;

import com.google.gson.Gson;
import database.Database;
import services.CreateGameRequest;
import services.CreateGameResponse;
import services.CreateGameService;

/**
 * ClearApplicationHandler - handles the json translation for the clear application service
 */
public class CreateGameHandler extends Handler{

    public CreateGameHandler(String Json) {
        super(Json);
    }

    public String sendRequest(Database database) {
        var serializer = new Gson();
        CreateGameService service = new CreateGameService();
        return returnResult(service.createGame(serializer.fromJson(Json, CreateGameRequest.class), database));
    }

    public String returnResult(CreateGameResponse result) {
        var serializer = new Gson();
        return serializer.toJson(result);
    }
}
