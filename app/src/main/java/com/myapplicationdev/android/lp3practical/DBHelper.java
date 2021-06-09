package com.myapplicationdev.android.lp3practical;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "drinks.db";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "Drink";

    private static final String COLUMN_CATEGORY = "Guide";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + DATABASE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TITLE + " TEXT, "
                + COLUMN_CATEGORY + " TEXT )";

        db.execSQL(createTableSql);
        Log.i("info" ,"created tables");
        Drink[] drinks = {new Drink("Latte", "coffee"),
                new Drink("Cappuccino", "coffee"),
                new Drink("White coffee", "coffee"),
                new Drink("Milk tea", "tea"),
                new Drink("Green tea", "tea")};

        for (int i=0; i<drinks.length; i++) {
            insertItem(db, drinks[i].getName(), drinks[i].getCategory());
        }
    }


    public ArrayList<String> getItemsOfCategory(String category) {
        ArrayList<String> drinks = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {COLUMN_NAME};
        String condition = COLUMN_CATEGORY + "='" + category + "'";

        Cursor cursor = db.query(TABLE_NAME, columns,condition,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                drinks.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        db.close();
        cursor.close();
        return drinks;
    }
}
