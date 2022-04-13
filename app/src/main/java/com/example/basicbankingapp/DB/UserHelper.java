package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE = "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Milan Kumar', 'milan@gmail.com','7584','+91-92114204XX', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Ajay prakash', 'ajay@gmail.com','1258','+91-88048408XX', 25000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Rahul Singh', 'rahul@gmail.com','8896','+91-92047424XX', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Ankit Ranjan', 'ankit@gmail.com','7752','+91-88045878XX', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Smriti Kumari', 'smriti@gmail.com','3669','+91-87657896XX', 5111)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Unnati Arya', 'unnati@gmail.com','9985','+91-92857496XX', 1111)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Neha Kaur', 'neha@gmail.com','1207','+91-62857496XX', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Ayush Marwah', 'marwah@gmail.com','4522','+91-62968574XX', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Mahesh Rao', 'mahesh@gmail.com','6582','+91-72845678XX', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Ayush Raj', 'ayush@gmail.com','5450','+91-74859685XX', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Astik Anand', 'astik@gmail.com','2656','+91-96857496XX', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Md. Saif', 'saif@gmail.com','1203','+91-98757896XX', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Bishnu Mahto', 'bishnu@gmail.com','5566','+91-62987896XX', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Achintya Raj', 'achintya@gmail.com','2236','+91-96857412XX', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Kaushik Jena', 'kaushik@gmail.com','6692','+91-98735869XX', 1011)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}