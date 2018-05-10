package com.example.vivek.rainanimation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.github.jinatonic.confetti.CommonConfetti;

public class MainActivity extends AppCompatActivity {

    private static final ConfettiSample[] SAMPLES = {
            new ConfettiSample(
                    R.string.falling_confetti_from_top,
                    RainActivity.class
            ),

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(android.R.id.list);
        final ListAdapter adapter = new ArrayAdapter<ConfettiSample>(this,
                R.layout.item_confetti_sample, SAMPLES) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                final View view = super.getView(position, convertView, parent);
                final ConfettiSample sample = getItem(position);
                ((TextView) view).setText(sample.nameResId);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, RainFallingActivity.class));
                    }
                });

                return view;
            }
        };

        listView.setAdapter(adapter);
    }

    private static class ConfettiSample {
        final int nameResId;
        final Class<? extends Activity> targetActivityClass;

        private ConfettiSample(int nameResId, Class<? extends Activity> targetActivityClass) {
            this.nameResId = nameResId;
            this.targetActivityClass = targetActivityClass;
        }
    }

}
