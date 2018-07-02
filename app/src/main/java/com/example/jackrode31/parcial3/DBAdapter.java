package com.example.jackrode31.parcial3;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;


public class DBAdapter {
    public static final String LOGTAG = "EMP_MNGMNT_SYS";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            BooksHandler.COLUMN_ID,
            BooksHandler.COLUMN_AUTOR,
            BooksHandler.COLUMN_TITLE,
            BooksHandler.COLUMN_AÑO,
            BooksHandler.COLUMN_EDITORIAL,
            BooksHandler.COLUMN_AREA

    };

    public DBAdapter(Context context){
        dbhandler = new BooksHandler(context);
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
        values.put(BooksHandler.COLUMN_AUTOR,Books.getautor());
        values.put(BooksHandler.COLUMN_TITLE,Books.gettitle());
        values.put(BooksHandler.COLUMN_AÑO, Books.getaño());
        values.put(BooksHandler.COLUMN_EDITORIAL, Books.geteditorial());
        values.put(BooksHandler.COLUMN_AREA, Books.getarea());
        long insertid = database.insert(BooksHandler.TABLE_BOOKS,null,values);
        Books.setisbn(insertid);
        return Books;

    }

    // Getting Book
    public Books getBook(long id) {

        Cursor cursor = database.query(BooksHandler.TABLE_BOOKS,allColumns,BooksHandler.COLUMN_ID + "=?",new String[]{String.valueOf(id)},null,null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Books e = new Books(Long.parseLong(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
        // return Book
        return e;
    }

    public List<Books> getAllBoxs() {

        Cursor cursor = database.query(BooksHandler.TABLE_BOOKS,allColumns,null,null,null, null, null);

        List<Books> books = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Books book = new Books();

                book.setisbn(cursor.getLong(cursor.getColumnIndex(BooksHandler.COLUMN_ID)));
                book.setautor(cursor.getString(cursor.getColumnIndex(BooksHandler.COLUMN_AUTOR)));
                book.settitle(cursor.getString(cursor.getColumnIndex(BooksHandler.COLUMN_TITLE)));
                book.setaño(cursor.getString(cursor.getColumnIndex(BooksHandler.COLUMN_AÑO)));
                book.seteditorial(cursor.getString(cursor.getColumnIndex(BooksHandler.COLUMN_EDITORIAL)));
                book.setarea(cursor.getString(cursor.getColumnIndex(BooksHandler.COLUMN_AREA)));
                books.add(book);
            }
        }
        // return All books
        return books;
    }




    // Updating Book
    public int updateBooks(Books book) {

        ContentValues values = new ContentValues();
        values.put(BooksHandler.COLUMN_AUTOR, book.getautor());
        values.put(BooksHandler.COLUMN_TITLE, book.gettitle());
        values.put(BooksHandler.COLUMN_AÑO, book.getaño());
        values.put(BooksHandler.COLUMN_EDITORIAL, book.geteditorial());
        values.put(BooksHandler.COLUMN_AREA, book.getarea());

        // updating row
        return database.update(BooksHandler.TABLE_BOOKS, values,
                BooksHandler.COLUMN_ID + "=?",new String[] { String.valueOf(book.getisbn())});
    }

    // Deleting Book
    public void removeBooks(Books book) {

        database.delete(BooksHandler.TABLE_BOOKS, BooksHandler.COLUMN_ID + "=" + book.getisbn(), null);
    }



}