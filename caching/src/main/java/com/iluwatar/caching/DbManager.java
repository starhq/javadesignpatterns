package com.iluwatar.caching;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by starhq on 2017/3/21.
 */
public final class DbManager {

    private static MongoClient mongoClient;
    private static MongoDatabase db;
    private static boolean useMongoDB;

    private static Map<String, UserAccount> virtualDB;

    private DbManager() {
    }

    public static void createVirtualDb() {
        useMongoDB = false;
        virtualDB = new HashMap<>();
    }

    public static void connect() {
        useMongoDB = true;
        mongoClient = new MongoClient();
        db = mongoClient.getDatabase("test");
    }

    public static UserAccount readFromDb(String userId) {
        if (!useMongoDB) {
            if (virtualDB.containsKey(userId)) {
                return virtualDB.get(userId);
            }
            return null;
        }
        if (db == null) {
            connect();
        }
        FindIterable<Document> iterable =
                db.getCollection("user_accounts").find(new Document("userID", userId));
        if (iterable == null) {
            return null;
        }
        Document doc = iterable.first();
        return new UserAccount(userId, doc.getString("userName"), doc.getString("additionalInfo"));
    }

    public static void writeToDb(UserAccount userAccount) {
        if (!useMongoDB) {
            virtualDB.put(userAccount.getUserId(), userAccount);
            return;
        }
        if (db == null) {
            connect();
        }
        db.getCollection("user_accounts").insertOne(new Document("userID", userAccount.getUserId()).append
                ("userName", userAccount.getUserName()).append("additionalInfo", userAccount.getAdditionalInfo()));
    }

    public static void updateDb(UserAccount userAccount) {
        if (!useMongoDB) {
            virtualDB.put(userAccount.getUserId(), userAccount);
            return;
        }
        if (db == null) {
            connect();
        }
        db.getCollection("user_accounts").updateOne(
                new Document("userID", userAccount.getUserId()),
                new Document("$set", new Document("userName", userAccount.getUserName()).append(
                        "additionalInfo", userAccount.getAdditionalInfo())));
    }

    public static void upsertDb(UserAccount userAccount) {
        if (!useMongoDB) {
            virtualDB.put(userAccount.getUserId(), userAccount);
            return;
        }
        if (db == null) {
            connect();
        }
        db.getCollection("user_accounts").updateOne(
                new Document("userID", userAccount.getUserId()),
                new Document("$set", new Document("userID", userAccount.getUserId()).append("userName",
                        userAccount.getUserName()).append("additionalInfo", userAccount.getAdditionalInfo())),
                new UpdateOptions().upsert(true));
    }
}
