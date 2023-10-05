package com.example.list_items_course;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_screen);
        String itemName = getIntent().getStringExtra("itemNameTextView");

        // Find the TextView in your layout
        TextView itemNameTextView = findViewById(R.id.itemNameTextView);

        // Set the item name in the TextView

        if (itemName != null) {
            itemNameTextView.setText(itemName);
        }
        else {
            itemNameTextView.setText("itemName");
        }
    }
}