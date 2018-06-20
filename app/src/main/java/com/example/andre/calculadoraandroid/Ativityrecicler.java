package com.example.andre.calculadoraandroid;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class Ativityrecicler extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, android.support.v4.app.LoaderManager.LoaderCallbacks<Object> {

    private EconomiaCursorAdapter EconomiaCursorAdapter;
    private static final int CursorLoaderID = 0;
    public static final String ECONOMIA_ID="ECONOMIA_ID";
    private RecyclerView recyclerViewEconomia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ativityrecicler);

        recyclerViewEconomia = (RecyclerView) findViewById(R.id.RecyclerViewPrecos);

        recyclerViewEconomia.setLayoutManager(new LinearLayoutManager(this));

        EconomiaCursorAdapter = new EconomiaCursorAdapter(this);
        recyclerViewEconomia.setAdapter(EconomiaCursorAdapter);

        EconomiaCursorAdapter.setViewHolderClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 editEconomia();
             }
        });
        getSupportLoaderManager().restartLoader(CursorLoaderID, null, this);
    }

    private void editEconomia() {
        int id = EconomiaCursorAdapter.getLastEconomiaClicked();
        Intent intent = new Intent(this,EditEconomia.class);
        intent.putExtra(ECONOMIA_ID,id);
        startActivity(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();
        getSupportLoaderManager().restartLoader(CursorLoaderID, null, this);
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
