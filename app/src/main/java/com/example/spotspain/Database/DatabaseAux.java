package com.example.spotspain.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseAux extends SQLiteOpenHelper {
    private static final String DB_NAME = "SpotSpain";
    private static final int DB_VERSION = 1;
    private static final String TABLE_CUENTAS = "t_cuentas";
    public DatabaseAux(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_CUENTAS +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "pass TEXT NOT NULL)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
