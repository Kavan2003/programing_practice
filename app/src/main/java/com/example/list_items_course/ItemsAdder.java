package com.example.list_items_course;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class ItemsAdder {
    private final SQLiteDatabase database;

    public ItemsAdder(SQLiteDatabase db) {
        database = db;
    }

    public long addCourse(String tableName, String courseImg, String courseName, int isActive, String remarks) {
        ContentValues values = new ContentValues();
        values.put("courseImg", courseImg);
        values.put("courseName", courseName);
        values.put("IsActive", isActive); // 1 for true, 0 for false
        values.put("Remarks", remarks);

        // Insert the record into the "courses" table
        return database.insert(tableName, null, values);
    }

    public long addTopic(String tableName, String TopicName, int isActive, String remarks, int isRead, Integer courseIDs) {
        ContentValues values = new ContentValues();

        values.put("TopicName", TopicName);
        values.put("courseID", courseIDs);
        values.put("IsActive", isActive); // 1 for true, 0 for false
        values.put("Remarks", remarks);
        values.put("isRead", isRead);


        // Insert the record into the "courses" table
        return database.insert(tableName, null, values);
    }
}
