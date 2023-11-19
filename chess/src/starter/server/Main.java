package server;
import handlers.ClearApplicationHandler;
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

    }
}
