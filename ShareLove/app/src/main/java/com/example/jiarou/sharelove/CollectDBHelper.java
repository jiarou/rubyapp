package com.example.jiarou.sharelove;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Peter on 2016/10/19.
 */
public class CollectDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "collectdata.db";

    public static final int VERSION = 1;

    private static SQLiteDatabase database;

    public CollectDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static SQLiteDatabase getDatabase(Context context){
        if(database == null || !database.isOpen()){
            database = new CollectDBHelper(context, DATABASE_NAME, null, VERSION).getWritableDatabase();
        }

        return database;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE vendor" + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "vendorid TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + "vendor");
        onCreate(db);

    }
}
