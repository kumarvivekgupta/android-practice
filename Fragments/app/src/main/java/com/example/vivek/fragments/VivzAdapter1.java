package com.example.vivek.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Vivek on 1/21/2018.
 */

public class VivzAdapter1 extends RecyclerView.Adapter<VivzAdapter1.MyViewHolder> {
    private LayoutInflater inflater;
    ArrayList<Integer> data;
    private Context context;
    private ClickListener clickListener;

    public  VivzAdapter1(Context context, ArrayList<Integer> data) {
        this.context = context;


        inflater = LayoutInflater.from(context);
       // inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        this.data = new ArrayList<>();
        this.data = data;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.singlerow, parent, false);
        MyViewHolder holder = new MyViewHolder(view,context);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(data.get(position)+"");

    }

    @Override
    public int getItemCount() {

        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
Context context;
        public MyViewHolder(View itemView,Context context) {
            super(itemView);
this.context=context;
            title = (TextView) itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            clickListener.onitemClicked(data);

        }
    }
        public interface ClickListener{
            public void onitemClicked(ArrayList<Integer> e);




        }
        public void setitemClicked(ClickListener clickListener)
        {
            this.clickListener=clickListener;
        }

    }

