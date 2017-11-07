package com.example.vivek.squlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText editText;
    EditText phonetext;
    TextView textView;
    myDatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.edittext);
        phonetext=(EditText)findViewById(R.id.phoneText);
        textView=(TextView)findViewById(R.id.textView);
        databaseHelper =new myDatabaseHelper(this,null,null,1);
        printDB();
    }
    public void addbuttonclicked(View view){
Tasks tasks=new Tasks(editText.getText().toString(),phonetext.getText().toString());

        databaseHelper.addtask(tasks);

        printDB();
    }
    public void removebuttonclicked(View view){
String input=(editText.getText().toString());
      String input1=  phonetext.getText().toString();
       databaseHelper.removeTasks(input,input1);

        printDB();
    }
    public void printDB(){
        String dbstring=databaseHelper.databasetostring();
        textView.setText(dbstring);


    }
}
