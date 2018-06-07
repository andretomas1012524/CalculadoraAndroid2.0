package com.example.andre.calculadoraandroid;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Andre on 31-05-2018.
 */

public class DbTabelaPais implements BaseColumns {
    private SQLiteDatabase db;
    public static final String Pais = "pais";
    public static final String Nome = "name";
    public DbTabelaPais(SQLiteDatabase db) {
        this.db=db;
    }
    public void create(){
        db.execSQL(
                "CREATE TABLE " + Pais + "(" +
                        _ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                        Nome + " TEXT NOT NULL " +
                        ")"
        );
    }

    public ContentValues getContentValues(Pais nome){
        ContentValues values = new ContentValues();

        values.put(_ID, nome.getId());
        values.put(Nome,nome.getNome());
        return values;
    }


    public long insert(ContentValues values){
        return db.insert(Pais,null, values);
    }
}
