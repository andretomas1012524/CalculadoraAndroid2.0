package com.example.andre.calculadoraandroid;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.Toast;

public class EditEconomia extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final int Pais_CURSOR_LOADER_ID = 0;
    private EditText editTextTitle;
    private EditText editTextPrice;
    private Spinner spinnerPais;
    private Funcoes funcoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_economia);

        Intent intent = getIntent();
        int funcaoId = intent.getIntExtra(Ativityrecicler.ECONOMIA_ID, -1);
        if (funcaoId == -1) {
            finish();
            return;
        }
        Cursor cursorfuncao = getContentResolver().query(
                Uri.withAppendedPath(FuncoesContentProvider.Pais_URI, Integer.toString(funcaoId)),
                DbTabelaFuncoes.All_colunas,
                null,
                null,
                null
        );
        if (!cursorfuncao.moveToNext()) {
            Toast.makeText(this, "Book not found", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        spinnerPais = (Spinner) findViewById(R.id.spinnerCategory);

    }


    public void cancel(View view) {
        finish();
    }
    public void save(View view) {

    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
