package com.example.andre.calculadoraandroid;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Andre on 31-05-2018.
 */

public class DbTabelaFuncoes implements BaseColumns {
    private SQLiteDatabase db;

    public static final String Funcoes = "funcoes";
    public static final String Nome = "name";
    public static final String Valor = "price";
    public static final String ID_Pais = "idpais";

    public static final String[] All_colunas= new String[]{_ID,Nome,Valor,ID_Pais};
    public DbTabelaFuncoes(SQLiteDatabase db) {
        this.db=db;
    }
    public void create(){
        db.execSQL(
                "CREATE TABLE " + Funcoes + "(" +
                        _ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                        Nome + " TEXT NOT NULL, " +
                        Valor + " Real NOT NULL," +
                        ID_Pais +" Integer ," +
                        "FOREIGN KEY ("+ID_Pais +") references " + DbTabelaFinancas.Pais + "(" + DbTabelaFinancas._ID + ")"+
                        ")"
        );
    }
    public static ContentValues getContentValues(Funcoes funcoes){
        ContentValues values = new ContentValues();

        values.put(Nome,funcoes.getNome());
        values.put(Valor,funcoes.getValor());
        values.put(ID_Pais,funcoes.getIdFinanca());

        return values;
    }

    public static Funcoes getCurrentFuncoes(Cursor cursor){
        final int posnome = cursor.getColumnIndex(Nome);
        final int posId=cursor.getColumnIndex(_ID);
        final int posvalor = cursor.getColumnIndex(Valor);
        final int posIDpais = cursor.getColumnIndex(ID_Pais);
        Funcoes funcoes = new Funcoes();
        funcoes.setId(cursor.getInt(posId));
        funcoes.setNome(cursor.getString(posnome));
        funcoes.setValor(cursor.getDouble(posvalor));
        funcoes.setIdFinanca(cursor.getInt(posIDpais));
        return funcoes;
    }


    public long insert(ContentValues values){
        return db.insert(Funcoes,null, values);
    }

    public int update(ContentValues values,String whereClause, String[] whereArgs){
        return db.update(Funcoes,values,whereClause,whereArgs);
    }

    public int delete(String whereClause,String[] whereArgs){
        return db.delete(Funcoes,whereClause,whereArgs);
    }

    public Cursor quarry(String[] colunas,String seletion, String[] seletionargs,String groupBy, String having,String orderby){
        Cursor cursor = db.query(Funcoes,colunas,seletion,seletionargs,groupBy,having,orderby);
        return cursor;
    }
}
