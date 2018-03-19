package com.example.vivek.fragments;


import android.content.Intent;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Vivek on 12/6/2017.
 */

public class Fragment1 extends Fragment implements VivzAdapter1.ClickListener {
    private RecyclerView recyclerView;
    private VivzAdapter1 adapter1;
    private Random random;
    private int s[] = new int[20];
    private int pos;
    ArrayList<Integer> data;
    Communicator comm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1layout, container, false);



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = getActivity().findViewById(R.id.recyclerview1);
        random = new Random();
        adapter1=new VivzAdapter1(getActivity(),getdata());

recyclerView.setAdapter(adapter1);
recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



    }
    public ArrayList<Integer> getdata()
    {ArrayList<Integer> data=new ArrayList<>();
    for(int z=0;z<20;z++)
        data.add(random.nextInt(100));
        return data;
    }



//    public void onitemClicked(ArrayList<Integer> e,int s) {
//        Intent intent=new Intent(getActivity(),Main2Activity.class);
//        intent.putExtra("array",s);
//        startActivity(intent);
//    }

    @Override
    public void onitemClicked( ArrayList<Integer> e)
     {
        Intent intent=new Intent(getActivity(),Main2Activity.class);
        intent.putExtra("array",e);
        startActivity(intent);
    }

}