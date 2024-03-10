package com.example.awsprimerlogservice;

import static spark.Spark.*;

import java.util.Date;

import com.example.awsprimerlogservice.Mongo.MongoUtil;
import com.example.awsprimerlogservice.Mongo.MssgDAO;
import com.mongodb.client.MongoDatabase;

public class LogService {
    public static void main( String[] args ) {

        port(getPort());
        MongoDatabase database = MongoUtil.getDB();
        MssgDAO mssgDAO = new MssgDAO(database);

        get("/logservice", (req, res) -> {
            System.out.println("LogService has been called");
            res.type("application/json");
            mssgDAO.addMssg(new Date(), req.queryParams("msg"));
            return mssgDAO.listMssg();
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }


}
