package com.example.andre.calculadoraandroid;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Andre on 31-05-2018.
 */

public class DbTabelaFinancas implements BaseColumns {
    private SQLiteDatabase db;
    public static final String Pais = "pais";
    public static final String Nome = "name";

    public static final String[] All_colunas= new String[]{_ID,Nome};
    public DbTabelaFinancas(SQLiteDatabase db) {
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

    public static ContentValues getContentValues(Financas nome){
        ContentValues values = new ContentValues();

        values.put(Nome,nome.getNome());
        return values;
    }

    public static Financas getCurrentpais(Cursor cursor){
        final int posnome = cursor.getColumnIndex(Nome);
        final int posId=cursor.getColumnIndex(_ID);
        Financas Financas = new Financas();
        Financas.setId(cursor.getInt(posId));
        Financas.setNome(cursor.getString(posnome));
        return Financas;
    }


    public long insert(ContentValues values){
        return db.insert(Pais,null, values);
    }

    public int update(ContentValues values,String whereClause, String[] whereArgs){
        return db.update(Pais,values,whereClause,whereArgs);
    }

    public int delete(String whereClause,String[] whereArgs){
        return db.delete(Pais,whereClause,whereArgs);
    }

    public Cursor quarry(String[] colunas,String seletion, String[] seletionargs,String groupBy, String having,String orderby){
        return db.query(Pais,colunas,seletion,seletionargs,groupBy,having,orderby);
    }
}
