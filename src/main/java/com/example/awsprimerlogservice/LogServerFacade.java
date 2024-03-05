package com.example.awsprimerlogservice;

import static spark.Spark.port;
import static spark.Spark.staticFiles;
import static spark.Spark.get;


public class LogServerFacade {

    private static final String LOGSERVICEURL = "http://localhost:5000/logservice";

    public static void main( String[] args ) {
        RemoteLogServiceInvoker invoker = new RemoteLogServiceInvoker(LOGSERVICEURL);

        staticFiles.location("/public");

        get("/logservicefacade", (req, res) -> {
            res.type("application/json");
            return invoker.invoke(args);
        });
    }
}
