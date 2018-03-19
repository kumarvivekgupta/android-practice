package com.example.vivek.notes;

import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private ListView listView;
    //    private List<String> values;
    private String user;
    private RecyclerView recycler;
    private VivzAdapter adapter;
    private String[] value;
    public static int i = 0;

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);


        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.eng: {

                user = sharedPreferences.getString("english", "");
                Toast.makeText(MainActivity.this, user, Toast.LENGTH_LONG).show();
//                data.add("English");
//                ListAdapter.getString(user);
                Log.i("English", user);
                value[i++] = "English";
                for (int a = 0; a < i; a++)
                    Log.i("value", "" + value[a]);
                adapter = new VivzAdapter(this, value);
                recycler.setAdapter(adapter);
                recycler.setLayoutManager(new LinearLayoutManager(this));
                return true;


            }
            case R.id.span: {
                user = sharedPreferences.getString("spanish", "");
//                    ListAdapter.getString(user);
                value[i++] = "Spanish";
                adapter = new VivzAdapter(this, getdata());
                recycler.setAdapter(adapter);
                recycler.setLayoutManager(new LinearLayoutManager(this));

                return true;


            }
            default:
                return false;

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = this.getSharedPreferences("com.example.vivek.notes", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("english", "English").apply();
        sharedPreferences.edit().putString("spanish", "Spanish").apply();
//        listView = (ListView) findViewById(R.id.listView);
        value = new String[100];
//        ListAdapter adapter=new ListAdapter(this,R.layout.singlerow);
//        listView.setAdapter(adapter);
        recycler = (RecyclerView) findViewById(R.id.recyclerView);

    }

    public String[] getdata() {
        String[] data = new String[100];
        for (int j = 0; j < i; j++)
            data[j] = value[j];

        return data;
    }

}
