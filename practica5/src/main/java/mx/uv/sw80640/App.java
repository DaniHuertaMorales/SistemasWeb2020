package mx.uv.sw80640;

import static spark.Spark.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        port(80);
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/", (req, res) -> "Hola desde Spark");
        get("/hola", (req, res) -> {
            System.out.println("Request: " + req.queryParams());
            System.out.println("Request: " + req.queryParams("PrmEmail"));
            System.out.println("Request: " + req.queryParams("PrmPassword"));
            System.out.println("Request: " + req.contentType());
            return "Hola" + req.queryParams("PrmEmail" + "desde Spark");
        });

        post("/adios", (req, res) -> {
            System.out.println("Request: " + req.queryParams());
            System.out.println("Request: " + req.queryParams("PrmEmail"));
            System.out.println("Request: " + req.queryParams("PrmPassword"));
            return "Adios" + req.queryParams("PrmEmail" + "desde Spark");
        });
    }
}
