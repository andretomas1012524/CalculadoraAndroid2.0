package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Cbasico(View view) {
        Intent intent = new Intent(this,funcoesbasicas.class);
        startActivity(intent);
    }

    public void Ccientifico(View view) {
        Intent intent = new Intent(this,funcoescientificas.class);
        startActivity(intent);
    }

    public void Cbinario(View view) {
        Intent intent = new Intent(this,funcoescalculobinario.class);
        startActivity(intent);
    }

    public void Cpessoal(View view) {
        Intent intent = new Intent(this,contaspessoais.class);
        startActivity(intent);
    }
}
