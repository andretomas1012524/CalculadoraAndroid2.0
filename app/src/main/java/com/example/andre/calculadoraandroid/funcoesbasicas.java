package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class funcoesbasicas extends AppCompatActivity {

    public static final String RESULTADO_SOMA = "ResultadoSoma";
    public static final String RESULTADO_SOMA1 = "ResultadoSoma";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcoesbasicas);
    }

    public void csomabasica(View view) {
        Intent intent = new Intent(this,calculobasico.class);
        startActivity(intent);
    }

    public void csubbasica(View view) {
    }

    public void cmultbasica(View view) {
    }

    public void cdivbasica(View view) {
    }

    public void cdivibasica(View view) {
    }

    public void cmedbasica(View view) {
    }

    public void cmfuncbasica(View view) {
    }
}
