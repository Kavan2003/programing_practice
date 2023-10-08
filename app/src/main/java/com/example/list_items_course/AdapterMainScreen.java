package com.example.list_items_course;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterMainScreen extends RecyclerView.Adapter<AdapterMainScreen.MyViewHolder> {
    private final List<String> dataList;
    private final List<Integer> imageDataList;
    private final List<Integer> DataIDList;

    private final Context context; // Declare a Context variable

    public AdapterMainScreen(List<String> dataList,List<Integer> ImagedataList, List<Integer> DataIDList, Context context) {
        this.dataList = dataList;
        this.imageDataList = ImagedataList;
        this.DataIDList = DataIDList;
        this.context = context; // Initialize the context variable
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String item = dataList.get(position);
        int image = imageDataList.get(position) ;
        Integer id = DataIDList.get(position);
        holder.textView.setText(item);
        holder.courseNameImageView.setImageResource(image);
        // Add an OnClickListener for the ImageView



        holder.ListItemClick.setOnClickListener(v -> {
            // Handle the click event here
            // Start NextActivity when the ImageView is clicked
            Intent intent = new Intent(context, DisplayScreen.class);
            intent.putExtra("itemId",id);
            intent.putExtra("itemNameTextView",item );
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView arrowImageView;
        LinearLayout ListItemClick ;
        ImageView courseNameImageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            courseNameImageView = itemView.findViewById(R.id.courseNameImageView);
            textView = itemView.findViewById(R.id.courseNameTextView);
            ListItemClick = itemView.findViewById(R.id.ListItemClick);
            arrowImageView = itemView.findViewById(R.id.arrowImageView);
        }
    }
}
