package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class funcoescalculobinario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcoescalculobinario);
    }

    public void Conversao(View view) {
        Intent intent = new Intent(this,ConversaoBinario.class);
        startActivity(intent);
    }

    public void BCD(View view) {
        Intent intent = new Intent(this,funcoesbinariasMenu.class);
        startActivity(intent);
    }

    public void BinarioB(View view) {
        //Intent intent = new Intent(this,funcoesbinariaspred.class);
        //startActivity(intent);
    }
}
