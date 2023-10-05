package com.example.list_items_course;

import static com.example.list_items_course.R.id.arrowImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Database setup
        String databaseName = "Programming.db";
        String tableName = "PP_Course";
        String createTableSQL = "CREATE TABLE IF NOT EXISTS PP_Course (" +
                "courseID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "courseName NVARCHAR(200) NOT NULL, " +
                "IsActive BIT, " +
                "Remarks NVARCHAR(500))";

        DatabaseHelper databaseHelper = new DatabaseHelper(this, databaseName, createTableSQL);
        database = databaseHelper.getWritableDatabase();
        ItemsAdder itemsAdder = new ItemsAdder(database);

        // Sample data for courses
        String[] courseNames = {
                "Java", "Python", "C++", "JavaScript", "Swift",
                "SQL", "HTML/CSS", "Ruby", "Kotlin", "PHP",
                "React", "Angular", "Vue.js", "Node.js", "Go"
        };

        int[] isActiveValues = {1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1};

        String[] remarks = {
                "Good", "Excellent", "Fair", "Great", "Average",
                "Good", "Average", "Excellent", "Great", "Fair",
                "Good", "Great", "Average", "Excellent", "Good"
        };

        // Insert sample data into the database
        for (int i = 0; i < courseNames.length; i++) {

            if (!courseExists(courseNames[i])){
                long newRowId = itemsAdder.addCourse("PP_Course", courseNames[i], isActiveValues[i], remarks[i]);

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
        Cursor cursor = database.rawQuery("SELECT * FROM PP_Course", null);

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("courseName"));
            dataList.add(name);
        }
        cursor.close();

        AdapterMainScreen adapter = new AdapterMainScreen(dataList,MainActivity.this);
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
