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
        String[] createTableSQL = {
                "CREATE TABLE IF NOT EXISTS PP_Course (courseID INTEGER PRIMARY KEY AUTOINCREMENT, courseImg  NVARCHAR(200) NOT NULL, courseName NVARCHAR(200) NOT NULL, IsActive BIT, Remarks NVARCHAR(500));",
                "CREATE TABLE IF NOT EXISTS PP_Topic (TopicID INTEGER PRIMARY KEY AUTOINCREMENT, TopicName NVARCHAR(200) NOT NULL, CourseID INTEGER, IsActive BIT, Remarks NVARCHAR(500), IsRead BIT, CONSTRAINT fk_PP_Course FOREIGN KEY (CourseID) REFERENCES PP_Course(courseID));"

        };
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
                "C", "C++", "Java", "Python"
        };

        int[] isActiveValues = {1, 0, 1, 1};

        String[] remarks = {
                "Good", "Excellent", "Fair", "Fair"
        };

        // Insert sample data into the database
        for (int i = 0; i < courseNames.length; i++) {

            if (!courseExists(courseNames[i])) {
                long newRowId = itemsAdder.addCourse("PP_Course", courseImg[i], courseNames[i], isActiveValues[i], remarks[i]);

                if (newRowId == -1) {
                    Log.d("TableAdd", i + "-> Failed");
                } else {
                    Log.d("TableAdd", i + "-> Success");
                }
            }
        }
// Sample data for PP_Topic table
        String[] topicNames = {
                "Introduction to C Programming",
                "Basic Data Types in C",
                "Control Flow in C",
                "Functions and Procedures in C",
                "Memory Management in C",

                "Object-Oriented Concepts in C++",
                "Inheritance and Polymorphism in C++",
                "STL Containers in C++",
                "Exception Handling in C++",
                "File I/O in C++",

                "Advanced Java Programming",
                "Multithreading in Java",
                "Database Connectivity in Java",
                "GUI Development in Java",
                "Web Development with Java",

                "Python Fundamentals",
                "Data Structures in Python",
                "File Handling in Python",
                "Python Libraries and Modules",
                "Web Scraping with Python"
        };

        int[] topicIsActiveValues = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        String[] topicRemarks = {
                "Learn the basics of C programming.",
                "Explore different data types in C.",
                "Understand control flow statements.",
                "Learn about functions and procedures.",
                "Explore memory management in C.",

                "Dive into object-oriented concepts.",
                "Understand inheritance and polymorphism.",
                "Explore STL containers in C++.",
                "Learn about exception handling.",
                "Work with file I/O in C++.",

                "Take your Java skills to the next level.",
                "Learn how to work with multithreading.",
                "Connect to databases using Java.",
                "Develop graphical user interfaces in Java.",
                "Explore web development with Java.",

                "Get started with Python.",
                "Explore data structures in Python.",
                "Learn about file handling in Python.",
                "Work with Python libraries and modules.",
                "Learn web scraping with Python."
        };

// Corresponding CourseID values for PP_Topic
        int[] courseIDs = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4};
        for (int i = 0; i < topicNames.length; i++) {
if(!TopicExists(topicNames[i]))

{
    long newRowId = itemsAdder.addTopic("PP_Topic", topicNames[i], topicIsActiveValues[i], topicRemarks[i], 0, courseIDs[i]);

    if (newRowId == -1) {
        Log.d("TableAdd", "PP_Topic " + i + "-> Failed");
    } else {
        Log.d("TableAdd", "PP_Topic " + i + "-> Success");
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
        List<Integer> DataIDList = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT courseID ,courseImg, courseName,  courseName, Remarks FROM PP_Course", null);

        while (cursor.moveToNext()) {
            int image = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow("courseImg")));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("courseName"));
            int dataId = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow("courseID")));

            imageDataList.add(image);
            dataList.add(name);
            DataIDList.add(dataId);
        }
        cursor.close();
        AdapterMainScreen adapter = new AdapterMainScreen(dataList, imageDataList,DataIDList,MainActivity.this);
        recyclerView.setAdapter(adapter);



    }

    // Helper function to check if a course with the given name exists in the database
    private boolean courseExists(String courseName) {
        Cursor cursor = database.rawQuery("SELECT courseID ,courseImg, courseName,  courseName, Remarks FROM PP_Course WHERE courseName=?", new String[]{courseName});
        boolean exists = cursor.moveToFirst();
        cursor.close();
        Log.d("TAG", "courseExists: "+exists);
        return exists;
    }
    private boolean TopicExists(String TopicName) {
        Cursor cursor = database.rawQuery("SELECT * FROM PP_Topic WHERE TopicName=?", new String[]{TopicName});
        boolean exists = cursor.moveToFirst();
        cursor.close();
        return exists;
    }

}
