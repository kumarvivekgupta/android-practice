package com.example.vivek.fragments;

import java.util.ArrayList;

/**
 * Created by Vivek on 1/27/2018.
 */

public class Table {
    public static ArrayList<Integer> getno(int a)
    {
        ArrayList<Integer> data=new ArrayList<>();
        for(int i=0;i<11;i++)
        {
            data.add(a*i);
        }
        return data;
    }
}
