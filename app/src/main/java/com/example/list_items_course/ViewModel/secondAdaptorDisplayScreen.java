
package com.example.list_items_course.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.list_items_course.R;
import com.example.list_items_course.view.Programming_question;

import java.util.List;
import java.util.Locale;

public class secondAdaptorDisplayScreen extends RecyclerView.Adapter<secondAdaptorDisplayScreen.MyViewHolder> {
    private final List<String> dataList;
//    private final List<String> dataTopicList;

    List<Integer> dataIdList ;
    private final Context context;


    public secondAdaptorDisplayScreen(List<Integer> dataIdList , List<String> dataList, Context context ) {

        this.dataList = dataList;
        this.dataIdList = dataIdList;

        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_topic, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String item = dataList.get(position);
        holder.textView.setText(item);


            holder.TopicSerialNumberTextView.setText(String.format(Locale.US, "%d.", position + 1));




        holder.ListItemClick.setOnClickListener(v -> {
            Intent intent = new Intent(context, Programming_question.class);


            intent.putExtra("QuestionTextView", item);

            if(dataIdList!=null)
            {
                intent.putExtra("QuestionId", dataIdList.get(position));

            }
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
        TextView TopicSerialNumberTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.TopicNameTextView);
            TopicSerialNumberTextView = itemView.findViewById(R.id.TopicSerialNumberTextView);
            ListItemClick = itemView.findViewById(R.id.ListTopicClick);
        }
    }
}
