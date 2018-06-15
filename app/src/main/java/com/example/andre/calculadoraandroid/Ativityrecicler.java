package com.example.andre.calculadoraandroid;

import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Ativityrecicler extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    public static final int CursorLoaderID = 0;
    private EconomiaCursorAdapter EconomiaCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ativityrecicler);

        RecyclerView recyclerViewPrecos = (RecyclerView) findViewById(R.id.RecyclerViewPrecos);

        recyclerViewPrecos.setLayoutManager(new LinearLayoutManager(this));

        EconomiaCursorAdapter = new EconomiaCursorAdapter(this);
        recyclerViewPrecos.setAdapter(EconomiaCursorAdapter);

        getLoaderManager().initLoader(CursorLoaderID,null,this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        if(i == CursorLoaderID){
            new CursorLoader(this,FuncoesContentProvider.Economia_URI,DbTabelaFuncoes.All_colunas,null,null,null);
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        EconomiaCursorAdapter.refreshData(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        EconomiaCursorAdapter.refreshData(null);
    }
}
