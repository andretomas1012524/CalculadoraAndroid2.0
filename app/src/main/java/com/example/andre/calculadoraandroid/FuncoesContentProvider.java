package com.example.andre.calculadoraandroid;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Andre on 13-06-2018.
 */

public class FuncoesContentProvider extends ContentProvider {
    public static final int Uri_Funcoes = 100;
    public static final int Funcoes_ID = 101;
    public static final int Pais_Uri = 200;
    public static final int Pais_ID = 201;
    DbEconomicaOpenHelper dbEconomicaOpenHelper;

    private static UriMatcher getEconomiaUnimatcher(){
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.andre.calculadoraandroid","Funcoes", Uri_Funcoes);
        uriMatcher.addURI("com.example.andre.calculadoraandroid","Funcoes/#", Funcoes_ID);
        uriMatcher.addURI("com.example.andre.calculadoraandroid","Pais", Pais_Uri);
        uriMatcher.addURI("com.example.andre.calculadoraandroid","Pais/#", Pais_ID);
        return uriMatcher;

    }

    @Override
    public boolean onCreate() {
        dbEconomicaOpenHelper = new DbEconomicaOpenHelper(getContext());

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        SQLiteDatabase bd = dbEconomicaOpenHelper.getReadableDatabase();

        String id = uri.getLastPathSegment();

        UriMatcher matcher = getEconomiaUnimatcher();

        switch (matcher.match(uri)){
            case Uri_Funcoes:
                return new DbTabelaFuncoes(bd).quarry(projecion,selection,selectionargs,null,null,sortOrder);
                break;
            case Funcoes_ID:
                break;
            case Pais_Uri:
                break;
            case Pais_ID:
                break;
            default:
                throw new UnsupportedOperationException("Uri inválido !! :"+ uri);
        }


        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase bd = dbEconomicaOpenHelper.getWritableDatabase();

        long id;

        UriMatcher matcher = getEconomiaUnimatcher();

        switch (matcher.match(uri)){
            case Uri_Funcoes:
                id = new DbTabelaFuncoes(bd).insert(contentValues);
                break;
            case Pais_Uri:
                 id = new DbTabelaPais(bd).insert(contentValues);
                break;
            default:
                throw new UnsupportedOperationException("Uri inválido !! :"+ uri);
        }
        if (id>0){
            NotifyChanges(uri);
            return Uri.withAppendedPath(uri, Long.toString(id));
        }else {
            throw new SQLException("Não conseguiu inserir no registo");
        }

    }

    private void NotifyChanges(@NonNull Uri uri) {
        getContext().getContentResolver().notifyChange(uri,null);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
