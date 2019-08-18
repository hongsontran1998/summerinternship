package com.demo.util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDbConnectionUtil {
    private static final String HOST = "localhost";
    private static final String DATABASE_NAME = "mydatabase";
    private static final int PORT = 27017;

    public static MongoDatabase getMongoDatabase() {
        return getMongoClient().getDatabase(DATABASE_NAME);
    }
    public static MongoCollection<Document> getMongoCollection(String collectionName) {
        return getMongoDatabase().getCollection(collectionName);
    }
    /*
        let's use these 3 function to get a MongoCollection<Document>
        because use should close the connection to mongodb (MongoClient mongoClient) in your code
    */
    public static MongoClient getMongoClient() {
        return new MongoClient(HOST, PORT);
    }
    public static MongoCollection<Document> getMongoCollection(MongoClient mongoClient, String collectionName) {
        return getMongoDatabase(mongoClient).getCollection(collectionName);
    }
    public static MongoDatabase getMongoDatabase(MongoClient mongoClient) {
        return mongoClient.getDatabase(DATABASE_NAME);
    }
}
