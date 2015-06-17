package com.example.casper.karot_system;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginDatabaseAdapter
{
    static final String DATABASE_NAME = "Core.db";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;

    static final String DATABASE_CREATEUNIVERSITY = "create table "+"UNIVERSITY"+
            "( " +"ID"+" integer primary key autoincrement,"+ "UNINAME  text,MANAGER text,TYPE text) ";
    static final String DATABASE_CREATEUSERS="create table "+ "Kullanıcılar"+
            "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text,PASSWORD text,TYPE text)";

    static final String DATABASE_CREATECORE="create table "+ "CORE"+
            "( " +"ID"+" integer primary key autoincrement,"+ "CORENAME  text,CORELATİ text,CORELONGİ text,COREDEPTH text,COREDATE text,CORETYPE text,CORECOMMENT text,COREWORKER text)";

    static final String DATABASE_CREATELAKE="create table "+ "Lake"+
            "( " +"ID"+" integer primary key autoincrement,"+ "Lakename  text,longitude text,latitude text)";
    /*static final String DATABASE_CREATE_UNIVERSITY = "create table "+"UNIVERSITY"+
            "( " +"ID"+" integer primary key autoincrement,"+ "UNINAME  text,MANAGER text,PASSWORD text); ";
    static final String DATABASE_CREATE_LAKE = "create table "+"LAKE"+
            "( " +"ID"+" integer primary key autoincrement,"+ "LAKENAME  text,LONGITUDE text,LATITUDE text);";
    static final String DATABASE_CREATE_CORE = "create table "+"LAKE"+
            "( " +"ID"+" integer primary key autoincrement,"+ "LAKENAME  text,LONGITUDE text,LATITUDE text);";*/
    // Variable to hold the database instance
    public  SQLiteDatabase db;
    private final Context context;
    private DatabaseHelper dbHelper;
    public LoginDatabaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public LoginDatabaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String userName,String password, String type)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD",password);
        newValues.put("TYPE",type);


        // Insert the row into your table
        db.insert("Kullanıcılar", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
    public  void insertCore(String name,String lati,String longi,String depth,String type,String date, String comment,String worker){
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("CORENAME", name);
        newValues.put("CORELATİ",lati);
        newValues.put("CORELONGİ",longi);
        newValues.put("COREDEPTH", depth);
        newValues.put("COREDATE",date);
        newValues.put("CORECOMMENT",comment);
        newValues.put("COREWORKER", worker);
        newValues.put("CORETYPE",type);
        ;


        // Insert the row into your table
        db.insert("CORE", null, newValues);
    }
    public void insertEntryLake(String LakeName,String Longtitude, String Latitude)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("Lakename", LakeName);
        newValues.put("Longitude",Longtitude);
        newValues.put("Latitude",Latitude);

        // Insert the row into your table
        db.insert("Lake", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
    public void insertEntryUNIVERSITY(String NAME,String MANAGER,String PASSWORD)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("UNINAME", NAME);
        newValues.put("MANAGER",MANAGER);
        newValues.put("PASSWORD", PASSWORD);


        // Insert the row into your table
        db.insert("UNIVERSITY", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
    public int deleteEntry(String UserName)
    {
        String where="USERNAME=?";
        int numberOFEntriesDeleted= db.delete("Kullanıcılar", where, new String[]{UserName}) ;
        return numberOFEntriesDeleted;
    }
    public int deleteEntryLake(String LakeName)
    {
        String where="Lakename=?";
        int numberOFEntriesDeleted= db.delete("Lake", where, new String[]{LakeName}) ;
        return numberOFEntriesDeleted;
    }
    public int deleteEntryUNIVERSITY(String NAME)
    {
        String where="UNINAME=?";
        int numberOFEntriesDeleted= db.delete("UNIVERSITY", where, new String[]{NAME}) ;
        return numberOFEntriesDeleted;
    }
    public String getSingleEntry(String userName)
    {
        Cursor cursor=db.query("Kullanıcılar", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1)
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }
    public String getSingleEntry2(String userName)
    {
        Cursor cursor=db.query("Kullanıcılar", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1)
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String TYPE= cursor.getString(cursor.getColumnIndex("TYPE"));
        cursor.close();
        return TYPE;
    }
    public String getSingleEntryLake1(String LakeName)
    {
        Cursor cursor=db.query("Lake", null, " Lakename=?", new String[]{LakeName}, null, null, null);
        if(cursor.getCount()<1)
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String longi= cursor.getString(cursor.getColumnIndex("Longitude"));
        cursor.close();
        return longi;
    }
    public String getSingleEntryLake2(String LakeName)
    {
        Cursor cursor=db.query("Lake", null, " Lakename=?", new String[]{LakeName}, null, null, null);
        if(cursor.getCount()<1)
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String lati= cursor.getString(cursor.getColumnIndex("Latitude"));
        cursor.close();
        return lati;
    }
    public String getSinlgeEntryUNIVERSITY(String NAME)
    {
        Cursor cursor=db.query("UNIVERSITY", null, " UNINAME=?", new String[]{NAME}, null, null, null);
        if(cursor.getCount()<1)
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String MANAGER= cursor.getString(cursor.getColumnIndex("MANAGER"));
        String PASSWORD= cursor.getString(cursor.getColumnIndex("PASSWORD"));

        cursor.close();
        return MANAGER;

    }
    public void  updateEntry(String userName,String password,String type)
    {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD",password);
        updatedValues.put("TYPE", type);


        String where="USERNAME = ?";
        db.update("Kullanıcılar",updatedValues, where, new String[]{userName});
    }
    public void  updateEntryUNIVERSITY(String NAME,String MANAGER,String PASSWORD)
    {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("UNINAME", NAME);
        updatedValues.put("MANAGER",MANAGER);
        updatedValues.put("PASSWORD", PASSWORD);



        String where="UNINAME = ?";
        db.update("UNIVERSITY",updatedValues, where, new String[]{NAME});
    }
    
}