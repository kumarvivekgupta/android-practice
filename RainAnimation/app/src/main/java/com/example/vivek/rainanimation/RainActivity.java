package com.example.vivek.rainanimation;

import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.jinatonic.confetti.ConfettiManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivek on 4/5/2018.
 */

public abstract class RainActivity extends AppCompatActivity implements View.OnClickListener {


    protected ViewGroup container;

    protected int goldDark, goldMed, gold, goldLight;
    protected int[] colors;

    private final List<ConfettiManager> activeConfettiManagers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());

        container = (ViewGroup) findViewById(R.id.container);
        findViewById(R.id.generate_confetti_once_btn).setOnClickListener(this);
        findViewById(R.id.generate_confetti_stream_btn).setOnClickListener(this);
        findViewById(R.id.generate_confetti_infinite_btn).setOnClickListener(this);
        findViewById(R.id.generate_confetti_stop_btn).setOnClickListener(this);

        final Resources res = getResources();
      //  goldDark = res.getColor(R.color.gold_dark);
        goldMed = (R.drawable.theme4);
      //  gold = res.getColor(R.color.gold);
      //  goldLight = res.getColor(R.color.gold_light);
        colors = new int[] { goldDark, goldMed, gold, goldLight };
        goldLight=R.drawable.theme1;
        goldDark=R.drawable.theme3;
    }

    @LayoutRes
    protected int getLayoutRes() {
        return R.layout.activity_confetti_with_listener;
    }

    @Override
    public void onClick(View view) {
        final int id = view.getId();
        if (id == R.id.generate_confetti_once_btn) {
            activeConfettiManagers.add(generateOnce());
        } else if (id == R.id.generate_confetti_stream_btn) {
            activeConfettiManagers.add(generateStream());
        } else if (id == R.id.generate_confetti_infinite_btn) {
            activeConfettiManagers.add(generateInfinite());
        } else {
            for (ConfettiManager confettiManager : activeConfettiManagers) {
                confettiManager.terminate();
            }
            activeConfettiManagers.clear();
        }
    }

    protected abstract ConfettiManager generateOnce();
    protected abstract ConfettiManager generateStream();
    protected abstract ConfettiManager generateInfinite();
}

