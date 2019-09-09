package com.dev.yazidi.champpool.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseCreator extends SQLiteOpenHelper {
    //DATABASE
    public static final String DATABASE_NAME = "DBPOOL";
    public static final int DATABASE_VERSION = 1;

    //Scores Table
    public static final String SCORE_TABLE_NAME = "Scores";
    public static final String SCORE_KEY_ID = "_id";
    public static final String SCORE_KEY_CHAMPION = "champion";
    public static final String SCORE_KEY_LANE = "lane";
    public static final String SCORE_KEY_SCORE = "score";
    private static final String SCORE_TABLE_CREATE = "CREATE TABLE " + SCORE_TABLE_NAME + " (" +
            SCORE_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            SCORE_KEY_CHAMPION + " TEXT," +
            SCORE_KEY_LANE + " TEXT," +
            SCORE_KEY_SCORE + " INTEGER," +
            "UNIQUE(" + SCORE_KEY_CHAMPION + "," + SCORE_KEY_LANE + ")" +
            ");";

    public DatabaseCreator(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SCORE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
