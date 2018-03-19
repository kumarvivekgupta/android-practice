package com.example.vivek.chinakamaal;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button playbtn,imgbtn;

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playbtn=(Button)findViewById(R.id.button2);
        mp=MediaPlayer.create(MainActivity.this,R.raw.aud_201610140000);
playbtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       mp.start();
    }
});

        }
    }
