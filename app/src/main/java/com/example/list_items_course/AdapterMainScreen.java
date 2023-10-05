package com.example.list_items_course;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterMainScreen extends RecyclerView.Adapter<AdapterMainScreen.MyViewHolder> {
    private List<String> dataList;
    private Context context; // Declare a Context variable

    public AdapterMainScreen(List<String> dataList, Context context) {
        this.dataList = dataList;
        this.context = context; // Initialize the context variable
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String item = dataList.get(position);
        holder.textView.setText(item);

        // Add an OnClickListener for the ImageView
        holder.arrowImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                // Start NextActivity when the ImageView is clicked
                Intent intent = new Intent(context, DisplayScreen.class);

                intent.putExtra("itemNameTextView",item );
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView arrowImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.courseNameTextView);
            arrowImageView = itemView.findViewById(R.id.arrowImageView);
        }
    }
}
