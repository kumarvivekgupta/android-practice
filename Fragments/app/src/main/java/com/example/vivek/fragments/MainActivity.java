package com.example.vivek.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Toolbar toolbar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        textView = (TextView) findViewById(R.id.toolbartitle);
        toolbar.setVisibility(View.GONE);
        if (true) {
            textView.setText("RANDOM NUMBERS");
            toolbar.setVisibility(View.VISIBLE);


        }
        Fragment1 frag1=new Fragment1();

        manager=getSupportFragmentManager();
        transaction =manager.beginTransaction();
        transaction.add(R.id.f1,frag1,"fr1");
        transaction.commit();
    }
}
