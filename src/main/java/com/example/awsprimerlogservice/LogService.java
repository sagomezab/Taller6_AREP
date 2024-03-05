package com.example.awsprimerlogservice;

import static spark.Spark.*;

public class LogService {
    public static void main( String[] args ) {
        port(5000);
        get("/logservice", (req, res) -> {
            System.out.println("LogService has been called");
            res.type("application/json");
            return "{\"LogId\":\"3-05-2024\"}";
        });
    }
}
