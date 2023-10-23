package com.example.list_items_course.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progamming_question);

        String question = getIntent().getStringExtra("QuestionTextView");
        int questionid = getIntent().getIntExtra("QuestionId", -1);

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
int id;
        String name;


        while (cursor.moveToNext()) {
            name = cursor.getString(cursor.getColumnIndexOrThrow("ProgramStatement"));
            id = cursor.getInt(cursor.getColumnIndexOrThrow("ProgramID"));
            Log.d("TAGs", "onCreate: "+name);

            problemId.add(id);
            dataList.add(name);
        }
        cursor.close();
//        List<Integer> dataIdList = new ArrayList<>();
        thirdAdpatorProgrammingQuestion adapter = new thirdAdpatorProgrammingQuestion( problemId ,dataList, Programming_question.this,question);
        recyclerView.setAdapter(adapter);



    }
}