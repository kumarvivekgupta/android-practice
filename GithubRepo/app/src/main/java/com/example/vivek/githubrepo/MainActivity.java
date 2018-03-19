package com.example.vivek.githubrepo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String userName;

   @BindView(R.id.done)
   Button button;
@BindView(R.id.username)
EditText githubUser;
@BindView(R.id.listView)
ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
       // githubUser = (EditText) findViewById(R.id.username);

        //listView = (ListView) findViewById(R.id.listView);
       // button=(Button)findViewById(R.id.done);
    }


@OnClick(R.id.done)
    public void repositries(){
    userName = githubUser.getText().toString();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/").addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        GithubClient client = retrofit.create(GithubClient.class);
        Call<List<GithubRepo>> call = client.reposForUser(userName);
        Toast.makeText(MainActivity.this,userName,Toast.LENGTH_LONG).show();
        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                List<GithubRepo> repos = response.body();
                Toast.makeText(MainActivity.this,"land",Toast.LENGTH_LONG).show();
                listView.setAdapter(new GithubRepoAdapter(MainActivity.this, repos));
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
