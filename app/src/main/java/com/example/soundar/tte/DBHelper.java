package com.example.soundar.tte;

/**
 * Created by soundar on 13/2/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "S1.db";
    public static final String S1_TABLE_NAME = "passenger";
    public static final String S1_COLUMN_ID = "id";
    public static final String S1_COLUMN_NAME = "name";
    public static final String S1_COLUMN_PNRNUMER = "pnrnum";
    public static final String s1_COLUMN_AGE = "age";
    public static final String S1_COLUMN_GENDER = "gender";
    public static final String S1_COLUMN_SEATNO= "seatno";
    public static final String S1_COLUMN_AADHARNO = "aadharno";
    public static final String S1_COLUMN_PASSEMGERCOUNT = "count";

    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);

    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table passenger " +
                        "(id integer primary key, name text,pnrnum text,age text, gender text,seatno text,aadharno text,count text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS passenger");
        onCreate(db);
    }

    public boolean insertContact (String name, String pnrnum, String age, String gender,String seatno,String aadharno,String count) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("pnrnum", pnrnum);
        contentValues.put("age",  age);
        contentValues.put("gender", gender);
        contentValues.put("seatno",  seatno);
        contentValues.put("aadharno",  aadharno);
        contentValues.put("count",  count);

        db.insert("passenger", null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from passenger where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, S1_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact (Integer id, String name, String phone, String email, String street,String place) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("street", street);
        contentValues.put("place", place);
        db.update("passenger", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("passenger",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public ArrayList<String> getAllCotacts() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from passenger", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(S1_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }
}