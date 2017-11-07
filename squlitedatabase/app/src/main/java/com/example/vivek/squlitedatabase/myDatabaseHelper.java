package com.example.vivek.squlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;

/**
 * Created by Vivek on 9/8/2017.
 */

public class myDatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="tasks.db";

    public  static final String TABLE_TASKS="tasks";
    public  static  final String COLUMN_ID="_id";
    public  static  final String COLUMN_ID1="_id1";
    public static final String COLUMN_TASKNAME="taskname";
    public static final String COLUMN_TASKNAME1="phone";

    public myDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
String query=" CREATE TABLE " + TABLE_TASKS + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TASKNAME + " TEXT " +");";
   db.execSQL(query);
        String query1=" CREATE TABLE " + TABLE_TASKS + " ( " + COLUMN_ID1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_TASKNAME1 + " TEXT " +");";
        db.execSQL(query);
    }
public void addtask(Tasks tasks){
    ContentValues values =new ContentValues();
    values.put(COLUMN_TASKNAME,tasks.get_taskname());
    values.put(COLUMN_TASKNAME1,tasks.get_phone());
    SQLiteDatabase db=getWritableDatabase();
    SQLiteDatabase db1=getWritableDatabase();
    db.insert(TABLE_TASKS,null,values);
    db1.insert(TABLE_TASKS,null,values);
    db.close();
    db1.close();
}
public void removeTasks(String Taskname,String phone){
SQLiteDatabase db=getWritableDatabase();
    SQLiteDatabase db1=getWritableDatabase();
    db.execSQL("DELETE FROM " + TABLE_TASKS +" WHERE " + COLUMN_TASKNAME + "=\"" + Taskname + "\";");
    db1.execSQL("DELETE FROM " + TABLE_TASKS +" WHERE " + COLUMN_TASKNAME1 + "=\"" + phone + "\";");




}
    public String databasetostring(){
        String dbstring="";
        String db1string="";
        SQLiteDatabase db = getWritableDatabase();

        SQLiteDatabase db1=getWritableDatabase();
        //String query = "SELECT * FROM" + TABLE_TASKS +"WHERE 1";
        String query = "SELECT * FROM " + TABLE_TASKS + " WHERE 1";
        Cursor c = db.rawQuery(query,null);

        c.moveToFirst();
        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("taskname"))!=null){
                dbstring += c.getString(c.getColumnIndex("taskname"));

                db1string +=c.getString(c.getColumnIndex("phone"));
                dbstring += "\n";
            }
            c.moveToNext();
        }
        db.close();
        db1.close();
        return (dbstring);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS"+TABLE_TASKS);
        onCreate(db);
    }


}
