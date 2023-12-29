package com.example.list_items_course.view;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.list_items_course.Model.DatabaseHelper;
import com.example.list_items_course.R;
import com.example.list_items_course.ViewModel.secondAdaptorDisplayScreen;

import java.util.ArrayList;
import java.util.List;

public class DisplayScreen extends AppCompatActivity {
    String itemName;
    int itemid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_screen);
         itemName = getIntent().getStringExtra("itemNameTextView");
        itemid = getIntent().getIntExtra("itemId", -1);


        // Find the TextView in your layout

        TextView itemNameTextView = findViewById(R.id.itemNameTextView);

        // Set the item name in the TextView

        if (itemName != null) {
            itemNameTextView.setText(itemName);
        }  //            itemNameTextView.setText("itemName");


        RecyclerView recyclerView = findViewById(R.id.recyclerViewForDetails);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DatabaseHelper dbHelper = new DatabaseHelper(DisplayScreen.this, "Programming.db", null);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Log.d("TAG", "onCreate: " + itemid);

        Cursor cursor = database.rawQuery("SELECT TopicName , TopicID , IsRead FROM PP_Topic where CourseID  = " + itemid, null);
        List<String> dataList = new ArrayList<>();
        List<Integer> dataIdList = new ArrayList<>();
        List<Integer> topicIsRead = new ArrayList<>();
        int isRead;
        String name;
        int id;
        while (cursor.moveToNext()) {

            name = cursor.getString(cursor.getColumnIndexOrThrow("TopicName"));
isRead = cursor.getInt(cursor.getColumnIndexOrThrow("IsRead"));
            id=cursor.getInt(cursor.getColumnIndexOrThrow("TopicID"));

            dataList.add(name);
            dataIdList.add(id);
            topicIsRead.add(isRead);
        }
        cursor.close();
        secondAdaptorDisplayScreen adapter = new secondAdaptorDisplayScreen(dataIdList,dataList,topicIsRead, DisplayScreen.this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();

        RecyclerView recyclerView = findViewById(R.id.recyclerViewForDetails);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DatabaseHelper dbHelper = new DatabaseHelper(DisplayScreen.this, "Programming.db", null);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
//        Log.d("TAG", "onCreate: " + itemid);

        Cursor cursor = database.rawQuery("SELECT TopicName , TopicID , IsRead FROM PP_Topic where CourseID  = " + itemid, null);
        List<String> dataList = new ArrayList<>();
        List<Integer> dataIdList = new ArrayList<>();
        List<Integer> topicIsRead = new ArrayList<>();
        int isRead;
        String name;
        int id;
        while (cursor.moveToNext()) {

            name = cursor.getString(cursor.getColumnIndexOrThrow("TopicName"));
            isRead = cursor.getInt(cursor.getColumnIndexOrThrow("IsRead"));
            id=cursor.getInt(cursor.getColumnIndexOrThrow("TopicID"));

            dataList.add(name);
            dataIdList.add(id);
            topicIsRead.add(isRead);
        }
        cursor.close();
        secondAdaptorDisplayScreen adapter = new secondAdaptorDisplayScreen(dataIdList,dataList,topicIsRead, DisplayScreen.this);
        recyclerView.setAdapter(adapter);


    }
}