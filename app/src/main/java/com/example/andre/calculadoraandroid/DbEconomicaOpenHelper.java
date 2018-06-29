package com.example.andre.calculadoraandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andre on 31-05-2018.
 */

public class DbEconomicaOpenHelper extends SQLiteOpenHelper {
    private static final boolean Producao = false;
    public static final String DATABASE_NAME = "Economia.db";
    public static final int DATABASE_VERSION = 1;

    public DbEconomicaOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        DbTabelaFuncoes dbTabelaFuncoes = new DbTabelaFuncoes(db);
        dbTabelaFuncoes.create();
        DbTabelaFinancas dbTabelaFinancas = new DbTabelaFinancas(db);
        dbTabelaFinancas.create();

        if(!Producao){
            seed(db);
        }
    }

    private void seed(SQLiteDatabase db) {
        DbTabelaFinancas dbTabelaFinancas = new DbTabelaFinancas(db);

        Financas Financas = new Financas();
        Financas.setNome("Financa");
        int idFinanca0 = (int) dbTabelaFinancas.insert(DbTabelaFinancas.getContentValues(Financas));

        Financas=new Financas();
        Financas.setNome("Financa1");
        int idFinanca1 = (int) dbTabelaFinancas.insert(DbTabelaFinancas.getContentValues(Financas));
        Financas=new Financas();
        Financas.setNome("Financa2");
        int idFinanca2 = (int) dbTabelaFinancas.insert(DbTabelaFinancas.getContentValues(Financas));


        DbTabelaFuncoes dbTabelaFuncoes = new DbTabelaFuncoes(db);

        Funcoes funcoes= new Funcoes();
        funcoes.setNome("IVA");
        funcoes.setIdFinanca(idFinanca0);
        funcoes.setValor(9.99);
        dbTabelaFuncoes.insert(DbTabelaFuncoes.getContentValues(funcoes));

        funcoes=new Funcoes();
        funcoes.setNome("IMI");
        funcoes.setIdFinanca(idFinanca1);
        funcoes.setValor(10);
        dbTabelaFuncoes.insert(DbTabelaFuncoes.getContentValues(funcoes));

        funcoes=new Funcoes();
        funcoes.setNome("Propinas");
        funcoes.setIdFinanca(idFinanca2);
        funcoes.setValor(20);
        dbTabelaFuncoes.insert(DbTabelaFuncoes.getContentValues(funcoes));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
