package com.i044114_i012114.proyectofinalandroid.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.i044114_i012114.proyectofinalandroid.Utilities.Constants;
import com.i044114_i012114.proyectofinalandroid.Views.DescriptionProducts;
import com.i044114_i012114.proyectofinalandroid.Views.ProductsList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ACER on 13/11/2017.
 */

public class SqliteHelper extends SQLiteOpenHelper{

//List<ProductsList> productsListList = new ArrayList<>();
    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE_USERS);
        db.execSQL(Constants.CREATE_TABLE_PRODUCTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLA_NAME_USERS);
        db.execSQL("DROP TABLE IF EXIST" + Constants.TABLE_NAME_PRODUCTS);
        onCreate(db);
    }

}
