package com.filho.filho.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HeryVandoro on 9/13/2017.
 */

public class Comment extends Model{
    private static final String TABLE = "comments";

    public static final String COLUMN_FILM_ID = "film_id";
    public static final String COLUMN_TEXT = "text";

    public Comment(Context context) {
        super(context);
    }

    public void createTable() {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE+"");
        db.execSQL("CREATE TABLE if not exists "+TABLE+ " ("+COLUMN_PK+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_FILM_ID+ " INT ," + COLUMN_TEXT+ " TEXT);");

        ContentValues con = new ContentValues();
        con.put(COLUMN_FILM_ID, 324852);
        con.put(COLUMN_TEXT, "Coba comment 1");
        db.insert(TABLE, null, con);

        con.put(COLUMN_FILM_ID, 324852);
        con.put(COLUMN_TEXT, "Coba comment 2");
        db.insert(TABLE, null, con);

        con.put(COLUMN_FILM_ID, 324852);
        con.put(COLUMN_TEXT, "Coba comment 3");
        db.insert(TABLE, null, con);
    }

    public Cursor index() {
        return db.query(TABLE, new String[]{COLUMN_PK, COLUMN_TEXT}, null, null, null, null, null);
    }

    public Cursor show(int id) {
        return db.query(TABLE, new String[]{COLUMN_PK, COLUMN_TEXT}, COLUMN_FILM_ID+"= ?", new String[]{id+""}, null, null, null);
    }
}
