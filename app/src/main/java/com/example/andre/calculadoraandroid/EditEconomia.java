package com.example.andre.calculadoraandroid;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
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

        editTextTitle = (EditText) findViewById(R.id.editTexttitle);
        editTextPrice = (EditText) findViewById(R.id.editTextpreco);
        spinnerPais = (Spinner) findViewById(R.id.spinnerpreco);

        funcoes = DbTabelaFuncoes.getCurrentFuncoes(cursorfuncao);
        editTextTitle.setText(funcoes.getNome());
        editTextPrice.setText(String.format("%.2f",funcoes.getValor()));

        getSupportLoaderManager().initLoader(Pais_CURSOR_LOADER_ID, null, (android.support.v4.app.LoaderManager.LoaderCallbacks<Object>) this);
    }

    protected void onResume() {
        super.onResume();
        getSupportLoaderManager().restartLoader(Pais_CURSOR_LOADER_ID, null, (android.support.v4.app.LoaderManager.LoaderCallbacks<Object>) this);
    }

    public void cancel(View view) {
        finish();
    }
    public void save(View view) {
        funcoes.setNome(editTextTitle.getText().toString());
        funcoes.setValor(Double.parseDouble(editTextPrice.getText().toString()));
        funcoes.setIdpais((int) spinnerPais.getSelectedItemId());
        int recordsAffected = getContentResolver().update(
                Uri.withAppendedPath(FuncoesContentProvider.Pais_URI, Integer.toString(funcoes.getId())),
                DbTabelaFuncoes.getContentValues(funcoes),
                null,
                null
        );
        if (recordsAffected > 0) {
            Toast.makeText(this, "Conta guardada", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
        Toast.makeText(this, "Não foi possivel guardar a conta", Toast.LENGTH_LONG).show();

    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        if (id == Pais_CURSOR_LOADER_ID) {
            return new CursorLoader(this, FuncoesContentProvider.Pais_URI, DbTabelaPais.All_colunas, null, null, null);
        }
        return null;
    }
    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        SimpleCursorAdapter cursorAdapterCategories = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                data,
                new String[]{DbTabelaPais.Pais},
                new int[]{android.R.id.text1}
                );
        spinnerPais.setAdapter(cursorAdapterCategories);
        int idCategory = funcoes.getIdpais();
        for (int i = 0; i < spinnerPais.getCount(); i++) {
            Cursor cursor = (Cursor) spinnerPais.getItemAtPosition(i);
            final int posId = cursor.getColumnIndex(DbTabelaPais._ID);
            if (idCategory == cursor.getInt(posId)) {
                spinnerPais.setSelection(i);
                break;
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
