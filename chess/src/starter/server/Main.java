package server;
import handlers.*;
import spark.Spark;

public class Main {
    public static void main(String[] args) {
        Spark.port(8080);
        Spark.staticFileLocation("/web");
        establishRoutes();
    }

    public static void establishRoutes() {
        Spark.delete("/db", (request,response)->{
            ClearApplicationHandler handler = new ClearApplicationHandler();
            return handler.Handler(request,response);
        });

        Spark.post("/user",(request,response)->{
            RegisterHandler handler = new RegisterHandler();
            return handler.Handler(request,response);
        });

        Spark.post("/session", (request,response)->{
            LoginHandler handler = new LoginHandler();
            return handler.Handler(request,response);
        });

        Spark.delete("/session", (request,response)->{
            LogoutHandler handler = new LogoutHandler();
            return handler.Handler(request,response);
        });

        Spark.get("/game", (request, response) -> {
            ListGameHandler handler = new ListGameHandler();
            return handler.Handler(request,response);
        });

        Spark.post("/game", (request, response) -> {
            CreateGameHandler handler = new CreateGameHandler();
            return handler.Handler(request,response);
        });

        Spark.put("/game", (request, response) -> {
            JoinGameHandler handler = new JoinGameHandler();
            return handler.Handler(request,response);
        });
    }
}
