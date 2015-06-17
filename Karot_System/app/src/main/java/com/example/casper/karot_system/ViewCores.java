package com.example.casper.karot_system;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ViewCores extends Activity {
    SQLiteDatabase db;
    TextView tv;
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cores);
        //initialize all view objects
        tv=(TextView)findViewById(R.id.textView1);

        //create database if not already exist
        db= openOrCreateDatabase("Core.db", MODE_PRIVATE, null);
        //create new table if not already exist

            }

    public void display(View v)
    {
        //use cursor to keep all data
        //cursor can keep data of any data type
        Cursor c=db.rawQuery("select * from CORE", null);
        tv.setText("");
        //move cursor to first position
        c.moveToFirst();
        //fetch all data one by one
        do
        {
            //we can use c.getString(0) here
            //or we can get data using column index
            String name=c.getString(c.getColumnIndex("CORENAME"));
            String surname=c.getString(5);
            String date = c.getString(4);
            String comment =c.getString(6);
            //display on text view
            tv.append("CORENAME:"+name+"   CORETYPE:"+surname+"   DATE:"+date+"\n"+"COMMENT : "+"\n"+"\n");
            //move next position until end of the data
        }while(c.moveToNext());
    }
}