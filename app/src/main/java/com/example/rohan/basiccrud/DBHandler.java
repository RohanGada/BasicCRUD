package com.example.rohan.basiccrud;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {

    public static final String TAG="rohanMessage";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "vendors.db";
    private static final String TABLE_VENDORS = "vendors";
    private static final String COLUMN_ID="_id";
    private static final String COLUMN_VENDORNAME="vendorname";
    private static final String COLUMN_VENDORADDRESS="vendoraddress";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TABLE_VENDORS+"("+
                COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUMN_VENDORNAME+" TEXT,"+
                COLUMN_VENDORADDRESS+" TEXT"+
                ");";
        db.execSQL(query);
        Log.i(TAG,"created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_VENDORS+" ;");
        onCreate(db);
    }

    public void addVendor(Vendors vendor) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_VENDORNAME, vendor.get_vendorname());
        values.put(COLUMN_VENDORADDRESS,vendor.get_vendoraddress());
        SQLiteDatabase db = getWritableDatabase();
        Log.i(TAG,vendor.get_vendorname());
        db.insert(TABLE_VENDORS, null, values);
        db.close();
    }
    public String databaseToString() {
        String dbString="";
        SQLiteDatabase db =getWritableDatabase();
        String query="SELECT * FROM "+TABLE_VENDORS+" ;";
        Cursor c=db.rawQuery(query,null);
        c.moveToFirst();
        while(!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex("vendorname"))!=null) {
            dbString+=c.getString(c.getColumnIndex("vendorname"))+" "+ c.getString(c.getColumnIndex("vendoraddress"));
                dbString+="\n";
            }
        }
        db.close();
        return dbString;
    }

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
}
