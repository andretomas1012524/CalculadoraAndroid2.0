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
                        "FOREIGN KEY ("+ID_Pais +") references " + DbTabelaFinancas.Financa + "(" + DbTabelaFinancas._ID + ")"+
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


    /**
          * Convenience method for inserting a row into the categories table.
          *
          * @param values this map contains the initial column values for the
          *            row. The keys should be the column names and the values the
          *            column values
          * @return the row ID of the newly inserted row, or -1 if an error occurred
     */
    public long insert(ContentValues values){
        return db.insert(Funcoes,null, values);
    }

    /**
          * Convenience method for updating rows in the categories table.
          *
          * @param values a map from column names to new column values. null is a
          *            valid value that will be translated to NULL.
          * @param whereClause the optional WHERE clause to apply when updating.
          *            Passing null will update all rows.
          * @param whereArgs You may include ?s in the where clause, which
          *            will be replaced by the values from whereArgs. The values
          *            will be bound as Strings.
          * @return the number of rows affected
     */

    public int update(ContentValues values,String whereClause, String[] whereArgs){
        return db.update(Funcoes,values,whereClause,whereArgs);
    }

    /**
        * Convenience method for deleting rows in the categories table.
        *
        * @param whereClause the optional WHERE clause to apply when deleting.
        *            Passing null will delete all rows.
        * @param whereArgs You may include ?s in the where clause, which
        *            will be replaced by the values from whereArgs. The values
        *            will be bound as Strings.
        * @return the number of rows affected if a whereClause is passed in, 0
        *         otherwise. To remove all rows and get a count pass "1" as the
         *         whereClause.
     */
    public int delete(String whereClause,String[] whereArgs){
        return db.delete(Funcoes,whereClause,whereArgs);
    }

    /**
         * Query the categories table, returning a {@link Cursor} over the result set.
         *
         * @param columns A list of which columns to return. Passing null will
         *            return all columns, which is discouraged to prevent reading
         *            data from storage that isn't going to be used.
         * @param selection A filter declaring which rows to return, formatted as an
         *            SQL WHERE clause (excluding the WHERE itself). Passing null
         *            will return all rows for the given table.
         * @param selectionArgs You may include ?s in selection, which will be
         *         replaced by the values from selectionArgs, in order that they
         *         appear in the selection. The values will be bound as Strings.
         * @param groupBy A filter declaring how to group rows, formatted as an SQL
         *            GROUP BY clause (excluding the GROUP BY itself). Passing null
         *            will cause the rows to not be grouped.
         * @param having A filter declare which row groups to include in the cursor,
         *            if row grouping is being used, formatted as an SQL HAVING
         *            clause (excluding the HAVING itself). Passing null will cause
         *            all row groups to be included, and is required when row
         *            grouping is not being used.
         * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
         *            (excluding the ORDER BY itself). Passing null will use the
         *            default sort order, which may be unordered.
         * @return A {@link Cursor} object, which is positioned before the first entry. Note that
         * {@link Cursor}s are not synchronized, see the documentation for more details.
         * @see Cursor
     */
    public Cursor query(String[] colunas, String seletion, String[] seletionargs, String groupBy, String having, String orderby){
        Cursor cursor = db.query(Funcoes,colunas,seletion,seletionargs,groupBy,having,orderby);
        return cursor;
    }
}
