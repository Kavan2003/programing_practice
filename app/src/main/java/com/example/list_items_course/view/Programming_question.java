package com.example.list_items_course.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.list_items_course.Model.DatabaseHelper;
import com.example.list_items_course.R;
import com.example.list_items_course.ViewModel.secondAdaptorDisplayScreen;
import com.example.list_items_course.ViewModel.thirdAdpatorProgrammingQuestion;

import java.util.ArrayList;
import java.util.List;

public class Programming_question extends AppCompatActivity {
    int questionid;
    String question;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progamming_question);

         question = getIntent().getStringExtra("QuestionTextView");
        questionid = getIntent().getIntExtra("QuestionId", -1);

        TextView itemNameTextView = findViewById(R.id.QuestionTextView);

        // Set the item name in the TextView

        if (question != null) {
            itemNameTextView.setText(question);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerViewForDetails);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DatabaseHelper dbHelper = new DatabaseHelper(Programming_question.this, "Programming.db", null);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM PP_Program where TopicID=  "+ questionid , null);
        List<String> dataList = new ArrayList<>();
        List<Integer> problemId = new ArrayList<>();
        List<Integer> problemIsRead = new ArrayList<>();

        int id;
        String name;
int isread;
        while (cursor.moveToNext()) {
            name = cursor.getString(cursor.getColumnIndexOrThrow("ProgramStatement"));
            id = cursor.getInt(cursor.getColumnIndexOrThrow("ProgramID"));
           isread = cursor.getInt(cursor.getColumnIndexOrThrow("IsRead"));
            Log.d("TAGs", "onCreate: "+name);

            problemId.add(id);
            dataList.add(name);
            problemIsRead.add(isread);
        }
        cursor.close();
//        List<Integer> dataIdList = new ArrayList<>();
        thirdAdpatorProgrammingQuestion adapter = new thirdAdpatorProgrammingQuestion( problemId ,dataList, problemIsRead, Programming_question.this,question);
        recyclerView.setAdapter(adapter);



    }

    @Override
    protected void onResume() {
        super.onResume();


        RecyclerView recyclerView = findViewById(R.id.recyclerViewForDetails);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DatabaseHelper dbHelper = new DatabaseHelper(Programming_question.this, "Programming.db", null);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM PP_Program where TopicID=  "+ questionid , null);
        List<String> dataList = new ArrayList<>();
        List<Integer> problemId = new ArrayList<>();
        List<Integer> problemIsRead = new ArrayList<>();

        int id;
        String name;
        int isread;
        while (cursor.moveToNext()) {
            name = cursor.getString(cursor.getColumnIndexOrThrow("ProgramStatement"));
            id = cursor.getInt(cursor.getColumnIndexOrThrow("ProgramID"));
            isread = cursor.getInt(cursor.getColumnIndexOrThrow("IsRead"));
            Log.d("TAGs", "onCreate: "+name);

            problemId.add(id);
            dataList.add(name);
            problemIsRead.add(isread);
        }
        cursor.close();
        //check is all problemIsRead is 1
        if(problemIsRead.contains(0))
        {
            database.execSQL("UPDATE PP_Topic SET IsRead = 0 WHERE TopicID = "+questionid);


        }
        else
        {
            database.execSQL("UPDATE PP_Topic SET IsRead = 1 WHERE TopicID = "+questionid);
        }
//        List<Integer> dataIdList = new ArrayList<>();
        thirdAdpatorProgrammingQuestion adapter = new thirdAdpatorProgrammingQuestion( problemId ,dataList, problemIsRead, Programming_question.this,question);
        recyclerView.setAdapter(adapter);

    }
}