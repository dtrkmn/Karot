package com.example.casper.karot_system;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Casper on 4/30/2015.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{
    public DatabaseHelper(Context context, String name, CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase _db)
    {
        _db.execSQL(LoginDatabaseAdapter.DATABASE_CREATEUNIVERSITY);
        _db.execSQL(LoginDatabaseAdapter.DATABASE_CREATELAKE);
        _db.execSQL(LoginDatabaseAdapter.DATABASE_CREATECORE);
        _db.execSQL(LoginDatabaseAdapter.DATABASE_CREATEUSERS);


    }

    @Override
    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion)
    {
        Log.w("TaskDBAdapter", "Upgrading from version " +_oldVersion + " to " +_newVersion + ", which will destroy all old data");


        _db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
        onCreate(_db);
    }

}
