package com.example.jackrode31.parcial3;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;


public class Books_Handler {
    public static final String LOGTAG = "EMP_MNGMNT_SYS";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            DBAdapter.COLUMN_ID,
            DBAdapter.COLUMN_AUTOR,
            DBAdapter.COLUMN_TITLE,
            DBAdapter.COLUMN_AÑO,
            DBAdapter.COLUMN_EDITORIAL,
            DBAdapter.COLUMN_AREA

    };

    public Books_Handler(Context context){
        dbhandler = new DBAdapter(context);
    }

    public void open(){
        Log.i(LOGTAG,"Database Opened");
        database = dbhandler.getWritableDatabase();


    }
    public void close(){
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();

    }
    public Books addBook(Books Books){
        ContentValues values  = new ContentValues();
        values.put(DBAdapter.COLUMN_AUTOR,Books.getautor());
        values.put(DBAdapter.COLUMN_TITLE,Books.gettitle());
        values.put(DBAdapter.COLUMN_AÑO, Books.getaño());
        values.put(DBAdapter.COLUMN_EDITORIAL, Books.geteditorial());
        values.put(DBAdapter.COLUMN_AREA, Books.getarea());
        long insertid = database.insert(DBAdapter.TABLE_BOOKS,null,values);
        Books.setisbn(insertid);
        return Books;

    }

    // Getting Book
    public Books getBook(long id) {

        Cursor cursor = database.query(DBAdapter.TABLE_BOOKS,allColumns,DBAdapter.COLUMN_ID + "=?",new String[]{String.valueOf(id)},null,null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Books e = new Books(Long.parseLong(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
        // return Book
        return e;
    }

    public List<Books> getAllBoxs() {

        Cursor cursor = database.query(DBAdapter.TABLE_BOOKS,allColumns,null,null,null, null, null);

        List<Books> books = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Books book = new Books();

                book.setisbn(cursor.getLong(cursor.getColumnIndex(DBAdapter.COLUMN_ID)));
                book.setautor(cursor.getString(cursor.getColumnIndex(DBAdapter.COLUMN_AUTOR)));
                book.settitle(cursor.getString(cursor.getColumnIndex(DBAdapter.COLUMN_TITLE)));
                book.setaño(cursor.getString(cursor.getColumnIndex(DBAdapter.COLUMN_AÑO)));
                book.seteditorial(cursor.getString(cursor.getColumnIndex(DBAdapter.COLUMN_EDITORIAL)));
                book.setarea(cursor.getString(cursor.getColumnIndex(DBAdapter.COLUMN_AREA)));
                books.add(book);
            }
        }
        // return All books
        return books;
    }




    // Updating Book
    public int updateBooks(Books book) {

        ContentValues values = new ContentValues();
        values.put(DBAdapter.COLUMN_AUTOR, book.getautor());
        values.put(DBAdapter.COLUMN_TITLE, book.gettitle());
        values.put(DBAdapter.COLUMN_AÑO, book.getaño());
        values.put(DBAdapter.COLUMN_EDITORIAL, book.geteditorial());
        values.put(DBAdapter.COLUMN_AREA, book.getarea());

        // updating row
        return database.update(DBAdapter.TABLE_BOOKS, values,
                DBAdapter.COLUMN_ID + "=?",new String[] { String.valueOf(book.getisbn())});
    }

    // Deleting Book
    public void removeBooks(Books book) {

        database.delete(DBAdapter.TABLE_BOOKS, DBAdapter.COLUMN_ID + "=" + book.getisbn(), null);
    }



}