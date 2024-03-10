package com.example.awsprimerlogservice;

import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.Spark.get;


public class LogServerFacade {

    public static void main( String[] args ) {

        port(getPort());

        RemoteLogServiceInvoker invoker = new RemoteLogServiceInvoker();

        staticFiles.location("/public");

        get("/logservicefacade", (req, res) -> {
            res.type("application/json");
            return invoker.invoke(req.queryParams("msg"));
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
