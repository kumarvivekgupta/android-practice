package com.example.vivek.notes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vivek on 2/4/2018.
 */

public class VivzAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private LayoutInflater inflater;
    private String[] data;
    private Context context;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.singlerow, parent, false);
        MyViewHolder myholder = new MyViewHolder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public VivzAdapter(Context context, String[] data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        Log.i("adapter",data.length+"");

    }


}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public MyViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.textView);

    }
}