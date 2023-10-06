package com.example.list_items_course;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;

    public DatabaseHelper(Context context, String databaseName, String createTableSQL) {
        super(context, databaseName, null, DATABASE_VERSION);
        this.createTableSQL = createTableSQL;
    }

    private final String createTableSQL;

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the table when the database is first created
        db.execSQL(createTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades if needed
        // This method is called when the database version changes.
        // You can implement migration logic here if necessary.
    }
}
