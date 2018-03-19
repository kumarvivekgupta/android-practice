package com.example.vivek.githubrepo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vivek on 2/3/2018.
 */

public class GithubRepoAdapter extends ArrayAdapter<GithubRepo> {

    private Context context;
    private List<GithubRepo> values;
    private TextView textView;


    public GithubRepoAdapter(@NonNull Context context, @NonNull List<GithubRepo> objects) {
        super(context, R.layout.singlrrow, objects);
        this.values = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.singlrrow, parent, false);
         textView= v.findViewById(R.id.textView1);
         GithubRepo item=values.get(position);
        String message = item.getName();
        textView.setText(message);

        return v;
    }
}
