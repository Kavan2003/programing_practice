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

import com.example.list_items_course.view.CodeSolution;
import com.example.list_items_course.R;

import java.util.List;
import java.util.Locale;

public class thirdAdpatorProgrammingQuestion extends RecyclerView.Adapter<thirdAdpatorProgrammingQuestion.MyViewHolder> {
    private final List<String> dataList;
//    private final List<String> dataTopicList;

    List<Integer> dataIdList ;
    private final Context context;
    boolean isSerial = true;
    String question;


    public thirdAdpatorProgrammingQuestion(List<Integer> dataIdList , List<String> dataList, Context context, String question) {
        this.dataList = dataList;
        this.dataIdList = dataIdList;
this.question = question;
        this.context = context;

    }

    @NonNull
    @Override
    public thirdAdpatorProgrammingQuestion.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_topic, parent, false);
        return new thirdAdpatorProgrammingQuestion.MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(thirdAdpatorProgrammingQuestion.MyViewHolder holder, int position) {
        String item = dataList.get(position);
        holder.textView.setText(item);

        holder.TopicSerialNumberTextView.setText(String.format(Locale.US, "%d.", position + 1));



        holder.ListItemClick.setOnClickListener(v -> {
            Intent intent = new Intent(context, CodeSolution.class);


            intent.putExtra("ProblemTextView", item);
            intent.putExtra("QuestionTextView", question);

            if(dataIdList!=null)
            {
                intent.putExtra("ProblemId", dataIdList.get(position));

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

