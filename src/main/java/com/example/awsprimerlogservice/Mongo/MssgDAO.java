package com.example.awsprimerlogservice.Mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MssgDAO {

    private final MongoCollection<Document> MssgsCollection;

    public MssgDAO(MongoDatabase database) {
        this.MssgsCollection = database.getCollection("users");
    }

    public void addMssg(Date date, String mssg) {
        Document newMssg = new Document("date", date)
                .append("message", mssg);
        MssgsCollection.insertOne(newMssg);
    }

    public String listMssg() {
        FindIterable<Document> mssgs = MssgsCollection.find()
            .sort(Sorts.descending("date"))
            .limit(10);

        List<Map<String, Object>> MssgList = new ArrayList<>();
        for (Document mssg : mssgs) {
            Map<String, Object> MssgEntry = new HashMap<>();
            MssgEntry.put("message", mssg.getDate("date"));
            MssgEntry.put("timestamp", mssg.getString("message"));
            MssgList.add(MssgEntry);
            System.out.println(mssg.toJson());
        }

        Gson gson = new Gson();
        String jsonResponse = gson.toJson(MssgList);
        return jsonResponse;
    }

    public void deleteMssg(String mssg) {
        MssgsCollection.deleteOne(eq("message", mssg));
    }
}
