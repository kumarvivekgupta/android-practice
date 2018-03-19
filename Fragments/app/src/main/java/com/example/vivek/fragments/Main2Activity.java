package com.example.vivek.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
   private FragmentManager manager;
 private FragmentTransaction transaction1;
 private Toolbar toolbar;
 private TextView textView;
  public   static ArrayList<Integer> w;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        textView=(TextView)findViewById(R.id.textView);
        if(true)
        {
            textView.setText("Sorted Numbers");
            toolbar.setVisibility(View.GONE);
        }
manager=getSupportFragmentManager();
transaction1=manager.beginTransaction();
Fargment3 f3=new Fargment3();
w=new ArrayList<>();
w=getIntent().getExtras().getIntegerArrayList("array");
transaction1.add(R.id.frag3,f3,"fragment3");
transaction1.commit();


    }
}
