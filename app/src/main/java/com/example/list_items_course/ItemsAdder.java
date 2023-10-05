package com.example.list_items_course;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class ItemsAdder {
    private SQLiteDatabase database;

    public ItemsAdder(SQLiteDatabase db) {
        database = db;
    }

    public long addCourse(String tableName,String courseName, int isActive, String remarks) {
        ContentValues values = new ContentValues();
        values.put("courseName", courseName);
        values.put("IsActive", isActive); // 1 for true, 0 for false
        values.put("Remarks", remarks);

        // Insert the record into the "courses" table
        return database.insert(tableName, null, values);
    }
}
