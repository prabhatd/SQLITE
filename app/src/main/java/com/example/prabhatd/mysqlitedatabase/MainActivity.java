package com.example.prabhatd.mysqlitedatabase;

import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.example.prabhatd.mysqlitedatabase.db.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    public static final String TAG=MainActivity.class.getSimpleName();
    MyDatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper= new MyDatabaseHelper(this);
        helper.addData("Prabhat",7843);
        helper.addData("Sumedh",2554);
        helper.addData("Michael", 8334);

        fetchData();

       /* Cursor AllFriends= helper.getFreind1();
        String [] from={"name","phonenumber"};
        int [] to={android.R.id.text1,android.R.id.text2};
*/

/*
        ListAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,AllFriends,from,to);
*/


       /* ListAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,AllFriends,from,to);
        ListView myList =(ListView) findViewById(android.R.id.list);
        myList.setAdapter(adapter);
*/        }

        /*public void showData(View v){
            MyDatabaseHelper helper= new MyDatabaseHelper(this);
            Cursor AllFriends= helper.getFriends();
            String [] from={"name","phonenumber"};
            int [] to={android.R.id.text1,android.R.id.text2};
            ListAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,AllFriends,from,to);
            ListView myList = findViewById(android.R.id.list);
            myList.setAdapter(adapter);
        }*/



    public void fetchData(){
    Cursor AllFriends=helper.getFriends();
    AllFriends.moveToFirst();

    while (!AllFriends.isAfterLast()){
        String name = AllFriends.getString(1);

        int phonenumber=AllFriends.getInt(2);

        Log.e(TAG,"name"+name);
        Log.e(TAG,"phonenumber"+phonenumber);

        AllFriends.moveToNext();


    }
        final String [] from={"name","phonenumber"};

        int [] to={android.R.id.text1,android.R.id.text2};

        ListAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,AllFriends,from,to);

        Log.e(TAG,"adapterData"+adapter.toString());

        /*ListView listView =(ListView)findViewById(android.R.id.list);*/

         final ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*String selectedItem=from[+position];

                Toast.makeText(getApplicationContext(),selectedItem,Toast.LENGTH_LONG).show();*/


                Toast.makeText(getApplicationContext(),"you clicked"+parent.getItemAtPosition(position),Toast.LENGTH_LONG).show();
            }
        });



    }

}

