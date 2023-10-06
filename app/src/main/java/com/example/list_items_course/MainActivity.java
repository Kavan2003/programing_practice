package com.example.list_items_course;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Database setup
        String databaseName = "Programming.db";
        String createTableSQL = "CREATE TABLE IF NOT EXISTS PP_Course (" +

                "courseID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "courseImg  NVARCHAR(200) NOT NULL, "+
                "courseName NVARCHAR(200) NOT NULL, " +
                "IsActive BIT, " +
                "Remarks NVARCHAR(500))";

        DatabaseHelper databaseHelper = new DatabaseHelper(this, databaseName, createTableSQL);
        database = databaseHelper.getWritableDatabase();
        ItemsAdder itemsAdder = new ItemsAdder(database);

        // Sample data for courses
                String[] courseImg = {
                        String.valueOf(R.mipmap.c),
                        String.valueOf(R.mipmap.cpp),
                        String.valueOf(R.mipmap.java),
                        String.valueOf(R.mipmap.python),

                };
        String[] courseNames = {
                "C","C++","Java","Python"
        };

        int[] isActiveValues = {1, 0, 1,1};

        String[] remarks = {
                "Good", "Excellent", "Fair", "Fair"
        };

        // Insert sample data into the database
        for (int i = 0; i < courseNames.length; i++) {

            if (!courseExists(courseNames[i])){
                long newRowId = itemsAdder.addCourse("PP_Course",courseImg[i], courseNames[i], isActiveValues[i], remarks[i]);

                if (newRowId == -1) {
                    Log.d("TableAdd", i + "-> Failed");
                } else {
                    Log.d("TableAdd", i + "-> Success");
                }
            }
        }

        // RecyclerView setup
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Retrieve data from the database and display it in the RecyclerView
        List<String> dataList = new ArrayList<>();
        List<Integer> imageDataList = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM PP_Course", null);

        while (cursor.moveToNext()) {
            int image = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow("courseImg")));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("courseName"));
            imageDataList.add(image);
            dataList.add(name);
        }
        cursor.close();

        AdapterMainScreen adapter = new AdapterMainScreen(dataList,imageDataList,MainActivity.this);
        recyclerView.setAdapter(adapter);





         }

    // Helper function to check if a course with the given name exists in the database
    private boolean courseExists(String courseName) {
        Cursor cursor = database.rawQuery("SELECT * FROM PP_Course WHERE courseName=?", new String[]{courseName});
        boolean exists = cursor.moveToFirst();
        cursor.close();
        return exists;
    }

}
