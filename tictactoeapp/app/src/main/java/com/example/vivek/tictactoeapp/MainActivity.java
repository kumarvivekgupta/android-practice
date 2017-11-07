package com.example.vivek.tictactoeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {
    int myActivePlayer=0;
    List gameList=new ArrayList();
    int[] gamestat={2,2,2,2,2,2,2,2,2};


public  void imageclicked(View view) {
    gameList.add(2);
    gameList.add(2);
    gameList.add(2);
    gameList.add(2);
    gameList.add(2);
    gameList.add(2);
    gameList.add(2);
    gameList.add(2);
    gameList.add(2);

    ImageView clicked = (ImageView) view;
    //  Log.i("tag is","image number is"+clicked.getTag().toString());
    int mytap = Integer.parseInt(clicked.getTag().toString());

    if (gamestat[mytap] == 2) {

        gamestat[mytap]=myActivePlayer;
        if (myActivePlayer == 0) {

            clicked.setImageResource(R.drawable.cross);
            clicked.animate().rotation(360).setDuration(1000);
            myActivePlayer = 1;
            match();
        } else {
            clicked.setImageResource(R.drawable.circle);
            clicked.animate().rotation(360).setDuration(1000);
            myActivePlayer = 0;
            match();
        }
    }



}
public  void playagain(View view){
    for(int i=0;i<9;i++){
        gamestat[i]=2;
    }
    myActivePlayer=0;
    LinearLayout linearLayout1=(LinearLayout)findViewById(R.id.h1);
    for(int j=0;j<3;j++){
        ((ImageView)linearLayout1.getChildAt(j)).setImageResource(R.mipmap.ic_launcher);
    }
    LinearLayout linearLayout2=(LinearLayout)findViewById(R.id.h2);
    for(int j=0;j<3;j++){
        ((ImageView)linearLayout2.getChildAt(j)).setImageResource(R.mipmap.ic_launcher_round);
    }
    LinearLayout linearLayout3=(LinearLayout)findViewById(R.id.h3);
    for(int j=0;j<3;j++){
        ((ImageView)linearLayout3.getChildAt(j)).setImageResource(R.mipmap.ic_launcher);
    }
}
public void match() {
    for (int i = 0; i < 2; i++) {
        if (gamestat[0] == i) {
            if (gamestat[1] == i) {
                if (gamestat[2] == i)
                    Toast.makeText(MainActivity.this, "player "+i+" wins", Toast.LENGTH_LONG).show();

            }
        }
        if (gamestat[3] == i) {
            if (gamestat[4] == i) {
                if (gamestat[5] == i)
                    Toast.makeText(MainActivity.this, "player "+i+" wins", Toast.LENGTH_LONG).show();

            }
        }
        if (gamestat[6] == i) {
            if (gamestat[7] == i) {
                if (gamestat[8] == i)
                    Toast.makeText(MainActivity.this, "player"+ i+" wins", Toast.LENGTH_LONG).show();

            }
        }
        if (gamestat[0] == i) {
            if (gamestat[3] == i) {
                if (gamestat[6] == i)
                    Toast.makeText(MainActivity.this, "player "+ i+" wins", Toast.LENGTH_LONG).show();

            }
        }
        if (gamestat[1] == i) {
            if (gamestat[4] == i) {
                if (gamestat[7] == i)
                    Toast.makeText(MainActivity.this, "player "+ i+" wins", Toast.LENGTH_LONG).show();

            }
        }
        if (gamestat[2] == i) {
            if (gamestat[5] == i) {
                if (gamestat[8] == i)
                    Toast.makeText(MainActivity.this, "player "+ i+" wins", Toast.LENGTH_LONG).show();

            }
        }
        if (gamestat[0] == i) {
            if (gamestat[4] == i) {
                if (gamestat[8] == i)
                    Toast.makeText(MainActivity.this, "player "+ i+" wins", Toast.LENGTH_LONG).show();

            }
        }
        if (gamestat[2] == i) {
            if (gamestat[4] == i) {
                if (gamestat[6] == i)
                    Toast.makeText(MainActivity.this, "player "+ i+" wins", Toast.LENGTH_LONG).show();

            }
        }

    }

}






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
