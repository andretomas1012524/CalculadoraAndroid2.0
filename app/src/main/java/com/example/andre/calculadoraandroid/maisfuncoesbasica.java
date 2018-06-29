package com.example.andre.calculadoraandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class maisfuncoesbasica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maisfuncoesbasica);
    }

    public void potcal(View view) {
        Intent intent = new Intent(this,calculobasico6.class);
        startActivity(intent);
    }

    public void raizcal(View view) {
        Intent intent = new Intent(this,calculobasico7.class);
        startActivity(intent);
    }

    public void raizpredcal(View view) {
        Intent intent = new Intent(this,calculobasico8.class);
        startActivity(intent);
    }

    public void factcal(View view) {
        Intent intent = new Intent(this,calculobasico9.class);
        startActivity(intent);
    }

    public void voltbasc(View view) {
        Intent intent = new Intent(this,funcoesbasicas.class);
        startActivity(intent);
    }
}
