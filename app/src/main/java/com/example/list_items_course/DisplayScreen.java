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

public class DisplayScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_screen);
        String itemName = getIntent().getStringExtra("itemNameTextView");
        Integer itemid = getIntent().getIntExtra("itemId",-1);




        // Find the TextView in your layout

        TextView itemNameTextView = findViewById(R.id.itemNameTextView);

        // Set the item name in the TextView

        if (itemName != null) {
            itemNameTextView.setText(itemName);
        }
        else {
            itemNameTextView.setText("itemName");
        }

         RecyclerView recyclerView = findViewById(R.id.recyclerViewForDetails);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DatabaseHelper dbHelper = new DatabaseHelper(DisplayScreen.this,"Programming.db",null);
       SQLiteDatabase database = dbHelper.getWritableDatabase();
        Log.d("TAG", "onCreate: "+itemid);
        Cursor  cursor = database.rawQuery("SELECT TopicName FROM PP_Topic where CourseID  = "+itemid , null);
        List<String> dataList = new ArrayList<>();
        String name;
        while (cursor.moveToNext()) {

             name = cursor.getString(cursor.getColumnIndexOrThrow("TopicName"));

            dataList.add(name);
        }
        cursor.close();
        secondAdaptorDisplayScreen adapter = new secondAdaptorDisplayScreen(dataList,DisplayScreen.this);
        recyclerView.setAdapter(adapter);



    }
}