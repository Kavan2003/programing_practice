package com.example.list_items_course.view;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.list_items_course.ViewModel.AdapterMainScreen;
import com.example.list_items_course.Model.DatabaseHelper;
import com.example.list_items_course.Model.DummyData;
import com.example.list_items_course.Model.ItemsAdder;
import com.example.list_items_course.R;

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
                "CREATE TABLE IF NOT EXISTS PP_Topic (TopicID INTEGER PRIMARY KEY AUTOINCREMENT, TopicName NVARCHAR(200) NOT NULL, CourseID INTEGER, IsActive BIT, Remarks NVARCHAR(500), IsRead BIT, CONSTRAINT fk_PP_Course FOREIGN KEY (CourseID) REFERENCES PP_Course(courseID));",
                "CREATE TABLE IF NOT EXISTS PP_Program (ProgramID INTEGER PRIMARY KEY AUTOINCREMENT,TopicID INTEGER,ProgramStatement NVARCHAR(5000) NOT NULL ,ProgramSolution NVARCHAR(20000) NOT NULL,  IsRead BIT, Remarks NVARCHAR(500), CONSTRAINT fk_PP_Topic FOREIGN KEY (TopicID) REFERENCES PP_Topic(TopicID));"
        };
        DatabaseHelper databaseHelper = new DatabaseHelper(this, databaseName, createTableSQL);
        database = databaseHelper.getWritableDatabase();
        ItemsAdder itemsAdder = new ItemsAdder(database);

        insertData(itemsAdder);


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
        AdapterMainScreen adapter = new AdapterMainScreen(dataList, imageDataList, DataIDList, MainActivity.this);
        recyclerView.setAdapter(adapter);


    }


    private void insertData(ItemsAdder itemsAdder){

        // Insert sample data into the database
        for (int i = 0; i < DummyData.courseNames.length; i++) {

            if (!courseExists(DummyData.courseNames[i])) {
                long newRowId = itemsAdder.addCourse("PP_Course", DummyData.courseImg[i], DummyData.courseNames[i], DummyData.isActiveValues[i], DummyData.remarks[i]);

                if (newRowId == -1) {
                    Log.d("TableAdd", i + "-> Failed");
                } else {
                    Log.d("TableAdd", i + "-> Success");
                }
            }
        }

// Corresponding CourseID values for PP_Topic

        for (int i = 0; i < DummyData.topicNames.length; i++) {
            if (TopicExists(DummyData.PP_TopicID[i])) {
                long newRowId = itemsAdder.addTopic("PP_Topic", DummyData.topicNames[i], DummyData.topicIsActiveValues[i], DummyData.topicRemarks[i], 0, DummyData.courseIDs[i],DummyData.PP_TopicID[i]);

                if (newRowId == -1) {
                    Log.d("TableAdd", "PP_Topic " + i + "-> Failed");
                } else {
                    Log.d("TableAdd", "PP_Topic " + i + "-> Success");
                }

            }
        }
        for (int i = 0; i < DummyData.topicNames.length; i++) {
            if (TopicExists(DummyData.PP_TopicID[i])) {
                long newRowId = itemsAdder.addTopic("PP_Topic", DummyData.topicNames[i], DummyData.topicIsActiveValues[i], DummyData.topicRemarks[i], 0, DummyData.courseIDs[i],DummyData.PP_TopicID[i]);

                if (newRowId == -1) {
                    Log.d("TableAdd", "PP_Topic " + i + "-> Failed");
                } else {
                    Log.d("TableAdd", "PP_Topic " + i + "-> Success");
                }

            }

        }

        for (int i = 0; i < DummyData.programStatements.length; i++) {
        if(!programExists(DummyData.PP_TopicID[i])){
            long newRowId = itemsAdder.addProgram("PP_Program", DummyData.programStatements[i], DummyData.programSolutions[i], DummyData.programIsReadValues[i], DummyData.programRemarks[i], DummyData.programTopicIDs[i]);

            if (newRowId == -1) {
                Log.d("TableAdd", "PP_Program " + i + "-> Failed");
            } else {
                Log.d("TableAdd", "PP_Program " + i + "-> Success");
            }
        }
        }


    }

    // Helper function to check if a course with the given name exists in the database
    private boolean courseExists(String courseName) {
        Cursor cursor = database.rawQuery("SELECT courseID ,courseImg, courseName,  courseName, Remarks FROM PP_Course WHERE courseName=?", new String[]{courseName});
        boolean exists = cursor.moveToFirst();
        cursor.close();
        Log.d("TAG", "courseExists: " + exists);
        return exists;
    }

    private boolean TopicExists(Integer TopicID) {
        Cursor cursor = database.rawQuery("SELECT * FROM PP_Topic WHERE TopicID=?", new String[]{String.valueOf(TopicID)});
        boolean exists = cursor.moveToFirst();
        Log.d("TAG", "topicExists: " + exists);
        cursor.close();

        return !exists;
    }
    private boolean programExists(Integer programID) {
        Cursor cursor = database.rawQuery("SELECT * FROM PP_Program WHERE ProgramID=?", new String[]{String.valueOf(programID)});
        boolean exists = cursor.moveToFirst();
        Log.d("TAG", "programExists: " + exists);
        cursor.close();

        return exists;
    }
}


