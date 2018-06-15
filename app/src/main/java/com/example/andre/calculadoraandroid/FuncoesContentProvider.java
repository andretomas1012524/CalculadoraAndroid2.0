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
    public static final String Autoridade = "com.example.andre.calculadoraandroid";
    public  static final Uri Base_uri = Uri.parse("content ://" + Autoridade);
    public static final Uri Economia_URI = Uri.withAppendedPath(Base_uri,DbTabelaFuncoes.Funcoes);
    public static final int Uri_Funcoes = 100;
    public static final int Funcoes_ID = 101;
    public static final int Pais_Uri = 200;
    public static final int Pais_ID = 201;
    public static final String MultiplosItens = "vnd.android.cursor.dir";
    public static final String ItemSimples = "vnd.android.cursor.item";
    DbEconomicaOpenHelper dbEconomicaOpenHelper;

    private static UriMatcher getEconomiaUnimatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(Autoridade, "Funcoes", Uri_Funcoes);
        uriMatcher.addURI(Autoridade, "Funcoes/#", Funcoes_ID);
        uriMatcher.addURI(Autoridade, "Pais", Pais_Uri);
        uriMatcher.addURI(Autoridade, "Pais/#", Pais_ID);
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

        switch (matcher.match(uri)) {
            case Uri_Funcoes:
                return new DbTabelaFuncoes(bd).quarry(strings, s, strings1, null, null, s1);
            case Funcoes_ID:
                return new DbTabelaFuncoes(bd).quarry(strings, DbTabelaFuncoes._ID + "=?", new String[] { id }, null, null, null);
            case Pais_Uri:
                return new DbTabelaPais(bd).quarry(strings, s, strings1, null, null, s1);
            case Pais_ID:
                return new DbTabelaPais(bd).quarry(strings, DbTabelaPais._ID + "=?", new String[] { id }, null, null, null);
            default:
                throw new UnsupportedOperationException("Uri inválido !! :" + uri);
        }


    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        UriMatcher matcher = getEconomiaUnimatcher();

        switch (matcher.match(uri)){
            case Uri_Funcoes:
                return MultiplosItens + "/" + Autoridade + "/" + DbTabelaFuncoes.Funcoes;
            case Pais_Uri:
                return MultiplosItens + "/" + Autoridade + "/" + DbTabelaPais.Pais;
            case Funcoes_ID:
                return ItemSimples + "/" + Autoridade + "/" + DbTabelaFuncoes.Funcoes;
            case Pais_ID:
                return ItemSimples + "/" + Autoridade + "/" + DbTabelaPais.Pais;
            default:
                throw new UnsupportedOperationException("Uri inválido !! :" + uri);
        }

    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase bd = dbEconomicaOpenHelper.getWritableDatabase();

        long id = -1;

        UriMatcher matcher = getEconomiaUnimatcher();

        switch (matcher.match(uri)) {
            case Uri_Funcoes:
                id = new DbTabelaFuncoes(bd).insert(contentValues);
                break;
            case Pais_Uri:
                id = new DbTabelaPais(bd).insert(contentValues);
                break;
            default:
                throw new UnsupportedOperationException("Uri inválido !! :" + uri);
        }
        if (id > 0) {
            NotifyChanges(uri);
            return Uri.withAppendedPath(uri, Long.toString(id));
        } else {
            throw new SQLException("Não conseguiu inserir no registo");
        }

    }

    private void NotifyChanges(@NonNull Uri uri) {
        getContext().getContentResolver().notifyChange(uri, null);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        SQLiteDatabase bd = dbEconomicaOpenHelper.getWritableDatabase();

        String id = uri.getLastPathSegment();

        UriMatcher matcher = getEconomiaUnimatcher();

        int rows = 0;

        switch (matcher.match(uri)) {
            case Funcoes_ID:
                rows = new DbTabelaFuncoes(bd).delete(DbTabelaFuncoes._ID + "=?", new String[]{id});
                break;
            case Pais_ID:
                rows = new DbTabelaPais(bd).delete(DbTabelaPais._ID + "=?", new String[]{id});
                break;
            default:
                throw new UnsupportedOperationException("Uri inválido !! :" + uri);
        }

        if (rows > 0) NotifyChanges(uri);
        return rows;

    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        SQLiteDatabase bd = dbEconomicaOpenHelper.getWritableDatabase();

        String id = uri.getLastPathSegment();

        UriMatcher matcher = getEconomiaUnimatcher();

        int rows = 0;

        switch (matcher.match(uri)) {
            case Funcoes_ID:
                rows = new DbTabelaFuncoes(bd).update(contentValues, DbTabelaFuncoes._ID + "=?", new String[]{id});
                break;
            case Pais_ID:
                rows = new DbTabelaPais(bd).update(contentValues, DbTabelaPais._ID + "=?", new String[]{id});
                break;
            default:
                throw new UnsupportedOperationException("Uri inválido !! :" + uri);
        }

        if (rows > 0) NotifyChanges(uri);
        return rows;

    }
}
