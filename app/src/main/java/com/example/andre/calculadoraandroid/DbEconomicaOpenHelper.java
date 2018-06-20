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
        DbTabelaPais dbTabelaPais = new DbTabelaPais(db);
        dbTabelaPais.create();

        if(!Producao){
            seed(db);
        }
    }

    private void seed(SQLiteDatabase db) {
        DbTabelaPais dbTabelaPais = new DbTabelaPais(db);

        Pais pais = new Pais();
        pais.setNome("portugal");
        int idpais = (int) dbTabelaPais.insert(DbTabelaPais.getContentValues(pais));

        pais=new Pais();
        pais.setNome("Espanha");
        int idpaisE = (int) dbTabelaPais.insert(DbTabelaPais.getContentValues(pais));
        pais=new Pais();
        pais.setNome("França");
        int idpaisF= (int) dbTabelaPais.insert(DbTabelaPais.getContentValues(pais));


        DbTabelaFuncoes dbTabelaFuncoes = new DbTabelaFuncoes(db);

        Funcoes funcoes= new Funcoes();
        funcoes.setNome("IVA");
        funcoes.setIdpais(idpais);
        funcoes.setValor(9.99);
        dbTabelaFuncoes.insert(DbTabelaFuncoes.getContentValues(funcoes));

        funcoes=new Funcoes();
        funcoes.setNome("IMI");
        funcoes.setIdpais(idpaisE);
        funcoes.setValor(10);
        dbTabelaFuncoes.insert(DbTabelaFuncoes.getContentValues(funcoes));

        funcoes=new Funcoes();
        funcoes.setNome("Propinas");
        funcoes.setIdpais(idpaisF);
        funcoes.setValor(20);
        dbTabelaFuncoes.insert(DbTabelaFuncoes.getContentValues(funcoes));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
