package com.example.prabhatd.mysqlitedatabase.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="MyDatabase";
    public static final String TAG=MyDatabaseHelper.class.getSimpleName();

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

/*
        db.execSQL("CREATE TABLE prabhat (_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,phonenumber INTEGER);");
*/
        db.execSQL("CREATE TABLE prabhat(_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,phonenumber INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS prabhat");
        onCreate(db);
    }

    public  void addData(String name,int phonenumber){
       ContentValues values = new ContentValues(2);
       values.put("name",name);
       values.put("phonenumber",phonenumber);

       getWritableDatabase().insert("prabhat","name",values);
    }

    /*
   By using raw Query
     */
    public Cursor getFriends(){
        Cursor cursor =getReadableDatabase().rawQuery("select * from prabhat",null);

        Log.e(TAG,"cursor"+cursor.toString());
        return  cursor;
    }


    public Cursor getFreind1(){
        Cursor cursor =getReadableDatabase().query("prabhat",new String[]{"_id","name","phonenumber"},null,null,null,null,null);
        Log.e(TAG,"getFreind1 cursor"+cursor.toString());
        return  cursor;
    }

    public  void delete(){
        getWritableDatabase().delete("prabhat",null,null);
    }

}
