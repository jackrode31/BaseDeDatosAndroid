package com.example.jackrode31.parcial3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BooksHandler extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "books.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_BOOKS = "books";
    public static final String COLUMN_ID = "isbn";
    public static final String COLUMN_AUTOR = "autor";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_AÑO = "año";
    public static final String COLUMN_EDITORIAL= "editorial";
    public static final String COLUMN_AREA= "area";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_BOOKS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_AUTOR + " TEXT, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_AÑO + " TEXT, " +
                    COLUMN_EDITORIAL + " NUMERIC, " +
                    COLUMN_AREA + " TEXT " +
                    ")";


    public BooksHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
        db.execSQL(TABLE_CREATE);
    }
}