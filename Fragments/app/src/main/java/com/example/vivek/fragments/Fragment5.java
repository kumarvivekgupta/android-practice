package com.example.vivek.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by Vivek on 12/12/2017.
 */

public class Fragment5 extends Fragment {
private RecyclerView recyclerView;
private VivzAdapter1 adapter1;
private int no;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment5layout,container,false);
        return view;
    }
    public void onActivityCreated(Bundle savedInstance) {

        super.onActivityCreated(savedInstance);
        no=getArguments().getInt("Data");
        recyclerView=(RecyclerView)getActivity().findViewById(R.id.recyclerview5);
        adapter1=new VivzAdapter1(getActivity(),Table.getno(no));
        recyclerView.setAdapter(adapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}
