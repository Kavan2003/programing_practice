package com.example.list_items_course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Progamming_question extends AppCompatActivity {

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
        DatabaseHelper dbHelper = new DatabaseHelper(Progamming_question.this, "Programming.db", null);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM PP_Program where TopicID=  "+ questionid , null);
        List<String> dataList = new ArrayList<>();
        String name;


        while (cursor.moveToNext()) {
            name = cursor.getString(cursor.getColumnIndexOrThrow("ProgramStatement"));
            Log.d("TAGs", "onCreate: "+name);


            dataList.add(name);
        }
        cursor.close();
//        List<Integer> dataIdList = new ArrayList<>();
        secondAdaptorDisplayScreen adapter = new secondAdaptorDisplayScreen( null ,dataList, Progamming_question.this);
        recyclerView.setAdapter(adapter);



    }
}