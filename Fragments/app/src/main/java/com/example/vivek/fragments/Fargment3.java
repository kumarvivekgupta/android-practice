package com.example.vivek.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.media.CamcorderProfile.get;

/**
 * Created by Vivek on 12/12/2017.
 */

public class Fargment3 extends Fragment implements Communicator {
    private FragmentManager manager;
    private FragmentTransaction transaction, transaction2;
    private Fragment4 fr4;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3layout, container, false);


        return view;

    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fr4=new Fragment4();
        transaction=getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.parent1,fr4,"fragment4");
        transaction.commit();

    }

    @Override
    public void respond(int data) {
        Bundle bundle=new Bundle();
        bundle.putInt("Data",data);
        Fragment5 fragment5 = new Fragment5();
        fragment5.setArguments(bundle);
        transaction2 = getChildFragmentManager().beginTransaction();
        transaction2.replace(R.id.parent2, fragment5).commit();
    }
}
