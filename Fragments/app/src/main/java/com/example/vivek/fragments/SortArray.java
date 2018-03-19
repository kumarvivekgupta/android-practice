package com.example.vivek.fragments;

import java.util.ArrayList;

/**
 * Created by Vivek on 1/27/2018.
 */

public class SortArray {
//    private static int num[]=new int[20];
//    private static ArrayList<Integer> s=new ArrayList<>();
    public static ArrayList<Integer>  getSortedArray(ArrayList<Integer> e)
    {
        int i=0,j=0,temp=0;
//        for(i=0;i<30;i++)

        for(i=0;i<20;i++)
        {
            for(j=0;j<20-1-i;j++)
            {
                if(e.get(i)>e.get(j+1))
                {
                    temp=e.get(j);
                  e.add(j,e.get(j+1));
                  e.add((j+1),temp);

                }
            }
        }
//        for(i=0;i<30;i++)
//        {
//            s[i]=String.valueOf(numbers[i]);
//        }
        return e;
    }
}
