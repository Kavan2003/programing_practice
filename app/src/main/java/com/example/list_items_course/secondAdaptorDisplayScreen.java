
package com.example.list_items_course;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class secondAdaptorDisplayScreen extends RecyclerView.Adapter<secondAdaptorDisplayScreen.MyViewHolder> {
    private final List<String> dataList;
    private final Context context;


    public secondAdaptorDisplayScreen(List<String> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_course_details, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String item = dataList.get(position);
        holder.textView.setText(item);

        holder.ListItemClick.setOnClickListener(v -> {
            Intent intent = new Intent(context, DisplayScreen.class);
            intent.putExtra("itemNameTextView", item);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        LinearLayout ListItemClick;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.TopicNameTextView);
            ListItemClick = itemView.findViewById(R.id.ListTopicClick);
        }
    }
}
