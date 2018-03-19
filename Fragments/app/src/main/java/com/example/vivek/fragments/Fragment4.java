package com.example.vivek.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.ArrayList;

/**
 * Created by Vivek on 12/12/2017.
 */

public class Fragment4 extends Fragment  implements VivzAdapter1.ClickListener{
    private int no;
    private RecyclerView recyclerView;
    private VivzAdapter1 adapter1;
    private ArrayList<Integer> num;
    private Communicator comm;
    private  int numb;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4layout, container, false);

return view;

    }
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        num=Main2Activity.w;
        recyclerView=getActivity().findViewById(R.id.recyclerview4);
        adapter1=new VivzAdapter1(getActivity(),SortArray.getSortedArray(num));

        recyclerView.setAdapter(adapter1);
adapter1.setitemClicked(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onitemClicked(ArrayList<Integer> w) {
//numb=s;
        Toast.makeText(getActivity(),numb,Toast.LENGTH_SHORT).show();
        comm.respond(numb);
    }

//    @Override
//    public void respond(int data) {
//
//    }

    private void setCommunicate(Communicator comm)
    {
        this.comm=comm;
    }
}
