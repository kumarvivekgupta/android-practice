package com.example.vivek.squlitedatabase;

/**
 * Created by Vivek on 9/8/2017.
 */

public class Tasks {
    private int _id;
    private String _taskname;
    private  String _phone;
    private  int _id1;
public void Tasks(){

}
public  Tasks(String taskname,String phone){
    this._taskname= taskname;
    this._phone =phone;

}

    public String get_taskname() {
        return _taskname;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_taskname(String _taskname) {
        this._taskname = _taskname;
    }
    public  String get_phone(){return _phone;}
    public int get_id1(){return _id1;}
    public void set_id1(int _id1) {
        this._id1 = _id1;

    }

    public  void set_phone(String _phone){this._phone=_phone;}


}
