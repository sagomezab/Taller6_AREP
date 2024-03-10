package com.example.awsprimerlogservice.Mongo;

import java.util.Date;

import com.mongodb.client.MongoDatabase;


public class Mongoexample {


        public static void main(String[] args) {
            MongoDatabase database = MongoUtil.getDB();
            MssgDAO mssgDAO = new MssgDAO(database);

            // Create a new user
            mssgDAO.addMssg(new Date(), "AREP");

            // List users
            mssgDAO.listMssg();

            // Delete user
            mssgDAO.deleteMssg("AREP");
        }

}
