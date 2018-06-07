package com.example.andre.calculadoraandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andre on 31-05-2018.
 */

public class DbEconomicaOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Economia.db";
    public static final int DATABASE_VERSION = 1;

    public DbEconomicaOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        DbTabelaFuncoes dbTabelaFuncoes = new DbTabelaFuncoes(db);
        dbTabelaFuncoes.create();
        DbTabelaPais dbTabelaPais = new DbTabelaPais(db);
        dbTabelaPais.create();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
