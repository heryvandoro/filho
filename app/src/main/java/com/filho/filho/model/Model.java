package com.filho.filho.model;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by HeryVandoro on 9/13/2017.
 */

public abstract class Model extends SQLiteOpenHelper{
    protected static final String DATABASE_NAME = "filho";
    protected static final String TABLE = "";
    protected static final String COLUMN_PK = "_id";

    protected SQLiteDatabase db = null;

    public Model(Context context) {
        super(context, DATABASE_NAME, null, 1);
        db = this.getWritableDatabase();
    }

    public abstract void createTable();

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
}
