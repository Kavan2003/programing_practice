package com.example.list_items_course.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.list_items_course.Model.DatabaseHelper;
import com.example.list_items_course.R;

public class CodeSolution extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_solution);
String question = getIntent().getStringExtra("QuestionTextView");
int probileId = getIntent().getIntExtra("ProblemId", -1);
        String ProgramSolution = "No content";
        String   ProgramStatement = "No content";
TextView ProblemTextView = findViewById(R.id.ProblemTextView);
TextView QuestionTextView = findViewById(R.id.Topic);

        ImageButton share = findViewById(R.id.share);
//        ImageButton report = findViewById(R.id.report);
Button markAsRead = findViewById(R.id.markAsRead);




        DatabaseHelper dbHelper = new DatabaseHelper(CodeSolution.this, "Programming.db", null);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor;
            if (question != null) {
                QuestionTextView.setText(question);
            }

            if(probileId!=-1)
            {

                 cursor = database.rawQuery("SELECT ProgramStatement,ProgramSolution FROM PP_Program where ProgramID=  "+ probileId , null);

                while (cursor.moveToNext()) {
                    ProgramStatement = cursor.getString(cursor.getColumnIndexOrThrow("ProgramStatement"));
                  ProgramSolution = cursor.getString(cursor.getColumnIndexOrThrow("ProgramSolution"));

                    ProblemTextView.setText(ProgramStatement);
                }
                

            }
        final int[] isRead = {0};
        markAsRead.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                ContentValues values = new ContentValues();
                if(isRead[0] ==0)
                values.put("IsRead", 1);
                else
                    values.put("IsRead", 0);
                String whereClause = "ProgramID = ?"; // You need to specify which program you want to update by ProgramID
                String[] whereArgs = new String[] { String.valueOf(probileId) }; // Replace programId with the actual program ID you want to mark as read

                int rowsUpdated = database.update("PP_Program", values, whereClause, whereArgs);

                if (rowsUpdated > 0) {
//                    Toast.makeText(CodeSolution.this, "Success", Toast.LENGTH_SHORT).show();
                    isRead[0] =isRead[0]==0?1:0;


                } else {
//                    Toast.makeText(CodeSolution.this, "Failed", Toast.LENGTH_SHORT).show();


                    // No rows were updated (perhaps the program with the specified ProgramID doesn't exist)
                    // You can handle this case accordingly
                }
if(isRead[0] ==1)
                markAsRead.setText(R.string.mark_as_unread);
else
    markAsRead.setText(R.string.mark_as_read);

            }
        });





        String finalProgramSolution = ProgramSolution;
        String finalProgramStatement = ProgramStatement;
        share.setOnClickListener(new View.OnClickListener(){
                public void  onClick(View v){
                    shareContent(finalProgramStatement +"\n\n"+ finalProgramSolution);
                }
        });
//        report.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                sendReportByEmail("kavanthosani2003@gmail.com",probileId+"\n\n"+finalProgramStatement +"\n\n"+ finalProgramSolution);
//            }
//        });

        // Find the WebView in the layout
        TextView webView = findViewById(R.id.codeWebView);


webView.setText(ProgramSolution);
        // Define the HTML content with the C code
//        String htmlContent = "<html><body><pre><code>" +
//                ProgramSolution +
//                "#include <stdio.h>\n" +
//                "int main() {\n" +
//                "    int arr[] = {1, 2, 3, 4, 5};\n" +
//                "    int n = sizeof(arr) / sizeof(arr[0]);\n" +
//                "    int sum = 0;\n" +
//                "    for (int i = 0; i < n; i++) {\n" +
//                "        sum += arr[i];\n" +
//                "    }\n" +
//                "    printf(\"Sum of array elements: %d\\n\", sum);\n" +
//                "    return 0;\n" +
//                "}" +
//                "</code></pre></body></html>"
//                ;




//        webView.loadDataWithBaseURL(null, htmlContent, "text/html", "utf-8", null);







    }

    private void shareContent(String text) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.setType("text/plain");

        // Create a chooser dialog to let the user choose the sharing app
        Intent chooser = Intent.createChooser(shareIntent, "Share via");

            startActivity(chooser);
    }
    private void sendReportByEmail(String emailAddress, String emailContent) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setDataAndType(Uri.parse("mailto:" + emailAddress),"text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "test");
        intent.putExtra(Intent.EXTRA_TEXT, emailContent);

        startActivity(intent);
//        startActivity(Intent.createChooser(intent, "Send Email"));
    }





}